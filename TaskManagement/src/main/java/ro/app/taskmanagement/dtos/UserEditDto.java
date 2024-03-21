package ro.app.taskmanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEditDto {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private String city;
    private String country;
    private String postalCode;
}
