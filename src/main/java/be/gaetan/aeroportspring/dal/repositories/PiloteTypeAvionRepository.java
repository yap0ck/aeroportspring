package be.gaetan.aeroportspring.dal.repositories;

import be.gaetan.aeroportspring.dal.models.TypeAvion;
import be.gaetan.aeroportspring.dal.models.joinTables.PiloteTypeAvion;
import be.gaetan.aeroportspring.dal.models.personnes.Pilote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PiloteTypeAvionRepository extends JpaRepository<PiloteTypeAvion,Long> {
    List<PiloteTypeAvion> findByPilote(Pilote pilote);
    List<PiloteTypeAvion> findByTypeAvion(TypeAvion typeAvion);
}
