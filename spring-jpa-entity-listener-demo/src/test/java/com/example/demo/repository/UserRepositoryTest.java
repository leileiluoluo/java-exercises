package com.example.demo.repository;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testOperations() {
        // save
        User user = new User();
        user.setName("Alice");
        user.setEmail("alice@alice.com");
        user.setAge(18);
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        userRepository.save(user);

        // update
        user.setAge(19);
        user.setUpdatedAt(new Date());
        userRepository.save(user);

        // delete
        userRepository.deleteById(user.getId());
    }

}
