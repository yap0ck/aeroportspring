package be.gaetan.aeroportspring.dal.repositories;

import be.gaetan.aeroportspring.dal.models.personnes.Pilote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PiloteRepository extends JpaRepository<Pilote, Long>, JpaSpecificationExecutor<Pilote> {
    Page<Pilote> findAllByDeleted(boolean deleted, Pageable pageable);
}
