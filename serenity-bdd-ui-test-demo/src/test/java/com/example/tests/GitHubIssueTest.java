package com.example.tests;

import com.example.tests.page.CreateIssuePage;
import com.example.tests.page.LoginPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class GitHubIssueTest {

    private LoginPage loginPage;
    private CreateIssuePage createIssuePage;

    @Test
    public void testIssueCreation() {
        // login
        loginPage.login();

        // create issue
        String title = "Serenity UI Test";
        createIssuePage.createIssue(title);

        // assert
        Serenity.reportThat("Check title",
                () -> assertThat(createIssuePage.getTitle(), startsWith(title))
        );
    }

}
