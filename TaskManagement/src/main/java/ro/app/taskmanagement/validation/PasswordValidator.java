package ro.app.taskmanagement.validation;

import ro.app.taskmanagement.exceptions.InvalidPasswordException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    private final int MIN_LENGTH = 6;

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(final String password, final ConstraintValidatorContext context) {
        boolean hasUppercase = hasUppercase(password);
        boolean hasDigit = hasDigit(password);
        boolean hasWhiteSpaces = hasWhiteSpace(password);

        boolean valid = password.length() >= MIN_LENGTH && hasDigit && hasUppercase && !hasWhiteSpaces;


        if (!valid) {
            if (!hasUppercase) {
                throw new InvalidPasswordException("Must contain at least one uppercase");
            }
            if (!hasDigit) {
                throw new InvalidPasswordException("Must contain at least one digit");
            }
            if (hasWhiteSpaces) {
                throw new InvalidPasswordException("Must not contain whitespaces");
            }
        }

        return valid;
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
