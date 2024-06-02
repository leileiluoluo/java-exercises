package com.example.tests.stepdefs;

import com.example.tests.conf.CucumberSpringIntegrationTest;
import com.example.tests.pages.LoginPage;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginStep extends CucumberSpringIntegrationTest {

    @Autowired
    private LoginPage loginPage;

    @Given("登录到 GitHub")
    public void login() {
        loginPage.login();
    }

}
