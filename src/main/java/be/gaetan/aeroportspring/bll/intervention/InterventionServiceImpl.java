package be.gaetan.aeroportspring.bll.intervention;

import be.gaetan.aeroportspring.dal.models.Avion;
import be.gaetan.aeroportspring.dal.models.Intervention;
import be.gaetan.aeroportspring.dal.models.personnes.Mecano;
import be.gaetan.aeroportspring.dal.repositories.AvionRepository;
import be.gaetan.aeroportspring.dal.repositories.InterventionRepository;
import be.gaetan.aeroportspring.dal.repositories.MecanoRepository;
import be.gaetan.aeroportspring.pl.models.intervention.forms.InterventionForm;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

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
    public List<Intervention> getAll() {
        return interventionRepository.findAllByDeleted(false);
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
     * Retrieves all Intervention objects associated with a specific verificateur ID.
     *
     * @param id the ID of the verificateur
     * @return a List of Intervention objects associated with the given verificateur ID
     */
    @Override
    public List<Intervention> getAllByVerificateur(long id) {
        return interventionRepository.findAllByVerificateur(id);
    }

    /**
     * Retrieves all Intervention objects associated with a specific reparateur ID.
     *
     * @param id the ID of the reparateur
     * @return a List of Intervention objects associated with the given reparateur ID
     */
    @Override
    public List<Intervention> getAllByReparateur(long id) {
        return interventionRepository.findAllByReparateur(id);
    }

    /**
     * Retrieves all Intervention objects associated with a specific avion ID.
     *
     * @param id the ID of the avion
     * @return a List of Intervention objects associated with the given avion ID
     */
    @Override
    public List<Intervention> getAllByAvion(String id) {
        return interventionRepository.findAllByAvion(id);
    }

}
