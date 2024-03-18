package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;

public interface UserDaoMapper {

    List<User> list(int offset, int rows);

    long count();

    User getById(Long id);

    boolean existsByEmail(String email);

    List<User> searchByName(String name);

    void save(User user);

    void batchSave(List<User> users);

    void update(User user);

    void deleteById(Long id);

}
