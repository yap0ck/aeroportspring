package be.gaetan.aeroportspring.bll.pilote;

import be.gaetan.aeroportspring.dal.models.personnes.Pilote;
import be.gaetan.aeroportspring.pl.models.pilote.form.PiloteForm;

import java.util.List;

public interface PiloteService {
    void create(PiloteForm form);
    Pilote getOne(long id);
    List<Pilote> getAll();
    void update(long id, PiloteForm form);
    void delete(long id);
}
