package ro.app.taskmanagement.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.app.taskmanagement.dtos.UserEditDto;
import ro.app.taskmanagement.models.Task;
import ro.app.taskmanagement.models.User;
import ro.app.taskmanagement.services.UserService;

import java.util.List;


@CrossOrigin(origins = "${allowed.origins}")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> editProfile(@PathVariable(value = "id") Long id,
                                            @Valid @RequestBody UserEditDto dto) {

        return new ResponseEntity<>(userService.editUserProfile(id, dto), HttpStatus.OK);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<User> getUserDetails(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(userService.getUserDetails(id), HttpStatus.OK);
    }
}
