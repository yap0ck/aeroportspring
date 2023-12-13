package be.gaetan.aeroportspring.pl.models.intervention.dtos;

import be.gaetan.aeroportspring.dal.models.Intervention;

import java.time.LocalDate;

public record InterventionShortDto(
        long id,
        String objet,
        LocalDate date
) {
    public static InterventionShortDto fromEntity(Intervention intervention){
        return new InterventionShortDto(intervention.getId(),
                intervention.getObjet(),
                intervention.getDate());
    }
}
