package com.example.tests.hooks;

import com.example.tests.utils.WebDriverFactory;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHook {

    @AfterStep
    public void attachScreenshot(Scenario scenario) {
        WebDriver driver = WebDriverFactory.getWebDriver();
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", driver.getCurrentUrl());
    }

}
