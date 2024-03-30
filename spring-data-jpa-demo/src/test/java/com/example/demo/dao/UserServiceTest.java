package com.example.demo.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testDeleteUserByAgeGreaterThanWithException() {
        assertThrows(
                RuntimeException.class,
                () -> userService.deleteUserByAgeGreaterThanWithException(1)
        );
    }

}
