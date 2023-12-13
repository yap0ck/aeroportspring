package be.gaetan.aeroportspring.pl.controller;

import be.gaetan.aeroportspring.bll.proprio.ProprioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proprio")
public class ProprioController {
    private final ProprioService proprioService;

    public ProprioController(ProprioService proprioService) {
        this.proprioService = proprioService;
    }
}
