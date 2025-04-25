package com.example.demo.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ObjectToMapUtil {

    public static Map<String, Object> toMap(Object obj) {
        Map<String, Object> result = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                result.put(field.getName(), value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
