package com.example.tests.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {

    private static final String FILE_NAME = "/config.properties";

    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try (InputStream is = ConfigUtil.class.getResourceAsStream(FILE_NAME)) {
            PROPERTIES.load(is);
        } catch (IOException e) {
            throw new RuntimeException("config.properties load failed", e);
        }
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }

}
