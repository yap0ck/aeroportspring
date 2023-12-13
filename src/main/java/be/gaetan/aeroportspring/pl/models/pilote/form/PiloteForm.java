package be.gaetan.aeroportspring.pl.models.pilote.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PiloteForm(
        @NotNull @NotBlank
        String name,
        @NotNull @NotBlank
        String adress,
        @NotNull @NotBlank
        String phoneNumber,
        @NotNull @NotBlank
        long numBrevet
) {
}
