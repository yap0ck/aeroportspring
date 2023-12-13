package be.gaetan.aeroportspring.pl.controller;

import be.gaetan.aeroportspring.bll.proprio.ProprioService;
import be.gaetan.aeroportspring.pl.models.proprio.form.ProprioForm;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
