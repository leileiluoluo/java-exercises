package com.example.demo.repository;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindById() {
        User user = userRepository.findById(1L);

        assertNotNull(user);
        assertEquals("Larry", user.getName());
    }

    @Test
    public void testFindByNameIgnoreCase() {
        List<User> users = userRepository.findByNameIgnoreCase("larry");

        assertEquals(1, users.size());
        assertEquals("Larry", users.get(0).getName());
    }

    @Test
    public void testFindByNameOrderByCreatedAtDesc() {
        List<User> users = userRepository.findByNameOrderByCreatedAtDesc("larry");

        assertNotNull(users);
    }

    @Test
    public void testFindAll() {
        Pageable pageable = PageRequest.of(1, 2, Sort.by("createdAt").descending());
        Page<User> page = userRepository.findAll(pageable);

        assertEquals(1, page.getContent().size());
    }

}
