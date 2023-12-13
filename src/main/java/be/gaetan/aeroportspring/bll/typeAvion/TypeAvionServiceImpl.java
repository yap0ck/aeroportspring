package be.gaetan.aeroportspring.bll.typeAvion;

import be.gaetan.aeroportspring.dal.models.TypeAvion;
import be.gaetan.aeroportspring.dal.repositories.TypeAvionRepository;
import be.gaetan.aeroportspring.pl.models.typeAvion.form.TypeAvionForm;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeAvionServiceImpl implements TypeAvionService{
    private final TypeAvionRepository typeAvionRepository;

    public TypeAvionServiceImpl(TypeAvionRepository typeAvionRepository) {
        this.typeAvionRepository = typeAvionRepository;
    }

    /**
     * Creates a new TypeAvion based on the provided form.
     *
     * @param form the form containing the data to create the TypeAvion
     * @throws IllegalArgumentException if the form is null
     */
    @Override
    public void create(TypeAvionForm form) {
        if (form==null) throw new IllegalArgumentException("le formulaire ne peut etre null");
        TypeAvion typeAvion = new TypeAvion();
        typeAvion.setName(form.name());
        typeAvion.setConstructor(form.constructeur());
        typeAvion.setPuissance(form.puissance());
        typeAvion.setNbPlaces(form.nbPlaces());
        typeAvionRepository.save(typeAvion);
    }

    /**
     * Retrieves a specific TypeAvion based on the provided id.
     *
     * @param id the id of the TypeAvion to retrieve
     * @return the retrieved TypeAvion object
     * @throws EntityNotFoundException if the TypeAvion with the given id is not found or is marked as deleted
     */
    @Override
    public TypeAvion getOne(long id) {
        TypeAvion typeAvion = typeAvionRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Type d'avion nom trouvé"));
        if (typeAvion.isDeleted()) throw new EntityNotFoundException("Type d'avion nom trouvé");
        return typeAvion;
    }

    /**
     * Retrieves all non-deleted TypeAvion objects.
     *
     * @return a List of TypeAvion objects
     */
    @Override
    public List<TypeAvion> getAll() {
        return typeAvionRepository.findAllByDeleted(false);
    }

    /**
     * Updates an existing TypeAvion object with the provided data.
     *
     * @param id   the id of the TypeAvion object to update
     * @param form the form containing the updated data
     * @throws EntityNotFoundException if the TypeAvion with the given id is not found or is marked as deleted
     */
    @Override
    public void update(long id, TypeAvionForm form) {
        TypeAvion typeAvion = getOne(id);
        typeAvion.setName(form.name());
        typeAvion.setConstructor(form.constructeur());
        typeAvion.setPuissance(form.puissance());
        typeAvion.setNbPlaces(form.nbPlaces());
        typeAvionRepository.save(typeAvion);
    }

    /**
     * Deletes a TypeAvion by marking it as deleted.
     *
     * @param id the id of the TypeAvion to delete
     * @throws EntityNotFoundException if the TypeAvion with the given id is not found or is already marked as deleted
     */
    @Override
    public void delete(long id) {
        TypeAvion typeAvion = getOne(id);
        typeAvion.setDeleted(true);
        typeAvionRepository.save(typeAvion);
    }
}