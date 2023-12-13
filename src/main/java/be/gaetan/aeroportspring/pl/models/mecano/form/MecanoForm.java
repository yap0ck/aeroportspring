package be.gaetan.aeroportspring.pl.models.mecano.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MecanoForm(
        @NotNull @NotBlank
        String name,
        @NotNull @NotBlank
        String adress,
        @NotNull @NotBlank
        String phoneNumber) {
}
