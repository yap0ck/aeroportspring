package be.gaetan.aeroportspring.bll.intervention;

import be.gaetan.aeroportspring.dal.models.Avion;
import be.gaetan.aeroportspring.dal.models.Intervention;
import be.gaetan.aeroportspring.dal.models.personnes.Mecano;
import be.gaetan.aeroportspring.dal.repositories.AvionRepository;
import be.gaetan.aeroportspring.dal.repositories.InterventionRepository;
import be.gaetan.aeroportspring.dal.repositories.MecanoRepository;
import be.gaetan.aeroportspring.pl.models.intervention.forms.InterventionForm;
import be.gaetan.aeroportspring.pl.models.intervention.forms.InterventionSearchForm;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterventionServiceImpl implements InterventionService {
    private final InterventionRepository interventionRepository;
    private final MecanoRepository mecanoRepository;
    private final AvionRepository avionRepository;

    public InterventionServiceImpl(InterventionRepository interventionRepository, MecanoRepository mecanoRepository, AvionRepository avionRepository) {
        this.interventionRepository = interventionRepository;
        this.mecanoRepository = mecanoRepository;
        this.avionRepository = avionRepository;
    }

    /**
     * Creates a new Intervention object based on the provided InterventionForm data and saves it to the database.
     *
     * @param form the InterventionForm containing the data for creating a new Intervention
     * @throws EntityNotFoundException      if the verificateur, reparateur, or avion with the corresponding IDs are not found
     * @throws IllegalArgumentException    if the reparateur is not authorized to work on the avion type
     */
    @Override
    public void create(InterventionForm form) {
        Intervention intervention = new Intervention();
        intervention.setObjet(form.objet());
        intervention.setDate(form.date());
        intervention.setDuree(form.duree());
        intervention.setVerificateur(mecanoRepository.findById(form.verificateurId()).orElseThrow(()-> new EntityNotFoundException("vérificateur non trouvé")));
        Mecano mecano = mecanoRepository.findById(form.reparateurId()).orElseThrow(()-> new EntityNotFoundException("vérificateur non trouvé"));
        Avion avion = avionRepository.findById(form.avionId()).orElseThrow(()-> new EntityNotFoundException("Avion pas trouvé"));
        if (!mecano.getHabilitations().contains(avion.getTypeAvion())) throw new IllegalArgumentException("mécanicien pas habilité");
        intervention.setReparateur(mecano);
        intervention.setAvion(avion);
        interventionRepository.save(intervention);
    }

    /**
     * Retrieves an Intervention object by its ID.
     *
     * @param id the ID of the Intervention to retrieve
     * @return the Intervention object corresponding to the given ID
     * @throws EntityNotFoundException if the Intervention with the given ID is not found or is marked as deleted
     */
    @Override
    public Intervention getOne(long id) {
        Intervention intervention = interventionRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("l'intervention n'as pas été trouvée"));
        if (intervention.isDeleted()) throw new EntityNotFoundException("l'intervention n'as pas été trouvée");
        return intervention;
    }

    /**
     * Retrieves all non-deleted Intervention objects.
     *
     * @return a List of Intervention objects without deleted flag
     */
    @Override
    public Page<Intervention> getAll(Pageable pageable) {
        return interventionRepository.findAllByDeleted(false, pageable);
    }

    /**
     * Updates an Intervention object with the provided ID based on the data from InterventionForm.
     *
     * @param id   the ID of the Intervention to update
     * @param form the InterventionForm containing the updated data
     * @throws EntityNotFoundException   if the verificateur, reparateur, or avion with the corresponding IDs are not found
     * @throws IllegalArgumentException if the reparateur is not authorized to work on the avion type
     */
    @Override
    public void update(long id, InterventionForm form) {
        Intervention intervention = getOne(id);
        intervention.setDuree(form.duree());
        intervention.setDate(form.date());
        intervention.setObjet(form.objet());
        intervention.setVerificateur(mecanoRepository.findById(form.verificateurId()).orElseThrow(()-> new EntityNotFoundException("vérificateur non trouvé")));
        Mecano mecano = mecanoRepository.findById(form.reparateurId()).orElseThrow(()-> new EntityNotFoundException("vérificateur non trouvé"));
        Avion avion = avionRepository.findById(form.avionId()).orElseThrow(()-> new EntityNotFoundException("Avion pas trouvé"));
        if (!mecano.getHabilitations().contains(avion.getTypeAvion())) throw new IllegalArgumentException("mécanicien pas habilité");
        intervention.setReparateur(mecano);
        intervention.setAvion(avion);
        interventionRepository.save(intervention);
    }

    /**
     * Deletes an Intervention by setting its 'deleted' flag to true.
     *
     * @param id the ID of the Intervention to delete
     */
    @Override
    public void delete(long id) {
        Intervention intervention = getOne(id);
        intervention.setDeleted(true);
        interventionRepository.save(intervention);
    }

    /**
     * Searches for Intervention objects based on the provided InterventionSearchForm.
     *
     * @param form the InterventionSearchForm containing the search criteria
     * @return a Specification<Intervention> object representing the search criteria
     */
    private Specification<Intervention> search(InterventionSearchForm form){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (form.date() != null) {
                predicates.add(criteriaBuilder.equal(root.get("date"), form.date()));
            }
            if (form.duree() > 0) {
                predicates.add(criteriaBuilder.equal(root.get("duree"), form.duree()));
            }
            if (form.reparateurId() > 0) {
                predicates.add(criteriaBuilder.equal(root.get("id"), form.reparateurId()));
            }
            if (form.avion_id() != null && !form.avion_id().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("immatriculation"), "%" + form.avion_id() + "%"));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    /**
     * Retrieves all Intervention objects based on the provided InterventionSearchForm and Pageable parameters.
     *
     * @param form     the InterventionSearchForm containing the search criteria
     * @param pageable the Pageable object for pagination and sorting
     * @return a Page of Intervention objects that match the search criteria
     */
    @Override
    public Page<Intervention> getAllBySpec(InterventionSearchForm form, Pageable pageable) {
        Specification<Intervention> spec = search(form);
        return interventionRepository.findAll(spec, pageable);
    }

}
