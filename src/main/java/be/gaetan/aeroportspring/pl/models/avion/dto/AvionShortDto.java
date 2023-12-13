package be.gaetan.aeroportspring.pl.models.avion.dto;

import be.gaetan.aeroportspring.dal.models.Avion;

public record AvionShortDto(
        String immatriculation
) {
    public static AvionShortDto fromEntity(Avion avion){
        return new AvionShortDto(avion.getImmatriculation());
    }
}
