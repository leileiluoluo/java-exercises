package com.example.tests.pages;

import com.example.tests.driver.LazyWebDriver;
import com.example.tests.utils.ConfigUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateIssuePage {

    private static final String CREATE_ISSUE_URL = "/issues/new";

    private static final By INPUT_TITLE_ELEM = By.xpath("//input[@id='issue_title']");
    private static final By SUBMIT_BUTTON = By.xpath("//button[contains(text(), 'Submit new issue')]");

    private final LazyWebDriver driver;

    public CreateIssuePage(LazyWebDriver driver) {
        this.driver = driver;
    }

    public void createIssue(String title) {
        // open issue creation URL
        driver.get(ConfigUtil.getProperty("GITHUB_REPO") + CREATE_ISSUE_URL);

        new WebDriverWait(driver, Duration.ofMinutes(1)).until(ExpectedConditions.visibilityOfElementLocated(INPUT_TITLE_ELEM));

        // input title
        driver.findElement(INPUT_TITLE_ELEM).sendKeys(title);

        // submit
        driver.findElement(SUBMIT_BUTTON).click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
