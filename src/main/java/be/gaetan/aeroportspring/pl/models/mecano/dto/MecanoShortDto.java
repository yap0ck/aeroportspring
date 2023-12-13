package be.gaetan.aeroportspring.pl.models.mecano.dto;

import be.gaetan.aeroportspring.dal.models.personnes.Mecano;

public record MecanoShortDto(
        long id,
        String name,
        String phoneNumber
) {
    public static MecanoShortDto fromEntity(Mecano mecano){
        return new MecanoShortDto(mecano.getId(), mecano.getName(), mecano.getPhoneNumber());
    }
}
