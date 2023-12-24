package com.example.tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GitHubIssueAPITest {

    @Test
    public void createIssue() {
        baseURI = "https://api.github.com/repos/olzhy/java-exercises";

        // request body
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("title", "GitHub REST API Test");
        requestBody.put("body", "Trying to raise a issue using REST API");
        requestBody.put("assignees", List.of("olzhy"));
        requestBody.put("labels", List.of("bug"));

        given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer ghp_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                .header("X-GitHub-Api-Version", "2022-11-28")
                .body(requestBody)
                .when()
                .post("/issues")
                .then()
                .statusCode(201)
                .body("title", equalTo("GitHub REST API Test"));
    }

}
