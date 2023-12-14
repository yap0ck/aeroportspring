package be.gaetan.aeroportspring.bll.intervention;

import be.gaetan.aeroportspring.dal.models.Intervention;
import be.gaetan.aeroportspring.pl.models.intervention.forms.InterventionForm;

import java.util.List;

public interface InterventionService {
    void create (InterventionForm form);
    Intervention getOne(long id);
    List<Intervention> getAll();
    void update(long id, InterventionForm form);
    void delete(long id);
    List<Intervention> getAllByVerificateur(long id);
    List<Intervention> getAllByReparateur(long id);
    List<Intervention> getAllByAvion(String id);
}
