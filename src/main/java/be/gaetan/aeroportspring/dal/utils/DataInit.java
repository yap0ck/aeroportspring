package be.gaetan.aeroportspring.dal.utils;

import be.gaetan.aeroportspring.dal.models.Avion;
import be.gaetan.aeroportspring.dal.models.TypeAvion;
import be.gaetan.aeroportspring.dal.models.personnes.Mecano;
import be.gaetan.aeroportspring.dal.models.personnes.Pilote;
import be.gaetan.aeroportspring.dal.models.personnes.Proprio;
import be.gaetan.aeroportspring.dal.repositories.*;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class DataInit implements InitializingBean {
    private final AvionRepository avionRepository;
    private final InterventionRepository interventionRepository;
    private final MecanoRepository mecanoRepository;
    private final PiloteRepository piloteRepository;
    private final ProprioRepository proprioRepository;
    private final PiloteTypeAvionRepository piloteTypeAvionRepository;
    private final TypeAvionRepository typeAvionRepository;
    //@Value("$api")
    boolean initialisation = true;


    public DataInit(AvionRepository avionRepository, InterventionRepository interventionRepository, MecanoRepository mecanoRepository, PiloteRepository piloteRepository, ProprioRepository proprioRepository, PiloteTypeAvionRepository piloteTypeAvionRepository, TypeAvionRepository typeAvionRepository) {
        this.avionRepository = avionRepository;
        this.interventionRepository = interventionRepository;
        this.mecanoRepository = mecanoRepository;
        this.piloteRepository = piloteRepository;
        this.proprioRepository = proprioRepository;
        this.piloteTypeAvionRepository = piloteTypeAvionRepository;
        this.typeAvionRepository = typeAvionRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (initialisation) {
            Faker fakerFR = Faker.instance(new Locale("fr-FR"));
            for (int i = 0; i < 5; i++) {
                TypeAvion typeAvion = new TypeAvion();
                typeAvion.setName(fakerFR.aviation().aircraft());
                typeAvion.setConstructor(fakerFR.company().name());
                typeAvion.setPuissance(fakerFR.number().randomDigitNotZero()*1000);
                typeAvion.setNbPlaces(fakerFR.number().randomDigitNotZero());
                typeAvionRepository.save(typeAvion);
            }
            for (int i = 0; i <50; i++) {
                Avion avion = new Avion();
                avion.setImmatriculation(fakerFR.regexify("^[A-Z]-[A-Z]{4}|[A-Z]{2}-[A-Z]{3}|N[0-9]{1,5}[A-Z]{0,2}$"));
                avion.setTypeAvion(typeAvionRepository.findById((long) fakerFR.number().numberBetween(1,5)).get());
                avionRepository.save(avion);
            }
            for (int i = 0; i < 5; i++) {
                Mecano mecano= new Mecano();
                mecano.setPhoneNumber(fakerFR.phoneNumber().phoneNumber());
                mecano.setAdress(fakerFR.address().fullAddress());
                mecano.setName(fakerFR.overwatch().hero());
                mecanoRepository.save(mecano);
            }
            for (int i = 0; i < 5; i++) {
                Pilote pilote = new Pilote();
                pilote.setPhoneNumber(fakerFR.phoneNumber().phoneNumber());
                pilote.setAdress(fakerFR.address().fullAddress());
                pilote.setName(fakerFR.lordOfTheRings().character());
                pilote.setNumBrevet(fakerFR.number().randomNumber(5,true));
                piloteRepository.save(pilote);
            }
            for (int i = 0; i < 5; i++) {
                Proprio proprio = new Proprio();
                proprio.setPhoneNumber(fakerFR.phoneNumber().phoneNumber());
                proprio.setAdress(fakerFR.address().fullAddress());
                proprio.setName(fakerFR.funnyName().name());
                proprioRepository.save(proprio);
            }
        }
    }
}
