package be.gaetan.aeroportspring.pl.models.pilote.form;

import be.gaetan.aeroportspring.dal.models.joinTables.PiloteTypeAvion;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record PiloteForm(
        @NotNull @NotBlank
        String name,
        @NotNull @NotBlank
        String adress,
        @NotNull @NotBlank
        String phoneNumber,
        @NotNull
        long numBrevet,
        List<Long> piloteTypeAvionId
) {
}
