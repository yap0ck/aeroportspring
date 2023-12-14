package be.gaetan.aeroportspring.pl.models.pilote.dto;

import be.gaetan.aeroportspring.dal.models.joinTables.PiloteTypeAvion;
import be.gaetan.aeroportspring.dal.models.personnes.Pilote;

import java.util.List;

public record PiloteFullDto(
        long id,
        String name,
        String adress,
        String phoneNumber,
        long numBrevet,
        List<Long> piloteTypeAvionId
) {
    public static PiloteFullDto fromEntity(Pilote pilote){
        return new PiloteFullDto(pilote.getId(),
                pilote.getName(),
                pilote.getAdress(),
                pilote.getPhoneNumber(),
                pilote.getNumBrevet(),
                pilote.getPiloteTypeAvionList().stream()
                        .map(PiloteTypeAvion::getId)
                        .toList());
    }
}
