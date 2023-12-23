package com.example.tests;

import com.example.tests.model.CommitEntity;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GitHubCommitAPITest {

    @Test
    public void filterCommits() {
        baseURI = "https://api.github.com/repos/olzhy/java-exercises";

        given().accept(ContentType.JSON)
                .header("Authorization", "Bearer ghp_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                .header("X-GitHub-Api-Version", "2022-11-28")
                .queryParam("page", 1)
                .queryParam("per_page", 10)
                .when()
                .get("/commits")
                .then()
                .statusCode(200)
                .body("findAll { it.commit.committer.email.equals('olzhy@qq.com') }.commit.message", hasItem("rest assured demo"));
    }

    @Test
    public void filterCommitsUsingJsonPath() {
        baseURI = "https://api.github.com/repos/olzhy/java-exercises";

        Response response = given().accept(ContentType.JSON)
                .header("Authorization", "Bearer ghp_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                .header("X-GitHub-Api-Version", "2022-11-28")
                .queryParam("page", 1)
                .queryParam("per_page", 10)
                .get("/commits")
                .then()
                .extract()
                .response();

        // extract response
        int statusCode = response.statusCode();
        String responseBody = response.asString();
        List<String> commitMessages = from(responseBody)
                .getList("findAll { it.commit.committer.email.equals('olzhy@qq.com') }.commit.message");

        // assertions
        assertThat(statusCode, equalTo(200));
        assertThat(commitMessages, hasItem("rest assured demo"));
    }

    @Test
    public void latestCommit() {
        baseURI = "https://api.github.com/repos/olzhy/java-exercises";

        given().accept(ContentType.JSON)
                .header("Authorization", "Bearer ghp_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                .header("X-GitHub-Api-Version", "2022-11-28")
                .queryParam("page", 1)
                .queryParam("per_page", 10)
                .when()
                .get("/commits")
                .then()
                .statusCode(200)
                .body("max { it.commit.committer.date }.commit.message", equalTo("rest assured demo"));
    }

    @Test
    public void latestCommitUsingJsonPath() {
        baseURI = "https://api.github.com/repos/olzhy/java-exercises";

        Response response = given().accept(ContentType.JSON)
                .header("Authorization", "Bearer ghp_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                .header("X-GitHub-Api-Version", "2022-11-28")
                .queryParam("page", 1)
                .queryParam("per_page", 10)
                .when()
                .get("/commits")
                .then()
                .extract()
                .response();

        // extract response
        int statusCode = response.statusCode();
        String responseBody = response.asString();
        String commitMessage = from(responseBody)
                .getString("max { it.commit.committer.date }.commit.message");

        // assertions
        assertThat(statusCode, equalTo(200));
        assertThat(commitMessage, equalTo("rest assured demo"));
    }

    @Test
    public void deserializeCommits() {
        baseURI = "https://api.github.com/repos/olzhy/java-exercises";

        // deserialization with generics
        List<CommitEntity> commits = given().accept(ContentType.JSON)
                .header("Authorization", "Bearer ghp_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                .header("X-GitHub-Api-Version", "2022-11-28")
                .queryParam("page", 1)
                .queryParam("per_page", 10)
                .when()
                .get("/commits")
                .then()
                .statusCode(200)
                .extract()
                .as(new TypeRef<>() {});

        // assertions
        assertThat(commits, hasSize(10));
        assertThat(commits.get(0).getCommit().getMessage(), equalTo("rest assured demo"));
    }

}
