package be.gaetan.aeroportspring.dal.repositories;

import be.gaetan.aeroportspring.dal.models.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvionRepository extends JpaRepository<Avion, String> {
    List<Avion> findAllByDeleted(boolean deleted);
}
