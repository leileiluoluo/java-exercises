package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;

public interface UserDao {

    Integer countAll();

    Integer countByName(String name);

    List<User> listAll();

    User getById(Integer id);

    User getByIdUsingProcedure(Integer id);

    Integer save(User user);

    Integer saveUsingSimpleInsert(User user);

    void update(User user);

    int[] batchUpdate(List<User> users);

    int[] batchUpdateUsingNamedParameters(List<User> users);

    void deleteById(Integer id);

}
