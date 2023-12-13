package be.gaetan.aeroportspring.bll.proprio;

import be.gaetan.aeroportspring.dal.models.personnes.Proprio;
import be.gaetan.aeroportspring.dal.repositories.ProprioRepository;
import be.gaetan.aeroportspring.pl.models.proprio.form.ProprioForm;
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
}
