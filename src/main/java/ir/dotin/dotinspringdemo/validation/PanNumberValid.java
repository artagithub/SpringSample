package ir.dotin.dotinspringdemo.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PanNumberValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface PanNumberValid {
    String message() default "{panNumber.isNotValid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
