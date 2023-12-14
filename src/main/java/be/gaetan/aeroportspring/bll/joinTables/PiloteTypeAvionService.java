package be.gaetan.aeroportspring.bll.joinTables;

import be.gaetan.aeroportspring.dal.models.joinTables.PiloteTypeAvion;
import be.gaetan.aeroportspring.pl.models.joinTables.piloteTypeAvion.forms.PiloteTypeAvionForm;

import java.util.List;

public interface PiloteTypeAvionService {
    void create(PiloteTypeAvionForm form);
    PiloteTypeAvion getOneById(long id);
    List<PiloteTypeAvion> getAll();
    void update(long id, PiloteTypeAvionForm form);
    void delete(long id);
    List<PiloteTypeAvion> getAllByPilote(long id);
    List<PiloteTypeAvion> getAllByTypeAvion(long id);
}
