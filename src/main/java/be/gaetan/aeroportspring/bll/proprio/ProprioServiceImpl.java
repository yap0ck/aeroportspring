package be.gaetan.aeroportspring.bll.proprio;

import be.gaetan.aeroportspring.dal.models.personnes.Proprio;
import be.gaetan.aeroportspring.dal.repositories.ProprioRepository;
import be.gaetan.aeroportspring.pl.models.proprio.form.ProprioForm;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProprioServiceImpl implements ProprioService{
    private final ProprioRepository proprioRepository;

    public ProprioServiceImpl(ProprioRepository proprioRepository) {
        this.proprioRepository = proprioRepository;
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
}
