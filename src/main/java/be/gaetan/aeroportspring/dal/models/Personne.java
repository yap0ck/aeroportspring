package be.gaetan.aeroportspring.dal.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Personne {
    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Getter @Setter
    @Column(nullable = false)
    String name;
    @Getter @Setter
    String adress;
    @Getter @Setter
    String phoneNumber;
}
