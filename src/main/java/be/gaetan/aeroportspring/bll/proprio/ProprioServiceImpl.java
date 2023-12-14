package be.gaetan.aeroportspring.bll.proprio;

import be.gaetan.aeroportspring.dal.models.personnes.Proprio;
import be.gaetan.aeroportspring.dal.repositories.AvionRepository;
import be.gaetan.aeroportspring.dal.repositories.ProprioRepository;
import be.gaetan.aeroportspring.pl.models.proprio.form.ProprioForm;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProprioServiceImpl implements ProprioService{
    private final ProprioRepository proprioRepository;
    private final AvionRepository avionRepository;

    public ProprioServiceImpl(ProprioRepository proprioRepository, AvionRepository avionRepository) {
        this.proprioRepository = proprioRepository;
        this.avionRepository = avionRepository;
    }

    /**
     * Creates a new Proprio entity and saves it in the repository.
     *
     * @param form The ProprioForm object containing the data for creating the Proprio.
     */
    @Override
    public void create(ProprioForm form) {
        Proprio proprio = new Proprio();
        proprio.setName(form.name());
        proprio.setAdress(form.adress());
        proprio.setPhoneNumber(form.phoneNumber());
        proprio.setAvionList(form.avionIdList().stream()
                .map(e-> avionRepository.findById(e).orElseThrow(()-> new EntityNotFoundException("avion pas trouvé")))
                .toList());
        proprioRepository.save(proprio);
    }

    /**
     * Retrieves a Proprio entity by its ID.
     *
     * @param id The ID of the Proprio entity to retrieve.
     * @return The retrieved Proprio entity.
     * @throws EntityNotFoundException If the Proprio entity is not found or if it is marked as deleted.
     */
    @Override
    public Proprio getOne(long id) {
        Proprio proprio = proprioRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("propriétaire pas trouvé"));
        if (proprio.isDeleted()) throw new EntityNotFoundException("propriétaire pas trouvé");
        return proprio;
    }

    /**
     * Retrieves all non-deleted Proprio entities.
     *
     * @return A List containing all non-deleted Proprio entities.
     */
    @Override
    public List<Proprio> getAll() {
        return proprioRepository.findAllByDeleted(false);
    }

    /**
     * Updates a Proprio entity with the specified ID using the provided form data.
     * Throws an EntityNotFoundException if the Proprio entity is not found or marked as deleted.
     *
     * @param id   The ID of the Proprio entity to update.
     * @param form The ProprioForm object containing the updated data for the Proprio.
     * @throws EntityNotFoundException If the Proprio entity is not found or marked as deleted.
     */
    @Override
    public void update(long id, ProprioForm form) {
        Proprio proprio = proprioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("propriétaire pas trouvé"));
        if (proprio.isDeleted()) throw new EntityNotFoundException("propriétaire pas trouvé");
        proprio.setName(form.name());
        proprio.setAdress(form.adress());
        proprio.setPhoneNumber(form.phoneNumber());
        proprio.setAvionList(form.avionIdList().stream()
                .map(e-> avionRepository.findById(e).orElseThrow(()-> new EntityNotFoundException("avion pas trouvé")))
                .toList());
        proprioRepository.save(proprio);
    }

    /**
     * Deletes a Proprio entity with the specified ID.
     *
     * @param id The ID of the Proprio entity to delete.
     * @throws EntityNotFoundException If the Proprio entity is not found or if it is already marked as deleted.
     */
    @Override
    public void delete(long id) {
        Proprio proprio = proprioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("propriétaire pas trouvé"));
        if (proprio.isDeleted()) throw new EntityNotFoundException("propriétaire pas trouvé");
        proprio.setDeleted(true);
        proprioRepository.save(proprio);
    }
}
