package be.gaetan.aeroportspring.dal.repositories;

import be.gaetan.aeroportspring.dal.models.TypeAvion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeAvionRepository extends JpaRepository<TypeAvion, Long>, JpaSpecificationExecutor<TypeAvion> {
    List<TypeAvion> findAllByDeleted(boolean deleted);
    @Query("SELECT t FROM TypeAvion t JOIN t.mecanoList m WHERE m.id = :mecano_id")
    List<TypeAvion> findAllByMecanoId(@Param("mecano_id") Long mecanoId);
}
