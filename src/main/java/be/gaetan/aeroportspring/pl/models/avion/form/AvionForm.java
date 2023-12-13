package be.gaetan.aeroportspring.pl.models.avion.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AvionForm(
        @NotNull @NotBlank
        @Pattern(regexp = "^([A-Z]{2})([A-Z0-9-]+)$")
        String immatriculation
) {
}
