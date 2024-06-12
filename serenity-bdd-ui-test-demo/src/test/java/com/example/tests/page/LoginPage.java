package com.example.tests.page;

import com.example.tests.util.GoogleAuthenticatorUtil;
import net.serenitybdd.core.pages.PageComponent;
import org.openqa.selenium.By;

public class LoginPage extends PageComponent {

    private static final String LOGIN_URL = "https://github.com/login";

    private static final By USERNAME_ELEM = By.xpath("//input[@name='login']");
    private static final By PASSWORD_ELEM = By.xpath("//input[@name='password']");
    private static final By SIGN_IN_BUTTON = By.xpath("//input[@name='commit']");
    private static final By TOTP_ELEM = By.xpath("//input[@name='app_otp']");

    public void login() {
        // open login url
        open(LOGIN_URL);

        // input username & password
        $(USERNAME_ELEM).sendKeys("a");
        $(PASSWORD_ELEM).sendKeys("b");

        // click "Sign in" button
        $(SIGN_IN_BUTTON).click();

        // input Authentication code
        int code = GoogleAuthenticatorUtil.getTotpCode("aaa");
        $(TOTP_ELEM).sendKeys("" + code);
    }

}
