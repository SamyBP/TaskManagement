package ro.app.taskmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.app.taskmanagement.dtos.SignInDto;
import ro.app.taskmanagement.dtos.SignInResponseDto;
import ro.app.taskmanagement.dtos.SignUpDto;
import ro.app.taskmanagement.models.User;
import ro.app.taskmanagement.services.AuthenticationService;
import ro.app.taskmanagement.handlers.JwtHandler;

import javax.validation.Valid;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/app/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final JwtHandler jwtHandler;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService, JwtHandler jwtHandler) {
        this.authenticationService = authenticationService;
        this.jwtHandler = jwtHandler;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@Valid @RequestBody SignUpDto dto) {
        return new ResponseEntity<>(authenticationService.signUp(dto), HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<SignInResponseDto> signIn(@Valid @RequestBody SignInDto dto) {
        User signedInUser = authenticationService.signIn(dto);
        String token = jwtHandler.generateToken(signedInUser.getEmail(), signedInUser.getId());
        SignInResponseDto response = new SignInResponseDto(true, null, token);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
