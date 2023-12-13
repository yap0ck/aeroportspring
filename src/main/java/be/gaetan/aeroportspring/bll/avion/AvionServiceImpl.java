package be.gaetan.aeroportspring.bll.avion;

import be.gaetan.aeroportspring.dal.models.Avion;
import be.gaetan.aeroportspring.dal.repositories.AvionRepository;
import be.gaetan.aeroportspring.pl.models.avion.form.AvionForm;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AvionServiceImpl implements AvionService{
    private final AvionRepository avionRepository;

    public AvionServiceImpl(AvionRepository avionRepository) {
        this.avionRepository = avionRepository;
    }

    /**
     * Creates a new Avion object based on the provided AvionForm, and saves it to the repository.
     *
     * @param form the AvionForm object that contains the details for creating the Avion
     */
    @Override
    public void create(AvionForm form) {
        Avion avion = new Avion();
        avion.setImmatriculation(form.immatriculation());
        avionRepository.save(avion);
    }

    /**
     * Retrieves an Avion object by its ID.
     *
     * @param id the ID of the Avion object to retrieve
     * @return the Avion object with the specified ID
     * @throws EntityNotFoundException if the Avion object is not found or it is marked as deleted
     */
    @Override
    public Avion getOne(String id) {
        Avion avion = avionRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Avion pas trouvé"));
        if (avion.isDeleted()) throw new EntityNotFoundException("Avion pas trouvé");
        return avion;
    }

    /**
     * Retrieves all non-deleted Avion objects from the repository.
     *
     * @return a List of Avion objects that are not marked as deleted
     */
    @Override
    public List<Avion> getAll() {
        return avionRepository.findAllByDeleted(false);
    }

    /**
     * Updates the Avion object with the specified ID by modifying its immatriculation field.
     *
     * @param id   the ID of the Avion object to update
     * @param form the AvionForm object containing the new immatriculation value
     * @throws EntityNotFoundException if the Avion object with the specified ID is not found or is marked as deleted
     */
    @Override
    public void update(String id, AvionForm form) {
        Avion avion = getOne(id);
        avion.setImmatriculation(form.immatriculation());
        avionRepository.save(avion);
    }

    /**
     * Deletes an Avion object by setting its deleted flag to true.
     *
     * @param id the ID of the Avion object to delete
     * @throws EntityNotFoundException if the Avion object with the specified ID is not found or is already marked as deleted
     */
    @Override
    public void delete(String id) {
        Avion avion = getOne(id);
        avion.setDeleted(true);
        avionRepository.save(avion);
    }
}
