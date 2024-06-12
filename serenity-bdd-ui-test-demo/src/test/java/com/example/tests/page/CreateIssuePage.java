package com.example.tests.page;

import net.serenitybdd.core.pages.PageComponent;
import org.openqa.selenium.By;

public class CreateIssuePage extends PageComponent {

    private static final String CREATE_ISSUE_URL = "/issues/new";

    private static final By INPUT_TITLE_ELEM = By.xpath("//input[@id='issue_title']");
    private static final By SUBMIT_BUTTON = By.xpath("//button[contains(text(), 'Submit new issue')]");

    public void createIssue(String title) {
        // open issue creation URL
        open(CREATE_ISSUE_URL);

        waitForRenderedElementsToBePresent(INPUT_TITLE_ELEM);

        // input title
        $(INPUT_TITLE_ELEM).sendKeys(title);

        // submit
        $(SUBMIT_BUTTON).click();
    }

}
