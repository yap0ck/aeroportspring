package be.gaetan.aeroportspring.dal.repositories;

import be.gaetan.aeroportspring.dal.models.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterventionRepository extends JpaRepository<Intervention, Long>, JpaSpecificationExecutor<Intervention> {
    List<Intervention> findAllByDeleted(boolean deleted);
    @Query("SELECT i FROM Intervention i JOIN i.reparateur r WHERE r.id = :reparateur_id")
    List<Intervention> findAllByReparateur(@Param("reparateur_id") long id);
    @Query("SELECT i FROM Intervention i JOIN i.verificateur v WHERE v.id = :verificateur_id")
    List<Intervention>findAllByVerificateur(@Param("verificateur_id") long id);
    @Query("SELECT i FROM Intervention i JOIN i.avion a where a.immatriculation LIKE :avion_id")
    List<Intervention>findAllByAvion(@Param("avion_id") String id);
}
