package be.gaetan.aeroportspring.pl.models.mecano.dto;

import be.gaetan.aeroportspring.dal.models.personnes.Mecano;

public record MecanoFullDto(
        long id,
        String name,
        String adress,
        String phoneNumber
) {
    public static MecanoFullDto fromEntity(Mecano mecano){
        return new MecanoFullDto(mecano.getId(), mecano.getName(), mecano.getAdress(), mecano.getPhoneNumber());
    }
}
