package be.gaetan.aeroportspring.dal.utils;

import be.gaetan.aeroportspring.dal.models.Avion;
import be.gaetan.aeroportspring.dal.models.Intervention;
import be.gaetan.aeroportspring.dal.models.TypeAvion;
import be.gaetan.aeroportspring.dal.models.personnes.Mecano;
import be.gaetan.aeroportspring.dal.repositories.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInit implements InitializingBean {
    private final AvionRepository avionRepository;
    private final InterventionRepository interventionRepository;
    private final MecanoRepository mecanoRepository;
    private final PiloteRepository piloteRepository;
    private final PiloteTypeAvionRepository piloteTypeAvionRepository;
    private final ProprioRepository proprioRepository;
    private final TypeAvionRepository typeAvionRepository;

    public DataInit(AvionRepository avionRepository, InterventionRepository interventionRepository, MecanoRepository mecanoRepository, PiloteRepository piloteRepository, PiloteTypeAvionRepository piloteTypeAvionRepository, ProprioRepository proprioRepository, TypeAvionRepository typeAvionRepository) {
        this.avionRepository = avionRepository;
        this.interventionRepository = interventionRepository;
        this.mecanoRepository = mecanoRepository;
        this.piloteRepository = piloteRepository;
        this.piloteTypeAvionRepository = piloteTypeAvionRepository;
        this.proprioRepository = proprioRepository;
        this.typeAvionRepository = typeAvionRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // TypeAvion
        TypeAvion typeAvion = new TypeAvion();
        typeAvion.setName("boeing 747");
        typeAvion.setConstructor("Boeing");
        typeAvion.setPuissance(1500);
        typeAvion.setNbPlaces(100);
        typeAvionRepository.save(typeAvion);

        TypeAvion typeAvion2 = new TypeAvion();
        typeAvion.setName("A-320");
        typeAvion.setConstructor("Airbus");
        typeAvion.setPuissance(1500);
        typeAvion.setNbPlaces(100);
        typeAvionRepository.save(typeAvion2);

        // Personnes

        //  -Mecano
        Mecano mecano = new Mecano();
        List<TypeAvion> typeAvionList = new ArrayList<>();
        typeAvionList.add(typeAvion);
        mecano.setHabilitations(typeAvionList);
        mecano.setName("John");
        mecano.setAdress("rue de la paix");
        mecano.setPhoneNumber("0465516");
        mecanoRepository.save(mecano);
        // Avions

        Avion avion1 = new Avion();
        avion1.setImmatriculation("ABC123");
        avion1.setTypeAvion(typeAvion);
    }
}
