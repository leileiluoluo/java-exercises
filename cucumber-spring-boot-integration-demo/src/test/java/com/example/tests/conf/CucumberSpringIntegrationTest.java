package com.example.tests.conf;

import com.example.tests.DummyApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = DummyApplication.class)
public class CucumberSpringIntegrationTest {

}
