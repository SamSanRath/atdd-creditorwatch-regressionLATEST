package com.creditorwatch.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.creditorwatch.stepdefinition.test"}, features = "src/test/resources", plugin = {"pretty", "html:target/reports/cucumber-pretty",
        "json:target/cucumber.json"})
public class RunCucumberTest {
}
