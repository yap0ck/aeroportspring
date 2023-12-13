package be.gaetan.aeroportspring.dal.models.personnes;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Personne {
    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter @Setter
    @Column(nullable = false)
    private String name;
    @Getter @Setter
    private String adress;
    @Getter @Setter
    private String phoneNumber;
    @Getter @Setter
    private boolean deleted = false;
}
