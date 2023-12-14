package be.gaetan.aeroportspring.pl.models.intervention.forms;

import be.gaetan.aeroportspring.dal.models.TypeAvion;
import be.gaetan.aeroportspring.pl.validation.constraints.DifferentIds;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
@DifferentIds
public record InterventionForm(
        @NotNull
        String objet,
        @Future
        LocalDate date,
        @Min(value = 1)
        int duree,
        @NotNull
        @Getter
        long reparateurId,
        @NotNull
        @Getter
        long verificateurId,
        @NotBlank @NotNull
        String avionId
) {
}
