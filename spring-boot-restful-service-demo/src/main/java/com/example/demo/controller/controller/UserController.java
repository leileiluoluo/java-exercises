package com.example.demo.controller.controller;

import com.example.demo.controller.model.User;
import com.example.demo.controller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody @Validated User user) {
        userService.addUser(user);
    }

    @PatchMapping("/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@RequestBody @Validated User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
    }

}
