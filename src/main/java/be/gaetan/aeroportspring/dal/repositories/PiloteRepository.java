package be.gaetan.aeroportspring.dal.repositories;

import be.gaetan.aeroportspring.dal.models.Pilote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PiloteRepository extends JpaRepository<Pilote, Long> {
}
