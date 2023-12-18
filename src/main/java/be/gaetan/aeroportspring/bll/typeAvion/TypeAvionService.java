package be.gaetan.aeroportspring.bll.typeAvion;

import be.gaetan.aeroportspring.dal.models.TypeAvion;
import be.gaetan.aeroportspring.pl.models.typeAvion.form.TypeAvionForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeAvionService {
    void create(TypeAvionForm form);
    TypeAvion getOne(long id);
    Page<TypeAvion> getAll(Pageable pageable);
    void update(long id, TypeAvionForm form);
    void delete(long id);
    Page<TypeAvion> getAllByMecanoId(long id, Pageable pageable);
}
