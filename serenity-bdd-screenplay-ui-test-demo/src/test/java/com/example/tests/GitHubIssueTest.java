package com.example.tests;

import com.example.tests.utils.ConfigUtil;
import com.example.tests.utils.GoogleAuthenticatorUtil;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;
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
        int code = GoogleAuthenticatorUtil.getTotpCode(ConfigUtil.getProperty("GITHUB_TOTP_SECRET"));

        // login
        larry.attemptsTo(
                Open.url("https://github.com/login"),
                Enter.theValue(username).into(By.xpath("//input[@name='login']")),
                Enter.theValue(password).into(By.xpath("//input[@name='password']")),
                Click.on(By.xpath("//input[@name='commit']")),
                Enter.theValue("" + code).into(By.xpath("//input[@name='app_otp']"))
        );

        // create issue
        String title = "Serenity Screenplay UI Test";
        String createIssueURL = ConfigUtil.getProperty("GITHUB_REPO") + "/issues/new";
        larry.attemptsTo(
                Open.url(createIssueURL),
                Enter.theValue(title).into(By.xpath("//input[@id='issue_title']")),
                Click.on(By.xpath("//button[contains(text(), 'Submit new issue')]"))
        );

        // get issue title
        String issueTitle = larry.asksFor(TheWebPage.title());

        // assert
        Serenity.reportThat("Check title",
                () -> assertThat(issueTitle, startsWith(title))
        );
    }

}
