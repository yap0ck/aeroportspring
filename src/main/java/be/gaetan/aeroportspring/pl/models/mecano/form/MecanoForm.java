package be.gaetan.aeroportspring.pl.models.mecano.form;

import be.gaetan.aeroportspring.dal.models.TypeAvion;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MecanoForm(
        @NotNull @NotBlank
        String name,
        @NotNull @NotBlank
        String adress,
        @NotNull @NotBlank
        String phoneNumber,
        @NotNull
        List<Long> habilitations
) {
}
