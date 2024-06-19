package com.example.tests.actions;

import com.example.tests.utils.ConfigUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.core.steps.UIInteractions;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.path.json.JsonPath.from;
import static net.serenitybdd.rest.SerenityRest.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateIssueAction extends UIInteractions {

    private int statusCode;
    private String responseBody;

    @Given("新增一个标题为 {0} 的 Issue")
    public void createIssue(String title) {
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

    @Then("响应码为 {0}，响应体中的 Issue 标题为 {1}")
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
        return requestBody;
    }

}



































