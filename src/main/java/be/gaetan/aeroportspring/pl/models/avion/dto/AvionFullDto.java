package be.gaetan.aeroportspring.pl.models.avion.dto;

import be.gaetan.aeroportspring.dal.models.Avion;
import be.gaetan.aeroportspring.dal.models.TypeAvion;
import be.gaetan.aeroportspring.dal.models.personnes.Personne;

import java.util.List;

public record AvionFullDto(
        String immatriculation,
        Long typeAvionId,
        List<Long> proprioIdList
) {
    public static AvionFullDto fromEntity(Avion avion){
        return new AvionFullDto(avion.getImmatriculation(),
                avion.getTypeAvion().getId(),
                avion.getProprioList().stream()
                        .map(Personne::getId)
                        .toList());
    }
}
