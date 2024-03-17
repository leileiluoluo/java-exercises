package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;

public interface UserDaoMapper {

    List<User> list(int offset, int rows);

    long count();

    User getById(Long id);

    User existsByEmail(String email);

    Long save(User user);

    void update(User user);

    void deleteById(Long id);

}
