package com.example.demo.dao;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testCountAll() {
        assertEquals(3, userDao.countAll());
    }

    @Test
    public void testCountByName() {
        assertEquals(1, userDao.countByName("Larry"));
    }

    @Test
    public void testListAll() {
        List<User> users = userDao.listAll();
        assertEquals(3, users.size());
    }

    @Test
    public void testGetById() {
        User user = userDao.getById(1);
        assertEquals("Larry", user.getName());
    }

    @Test
    public void testGetByIdUsingProcedure() {
        User user = userDao.getByIdUsingProcedure(1);
        assertEquals("Larry", user.getName());
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setName("Alan");
        user.setAge(38);
        user.setEmail("alan@alan.com");

        Integer id = userDao.saveUsingSimpleInsert(user);
        assertEquals(4, id);
    }

    @Test
    public void testUpdateWithException() {
        User user = new User();
        user.setId(1);
        user.setName("Larry");
        user.setAge(null);
        user.setEmail("larry@larry.com");

        assertThrows(
                DataIntegrityViolationException.class,
                () -> userDao.update(user)
        );
    }

}
