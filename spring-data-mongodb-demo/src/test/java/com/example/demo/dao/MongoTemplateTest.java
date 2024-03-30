package com.example.demo.dao;

import com.example.demo.model.User;
import com.mongodb.client.result.UpdateResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MongoTemplateTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testFindAll() {
        List<User> users = mongoTemplate.findAll(User.class);

        assertFalse(users.isEmpty());
    }

    @Test
    public void testFindByName() {
        Query query = new Query(Criteria.where("name").is("Jacky"));
        User user = mongoTemplate.findOne(query, User.class);

        assertNotNull(user);
        assertEquals("jacky@jacky.com", user.getEmail());
    }

    @Test
    public void testUpdateEmailByName() {
        Query query = new Query(Criteria.where("name").is("Jacky"));
        Update update = new Update().set("email", "jacky2@jacky.com");

        UpdateResult result = mongoTemplate.updateMulti(query, update, User.class);
        assertEquals(1, result.getModifiedCount());
    }

}
