package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final List<User> USERS = new ArrayList<>();

    @Override
    public List<User> getUsers() {
        return USERS;
    }

    @Override
    public User getUser(Integer id) {
        int i = findUserIndex(id);

        if (i < USERS.size()) {
            return USERS.get(i);
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        USERS.add(user);
    }

    @Override
    public void updateUser(User user) {
        int i = findUserIndex(user.id());

        // update
        if (i < USERS.size()) {
            USERS.set(i, user);
        }
    }

    @Override
    public void deleteUser(Integer id) {
        int i = findUserIndex(id);

        // update
        if (i < USERS.size()) {
            USERS.remove(i);
        }
    }

    private int findUserIndex(Integer userId) {
        int i = 0;
        for (; i < USERS.size(); i++) {
            if (USERS.get(i).id().equals(userId)) {
                break;
            }
        }
        return i;
    }

}
