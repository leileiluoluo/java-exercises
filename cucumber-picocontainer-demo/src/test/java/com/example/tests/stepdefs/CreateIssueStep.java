package com.example.tests.stepdefs;

import com.example.tests.pages.CreateIssuePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateIssueStep {

    private final CreateIssuePage issuesPage;

    public CreateIssueStep(CreateIssuePage issuesPage) {
        this.issuesPage = issuesPage;
    }

    @When("打开 Issues 页面并新增一个标题为 {string} 的 Issue")
    public void createIssue(String title) {
        // create issue
        issuesPage.createIssue(title);
    }

    @Then("Issue 新增成功且标题为 {string}")
    public void checkTitle(String title) {
        assertThat(issuesPage.getTitle(), startsWith(title));
    }

}
