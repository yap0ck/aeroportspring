package be.gaetan.aeroportspring.bll.proprio;

import be.gaetan.aeroportspring.dal.models.personnes.Proprio;
import be.gaetan.aeroportspring.pl.models.proprio.form.ProprioForm;

public interface ProprioService {
    void create(ProprioForm form);
    Proprio getOne(long id);
}
