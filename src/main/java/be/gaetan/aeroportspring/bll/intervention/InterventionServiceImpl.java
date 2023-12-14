package be.gaetan.aeroportspring.bll.intervention;

import be.gaetan.aeroportspring.dal.models.Intervention;
import be.gaetan.aeroportspring.dal.models.personnes.Mecano;
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

    public InterventionServiceImpl(InterventionRepository interventionRepository, MecanoRepository mecanoRepository) {
        this.interventionRepository = interventionRepository;
        this.mecanoRepository = mecanoRepository;
    }

    /**
     * Creates a new Intervention based on the provided InterventionForm.
     *
     * @param form the InterventionForm containing the data for the new Intervention
     */
    @Override
    public void create(InterventionForm form) {
        Intervention intervention = new Intervention();
        intervention.setObjet(form.objet());
        intervention.setDate(form.date());
        intervention.setDuree(form.duree());
        intervention.setVerificateur(mecanoRepository.findById(form.verificateurId()).orElseThrow(()-> new EntityNotFoundException("vérificateur non trouvé")));
        intervention.setReparateur(mecanoRepository.findById(form.reparateurId()).orElseThrow(()-> new EntityNotFoundException("vérificateur non trouvé")));
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
     * Updates an existing Intervention object with the provided data from an InterventionForm.
     *
     * @param id   the ID of the Intervention to update
     * @param form the InterventionForm containing the data for update
     */
    @Override
    public void update(long id, InterventionForm form) {
        Intervention intervention = getOne(id);
        intervention.setDuree(form.duree());
        intervention.setDate(form.date());
        intervention.setObjet(form.objet());
        intervention.setVerificateur(mecanoRepository.findById(form.verificateurId()).orElseThrow(()-> new EntityNotFoundException("vérificateur non trouvé")));
        intervention.setReparateur(mecanoRepository.findById(form.reparateurId()).orElseThrow(()-> new EntityNotFoundException("vérificateur non trouvé")));
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
}
