package ro.app.taskmanagement.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.app.taskmanagement.dataAccess.IUserRepository;
import ro.app.taskmanagement.dtos.UserEditDto;
import ro.app.taskmanagement.exceptions.ResourceNotFoundException;
import ro.app.taskmanagement.mappers.Mapper;
import ro.app.taskmanagement.models.User;

import javax.validation.Valid;

@Service
public class UserService {
    private final IUserRepository userRepository;
    private final Mapper<User> userMapper;

    @Autowired
    public UserService(IUserRepository userRepository, Mapper<User> userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User editUserProfile(Long id, @Valid UserEditDto dto) throws EntityNotFoundException{
        userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        User userToUpdate = userMapper.createMap(dto, User.class);
        userToUpdate.setId(id);

        return userRepository.save(userToUpdate);
    }
}
