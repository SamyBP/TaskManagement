package ro.app.taskmanagement.mappers;

import org.springframework.stereotype.Component;
import ro.app.taskmanagement.dtos.SignInDto;
import ro.app.taskmanagement.dtos.SignUpDto;
import ro.app.taskmanagement.models.User;

@Component
public class UserMapper {
    public User toEntity(SignUpDto dto) {
        return new User(dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getPassword(), dto.getAddress());
    }

    public User toEntity(SignInDto dto) {
        return new User(dto.getEmail(), dto.getPassword());
    }

}
