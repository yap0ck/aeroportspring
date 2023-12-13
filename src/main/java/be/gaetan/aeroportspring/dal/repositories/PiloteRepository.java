package be.gaetan.aeroportspring.dal.repositories;

import be.gaetan.aeroportspring.dal.models.Pilote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PiloteRepository extends JpaRepository<Pilote, Long>, JpaSpecificationExecutor<Pilote> {
    List<Pilote> findAllByDeleted(boolean deleted);
}
