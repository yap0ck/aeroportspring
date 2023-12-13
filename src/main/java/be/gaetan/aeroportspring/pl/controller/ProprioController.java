package be.gaetan.aeroportspring.pl.controller;

import be.gaetan.aeroportspring.bll.proprio.ProprioService;
import be.gaetan.aeroportspring.dal.models.personnes.Proprio;
import be.gaetan.aeroportspring.pl.models.proprio.dto.ProprioFullDto;
import be.gaetan.aeroportspring.pl.models.proprio.dto.ProprioShortDto;
import be.gaetan.aeroportspring.pl.models.proprio.form.ProprioForm;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proprio")
public class ProprioController {
    private final ProprioService proprioService;

    public ProprioController(ProprioService proprioService) {
        this.proprioService = proprioService;
    }

    /**
     * Creates a new "Proprio" using the provided form data.
     *
     * @param form The ProprioForm object containing the data for the new "Proprio".
     */
    @PostMapping("/")
    public void createProprio(@RequestBody @Valid ProprioForm form) {
        proprioService.create(form);
    }

    /**
     * Retrieves a single "Proprio" by its ID.
     *
     * @param id The ID of the "Proprio" to retrieve.
     * @return A ResponseEntity containing the ProprioFullDto of the retrieved "Proprio".
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProprioFullDto> getProprio(@PathVariable long id) {
        return ResponseEntity.ok(ProprioFullDto.fromEntity(proprioService.getOne(id)));
    }

    /**
     * Retrieves a list of all "Proprio" entities.
     *
     * @return A ResponseEntity containing a list of ProprioShortDto representing all "Proprio" entities.
     */
    @GetMapping("/")
    public ResponseEntity<List<ProprioShortDto>> getAllProprios() {
        return ResponseEntity.ok(proprioService.getAll().stream()
                .map(ProprioShortDto::fromEntity)
                .toList());
    }

    /**
     * Updates the "Proprio" entity with the provided ID using the data from the provided form.
     *
     * @param id   The ID of the "Proprio*/
    @PutMapping("/{id}")
    public void updateProprio(@PathVariable long id, @RequestBody @Valid ProprioForm form) {
        proprioService.update(id, form);
    }

    /**
     * Deletes a "Proprio" entity by its ID.
     *
     * @param id The ID of the "Proprio" entity to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteProprio(@PathVariable long id) {
        proprioService.delete(id);
    }
}