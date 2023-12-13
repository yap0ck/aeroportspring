package be.gaetan.aeroportspring.bll.pilote;

import be.gaetan.aeroportspring.dal.models.personnes.Pilote;
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
     * Retrieves a Pilote object from the repository with the specified ID.
     *
     * @param id The ID of the Pilote to retrieve.
     * @return The retrieved Pilote object.
     * @throws EntityNotFoundException If the Pilote with the specified ID is not found.
     */
    @Override
    public Pilote getOne(long id) {
        Pilote pilote = piloteRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Pilote non trouvé"));
        if (pilote.isDeleted())throw new EntityNotFoundException("pilote non trouvé");
        return pilote;
    }

    /**
     * Retrieves a list of all non-deleted pilots from the repository.
     *
     * @return The list of non-deleted pilots.
     */
    @Override
    public List<Pilote> getAll() {
        return piloteRepository.findAllByDeleted(false);
    }

    /**
     * Updates a Pilote object with the specified ID using the provided PiloteForm object.
     *
     * @param id   The ID of the Pilote to update.
     * @param form The PiloteForm object containing the updated data.
     * @throws IllegalArgumentException    if the form is null.
     * @throws EntityNotFoundException      if the Pilote with the specified ID is not found.
     */
    @Override
    public void update(long id, PiloteForm form) {
        if (form == null) throw new IllegalArgumentException("le formulaire ne peut etre null");
        Pilote pilote = piloteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pilote non trouvé"));
        if (pilote.isDeleted()) throw new EntityNotFoundException("pilote non trouvé");
        pilote.setName(form.name());
        pilote.setAdress(form.adress());
        pilote.setPhoneNumber(form.phoneNumber());
        pilote.setNumBrevet(form.numBrevet());
        piloteRepository.save(pilote);
    }

    /**
     * Deletes a Pilote object from the repository with the specified ID.
     *
     * @param id The ID of the Pilote to delete.
     * @throws EntityNotFoundException If the Pilote with the specified ID is not found.
     */
    @Override
    public void delete(long id) {
        Pilote pilote = piloteRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("pilote non trouvé"));
        pilote.setDeleted(true);
        piloteRepository.save(pilote);
    }
}
