package be.gaetan.aeroportspring.pl.models.intervention.dtos;

import be.gaetan.aeroportspring.dal.models.Intervention;

import java.time.LocalDate;
import java.util.List;

public record InterventionFullDto(
        long id,
        String objet,
        LocalDate date,
        int duree,
        long reparateurId,
        long verificateurId,
        String avionId
) {
    public static InterventionFullDto fromEntity(Intervention intervention){
        return new InterventionFullDto(
                intervention.getId(),
                intervention.getObjet(),
                intervention.getDate(),
                intervention.getDuree(),
                intervention.getReparateur().getId(),
                intervention.getVerificateur().getId(),
                intervention.getAvion().getImmatriculation()
        );
    }
}
