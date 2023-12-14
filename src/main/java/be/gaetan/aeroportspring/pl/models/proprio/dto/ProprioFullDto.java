package be.gaetan.aeroportspring.pl.models.proprio.dto;

import be.gaetan.aeroportspring.dal.models.Avion;
import be.gaetan.aeroportspring.dal.models.personnes.Proprio;

import java.util.List;

public record ProprioFullDto(
        String name,
        String phoneNumber,
        String adress,
        List<String> avionIdList
) {
    public static ProprioFullDto fromEntity(Proprio proprio){
        return new ProprioFullDto(proprio.getName(),
                proprio.getPhoneNumber(),
                proprio.getAdress(),
                proprio.getAvionList().stream()
                        .map(Avion::getImmatriculation)
                        .toList());
    }
}
