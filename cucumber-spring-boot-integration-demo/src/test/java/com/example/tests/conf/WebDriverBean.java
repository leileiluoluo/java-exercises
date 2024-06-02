package com.example.tests.conf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebDriverBean {

    @Bean
    public WebDriver webDriver() {
        return new ChromeDriver();
    }

}
