package be.gaetan.aeroportspring.bll.typeAvion;

import be.gaetan.aeroportspring.dal.repositories.TypeAvionRepository;
import org.springframework.stereotype.Service;

@Service
public class TypeAvionServiceImpl implements TypeAvionService{
    private final TypeAvionRepository typeAvionRepository;

    public TypeAvionServiceImpl(TypeAvionRepository typeAvionRepository) {
        this.typeAvionRepository = typeAvionRepository;
    }
}
