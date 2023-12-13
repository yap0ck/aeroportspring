package be.gaetan.aeroportspring.dal.models;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Avion {
    @Id
    String immatriculation;
    boolean deleted;
}
