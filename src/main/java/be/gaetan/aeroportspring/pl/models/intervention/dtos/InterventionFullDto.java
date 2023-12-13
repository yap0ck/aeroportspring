package be.gaetan.aeroportspring.pl.models.intervention.dtos;

import be.gaetan.aeroportspring.dal.models.Intervention;

import java.time.LocalDate;

public record InterventionFullDto(
        long id,
        String objet,
        LocalDate date,
        int duree
) {
    public static InterventionFullDto fromEntity(Intervention intervention){
        return new InterventionFullDto(
                intervention.getId(),
                intervention.getObjet(),
                intervention.getDate(),
                intervention.getDuree()
        );
    }
}
