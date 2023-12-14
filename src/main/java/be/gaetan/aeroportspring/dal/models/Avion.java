package be.gaetan.aeroportspring.dal.models;

import be.gaetan.aeroportspring.dal.models.personnes.Proprio;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Avion {
    @Id
    private String immatriculation;
    private boolean deleted;
    @ManyToOne
    @JoinColumn(name = "type_avion_id")
    private TypeAvion typeAvion;
    @ManyToMany(mappedBy = "avionList")
    List<Proprio> proprioList;
}
