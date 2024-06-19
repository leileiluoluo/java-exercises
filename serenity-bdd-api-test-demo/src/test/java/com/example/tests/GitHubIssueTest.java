package com.example.tests;

import com.example.tests.actions.CreateIssueAction;
import com.example.tests.utils.ConfigUtil;
import io.restassured.RestAssured;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class GitHubIssueTest {

    private CreateIssueAction createIssueAction;

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = ConfigUtil.getProperty("GITHUB_BASE_URI");
    }

    @Test
    public void testIssueCreation() {
        String title = "Serenity API Test";
        createIssueAction.createIssue(title);
        createIssueAction.responseShouldBeValid(201, title);
    }

}
