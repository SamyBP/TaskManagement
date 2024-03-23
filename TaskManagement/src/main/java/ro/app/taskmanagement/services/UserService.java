package ro.app.taskmanagement.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.app.taskmanagement.dataAccess.IUserRepository;
import ro.app.taskmanagement.dtos.UserEditDto;
import ro.app.taskmanagement.mappers.Mapper;
import ro.app.taskmanagement.models.User;

@Service
public class UserService {
    IUserRepository userRepository;
    Mapper<User> userMapper;

    @Autowired
    public UserService(IUserRepository userRepository, Mapper<User> userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User editUserProfile(Long id, UserEditDto dto) throws EntityNotFoundException{
        userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        User userToUpdate = userMapper.createMap(dto, User.class);
        userToUpdate.setId(id);

        return userRepository.save(userToUpdate);
    }
}
