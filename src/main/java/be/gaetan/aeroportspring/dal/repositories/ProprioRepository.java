package be.gaetan.aeroportspring.dal.repositories;

import be.gaetan.aeroportspring.dal.models.personnes.Proprio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprioRepository extends JpaRepository<Proprio, Long>, JpaSpecificationExecutor<Proprio> {
}
