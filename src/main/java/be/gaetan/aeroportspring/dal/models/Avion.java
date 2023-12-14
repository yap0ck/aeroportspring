package be.gaetan.aeroportspring.dal.models;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Avion {
    @Id
    private String immatriculation;
    private boolean deleted;
    @ManyToOne
    @JoinColumn(name = "type_avion_id")
    private TypeAvion typeAvion;
}
