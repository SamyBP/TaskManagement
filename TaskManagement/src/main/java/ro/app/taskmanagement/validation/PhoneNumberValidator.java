package ro.app.taskmanagement.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if (s == null || s.isEmpty())
            return true;

        return Pattern.compile("^(\\d{3}[- .]?){2}\\d{4}$")
                .matcher(s)
                .matches();
    }
}
