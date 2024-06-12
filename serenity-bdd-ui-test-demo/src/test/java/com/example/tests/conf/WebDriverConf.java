package com.example.tests.conf;

import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class WebDriverConf {

    @Managed(driver = "chrome")
    private WebDriver driver;

}
