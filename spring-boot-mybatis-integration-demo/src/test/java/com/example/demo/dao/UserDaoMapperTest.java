package com.example.demo.dao;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserDaoMapperTest {

    @Autowired
    private UserDaoMapper userDaoMapper;

    @Test
    public void testList() {
        List<User> users = userDaoMapper.list(2, 10);

        // assertion
        assertFalse(users.isEmpty());
    }

    @Test
    public void testCount() {
        long count = userDaoMapper.count();

        // assertion
        assertTrue(count > 0);
    }

    @Test
    public void testGetById() {
        User user = userDaoMapper.getById(1L);

        // assertion
        assertNotNull(user);
    }

    @Test
    public void testExistsByEmail() {
        boolean exists = userDaoMapper.existsByEmail("larry@larry.com");

        // assertion
        assertTrue(exists);
    }

    @Test
    public void testSearchByName() {
        List<User> users = userDaoMapper.searchByName("La");

        // assertion
        assertFalse(users.isEmpty());
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setEmail("david@david.com");
        user.setName("David");
        user.setRole(User.Role.VIEWER);
        user.setDescription("I am David");

        // save
        userDaoMapper.save(user);

        // assertion
        assertNotNull(user.getId());
    }

    @Test
    public void testBatchSave() {
        User user1 = new User();
        user1.setEmail("ross@ross.com");
        user1.setName("Ross");
        user1.setRole(User.Role.EDITOR);
        user1.setDescription("I am Ross");

        User user2 = new User();
        user2.setEmail("linda@linda.com");
        user2.setName("Linda");
        user2.setRole(User.Role.VIEWER);
        user2.setDescription("I am Linda");

        List<User> users = List.of(user1, user2);

        // batch save
        userDaoMapper.batchSave(users);

        // assertion
        users.forEach(user -> assertNotNull(user.getId()));

    }

    @Test
    public void testUpdate() {
        User user = userDaoMapper.getById(1L);
        user.setRole(User.Role.EDITOR);
        user.setDescription("Hello, I am Larry!");

        // update
        userDaoMapper.update(user);
    }

    @Test
    public void testDeleteById() {
        userDaoMapper.deleteById(1L);
    }

}
