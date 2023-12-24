package com.example.tests;

import com.example.tests.model.BranchEntity;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GitHubBranchAPITest {

    @Test
    public void listBranches() {
        baseURI = "https://api.github.com/repos/olzhy/java-exercises";

        given().accept(ContentType.JSON)
                .header("Authorization", "Bearer ghp_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                .header("X-GitHub-Api-Version", "2022-11-28")
                .queryParam("page", 1)
                .queryParam("per_page", 10)
                .when()
                .get("/branches")
                .then()
                .statusCode(200)
                .body("$", hasItem(hasEntry("name", "main")));
    }

    @Test
    public void getBranch() {
        baseURI = "https://api.github.com/repos/olzhy/java-exercises";

        Response response = given().accept(ContentType.JSON)
                .header("Authorization", "Bearer ghp_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                .header("X-GitHub-Api-Version", "2022-11-28")
                .pathParam("branch", "main")
                .when()
                .get("/branches/{branch}")
                .then()
                .statusCode(200)
                .extract()
                .response();

        // extract fields
        String link = response.path("_links.html");
        Boolean protectionEnabled = response.path("protection.enabled");

        // assertions
        assertThat(link, equalTo("https://github.com/olzhy/java-exercises/tree/main"));
        assertThat(protectionEnabled, equalTo(false));
    }

    @Test
    public void getBranchUsingJsonPath() {
        baseURI = "https://api.github.com/repos/olzhy/java-exercises";

        String responseBody = given().accept(ContentType.JSON)
                .header("Authorization", "Bearer ghp_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                .header("X-GitHub-Api-Version", "2022-11-28")
                .pathParam("branch", "main")
                .when()
                .get("/branches/{branch}")
                .then()
                .statusCode(200)
                .extract()
                .asString();

        // extract fields
        JsonPath jsonPath = from(responseBody);
        String link = jsonPath.getString("_links.html");
        Boolean protectionEnabled = jsonPath.getBoolean("protection.enabled");

        // assertions
        assertThat(link, equalTo("https://github.com/olzhy/java-exercises/tree/main"));
        assertThat(protectionEnabled, equalTo(false));
    }

    @Test
    public void getBranchUsingDeserialization() {
        baseURI = "https://api.github.com/repos/olzhy/java-exercises";

        BranchEntity branchEntity = given().accept(ContentType.JSON)
                .header("Authorization", "Bearer ghp_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                .header("X-GitHub-Api-Version", "2022-11-28")
                .pathParam("branch", "main")
                .when()
                .get("/branches/{branch}")
                .then()
                .statusCode(200)
                .extract()
                .as(BranchEntity.class);

        // assertions
        assertThat(branchEntity.getLinks().getHtml(), equalTo("https://github.com/olzhy/java-exercises/tree/main"));
        assertThat(branchEntity.getProtection().getEnabled(), equalTo(false));
    }

    @Test
    public void getBranchWithLog() {
        baseURI = "https://api.github.com/repos/olzhy/java-exercises";

        given().log().all() // Log all request details
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer ghp_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                .header("X-GitHub-Api-Version", "2022-11-28")
                .pathParam("branch", "main")
                .when()
                .get("/branches/{branch}")
                .then()
                .log().body() // Log only the response body
                .statusCode(200)
                .body("_links.html", equalTo("https://github.com/olzhy/java-exercises/tree/main"));
    }

    @Test
    public void getBranchWithLogOnWhenValidationFails() {
        baseURI = "https://api.github.com/repos/olzhy/java-exercises";

        // Log request and response details only when validation fails
        enableLoggingOfRequestAndResponseIfValidationFails();

        given().accept(ContentType.JSON)
                .header("Authorization", "Bearer ghp_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                .header("X-GitHub-Api-Version", "2022-11-28")
                .pathParam("branch", "main")
                .when()
                .get("/branches/{branch}")
                .then()
                .statusCode(200)
                .body("_links.html", equalTo("https://github.com/olzhy/java-exercises/tree/main"));
    }

}
