package ro.app.taskmanagement.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    private final int MIN_LENGTH = 6;

    @Override
    public boolean isValid(final String password, final ConstraintValidatorContext context) {
        boolean hasUppercase = hasUppercase(password);
        boolean hasDigit = hasDigit(password);
        boolean hasWhiteSpaces = hasWhiteSpace(password);

        boolean valid = password.length() >= MIN_LENGTH && hasDigit && hasUppercase && !hasWhiteSpaces;


        if (!valid) {
            StringBuilder errorMessage = new StringBuilder("Invalid password.");
            if (!hasUppercase) {
                errorMessage.append("Must contain at least one uppercase");
            }
            if (!hasDigit) {
                errorMessage.append("Must contain at least one digit");
            }
            if (hasWhiteSpaces) {
                errorMessage.append("Must not contain whitespaces");
            }

            context.buildConstraintViolationWithTemplate(errorMessage.toString()).addConstraintViolation();
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
