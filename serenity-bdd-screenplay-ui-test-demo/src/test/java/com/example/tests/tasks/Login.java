package com.example.tests.tasks;

import com.example.tests.utils.GoogleAuthenticatorUtil;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.By;

public class Login implements Task {

    private static final String LOGIN_URL = "https://github.com/login";

    private static final By USERNAME_ELEM = By.xpath("//input[@name='login']");
    private static final By PASSWORD_ELEM = By.xpath("//input[@name='password']");
    private static final By SIGN_IN_BUTTON = By.xpath("//input[@name='commit']");
    private static final By TOTP_ELEM = By.xpath("//input[@name='app_otp']");

    private final String username;
    private final String password;
    private final String secret;

    public Login(String username, String password, String secret) {
        this.username = username;
        this.password = password;
        this.secret = secret;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int code = GoogleAuthenticatorUtil.getTotpCode(secret);

        actor.attemptsTo(
                Open.url(LOGIN_URL),
                Enter.theValue(username).into(USERNAME_ELEM),
                Enter.theValue(password).into(PASSWORD_ELEM),
                Click.on(SIGN_IN_BUTTON),
                Enter.theValue("" + code).into(TOTP_ELEM)
        );
    }

}
