package be.gaetan.aeroportspring.pl.controller;

import be.gaetan.aeroportspring.bll.intervention.InterventionService;
import be.gaetan.aeroportspring.dal.models.Intervention;
import be.gaetan.aeroportspring.pl.models.intervention.dtos.InterventionFullDto;
import be.gaetan.aeroportspring.pl.models.intervention.dtos.InterventionShortDto;
import be.gaetan.aeroportspring.pl.models.intervention.forms.InterventionForm;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/intervention")
public class InterventionController {
    private final InterventionService interventionService;

    public InterventionController(InterventionService interventionService) {
        this.interventionService = interventionService;
    }
    /**
     * Creates a new Intervention using the provided form.
     *
     * @param form The InterventionForm object containing the data for the new Intervention.
     */
    @PostMapping
    public void create(@RequestBody @Valid InterventionForm form){
        interventionService.create(form);
    }

    /**
     * Retrieves a specific Intervention by its ID.
     *
     * @param id The ID of the Intervention to retrieve.
     * @return ResponseEntity representing the InterventionFullDto object of the retrieved Intervention,
     *         or ResponseEntity with no body and HttpStatus.NOT_FOUND if the Intervention does not exist.
     */
    @GetMapping("/{id}")
    public ResponseEntity<InterventionFullDto> getOne(@PathVariable long id){
        return ResponseEntity.ok(InterventionFullDto.fromEntity(interventionService.getOne(id)));
    }

    /**
     * Retrieves all interventions.
     *
     * @return ResponseEntity representing a list of InterventionShortDto objects,
     *         or ResponseEntity with no body if there are no interventions.
     */
    @GetMapping
    public ResponseEntity<List<InterventionShortDto>> getAll(){
        return ResponseEntity.ok(interventionService.getAll().stream()
                .map(InterventionShortDto::fromEntity)
                .toList());
    }

    /**
     * Updates an Intervention with the provided ID using the given form.
     *
     * @param id   The ID of the Intervention to update.
     * @param form The InterventionForm object containing the updated data for the Intervention.
     */
    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody @Valid InterventionForm form){
        interventionService.update(id, form);
    }

    /**
     * Deletes an Intervention by its ID.
     *
     * @param id The ID of the Intervention to delete.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        interventionService.delete(id);
    }
}
