package be.gaetan.aeroportspring.bll.pilote;

import be.gaetan.aeroportspring.dal.models.Pilote;
import be.gaetan.aeroportspring.pl.models.pilote.form.PiloteForm;

public interface PiloteService {
    void create(PiloteForm form);
    Pilote getOne(long id);
}
