package be.gaetan.aeroportspring.bll.proprio;

import be.gaetan.aeroportspring.dal.models.personnes.Proprio;
import be.gaetan.aeroportspring.pl.models.proprio.form.ProprioForm;

import java.util.List;

public interface ProprioService {
    void create(ProprioForm form);
    Proprio getOne(long id);
    List<Proprio> getAll();
    void update(long id, ProprioForm form);
}
