package ro.app.taskmanagement.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import ro.app.taskmanagement.validation.Password;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignInDto {
    @Email
    @NotEmpty
    private String email;

    @Password
    @NotEmpty
    private String password;
}
