package com.example.tests.pages;

import com.example.tests.conf.ApplicationConf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class CreateIssuePage {

    private static final String CREATE_ISSUE_URL = "/issues/new";

    private static final By INPUT_TITLE_ELEM = By.xpath("//input[@id='issue_title']");
    private static final By SUBMIT_BUTTON = By.xpath("//button[contains(text(), 'Submit new issue')]");

    @Autowired
    private ApplicationConf applicationConf;
    @Autowired
    private WebDriver driver;

    public void createIssue(String title) {
        // open issue creation URL
        driver.get(applicationConf.getGithubRepo() + CREATE_ISSUE_URL);

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
