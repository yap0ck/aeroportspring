package be.gaetan.aeroportspring.pl.models.intervention.forms;

import java.time.LocalDate;

public record InterventionSearchForm(
        LocalDate date,
        int duree,
        long reparateurId,
        String avion_id
) {
}
