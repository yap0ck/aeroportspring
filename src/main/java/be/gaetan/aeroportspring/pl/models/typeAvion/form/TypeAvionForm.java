package be.gaetan.aeroportspring.pl.models.typeAvion.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TypeAvionForm(
        @NotBlank @NotNull
        String name,
        @NotBlank @NotNull
        String constructeur,
        @NotNull
        @Min(value = 1)
        int puissance,
        @NotNull
        @Min(value = 1)
        int nbPlaces
) {
}
