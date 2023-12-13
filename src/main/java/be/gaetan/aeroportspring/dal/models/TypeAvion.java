package be.gaetan.aeroportspring.dal.models;

import be.gaetan.aeroportspring.dal.models.personnes.Mecano;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Entity
@Data
public class TypeAvion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String constructor;
    private int puissance;
    private int nbPlaces;
    private boolean deleted;
    @ManyToMany(mappedBy = "habilitations")
    private List<Mecano> mecanoList;

}
