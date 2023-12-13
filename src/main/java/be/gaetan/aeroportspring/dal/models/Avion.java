package be.gaetan.aeroportspring.dal.models;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Avion {
    @Id
    private String immatriculation;
    private boolean deleted;
}
