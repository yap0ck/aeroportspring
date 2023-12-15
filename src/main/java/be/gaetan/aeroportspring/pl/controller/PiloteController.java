package be.gaetan.aeroportspring.pl.controller;

import be.gaetan.aeroportspring.bll.pilote.PiloteService;
import be.gaetan.aeroportspring.pl.models.pilote.dto.PiloteFullDto;
import be.gaetan.aeroportspring.pl.models.pilote.dto.PiloteShortDto;
import be.gaetan.aeroportspring.pl.models.pilote.form.PiloteForm;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pilote")
public class PiloteController {
    private final PiloteService piloteService;

    public PiloteController(PiloteService piloteService) {
        this.piloteService = piloteService;
    }

    /**
     * Creates a new pilot record using the provided form data.
     *
     * @param form The form data containing the pilot details.
     *             The form should be annotated with the {@link Valid} annotation
     *             to enable validation of the input data.
     */
    @PostMapping
    public void create(@RequestBody @Valid PiloteForm form){
        piloteService.create(form);
    }

    /**
     * Retrieves a pilot by their ID.
     *
     * @param id The ID of the pilot.
     * @return A ResponseEntity containing the full pilot details as a PiloteFullDto object.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PiloteFullDto> getOneById(@PathVariable long id){
        return ResponseEntity.ok(PiloteFullDto.fromEntity(piloteService.getOne(id)));
    }

    /**
     * Retrieves a list of all pilots.
     *
     * @return A ResponseEntity containing the list of all pilots as a List of PiloteShortDto objects.
     */
    @GetMapping("/all")
    public ResponseEntity<List<PiloteShortDto>> getAll(){
        return ResponseEntity.ok(piloteService.getAll().stream()
                .map(PiloteShortDto::fromEntity)
                .toList());
    }

    /**
     * Updates a pilot record with the provided ID using the data from the PiloteForm object.
     *
     * @param id   The ID of the pilot to be updated.
     * @param form The PiloteForm object containing the updated pilot details.
     *             The object should be annotated with the @Valid annotation to enable validation of the input data.
     */
    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody @Valid PiloteForm form) {
        piloteService.update(id, form);
    }

    /**
     * Deletes a pilot record with the provided ID.
     *
     * @param id The ID of the pilot record to be deleted.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        piloteService.delete(id);
    }

    /**
     * Retrieves the total volume of the pilot identified by the given ID.
     *
     * @param id The ID of the pilot.
     * @return A ResponseEntity containing the total volume as an Integer.
     */
    @GetMapping("/{id}/totalVol")
    public ResponseEntity<Integer> getTotalVol(@PathVariable long id) {
        return ResponseEntity.ok(piloteService.getTotalVol(id));
    }
}
