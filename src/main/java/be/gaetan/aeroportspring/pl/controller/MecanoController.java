package be.gaetan.aeroportspring.pl.controller;

import be.gaetan.aeroportspring.bll.mecano.MecanoService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MecanoController {
    private final MecanoService mecanoService;

    public MecanoController(MecanoService mecanoService) {
        this.mecanoService = mecanoService;
    }
}
