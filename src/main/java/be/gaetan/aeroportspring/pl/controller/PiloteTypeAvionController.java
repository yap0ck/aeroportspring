package be.gaetan.aeroportspring.pl.controller;

import be.gaetan.aeroportspring.bll.joinTables.PiloteTypeAvionService;
import be.gaetan.aeroportspring.pl.models.joinTables.piloteTypeAvion.dtos.PiloteTypeAvionDto;
import be.gaetan.aeroportspring.pl.models.joinTables.piloteTypeAvion.forms.PiloteTypeAvionForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pilotetypeavion")
public class PiloteTypeAvionController {
    private final PiloteTypeAvionService piloteTypeAvionService;

    public PiloteTypeAvionController(PiloteTypeAvionService piloteTypeAvionService) {
        this.piloteTypeAvionService = piloteTypeAvionService;
    }

    /**
     * Creates a new PiloteTypeAvion entity based on the provided form.
     *
     * @param form The PiloteTypeAvionForm object containing the necessary information for creating a new entity.
     */
    @PostMapping
    public void create(@RequestBody PiloteTypeAvionForm form){
        piloteTypeAvionService.create(form);
    }

    /**
     * Retrieve a specific PiloteTypeAvionDto by its ID.
     *
     * @param id The ID of the PiloteTypeAvionDto to retrieve.
     * @return A ResponseEntity containing the PiloteTypeAvionDto.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PiloteTypeAvionDto> getOne(@PathVariable long id){
        return ResponseEntity.ok(PiloteTypeAvionDto.fromEntity(piloteTypeAvionService.getOneById(id)));
    }

    /**
     * Retrieves a list of PiloteTypeAvionDto objects representing all the PiloteTypeAvion entities.
     *
     * @return A ResponseEntity containing a list of PiloteTypeAvionDto objects.
     */
    @GetMapping
    public ResponseEntity<List<PiloteTypeAvionDto>> getAll(){
        return ResponseEntity.ok(piloteTypeAvionService.getAll().stream()
                .map(PiloteTypeAvionDto::fromEntity)
                .toList());
    }

    /**
     * Updates the PiloteTypeAvion entity with the specified ID using the provided form.
     *
     * @param id   The ID of the PiloteTypeAvion entity to update.
     * @param form The PiloteTypeAvionForm object containing the updated information.
     */
    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody PiloteTypeAvionForm form) {
        piloteTypeAvionService.update(id, form);
    }

    /**
     * Retrieves a list of PiloteTypeAvionDto objects representing all the PiloteTypeAvion entities associated with a specific Pilote.
     *
     * @param id The ID of the Pilote to retrieve the associated PiloteTypeAvion entities for.
     * @return A ResponseEntity containing a list of PiloteTypeAvionDto objects.
     */
    @GetMapping("/pilote/{id}")
    public ResponseEntity<List<PiloteTypeAvionDto>> getAllByPilote(@PathVariable long id) {
        return ResponseEntity.ok(piloteTypeAvionService.getAllByPilote(id).stream()
                .map(PiloteTypeAvionDto::fromEntity)
                .toList());
    }

    /**
     * Retrieves a list of PiloteTypeAvionDto objects representing all the PiloteTypeAvion entities associated with a specific type avion.
     *
     * @param id The ID of the type avion to retrieve the associated PiloteTypeAvion entities for.
     * @return A ResponseEntity containing a list of PiloteTypeAvionDto objects.
     */
    @GetMapping("/typeavion/{id}")
    public ResponseEntity<List<PiloteTypeAvionDto>> getAllByTypeAvion(@PathVariable long id) {
        return ResponseEntity.ok(piloteTypeAvionService.getAllByTypeAvion(id).stream()
                .map(PiloteTypeAvionDto::fromEntity)
                .toList());
    }

    /**
     * Deletes a PiloteTypeAvion entity based on the provided ID.
     *
     * @param id The ID of the PiloteTypeAvion entity to delete.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        piloteTypeAvionService.delete(id);
    }
}
