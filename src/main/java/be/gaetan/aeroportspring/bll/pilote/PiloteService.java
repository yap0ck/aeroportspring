package be.gaetan.aeroportspring.bll.pilote;

import be.gaetan.aeroportspring.dal.models.personnes.Pilote;
import be.gaetan.aeroportspring.pl.models.pilote.form.PiloteForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PiloteService {
    void create(PiloteForm form);
    Pilote getOne(long id);
    Page<Pilote> getAll(Pageable pageable);
    void update(long id, PiloteForm form);
    void delete(long id);
    int getTotalVol(long id, Pageable pageable);
}
