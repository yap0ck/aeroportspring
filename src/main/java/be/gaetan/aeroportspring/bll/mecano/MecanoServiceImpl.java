package be.gaetan.aeroportspring.bll.mecano;

import be.gaetan.aeroportspring.dal.models.personnes.Mecano;
import be.gaetan.aeroportspring.dal.repositories.MecanoRepository;
import be.gaetan.aeroportspring.pl.models.mecano.form.MecanoForm;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MecanoServiceImpl implements MecanoService{
    private final MecanoRepository mecanoRepository;

    public MecanoServiceImpl(MecanoRepository mecanoRepository) {
        this.mecanoRepository = mecanoRepository;
    }

    /**
     * Creates a new Mecano object and saves it to the mecanoRepository.
     *
     * @param form the MecanoForm containing the information for creating a new Mecano
     */
    @Override
    public void create(MecanoForm form) {
        Mecano mecano = new Mecano();
        mecano.setName(form.name());
        mecano.setAdress(form.adress());
        mecano.setPhoneNumber(form.phoneNumber());
        mecanoRepository.save(mecano);
    }

    /**
     * Retrieves a Mecano object by its ID.
     *
     * @param id the ID of the Mecano to retrieve
     * @return the retrieved Mecano object
     * @throws EntityNotFoundException if the Mecano with the specified ID is not found or has been deleted
     */
    @Override
    public Mecano getOne(long id) {
        Mecano mecano = mecanoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("mecanicien pas trouvé"));
        if (mecano.isDeleted()) throw new EntityNotFoundException("mecanicien pas trouvé");
        return mecano;
    }

    /**
     * Retrieves all non-deleted Mecano objects.
     *
     * @return a list of Mecano objects
     */
    @Override
    public List<Mecano> getAll() {
        return mecanoRepository.findAllByDeleted(false);
    }
    /**
     * Updates a Mecano entity with the specified ID using the provided form data.
     *
     * @param id   the ID of the Mecano to update
     * @param form the MecanoForm containing the updated information
     * @throws EntityNotFoundException if the Mecano with the specified ID is not found or has been deleted
     */
    @Override
    public void update(long id, MecanoForm form) {
        Mecano mecano = mecanoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("mecanicien pas trouvé"));
        if (mecano.isDeleted()) throw new EntityNotFoundException("mecanicien pas trouvé");
        mecano.setName(form.name());
        mecano.setAdress(form.adress());
        mecano.setPhoneNumber(form.phoneNumber());
        mecanoRepository.save(mecano);
    }
}
