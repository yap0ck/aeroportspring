package be.gaetan.aeroportspring.bll.proprio;

import be.gaetan.aeroportspring.dal.repositories.ProprioRepository;
import org.springframework.stereotype.Service;

@Service
public class ProprioServiceImpl implements ProprioService{
    private final ProprioRepository proprioRepository;

    public ProprioServiceImpl(ProprioRepository proprioRepository) {
        this.proprioRepository = proprioRepository;
    }
}
