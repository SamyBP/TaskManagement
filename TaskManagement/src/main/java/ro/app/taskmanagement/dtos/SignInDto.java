package ro.app.taskmanagement.dtos;


import lombok.*;
import ro.app.taskmanagement.validation.ValidEmail;
import ro.app.taskmanagement.validation.ValidPassword;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignInDto {
    @ValidEmail
    @NotEmpty
    private String email;

    @ValidPassword
    @NotEmpty
    private String password;
}
