package be.gaetan.aeroportspring.bll.joinTables;

import be.gaetan.aeroportspring.dal.models.joinTables.PiloteTypeAvion;
import be.gaetan.aeroportspring.pl.models.joinTables.piloteTypeAvion.forms.PiloteTypeAvionForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PiloteTypeAvionService {
    void create(PiloteTypeAvionForm form);
    PiloteTypeAvion getOneById(long id);
    Page<PiloteTypeAvion> getAll(Pageable pageable);
    void update(long id, PiloteTypeAvionForm form);
    void delete(long id);
    Page<PiloteTypeAvion> getAllByPilote(long id, Pageable pageable);
    Page<PiloteTypeAvion> getAllByTypeAvion(long id, Pageable pageable);
}
