package ro.app.taskmanagement.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {
    private static final int MIN_LENGTH = 6;

    @Override
    public void initialize(Password constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return  s.length() >= MIN_LENGTH &
                hasDigit(s) &
                hasUppercase(s) &
                !hasWhiteSpace(s);
    }

    private boolean hasUppercase(final String password) {
        return password.matches(".*[A-Z].*");
    }

    private boolean hasDigit(final String password) {
        return password.matches(".*\\d.*");
    }

    private boolean hasWhiteSpace(final String password) {
        return password.contains(" ");
    }

}
