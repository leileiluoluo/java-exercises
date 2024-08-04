package com.leileiluoluo.module1.model;

import com.leileiluoluo.module1.util.AgeUtil;

public class User {

    private final String name;
    private final Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getAgeGroup() {
        return AgeUtil.getAgeGroup(age);
    }
}
