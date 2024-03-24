package ro.app.taskmanagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import ro.app.taskmanagement.validation.EmailValidator;


@ExtendWith(MockitoExtension.class)
public class EmailValidatorTest {
    @InjectMocks
    private EmailValidator emailValidator;

    @Test
    public void testValidEmail() {
        Assertions.assertTrue(emailValidator.isValid("valid@email.com", null));
    }

    @Test
    public void testInvalidEmailMissingAt() {
        String email = "email.yahoo.com";
        Assertions.assertFalse(emailValidator.isValid(email, null));
    }

    @Test
    public void testInvalidEmailMissingDomain() {
        String email = "email@";
        Assertions.assertFalse(emailValidator.isValid(email, null));
    }

    @Test
    public void testInvalidEmailEmpty() {
        String email = "";
        Assertions.assertFalse(emailValidator.isValid(email, null));
    }
}
