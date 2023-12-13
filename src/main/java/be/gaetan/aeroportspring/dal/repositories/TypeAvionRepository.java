package be.gaetan.aeroportspring.dal.repositories;

import be.gaetan.aeroportspring.dal.models.TypeAvion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeAvionRepository extends JpaRepository<TypeAvion, Long>, JpaSpecificationExecutor<TypeAvion> {
    List<TypeAvion> findAllByDeleted(boolean deleted);
}
