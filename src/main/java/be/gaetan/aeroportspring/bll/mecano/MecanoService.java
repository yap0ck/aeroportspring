package be.gaetan.aeroportspring.bll.mecano;

import be.gaetan.aeroportspring.dal.models.personnes.Mecano;
import be.gaetan.aeroportspring.pl.models.mecano.form.MecanoForm;

import java.util.List;

public interface MecanoService {
    void create(MecanoForm form);
    Mecano getOne(long id);
    List<Mecano> getAll();
    void update(long id,MecanoForm form);
}
