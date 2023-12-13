package be.gaetan.aeroportspring.pl.controller;

import be.gaetan.aeroportspring.bll.mecano.MecanoService;
import be.gaetan.aeroportspring.pl.models.mecano.form.MecanoForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
