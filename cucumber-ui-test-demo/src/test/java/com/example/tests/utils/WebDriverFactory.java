package com.example.tests.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    public static WebDriver getWebDriver() {
        return new ChromeDriver();
    }

}
