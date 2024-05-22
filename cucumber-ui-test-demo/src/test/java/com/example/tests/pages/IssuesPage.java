package com.example.tests.pages;

import com.example.tests.utils.ConfigUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IssuesPage {

    private static final String ISSUES_URL = "/issues";

    private static final By CREATE_ISSUE_BUTTON = By.partialLinkText("New issue");
    private static final By INPUT_TITLE_ELEM = By.xpath("//input[@id='issue_title']");
    private static final By SUBMIT_BUTTON = By.xpath("//button[contains(text(), 'Submit new issue')]");

    private final WebDriver driver;

    public IssuesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(ConfigUtil.getProperty("GITHUB_REPO") + ISSUES_URL);

        new WebDriverWait(driver, Duration.ofMinutes(1)).until(ExpectedConditions.elementToBeClickable(CREATE_ISSUE_BUTTON));
    }

    public void createIssue(String title) {
        driver.findElement(CREATE_ISSUE_BUTTON).click();

        new WebDriverWait(driver, Duration.ofMinutes(1)).until(ExpectedConditions.visibilityOfElementLocated(INPUT_TITLE_ELEM));
        driver.findElement(INPUT_TITLE_ELEM).sendKeys(title);

        driver.findElement(SUBMIT_BUTTON).click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
