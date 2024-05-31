package com.example.tests.hooks;

import com.example.tests.driver.LazyWebDriver;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotHook {

    private final LazyWebDriver driver;

    public ScreenshotHook(LazyWebDriver driver) {
        this.driver = driver;
    }

    @AfterStep
    public void attachScreenshot(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) driver.getDelegate()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", driver.getCurrentUrl());
    }

}
