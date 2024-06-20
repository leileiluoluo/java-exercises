package com.example.tests.pages;

import com.example.tests.utils.ConfigUtil;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;


public class IssuesPage extends PageObject {

    private static final String ISSUES_URL = "/issues";

    private static final By CREATE_ISSUE_BUTTON = By.partialLinkText("New issue");
    private static final By INPUT_TITLE_ELEM = By.xpath("//input[@id='issue_title']");
    private static final By SUBMIT_BUTTON = By.xpath("//button[contains(text(), 'Submit new issue')]");

    public void createIssue(String title) {
        // open issue creation url
        openUrl(ConfigUtil.getProperty("GITHUB_REPO_URL") + ISSUES_URL);

        // click "New issue" button
        $(CREATE_ISSUE_BUTTON).click();

        // input issue title
        $(INPUT_TITLE_ELEM).sendKeys(title);

        // click "Submit new issue" button
        $(SUBMIT_BUTTON).click();
    }

}
