package ro.app.taskmanagement.dtos;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.app.taskmanagement.validation.PhoneNumber;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEditDto {
    @Nullable
    private String firstName;

    @Nullable
    private String lastName;

    @Nullable
    private String username;

    @Nullable
    @Email
    private String email;

    @Nullable
    private String address;

    @Nullable
    @PhoneNumber
    private String phoneNumber;

    @Nullable
    private String city;

    @Nullable
    private String country;

    @Nullable
    private String postalCode;
}
