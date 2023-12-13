package be.gaetan.aeroportspring.pl.models.typeAvion.dto;

import be.gaetan.aeroportspring.dal.models.TypeAvion;

public record TypeAvionShortDto(
        String name,
        String constructeur
) {
    public static TypeAvionShortDto fromEntity(TypeAvion typeAvion){
        return new TypeAvionShortDto(
                typeAvion.getName(),
                typeAvion.getConstructor()
        );
    }
}
