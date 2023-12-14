package be.gaetan.aeroportspring.pl.models.typeAvion.dto;

import be.gaetan.aeroportspring.dal.models.TypeAvion;
import be.gaetan.aeroportspring.dal.models.joinTables.PiloteTypeAvion;

import java.util.List;

public record TypeAvionFullDto(
        String name,
        String constructeur,
        int puissance,
        int nbPlaces,
        List<Long> piloteTypeAvionId
) {
    public static TypeAvionFullDto fromEntity(TypeAvion typeAvion){
        return new TypeAvionFullDto(typeAvion.getName(),
                typeAvion.getConstructor(),
                typeAvion.getPuissance(),
                typeAvion.getNbPlaces(),
                typeAvion.getPiloteTypeAvionList().stream()
                        .map(PiloteTypeAvion::getId)
                        .toList());
    }
}
