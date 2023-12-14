package be.gaetan.aeroportspring.pl.models.joinTables.piloteTypeAvion.forms;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PiloteTypeAvionForm(
        @Min(value = 0)
        int nbVols,
        @NotNull @NotBlank
        long piloteId,
        @NotNull @NotBlank
        long typeAvionId
) {
}
