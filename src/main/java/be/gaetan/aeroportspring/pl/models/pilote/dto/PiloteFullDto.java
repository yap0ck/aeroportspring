package be.gaetan.aeroportspring.pl.models.pilote.dto;

import be.gaetan.aeroportspring.dal.models.Pilote;

public record PiloteFullDto(
        long id,
        String name,
        String adress,
        String phoneNumber,
        long numBrevet
) {
    public static PiloteFullDto fromEntity(Pilote pilote){
        return new PiloteFullDto(pilote.getId(), pilote.getName(), pilote.getAdress(), pilote.getPhoneNumber(), pilote.getNumBrevet());
    }
}
