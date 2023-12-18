package be.gaetan.aeroportspring.bll.intervention;

import be.gaetan.aeroportspring.dal.models.Intervention;
import be.gaetan.aeroportspring.pl.models.intervention.forms.InterventionForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InterventionService {
    void create (InterventionForm form);
    Intervention getOne(long id);
    Page<Intervention> getAll(Pageable pageable);
    void update(long id, InterventionForm form);
    void delete(long id);
    Page<Intervention> getAllByVerificateur(long id, Pageable pageable);
    Page<Intervention> getAllByReparateur(long id, Pageable pageable);
    Page<Intervention> getAllByAvion(String id, Pageable pageable);
}
