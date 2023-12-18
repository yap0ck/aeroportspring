package be.gaetan.aeroportspring.dal.repositories;

import be.gaetan.aeroportspring.dal.models.TypeAvion;
import be.gaetan.aeroportspring.dal.models.joinTables.PiloteTypeAvion;
import be.gaetan.aeroportspring.dal.models.personnes.Pilote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PiloteTypeAvionRepository extends JpaRepository<PiloteTypeAvion,Long> {
    Page<PiloteTypeAvion> findAllByDeleted(boolean deleted, Pageable pageable);
    Page<PiloteTypeAvion> findByPilote(Pilote pilote, Pageable pageable);
    Page<PiloteTypeAvion> findByTypeAvion(TypeAvion typeAvion, Pageable pageable);
}
