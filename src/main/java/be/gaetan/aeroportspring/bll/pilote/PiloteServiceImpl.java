package be.gaetan.aeroportspring.bll.pilote;

import be.gaetan.aeroportspring.dal.repositories.PiloteRepository;
import org.springframework.stereotype.Service;

@Service
public class PiloteServiceImpl implements PiloteService{
    private final PiloteRepository piloteRepository;

    public PiloteServiceImpl(PiloteRepository piloteRepository) {
        this.piloteRepository = piloteRepository;
    }
}
