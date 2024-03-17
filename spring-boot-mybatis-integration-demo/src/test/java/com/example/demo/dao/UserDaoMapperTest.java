package com.example.demo.dao;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDaoMapperTest {

    @Autowired
    private UserDaoMapper userDaoMapper;

    @Test
    public void testList() {
        userDaoMapper.list(1, 10);
    }

}
