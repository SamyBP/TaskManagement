package ro.app.taskmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.app.taskmanagement.dtos.UserEditDto;
import ro.app.taskmanagement.models.User;
import ro.app.taskmanagement.services.UserService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/app/user")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/edit-profile/{id}")
    public ResponseEntity<User> editProfile(@PathVariable(value = "id") Long id, @RequestBody UserEditDto dto) {
        userService.editUserProfile(id, dto);
        return ResponseEntity.ok().build();
    }
}
