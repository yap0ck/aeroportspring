package be.gaetan.aeroportspring.bll.mecano;

import be.gaetan.aeroportspring.dal.models.personnes.Mecano;
import be.gaetan.aeroportspring.dal.repositories.MecanoRepository;
import be.gaetan.aeroportspring.pl.models.mecano.form.MecanoForm;
import org.springframework.stereotype.Service;

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
}
