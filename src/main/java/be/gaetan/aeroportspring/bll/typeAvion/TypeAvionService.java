package be.gaetan.aeroportspring.bll.typeAvion;

import be.gaetan.aeroportspring.dal.models.TypeAvion;
import be.gaetan.aeroportspring.pl.models.typeAvion.form.TypeAvionForm;

import java.util.List;

public interface TypeAvionService {
    void create(TypeAvionForm form);
    TypeAvion getOne(long id);
    List<TypeAvion> getAll();
    void update(long id, TypeAvionForm form);
    void delete(long id);
    List<TypeAvion> getAllByMecanoId(long id);
}
