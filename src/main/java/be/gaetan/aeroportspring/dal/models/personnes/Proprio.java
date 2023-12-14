package be.gaetan.aeroportspring.dal.models.personnes;

import be.gaetan.aeroportspring.dal.models.Avion;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter @Setter
public class Proprio extends Personne{
    @ManyToMany
    @JoinTable(
            name = "proprio_avion",
            joinColumns = @JoinColumn(name = "proprio_id"),
            inverseJoinColumns = @JoinColumn(name = "avion_id")
    )
    List<Avion> avionList;
}
