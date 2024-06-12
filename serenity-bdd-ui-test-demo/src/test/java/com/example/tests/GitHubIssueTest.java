package com.example.tests;

import com.example.tests.page.CreateIssuePage;
import com.example.tests.page.LoginPage;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class GitHubIssueTest {

    @Managed(driver = "chrome")
    WebDriver driver;

    LoginPage loginPage;
    CreateIssuePage createIssuePage;

    @Test
    public void testIssueCreation() {
        loginPage.login();
        createIssuePage.createIssue("haha");

        assertThat(createIssuePage.getTitle(), startsWith("haha"));
    }

}
