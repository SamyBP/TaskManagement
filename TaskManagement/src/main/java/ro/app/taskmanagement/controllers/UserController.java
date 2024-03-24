package ro.app.taskmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ro.app.taskmanagement.dtos.UserEditDto;
import ro.app.taskmanagement.models.User;
import ro.app.taskmanagement.services.UserService;


@CrossOrigin(origins = "${cross.origins}")
@RestController
@RequestMapping("/app/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/edit-profile/{id}")
    public ResponseEntity<?> editProfile(@PathVariable(value = "id") Long id,
                                            @Validated @RequestBody UserEditDto dto) {

        return new ResponseEntity<>(userService.editUserProfile(id, dto), HttpStatus.OK);
    }
}
