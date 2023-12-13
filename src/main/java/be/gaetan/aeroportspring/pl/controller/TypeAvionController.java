package be.gaetan.aeroportspring.pl.controller;

import be.gaetan.aeroportspring.bll.typeAvion.TypeAvionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/typeavion")
public class TypeAvionController {
    private final TypeAvionService typeAvionService;


    public TypeAvionController(TypeAvionService typeAvionService) {
        this.typeAvionService = typeAvionService;
    }
}
