package ro.app.taskmanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.app.taskmanagement.validation.ValidEmail;
import ro.app.taskmanagement.validation.ValidPassword;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDto {
    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String username;

    @ValidEmail
    @NotEmpty
    private String email;

    @ValidPassword
    @NotEmpty
    private String password;
}
