package be.gaetan.aeroportspring.dal.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

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


}
