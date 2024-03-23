package ro.app.taskmanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.app.taskmanagement.validation.ValidEmail;
import ro.app.taskmanagement.validation.ValidPhoneNumber;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEditDto {
    private String firstName;

    private String lastName;

    private String username;

    @ValidEmail
    private String email;

    private String address;

    @ValidPhoneNumber
    private String phoneNumber;

    private String city;

    private String country;

    private String postalCode;
}
