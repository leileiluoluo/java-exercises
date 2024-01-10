package com.example.demo.controller;

import com.example.demo.model.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("")
    public ResponseEntity<?> addUser(@RequestBody @Valid User user) {
        // userService.addUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("")
    public ResponseEntity<?> updateUser(@RequestBody @Validated(User.Update.class) User user) {
        // userService.updateUser(user);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
