package be.gaetan.aeroportspring.bll.mecano;

import be.gaetan.aeroportspring.dal.models.personnes.Mecano;
import be.gaetan.aeroportspring.pl.models.mecano.form.MecanoForm;

public interface MecanoService {
    void create(MecanoForm form);
    Mecano getOne(long id);
}
