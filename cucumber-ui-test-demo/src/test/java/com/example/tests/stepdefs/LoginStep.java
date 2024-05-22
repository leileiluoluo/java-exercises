package com.example.tests.stepdefs;

import com.example.tests.pages.LoginPage;
import com.example.tests.utils.WebDriverFactory;
import io.cucumber.java.en.Given;

public class LoginStep {

    private final LoginPage loginPage;

    public LoginStep() {
        loginPage = new LoginPage(WebDriverFactory.getWebDriver());
    }

    @Given("登录到 GitHub")
    public void login() {
        loginPage.login();
    }

}
