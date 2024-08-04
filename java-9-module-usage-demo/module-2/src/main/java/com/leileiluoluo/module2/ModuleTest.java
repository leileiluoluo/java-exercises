package com.leileiluoluo.module2;

import com.leileiluoluo.module1.model.User;

public class ModuleTest {

    public static void main(String[] args) {
        User user = new User("Larry", 28);

        System.out.println("name: " + user.getName());
        System.out.println("age: " + user.getAge());
        System.out.println("group: " + user.getAgeGroup());
    }

}
