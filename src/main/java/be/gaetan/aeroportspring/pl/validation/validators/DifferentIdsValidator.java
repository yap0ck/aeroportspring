package be.gaetan.aeroportspring.pl.validation.validators;

import be.gaetan.aeroportspring.pl.models.intervention.forms.InterventionForm;
import be.gaetan.aeroportspring.pl.validation.constraints.DifferentIds;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DifferentIdsValidator implements ConstraintValidator<DifferentIds, InterventionForm> {
    @Override
    public void initialize(DifferentIds constraintAnnotation){}
    @Override
    public boolean isValid(InterventionForm interventionForm, ConstraintValidatorContext context) {
        return interventionForm.getReparateurId()!= interventionForm.getVerificateurId();
    }
}
