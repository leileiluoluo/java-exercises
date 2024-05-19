package com.example.tests.stepdefs;

import com.example.tests.utils.ConfigUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateIssueStep {

    private int statusCode;
    private String responseBody;

    @Given("新增一个标题为 {string} 的 Issue")
    public void createAnIssue(String title) {
        // request
        Map<String, Object> requestBody = prepareRequestBody(title);

        // response
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + ConfigUtil.getProperty("GITHUB_TOKEN"))
                .body(requestBody)
                .post("/issues")
                .then()
                .extract().response();

        // extract
        this.statusCode = response.getStatusCode();
        this.responseBody = response.asString();
    }

    @Then("响应码为 {int}，响应体中的 Issue 标题为 {string}")
    public void responseShouldBeValid(int statusCode, String title) {
        // extract fields
        String issueTitle = from(responseBody).getString("title");

        // assertions
        assertThat(statusCode, equalTo(this.statusCode));
        assertThat(title, equalTo(issueTitle));
    }

    private Map<String, Object> prepareRequestBody(String title) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("title", title);
        requestBody.put("body", "test");
        return requestBody;
    }

}
