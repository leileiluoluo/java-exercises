package com.example.demo.dao;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCount() {
        long count = userRepository.count();

        assertEquals(3, count);
    }

    @Test
    public void testFindAll() {
        List<User> users = userRepository.findAll();

        assertEquals(3, users.size());
    }

    @Test
    public void testFindById() {
        Optional<User> optional = userRepository.findById("6607d1e438537258779f990a");

        assertTrue(optional.isPresent());
        assertEquals("Larry", optional.get().getName());
    }

    @Test
    public void testFindByName() {
        List<User> users = userRepository.findByName("Larry");

        assertEquals(1, users.size());
        assertEquals("Larry", users.get(0).getName());
    }

    @Test
    public void testSave() {
        Date now = new Date();

        User user = new User();
        user.setEmail("linda@linda.com");
        user.setName("Linda");
        user.setRole(User.Role.EDITOR);
        user.setDescription("I am Linda");
        user.setCreatedAt(now);
        user.setUpdatedAt(now);
        user.setDeleted(false);

        // save
        userRepository.save(user);
    }

    @Test
    public void testUpdate() {
        User user = userRepository.findById("6607d1e438537258779f990a").get();
        user.setName("Larry2");

        userRepository.save(user);
    }

    @Test
    public void testDelete() {
        userRepository.deleteById("6607d1e438537258779f990a");
    }

}
