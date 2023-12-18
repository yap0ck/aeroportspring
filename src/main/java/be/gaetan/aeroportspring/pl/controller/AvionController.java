package be.gaetan.aeroportspring.pl.controller;

import be.gaetan.aeroportspring.bll.avion.AvionService;
import be.gaetan.aeroportspring.dal.models.Avion;
import be.gaetan.aeroportspring.pl.models.avion.dto.AvionFullDto;
import be.gaetan.aeroportspring.pl.models.avion.dto.AvionShortDto;
import be.gaetan.aeroportspring.pl.models.avion.form.AvionForm;
import be.gaetan.aeroportspring.pl.models.avion.form.AvionSearchForm;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avion")
public class AvionController {
    private final AvionService avionService;

    public AvionController(AvionService avionService) {
        this.avionService = avionService;
    }

    /**
     * Create a new Avion by submitting the AvionForm data.
     *
     * @param form The AvionForm object that contains the data for creating the Avion.
     */
    @PostMapping
    public void create(@RequestBody @Valid AvionForm form){
        avionService.create(form);
    }

    /**
     * Retrieves a specific Avion by its ID.
     *
     * @param id The ID of the Avion to retrieve.
     * @return A {@link ResponseEntity} with the AvionFullDto object representing the Avion, if found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<AvionFullDto> getOne(@PathVariable String id) {
        return ResponseEntity.ok(AvionFullDto.fromEntity(avionService.getOne(id)));
    }

    /**
     * Retrieves all Avions.
     *
     * This method returns a list of AvionShortDto objects representing all Avions in the system.
     *
     * @return A ResponseEntity with a List of AvionShortDto objects representing all Avions, if any.
     */
    @GetMapping
    public ResponseEntity<Page<AvionShortDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok(avionService.getAll(pageable).map(AvionShortDto::fromEntity));
    }

    /**
     * Update an Avion identified by the provided ID with the data from the AvionForm object.
     *
     * @param id   The ID of the Avion to update.
     * @param form The AvionForm object containing the updated data.
     */
    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody @Valid AvionForm form) {
        avionService.update(id, form);
    }

    /**
     * Deletes an Avion identified by the provided ID.
     *
     * This method calls the {@link AvionService#delete(String)} method to delete the Avion.
     *
     * @param id The ID of the Avion to delete.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        avionService.delete(id);
    }

    /**
     * Search for Avions based on the specified search form and pageable parameters.
     *
     * @param form     The AvionSearchForm object containing the search criteria.
     * @param pageable The Pageable object for pagination and sorting.
     * @return A ResponseEntity with a Page of AvionShortDto objects representing the search results, if any.
     */
    @PostMapping("/search")
    public ResponseEntity<Page<AvionShortDto>> search(@RequestBody AvionSearchForm form, Pageable pageable){
        return ResponseEntity.ok(avionService.getAllBySpec(form, pageable).map(AvionShortDto::fromEntity));
    }
}
