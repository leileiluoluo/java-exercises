package com.example.tests.stepdefs;

import com.example.tests.pages.LoginPage;
import io.cucumber.java.en.Given;

public class LoginStep {

    private LoginPage loginPage;

    @Given("登录到 GitHub")
    public void login() {
        loginPage.login();
    }

}
