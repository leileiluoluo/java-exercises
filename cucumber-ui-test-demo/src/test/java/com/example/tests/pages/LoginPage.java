package com.example.tests.pages;

import com.example.tests.utils.ConfigUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;

    private static final String LOGIN_URL = "https://github.com/login";
    private static final String PAGE_TITLE = "Sign in to GitHub · GitHub";

    private static final By USERNAME_ELEM = By.xpath("//input[@name='login']");
    private static final By PASSWORD_ELEM = By.xpath("//input[@name='password']");
    private static final By SIGN_IN_BUTTON = By.xpath("//input[@name='commit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        // open login url
        driver.get(LOGIN_URL);

        // waiting util title is "Sign in to GitHub · GitHub"
        new WebDriverWait(driver, Duration.ofMinutes(1)).until(ExpectedConditions.titleIs(PAGE_TITLE));

        // input username & password
        driver.findElement(USERNAME_ELEM).sendKeys(ConfigUtil.getProperty("GITHUB_USERNAME"));
        driver.findElement(PASSWORD_ELEM).sendKeys(ConfigUtil.getProperty("GITHUB_PASSWORD"));

        // click "Sign in" button
        driver.findElement(SIGN_IN_BUTTON).click();
    }

}
