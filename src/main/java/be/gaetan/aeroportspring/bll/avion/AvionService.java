package be.gaetan.aeroportspring.bll.avion;

import be.gaetan.aeroportspring.dal.models.Avion;
import be.gaetan.aeroportspring.pl.models.avion.form.AvionForm;

import java.util.List;

public interface AvionService {
    void create(AvionForm form);
    Avion getOne(String id);
    List<Avion> getAll();
    void update(String id, AvionForm form);
    void delete(String id);
}
