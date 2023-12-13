package be.gaetan.aeroportspring.pl.models.avion.dto;

import be.gaetan.aeroportspring.dal.models.Avion;

public record AvionFullDto(
        String immatriculation
) {
    public static AvionFullDto fromEntity(Avion avion){
        return new AvionFullDto(avion.getImmatriculation());
    }
}
