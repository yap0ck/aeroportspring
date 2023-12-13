package be.gaetan.aeroportspring.bll.pilote;

import be.gaetan.aeroportspring.dal.models.Pilote;
import be.gaetan.aeroportspring.dal.repositories.PiloteRepository;
import be.gaetan.aeroportspring.pl.models.pilote.form.PiloteForm;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PiloteServiceImpl implements PiloteService{
    private final PiloteRepository piloteRepository;

    public PiloteServiceImpl(PiloteRepository piloteRepository) {
        this.piloteRepository = piloteRepository;
    }


    /**
     * Creates a new pilot by saving the provided pilot form data into the repository.
     *
     * @param form The pilot form data to create the pilot.
     * @throws IllegalArgumentException if the form is null.
     */
    @Override
    public void create(PiloteForm form) {
        if (form == null) throw new IllegalArgumentException("le formulaire ne peut etre null");
        Pilote pilote = new Pilote();
        pilote.setName(form.name());
        pilote.setAdress(form.adress());
        pilote.setPhoneNumber(form.phoneNumber());
        pilote.setNumBrevet(form.numBrevet());
        piloteRepository.save(pilote);
    }

    /**
     * Retrieves a Pilote object with the specified ID.
     *
     * @param id The ID of the Pilote to retrieve.
     * @return The Pilote object with the specified ID.
     * @throws EntityNotFoundException if the Pilote with the specified ID is not found.
     */
    @Override
    public Pilote getOne(long id) {
        return piloteRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Pilote non trouvé"));
    }

    /**
     * Retrieves all Pilote objects from the repository.
     *
     * @return A list of Pilote objects.
     */
    @Override
    public List<Pilote> getAll() {
        return piloteRepository.findAll();
    }
}
