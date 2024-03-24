package ro.app.taskmanagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.app.taskmanagement.validation.PasswordValidator;


@ExtendWith(MockitoExtension.class)
public class PasswordValidatorTest {
    @InjectMocks
    private PasswordValidator passwordValidator;


    @Test
    public void testValidPassword(){
        String password = "Parola123";
        Assertions.assertTrue(passwordValidator.isValid(password, null));
    }

    @Test
    public void testInvalidPassword_NoUpperCase() {
        String password = "parola123";
        Assertions.assertFalse(passwordValidator.isValid(password, null));
    }

    @Test
    public void testInvalidPassword_NoDigit() {
        String password = "Parola";
        Assertions.assertFalse(passwordValidator.isValid(password, null));
    }

    @Test
    public void testInvalidPassword_HasWhiteSpaces() {
        String password = "this is an invalid password";
        Assertions.assertFalse(passwordValidator.isValid(password, null));
    }

    @Test
    public void testInvalidPassword_HasLessThen6Characters() {
        String password = "1234";
        Assertions.assertFalse(passwordValidator.isValid(password, null));
    }
}
