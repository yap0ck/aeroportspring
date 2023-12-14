package be.gaetan.aeroportspring.pl.models.avion.dto;

import be.gaetan.aeroportspring.dal.models.Avion;
import be.gaetan.aeroportspring.dal.models.TypeAvion;

public record AvionFullDto(
        String immatriculation,
        Long typeAvionId
) {
    public static AvionFullDto fromEntity(Avion avion){
        return new AvionFullDto(avion.getImmatriculation(), avion.getTypeAvion().getId());
    }
}
