package be.gaetan.aeroportspring.pl.models.proprio.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProprioForm(
        @NotNull @NotBlank
        String name,
        @NotNull @NotBlank
        String adress,
        @NotNull @NotBlank
        String phoneNumber
) {
}
