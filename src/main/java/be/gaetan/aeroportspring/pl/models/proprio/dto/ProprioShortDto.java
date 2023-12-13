package be.gaetan.aeroportspring.pl.models.proprio.dto;

import be.gaetan.aeroportspring.dal.models.personnes.Proprio;

public record ProprioShortDto(
        String name,
        String phoneNumber
) {
    public static ProprioShortDto fromEntity(Proprio proprio){
        return new ProprioShortDto(proprio.getName(), proprio.getPhoneNumber());
    }
}
