package com.example.demo.model;

import java.util.Objects;

public class User {

    private final String name;
    private final Integer age;
    private final Gender gender;

    public User(String name, Integer age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + Integer.hashCode(age);
        result = 31 * result + gender.toString().hashCode();
        return result;

        // Another way: using Object.hash()
        // return Objects.hash(name, age, gender);
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof User user)) {
            return false;
        }
        return Objects.equals(user.name, name)
                && Objects.equals(user.age, age)
                && Objects.equals(user.gender, gender);
    }

    public enum Gender {
        MALE,
        FEMALE
    }

    @Override
    public String toString() {
        return String.format("User{name=%s, age=%d, gender=%s}", name, age, gender);
    }
}
