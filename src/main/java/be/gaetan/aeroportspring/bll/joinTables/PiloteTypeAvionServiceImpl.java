package be.gaetan.aeroportspring.bll.joinTables;

import be.gaetan.aeroportspring.dal.models.joinTables.PiloteTypeAvion;
import be.gaetan.aeroportspring.dal.repositories.PiloteRepository;
import be.gaetan.aeroportspring.dal.repositories.PiloteTypeAvionRepository;
import be.gaetan.aeroportspring.dal.repositories.TypeAvionRepository;
import be.gaetan.aeroportspring.pl.models.joinTables.piloteTypeAvion.dtos.PiloteTypeAvionDto;
import be.gaetan.aeroportspring.pl.models.joinTables.piloteTypeAvion.forms.PiloteTypeAvionForm;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PiloteTypeAvionServiceImpl implements PiloteTypeAvionService{

    private final PiloteTypeAvionRepository piloteTypeAvionRepository;
    private final TypeAvionRepository typeAvionRepository;
    private final PiloteRepository piloteRepository;

    public PiloteTypeAvionServiceImpl(PiloteTypeAvionRepository piloteTypeAvionRepository, TypeAvionRepository typeAvionRepository, PiloteRepository piloteRepository) {
        this.piloteTypeAvionRepository = piloteTypeAvionRepository;
        this.typeAvionRepository = typeAvionRepository;
        this.piloteRepository = piloteRepository;
    }

    /**
     * Creates a new PiloteTypeAvion entity based on the given form data.
     *
     * @param form The form data used for creating the entity. Cannot be null.
     *             The form fields include:
     *             - nbVols: The number of flights. Must be a positive integer (min = 0).
     *             - piloteId: The ID of the pilote. Must not be null or blank.
     *             - typeAvionId: The ID of the type avion. Must not be null or blank.
     * @throws EntityNotFoundException If the type avion or pilote is not found based on the provided IDs.
     */
    @Override
    public void create(PiloteTypeAvionForm form) {
        PiloteTypeAvion piloteTypeAvion = new PiloteTypeAvion();
        piloteTypeAvion.setNbVols(form.nbVols());
        piloteTypeAvion.setTypeAvion(typeAvionRepository.findById(form.typeAvionId()).orElseThrow(()-> new EntityNotFoundException("Type d'avion non trouvé")));
        piloteTypeAvion.setPilote(piloteRepository.findById(form.piloteId()).orElseThrow(() -> new EntityNotFoundException("Pilote non trouvé")));
        piloteTypeAvionRepository.save(piloteTypeAvion);
    }


    /**
     * Retrieves a PiloteTypeAvion entity by its ID.
     *
     * @param id The ID of the PiloteTypeAvion entity.
     * @return The PiloteTypeAvion entity with the specified ID.
     * @throws EntityNotFoundException If the PiloteTypeAvion entity is not found based on the provided ID.
     */
    @Override
    public PiloteTypeAvion getOneById(long id) {
        return piloteTypeAvionRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("relation type avion - pilote pas trouvée"));
    }

    /**
     * Retrieves all PiloteTypeAvion entities that are not marked as deleted.
     *
     * @return A list of PiloteTypeAvion entities.
     */
    @Override
    public List<PiloteTypeAvion> getAll() {
        return piloteTypeAvionRepository.findAllByDeleted(false);
    }

    /**
     * Updates an existing PiloteTypeAvion entity based on the given ID and form data.
     *
     * @param id   The ID of the PiloteTypeAvion entity to be updated.
     * @param form The form data used for updating the entity. Cannot be null.
     *             The form fields include:
     *             - nbVols: The number of flights. Must be a positive integer (min = 0).
     *             - piloteId: The ID of the pilote. Must not be null or blank.
     *             - typeAvionId: The ID of the type avion. Must not be null or blank.
     * @throws EntityNotFoundException If the type avion or pilote is not found based on the provided IDs.
     */
    @Override
    public void update(long id, PiloteTypeAvionForm form) {
        PiloteTypeAvion piloteTypeAvion = getOneById(id);
        piloteTypeAvion.setNbVols(form.nbVols());
        piloteTypeAvion.setTypeAvion(typeAvionRepository.findById(form.typeAvionId()).orElseThrow(()-> new EntityNotFoundException("Type d'avion non trouvé")));
        piloteTypeAvion.setPilote(piloteRepository.findById(form.piloteId()).orElseThrow(() -> new EntityNotFoundException("Pilote non trouvé")));
        piloteTypeAvionRepository.save(piloteTypeAvion);
    }

    /**
     * Deletes a PiloteTypeAvion entity by its ID. Sets the 'deleted' flag to true.
     *
     * @param id The ID of the PiloteTypeAvion entity to delete.
     * @throws EntityNotFoundException If the PiloteTypeAvion entity is not found based on the provided ID.
     */
    @Override
    public void delete(long id) {
        PiloteTypeAvion piloteTypeAvion = getOneById(id);
        piloteTypeAvion.setDeleted(true);
        piloteTypeAvionRepository.save(piloteTypeAvion);
    }

    /**
     * Retrieves all PiloteTypeAvion entities associated with a specific Pilote.
     *
     * @param id The ID of the Pilote.
     * @return A list of PiloteTypeAvion entities associated with the specified Pilote.
     * @throws EntityNotFoundException If the Pilote is not found based on the provided ID.
     */
    @Override
    public List<PiloteTypeAvion> getAllByPilote(long id) {
        return piloteTypeAvionRepository.findByPilote(piloteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("pilote non trouvé")));
    }

    /**
     * Retrieves all PiloteTypeAvion entities by the ID of the type avion.
     *
     * @param id The ID of the type avion.
     * @return A list of PiloteTypeAvion entities associated with the specified type avion.
     * @throws EntityNotFoundException If the type avion is not found based on the provided ID.
     */
    @Override
    public List<PiloteTypeAvion> getAllByTypeAvion(long id) {
        return piloteTypeAvionRepository.findByTypeAvion(typeAvionRepository.findById(id).orElseThrow(()->new EntityNotFoundException("type d'avion non trouvé")));
    }
}
