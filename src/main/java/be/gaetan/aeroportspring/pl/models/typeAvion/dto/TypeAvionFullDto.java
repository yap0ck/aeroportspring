package be.gaetan.aeroportspring.pl.models.typeAvion.dto;

import be.gaetan.aeroportspring.dal.models.TypeAvion;

public record TypeAvionFullDto(
        String name,
        String constructeur,
        int puissance,
        int nbPlaces
) {
    public static TypeAvionFullDto fromEntity(TypeAvion typeAvion){
        return new TypeAvionFullDto(typeAvion.getName(), typeAvion.getConstructor(), typeAvion.getPuissance(), typeAvion.getNbPlaces());
    }
}
