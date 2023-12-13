package be.gaetan.aeroportspring.dal.models.personnes;

import be.gaetan.aeroportspring.dal.models.TypeAvion;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Mecano extends Personne {
    @ManyToMany
    @JoinTable(
            name = "mecano_Type_avion",
            joinColumns = @JoinColumn(name = "mecano_id"),
            inverseJoinColumns = @JoinColumn(name = "type_avion_id")
    )
    private List<TypeAvion> habilitations;
}
