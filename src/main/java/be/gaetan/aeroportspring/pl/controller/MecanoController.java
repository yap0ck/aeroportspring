package be.gaetan.aeroportspring.pl.controller;

import be.gaetan.aeroportspring.bll.mecano.MecanoService;
import be.gaetan.aeroportspring.dal.models.personnes.Mecano;
import be.gaetan.aeroportspring.pl.models.mecano.dto.MecanoFullDto;
import be.gaetan.aeroportspring.pl.models.mecano.dto.MecanoShortDto;
import be.gaetan.aeroportspring.pl.models.mecano.form.MecanoForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mecano")
public class MecanoController {
    private final MecanoService mecanoService;

    public MecanoController(MecanoService mecanoService) {
        this.mecanoService = mecanoService;
    }
    /**
     * Creates a new Mecano using the provided MecanoForm.
     *
     * @param form The MecanoForm object containing the necessary information to create a Mecano.
     */
    @PostMapping("/")
    public void createMecano(@RequestBody MecanoForm form) {
        mecanoService.create(form);
    }

    /**
     * Retrieves a Mecano with the specified ID.
     *
     * @param id The ID of the Mecano to retrieve.
     * @return The Mecano object with the specified ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<MecanoFullDto> getMecano(@PathVariable long id) {
        return ResponseEntity.ok(MecanoFullDto.fromEntity(mecanoService.getOne(id)));
    }

    /**
     * Retrieves all Mecanos.
     *
     * @return ResponseEntity<List < MecanoShortDto>> The ResponseEntity containing a list of MecanoShortDto objects.
     */
    @GetMapping("/all")
    public ResponseEntity<List<MecanoShortDto>> getAllMecanos() {
        return ResponseEntity.ok(mecanoService.getAll().stream()
                .map(MecanoShortDto::fromEntity)
                .toList());
    }
    /**
     * Updates a Mecano with the specified ID using the provided MecanoForm.
     *
     * @param id   The ID of the Mecano to update.
     * @param form The MecanoForm object containing the updated information.
     */
    @PutMapping("/{id}")
    public void updateMecano(@PathVariable long id, @RequestBody MecanoForm form) {
        mecanoService.update(id, form);
    }

    /**
     * Deletes a Mecano with the specified ID.
     *
     * @param id The ID of the Mecano to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteMecano(@PathVariable long id) {
        mecanoService.delete(id);
    }
}
