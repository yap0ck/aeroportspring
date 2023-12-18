package be.gaetan.aeroportspring.dal.repositories;

import be.gaetan.aeroportspring.dal.models.personnes.Proprio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProprioRepository extends JpaRepository<Proprio, Long>, JpaSpecificationExecutor<Proprio> {
    Page<Proprio> findAllByDeleted(boolean deleted, Pageable pageable);
}
