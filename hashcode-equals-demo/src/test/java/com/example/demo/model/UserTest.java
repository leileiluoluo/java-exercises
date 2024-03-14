package com.example.demo.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    private final User user1 = new User("Larry", 18, User.Gender.MALE);
    private final User user2 = new User("Larry", 18, User.Gender.MALE);

    @Test
    public void testHashCodeAndEquals() {
        System.out.println(user1.equals(user2));
        System.out.println(user1.hashCode() == user2.hashCode());
    }

    @Test
    public void testHashMap() {
        Map<User, Boolean> map = new HashMap<>();
        map.put(user1, true);
        map.put(user2, true);

        assertEquals(1, map.size());
    }

}
