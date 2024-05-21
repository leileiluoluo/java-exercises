package com.example.tests.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    private static final WebDriver driver = new ChromeDriver();

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static void closeWebDriver() {
        driver.close();
    }

}
