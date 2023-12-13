package be.gaetan.aeroportspring.pl.controller;

import be.gaetan.aeroportspring.bll.mecano.MecanoService;
import be.gaetan.aeroportspring.dal.models.personnes.Mecano;
import be.gaetan.aeroportspring.pl.models.mecano.form.MecanoForm;
import org.springframework.web.bind.annotation.*;

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
    public Mecano getMecano(@PathVariable long id) {
        return mecanoService.getOne(id);
    }
}
