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
     * Retrieves a PiloteTypeAvionDto object by its ID.
     *
     * @param id The ID of the PiloteTypeAvion entity to retrieve.
     * @return ResponseEntity object containing the PiloteTypeAvionDto if found, otherwise throws an EntityNotFoundException.
     */
    @Override
    public ResponseEntity<PiloteTypeAvionDto> getOneById(long id) {
        return ResponseEntity.ok(PiloteTypeAvionDto.fromEntity(piloteTypeAvionRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("relation type avion - pilote pas trouvée"))));
    }

    /**
     * Retrieves all PiloteTypeAvion objects that are not marked as deleted.
     *
     * @return ResponseEntity object containing a list of PiloteTypeAvionDto objects if found, otherwise an empty list.
     */
    @Override
    public ResponseEntity<List<PiloteTypeAvionDto>> getAll() {
        return ResponseEntity.ok(piloteTypeAvionRepository.findAllByDeleted(false).stream()
                .map(PiloteTypeAvionDto::fromEntity)
                .toList());
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
        PiloteTypeAvion piloteTypeAvion = piloteTypeAvionRepository.findById(id).orElseThrow(()->new EntityNotFoundException("relationpilote type avion non trouvée"));
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
        PiloteTypeAvion piloteTypeAvion = piloteTypeAvionRepository.findById(id).orElseThrow(()->new EntityNotFoundException("relationpilote type avion non trouvée"));
        piloteTypeAvion.setDeleted(true);
        piloteTypeAvionRepository.save(piloteTypeAvion);
    }

    /**
     * Retrieves all PiloteTypeAvionDto objects associated with a specific Pilote.
     *
     * @param id The ID of the Pilote.
     * @return ResponseEntity object containing a list of PiloteTypeAvionDto objects if found, otherwise an empty list.
     * @throws EntityNotFoundException If the Pilote is not found based on the provided ID.
     */
    @Override
    public ResponseEntity<List<PiloteTypeAvionDto>> getAllByPilote(long id) {
        return ResponseEntity.ok(piloteTypeAvionRepository.findByPilote(piloteRepository.findById(id).orElseThrow(()->new EntityNotFoundException("pilote non trouvé"))).stream()
                .map(PiloteTypeAvionDto::fromEntity)
                .toList());
    }

    /**
     * Retrieves all PiloteTypeAvionDto objects associated with a specific TypeAvion.
     *
     * @param id The ID of the TypeAvion.
     * @return ResponseEntity object containing a list of PiloteTypeAvionDto objects if found, otherwise an empty list.
     * @throws EntityNotFoundException If the TypeAvion is not found based on the provided ID.
     */
    @Override
    public ResponseEntity<List<PiloteTypeAvionDto>> getAllByTypeAvion(long id) {
        return ResponseEntity.ok(piloteTypeAvionRepository.findByTypeAvion(typeAvionRepository.findById(id).orElseThrow(()->new EntityNotFoundException("type d'avion non trouvé"))).stream()
                .map(PiloteTypeAvionDto::fromEntity)
                .toList());
    }
}
