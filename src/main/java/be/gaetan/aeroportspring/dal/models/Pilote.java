package be.gaetan.aeroportspring.dal.models;

import jakarta.persistence.*;

@Entity

public class Pilote extends Personne{
    @Column(nullable = false, unique = true)
    long numBrevet;
}
