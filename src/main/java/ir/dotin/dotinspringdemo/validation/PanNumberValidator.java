package ir.dotin.dotinspringdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PanNumberValidator implements ConstraintValidator<PanNumberValid,String> {

    @Override
    public void initialize(PanNumberValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String panNumber, ConstraintValidatorContext constraintValidatorContext) {
        if(!panNumber.contains("6037")){
            return false;
        }
        return true;
    }
}
