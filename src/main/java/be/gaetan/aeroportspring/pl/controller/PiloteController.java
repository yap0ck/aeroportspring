package be.gaetan.aeroportspring.pl.controller;

import be.gaetan.aeroportspring.bll.pilote.PiloteService;
import be.gaetan.aeroportspring.pl.models.pilote.dto.PiloteFullDto;
import be.gaetan.aeroportspring.pl.models.pilote.form.PiloteForm;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
}
