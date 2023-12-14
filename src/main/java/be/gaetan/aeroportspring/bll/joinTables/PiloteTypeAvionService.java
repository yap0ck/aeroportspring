package be.gaetan.aeroportspring.bll.joinTables;

import be.gaetan.aeroportspring.pl.models.joinTables.piloteTypeAvion.dtos.PiloteTypeAvionDto;
import be.gaetan.aeroportspring.pl.models.joinTables.piloteTypeAvion.forms.PiloteTypeAvionForm;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PiloteTypeAvionService {
    void create(PiloteTypeAvionForm form);
    ResponseEntity<PiloteTypeAvionDto> getOneById(long id);
    ResponseEntity<List<PiloteTypeAvionDto>> getAll();
    void update(long id, PiloteTypeAvionForm form);
    void delete(long id);
    ResponseEntity<List<PiloteTypeAvionDto>> getAllByPilote(long id);
    ResponseEntity<List<PiloteTypeAvionDto>> getAllByTypeAvion(long id);
}
