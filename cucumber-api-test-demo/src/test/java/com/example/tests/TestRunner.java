package com.example.tests;

import com.example.tests.utils.ConfigUtil;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.baseURI;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"json:target/cucumber.json"}
)
public class TestRunner {

    @BeforeClass
    public static void setUp() {
        baseURI = ConfigUtil.getProperty("GITHUB_BASE_URI");
    }

}
