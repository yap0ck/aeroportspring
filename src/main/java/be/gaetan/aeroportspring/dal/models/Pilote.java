package be.gaetan.aeroportspring.dal.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity

public class Pilote extends Personne{
    @Getter @Setter
    @Column(nullable = false, unique = true)
    long numBrevet;
}
