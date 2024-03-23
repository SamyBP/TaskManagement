package ro.app.taskmanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.app.taskmanagement.validation.ValidEmail;
import ro.app.taskmanagement.validation.ValidPassword;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDto {
    private String firstName;
    private String lastName;
    private String username;

    @ValidEmail
    private String email;

    @ValidPassword
    private String password;
}
