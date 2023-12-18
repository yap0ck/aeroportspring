package be.gaetan.aeroportspring.bll.avion;

import be.gaetan.aeroportspring.dal.models.Avion;
import be.gaetan.aeroportspring.pl.models.avion.form.AvionForm;
import be.gaetan.aeroportspring.pl.models.avion.form.AvionSearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AvionService {
    void create(AvionForm form);
    Avion getOne(String id);
    Page<Avion> getAll(Pageable pageable);
    void update(String id, AvionForm form);
    void delete(String id);
    Page<Avion> getAllBySpec(AvionSearchForm form, Pageable pageable);
}
