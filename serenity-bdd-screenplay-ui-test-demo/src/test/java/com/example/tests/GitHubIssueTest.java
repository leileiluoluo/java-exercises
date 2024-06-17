package com.example.tests;

import com.example.tests.question.IssueTitle;
import com.example.tests.tasks.CreateIssue;
import com.example.tests.tasks.Login;
import com.example.tests.utils.ConfigUtil;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.startsWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class GitHubIssueTest {

    @CastMember(name = "Larry")
    private Actor larry;

    @Test
    @DisplayName("Test GitHub issue creation")
    public void testIssueCreation() {
        // read variables from config file
        String username = ConfigUtil.getProperty("GITHUB_USERNAME");
        String password = ConfigUtil.getProperty("GITHUB_PASSWORD");
        String secret = ConfigUtil.getProperty("GITHUB_TOTP_SECRET");
        String githubRepoURL = ConfigUtil.getProperty("GITHUB_REPO_URL");

        // issue title
        String title = "Serenity Screenplay UI Test";

        // login & create issue
        larry.attemptsTo(
                new Login(username, password, secret),
                new CreateIssue(githubRepoURL, title)
        );

        // assert
        Serenity.reportThat("Check title",
                () -> larry.should(seeThat(new IssueTitle(), startsWith(title)))
        );
    }

}
