package be.gaetan.aeroportspring.dal.models.personnes;

import be.gaetan.aeroportspring.dal.models.joinTables.PiloteTypeAvion;
import be.gaetan.aeroportspring.dal.models.personnes.Personne;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity

public class Pilote extends Personne {
    @Column(nullable = false, unique = true)
    private long numBrevet;
    @OneToMany(mappedBy = "pilote")
    List<PiloteTypeAvion> piloteTypeAvionList;
}
