package ro.app.taskmanagement.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    private final String PHONE_NUMBER_REGEX = "^(\\+?\\d{1,4}[.-])?\\(?\\d{3}\\)?[.-]\\d{3}[.-]\\d{4}$";

    @Override
    public void initialize(ValidPhoneNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        return Pattern.compile(PHONE_NUMBER_REGEX)
                .matcher(phoneNumber)
                .matches();
    }
}
