package be.gaetan.aeroportspring.dal.repositories;

import be.gaetan.aeroportspring.dal.models.Intervention;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterventionRepository extends JpaRepository<Intervention, Long>, JpaSpecificationExecutor<Intervention> {
    Page<Intervention> findAllByDeleted(boolean deleted, Pageable pageable);
    @Query("SELECT i FROM Intervention i JOIN i.reparateur r WHERE r.id = :reparateur_id")
    Page<Intervention> findAllByReparateur(@Param("reparateur_id") long id, Pageable pageable);
    @Query("SELECT i FROM Intervention i JOIN i.verificateur v WHERE v.id = :verificateur_id")
    Page<Intervention>findAllByVerificateur(@Param("verificateur_id") long id, Pageable pageable);
    @Query("SELECT i FROM Intervention i JOIN i.avion a where a.immatriculation LIKE :avion_id")
    Page<Intervention>findAllByAvion(@Param("avion_id") String id, Pageable pageable);
}
