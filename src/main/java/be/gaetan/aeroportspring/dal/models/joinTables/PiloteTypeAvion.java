package be.gaetan.aeroportspring.dal.models.joinTables;

import be.gaetan.aeroportspring.dal.models.TypeAvion;
import be.gaetan.aeroportspring.dal.models.personnes.Pilote;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter
public class PiloteTypeAvion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    int nbVols;
    @ManyToOne
    @Setter
    @JoinColumn(name = "pilote_id")
    private Pilote pilote;
    @ManyToOne
    @Setter
    @JoinColumn(name = "type_avion_id")
    private TypeAvion typeAvion;
    @Setter
    private boolean deleted;
}
