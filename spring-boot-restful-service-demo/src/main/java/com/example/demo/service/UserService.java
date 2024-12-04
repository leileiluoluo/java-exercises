package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUser(Integer id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);

}
