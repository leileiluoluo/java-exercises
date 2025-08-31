package com.example.demo.repository;

import com.example.demo.model.User;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Order(1)
    public void testSave() {
        User user = new User();
        user.setName("Larry");
        user.setEmail("larry@larry.com");
        user.setYearOfBirth(2000);
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());

        userRepository.save(user);
    }

    @Test
    @Order(2)
    public void testExistsByNameAndEmail() {
        userRepository.existsByNameAndEmail("Larry", "larry@larry.com");
    }

    @Test
    @Order(3)
    public void testFindByNameIgnoreCase() {
        userRepository.findByNameIgnoreCase("larry");
    }

    @Test
    @Order(4)
    public void testUpdateNameByEmail() {
        userRepository.updateNameByEmail("larry 2", "larry@larry.com");
    }

    @Test
    @Order(5)
    public void testDeleteByEmail() {
        userRepository.deleteByEmail("larry@larry.com");
    }

}
