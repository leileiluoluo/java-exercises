package com.example.tests.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.By;

public class CreateIssue implements Task {

    private static final String CREATE_ISSUE_URL = "/issues/new";

    private static final By INPUT_TITLE_ELEM = By.xpath("//input[@id='issue_title']");
    private static final By SUBMIT_BUTTON = By.xpath("//button[contains(text(), 'Submit new issue')]");

    private final String githubRepoURL;
    private final String title;

    public CreateIssue(String githubRepoURL, String title) {
        this.githubRepoURL = githubRepoURL;
        this.title = title;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String createIssueURL = githubRepoURL + CREATE_ISSUE_URL;

        actor.attemptsTo(
                Open.url(createIssueURL),
                Enter.theValue(title).into(INPUT_TITLE_ELEM),
                Click.on(SUBMIT_BUTTON)
        );
    }

}
