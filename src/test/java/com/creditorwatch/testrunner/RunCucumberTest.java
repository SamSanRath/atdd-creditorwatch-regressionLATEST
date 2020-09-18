package com.creditorwatch.testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.creditorwatch.stepdefinition.test"},
        plugin = {"pretty", "html:target/reports/cucumber-pretty", "json:target/cucumber.json"},
        features = {
                "src/test/resources/CW-001-Validate_Links.feature"
        },
        tags =
        // OR      --->    {"@SmokeTest,@Regression"} Scenarios which has either of tags will be executed.
        // AND     --->    {"@SmokeTest","@Regression"} Scenarios which has both tags will be executed.
        // IGNORE  --->	   {~@E2E}
        "@Regression,@Smoke"
        )
public class RunCucumberTest {
}
