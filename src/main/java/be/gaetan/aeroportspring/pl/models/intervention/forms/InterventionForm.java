package be.gaetan.aeroportspring.pl.models.intervention.forms;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record InterventionForm(
        @NotNull
        String objet,
        @Future
        LocalDate date,
        @Min(value = 1)
        int duree
) {
}
