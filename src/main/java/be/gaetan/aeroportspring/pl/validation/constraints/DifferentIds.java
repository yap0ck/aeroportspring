package be.gaetan.aeroportspring.pl.validation.constraints;

import be.gaetan.aeroportspring.pl.validation.validators.DifferentIdsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.RECORD_COMPONENT, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DifferentIdsValidator.class)
@Documented
public @interface DifferentIds {
    String message() default "Le vérificateur ne peut etre le réparateur";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
