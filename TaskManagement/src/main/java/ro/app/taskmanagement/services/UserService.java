package ro.app.taskmanagement.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.app.taskmanagement.dataAccess.IUserRepository;
import ro.app.taskmanagement.dtos.UserEditDto;
import ro.app.taskmanagement.exceptions.ResourceNotFoundException;
import ro.app.taskmanagement.mappers.Mapper;
import ro.app.taskmanagement.models.User;


@Service
public class UserService {
    private final IUserRepository userRepository;
    private final Mapper<User> userMapper;

    @Autowired
    public UserService(IUserRepository userRepository, Mapper<User> userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User editUserProfile(Long id, UserEditDto dto) {
        User userToUpdate = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        userToUpdate = userMapper.mapToEntity(dto, userToUpdate);
        userToUpdate.setId(id);

        return userRepository.save(userToUpdate);
    }

    public User getUserDetails(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
