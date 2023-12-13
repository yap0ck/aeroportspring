package be.gaetan.aeroportspring.pl.models.proprio.dto;

import be.gaetan.aeroportspring.dal.models.personnes.Proprio;

public record ProprioFullDto(
        String name,
        String phoneNumber,
        String adress
) {
    public static ProprioFullDto fromEntity(Proprio proprio){
        return new ProprioFullDto(proprio.getName(), proprio.getPhoneNumber(), proprio.getAdress());
    }
}
