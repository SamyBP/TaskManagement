package ro.app.taskmanagement.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ro.app.taskmanagement.dataAccess.IUserRepository;
import ro.app.taskmanagement.dtos.SignInDto;
import ro.app.taskmanagement.dtos.SignUpDto;
import ro.app.taskmanagement.mappers.UserMapper;
import ro.app.taskmanagement.models.User;
import ro.app.taskmanagement.utils.EmailAlreadyTakenException;
import ro.app.taskmanagement.utils.InvalidCredentialException;

@Service
public class AuthenticationService {

    IUserRepository userRepository;
    UserMapper userMapper;

    @Autowired
    public AuthenticationService(IUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User signUp(SignUpDto dto) throws EmailAlreadyTakenException {
        if (userRepository.findByEmail(dto.getEmail()) != null) {
            throw new EmailAlreadyTakenException("Email already taken");
        }

        User newUser = userMapper.toEntity(dto);
        newUser.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
        return userRepository.save(newUser);
    }

    public User signIn(SignInDto dto) throws InvalidCredentialException{

        User user = userRepository.findByEmail(dto.getEmail());

        if (user == null)
            throw new InvalidCredentialException("Wrong email!");

        if (!BCrypt.checkpw(dto.getPassword(), user.getPassword()))
            throw new InvalidCredentialException("Wrong password!");

        return user;
    }
}
