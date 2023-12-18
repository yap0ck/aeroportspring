package be.gaetan.aeroportspring.pl.models.avion.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public record AvionForm(
        @NotNull @NotBlank
        @Pattern(regexp = "^[A-Z]-[A-Z]{4}|[A-Z]{2}-[A-Z]{3}|N[0-9]{1,5}[A-Z]{0,2}$")
        String immatriculation,
        @NotNull
        long typeAvionId,
        @NotNull
        List<Long> proprioIdList
) {
}
