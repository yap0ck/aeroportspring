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

public record InterventionForm(
        @NotNull
        String objet,
        @Future
        LocalDate date,
        @Min(value = 1)
        int duree,
        @NotNull @NotBlank
        @Getter
        @DifferentIds
        long reparateurId,
        @NotNull @NotBlank
        @Getter
        @DifferentIds
        long verificateurId,
        @NotBlank @NotNull
        String avionId
) {
}
