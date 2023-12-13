package be.gaetan.aeroportspring.dal.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
