package com.example.tests.pages;

import com.example.tests.utils.ConfigUtil;
import com.example.tests.utils.GoogleAuthenticatorUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;

    private static final String LOGIN_URL = "https://github.com/login";
    private static final String LOGIN_PAGE_TITLE = "Sign in to GitHub · GitHub";
    private static final String AUTHENTICATION_PAGE_TITLE = "Two-factor authentication · GitHub";

    private static final By USERNAME_ELEM = By.xpath("//input[@name='login']");
    private static final By PASSWORD_ELEM = By.xpath("//input[@name='password']");
    private static final By SIGN_IN_BUTTON = By.xpath("//input[@name='commit']");
    private static final By TOTP_ELEM = By.xpath("//input[@name='app_otp']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        // open login url
        driver.get(LOGIN_URL);

        // waiting util title is "Sign in to GitHub · GitHub"
        new WebDriverWait(driver, Duration.ofMinutes(1)).until(ExpectedConditions.titleIs(LOGIN_PAGE_TITLE));

        // input username & password
        driver.findElement(USERNAME_ELEM).sendKeys(ConfigUtil.getProperty("GITHUB_USERNAME"));
        driver.findElement(PASSWORD_ELEM).sendKeys(ConfigUtil.getProperty("GITHUB_PASSWORD"));

        // click "Sign in" button
        driver.findElement(SIGN_IN_BUTTON).click();

        // waiting util title is "Two-factor authentication · GitHub"
        new WebDriverWait(driver, Duration.ofMinutes(1)).until(ExpectedConditions.titleIs(AUTHENTICATION_PAGE_TITLE));

        // input Authentication code & return
        int code = GoogleAuthenticatorUtil.getTotpPassword(ConfigUtil.getProperty("GITHUB_TOTP_SECRET"));
        driver.findElement(TOTP_ELEM).sendKeys("" + code);
    }

}
