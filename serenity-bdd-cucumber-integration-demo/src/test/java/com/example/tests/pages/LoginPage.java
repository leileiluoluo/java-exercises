package com.example.tests.pages;

import com.example.tests.utils.ConfigUtil;
import com.example.tests.utils.GoogleAuthenticatorUtil;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    private static final String LOGIN_URL = "https://github.com/login";

    private static final By USERNAME_ELEM = By.xpath("//input[@name='login']");
    private static final By PASSWORD_ELEM = By.xpath("//input[@name='password']");
    private static final By SIGN_IN_BUTTON = By.xpath("//input[@name='commit']");
    private static final By TOTP_ELEM = By.xpath("//input[@name='app_otp']");

    public void login() {
        // open login url
        openUrl(LOGIN_URL);

        // input username & password
        $(USERNAME_ELEM).sendKeys(ConfigUtil.getProperty("GITHUB_USERNAME"));
        $(PASSWORD_ELEM).sendKeys(ConfigUtil.getProperty("GITHUB_PASSWORD"));

        // click "Sign in" button
        $(SIGN_IN_BUTTON).click();

        // input Authentication code
        int code = GoogleAuthenticatorUtil.getTotpCode(ConfigUtil.getProperty("GITHUB_TOTP_SECRET"));
        $(TOTP_ELEM).sendKeys("" + code);
    }

}
