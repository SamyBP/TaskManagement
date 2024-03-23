package ro.app.taskmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import ro.app.taskmanagement.dtos.SignInDto;
import ro.app.taskmanagement.dtos.SignInResponseDto;
import ro.app.taskmanagement.dtos.SignUpDto;
import ro.app.taskmanagement.models.User;
import ro.app.taskmanagement.services.AuthenticationService;
import ro.app.taskmanagement.handlers.JwtHandler;
import ro.app.taskmanagement.utils.EmailAlreadyTakenException;
import ro.app.taskmanagement.utils.InvalidCredentialException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/app/auth")
public class AuthenticationController {

    AuthenticationService authenticationService;
    JwtHandler jwtHandler;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService, JwtHandler jwtHandler) {
        this.authenticationService = authenticationService;
        this.jwtHandler = jwtHandler;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpDto dto) {

        if (dto == null)
            return ResponseEntity.badRequest().build();

        try {
            authenticationService.signUp(dto);
        } catch (EmailAlreadyTakenException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/signin")
    public ResponseEntity<SignInResponseDto> signIn(@RequestBody SignInDto dto) {

        if (dto == null) {
            return ResponseEntity.badRequest().build();
        }

        try {
            User signedInUser = authenticationService.signIn(dto);
            String token = jwtHandler.generateToken(signedInUser.getEmail(), signedInUser.getId());
            SignInResponseDto response = new SignInResponseDto(true, null, token);

            return ResponseEntity.ok(response);
        } catch (InvalidCredentialException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new SignInResponseDto(false, e.getMessage(), null));
        }
    }
}
