package com.example.demo.util;

public class IdGenerator {

    private static Integer COUNTER = 0;

    public synchronized static Integer generateId() {
        return COUNTER++;
    }

}
