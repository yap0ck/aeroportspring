package be.gaetan.aeroportspring.pl.models.mecano.dto;

import be.gaetan.aeroportspring.dal.models.TypeAvion;
import be.gaetan.aeroportspring.dal.models.personnes.Mecano;

import java.util.List;

public record MecanoFullDto(
        long id,
        String name,
        String adress,
        String phoneNumber,
        List<Long> habilitations
) {
    public static MecanoFullDto fromEntity(Mecano mecano){
        return new MecanoFullDto(mecano.getId(),
                mecano.getName(),
                mecano.getAdress(),
                mecano.getPhoneNumber(),
                mecano.getHabilitations().stream()
                        .map(TypeAvion::getId)
                        .toList());
    }
}
