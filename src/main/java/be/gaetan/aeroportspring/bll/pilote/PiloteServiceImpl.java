package be.gaetan.aeroportspring.bll.pilote;

import be.gaetan.aeroportspring.dal.models.Pilote;
import be.gaetan.aeroportspring.dal.repositories.PiloteRepository;
import be.gaetan.aeroportspring.pl.models.pilote.form.PiloteForm;
import org.springframework.stereotype.Service;

@Service
public class PiloteServiceImpl implements PiloteService{
    private final PiloteRepository piloteRepository;

    public PiloteServiceImpl(PiloteRepository piloteRepository) {
        this.piloteRepository = piloteRepository;
    }

    /**
     * Creates a new Pilote using the provided PiloteForm.
     *
     * @param form The PiloteForm object containing the data for the new Pilote.
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
}
