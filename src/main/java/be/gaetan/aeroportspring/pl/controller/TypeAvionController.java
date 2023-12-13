package be.gaetan.aeroportspring.pl.controller;

import be.gaetan.aeroportspring.bll.typeAvion.TypeAvionService;
import be.gaetan.aeroportspring.pl.models.typeAvion.dto.TypeAvionFullDto;
import be.gaetan.aeroportspring.pl.models.typeAvion.dto.TypeAvionShortDto;
import be.gaetan.aeroportspring.pl.models.typeAvion.form.TypeAvionForm;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeavion")
public class TypeAvionController {
    private final TypeAvionService typeAvionService;


    public TypeAvionController(TypeAvionService typeAvionService) {
        this.typeAvionService = typeAvionService;
    }

    /**
     * Creates a new TypeAvion using the provided TypeAvionForm.
     *
     * @param form The TypeAvionForm object containing the data for creating a TypeAvion.
     */
    @PostMapping
    public void create(@RequestBody @Valid TypeAvionForm form) {
        typeAvionService.create(form);
    }

    /**
     * Retrieves a TypeAvion with the given id.
     *
     * @param id The id of the TypeAvion to retrieve.
     * @return ResponseEntity containing the TypeAvionFullDto representation of the retrieved TypeAvion.
     */
    @GetMapping("/{id}")
    public ResponseEntity<TypeAvionFullDto> getOne(@PathVariable long id) {
        return ResponseEntity.ok(TypeAvionFullDto.fromEntity(typeAvionService.getOne(id)));
    }

    /**
     * Retrieves all TypeAvion records.
     *
     * @return ResponseEntity containing a list of TypeAvionShortDto objects.
     */
    @GetMapping
    public ResponseEntity<List<TypeAvionShortDto>> getAll() {
        return ResponseEntity.ok(typeAvionService.getAll().stream()
                .map(TypeAvionShortDto::fromEntity)
                .toList());
    }

    /**
     * Updates a TypeAvion record with the provided ID and TypeAvionForm object.
     *
     * @param id   The ID of the TypeAvion record to update.
     * @param form The TypeAvionForm object containing the updated data.
     */
    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody @Valid TypeAvionForm form) {
        typeAvionService.update(id, form);
    }

    /**
     * Deletes a TypeAvion record with the specified ID.
     *
     * @param id The ID of the TypeAvion record to delete.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        typeAvionService.delete(id);
    }

    /**
     * Retrieves a list of TypeAvionShortDto objects by mecano ID.
     *
     * @param id The ID of the mecano.
     * @return ResponseEntity containing a list of TypeAvionShortDto objects.
     */
    @GetMapping("/mecano/{id}")
    public ResponseEntity<List<TypeAvionShortDto>> getAllByMecanoId(@PathVariable long id){
        return ResponseEntity.ok(typeAvionService.getAllByMecanoId(id).stream()
                .map(TypeAvionShortDto::fromEntity)
                .toList());
    }
}
