package be.gaetan.aeroportspring.dal.models;

import be.gaetan.aeroportspring.dal.models.personnes.Mecano;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
public class Intervention {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter
    @Setter
    private String objet;
    @Getter
    @Setter
    private LocalDate date;
    @Getter
    @Setter
    private int duree;
    @Getter
    @Setter
    private boolean deleted;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "reparateur_id")
    private Mecano reparateur;
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "verificateur_id")
    private Mecano verificateur;
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "avion_id")
    private Avion avion;
}
