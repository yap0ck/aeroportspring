package be.gaetan.aeroportspring.dal.repositories;

import be.gaetan.aeroportspring.dal.models.personnes.Mecano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MecanoRepository extends JpaRepository<Mecano, Long>, JpaSpecificationExecutor<Mecano> {
    public List<Mecano> findAllByDeleted(boolean deleted);
}
