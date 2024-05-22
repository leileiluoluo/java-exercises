package com.example.tests.pages;

import com.example.tests.utils.ConfigUtil;
import com.example.tests.utils.GoogleAuthenticatorUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private static final String LOGIN_URL = "https://github.com/login";

    private static final By USERNAME_ELEM = By.xpath("//input[@name='login']");
    private static final By PASSWORD_ELEM = By.xpath("//input[@name='password']");
    private static final By SIGN_IN_BUTTON = By.xpath("//input[@name='commit']");
    private static final By TOTP_ELEM = By.xpath("//input[@name='app_otp']");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        // open login url
        driver.get(LOGIN_URL);

        // input username & password
        driver.findElement(USERNAME_ELEM).sendKeys(ConfigUtil.getProperty("GITHUB_USERNAME"));
        driver.findElement(PASSWORD_ELEM).sendKeys(ConfigUtil.getProperty("GITHUB_PASSWORD"));

        // click "Sign in" button
        driver.findElement(SIGN_IN_BUTTON).click();

        // input Authentication code
        int code = GoogleAuthenticatorUtil.getTotpCode(ConfigUtil.getProperty("GITHUB_TOTP_SECRET"));
        driver.findElement(TOTP_ELEM).sendKeys("" + code);
    }

}
