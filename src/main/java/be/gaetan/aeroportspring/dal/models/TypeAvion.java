package be.gaetan.aeroportspring.dal.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Entity
@Data @Builder
public class TypeAvion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    String constructor;
    int puissance;
    int nbPlaces;

    public TypeAvion() {

    }
}
