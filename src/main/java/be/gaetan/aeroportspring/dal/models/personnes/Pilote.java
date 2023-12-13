package be.gaetan.aeroportspring.dal.models.personnes;

import be.gaetan.aeroportspring.dal.models.personnes.Personne;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity

public class Pilote extends Personne {
    @Column(nullable = false, unique = true)
    private long numBrevet;
}
