package be.gaetan.aeroportspring.bll.mecano;

import be.gaetan.aeroportspring.dal.repositories.MecanoRepository;
import org.springframework.stereotype.Service;

@Service
public class MecanoServiceImpl implements MecanoService{
    private final MecanoRepository mecanoRepository;

    public MecanoServiceImpl(MecanoRepository mecanoRepository) {
        this.mecanoRepository = mecanoRepository;
    }
}
