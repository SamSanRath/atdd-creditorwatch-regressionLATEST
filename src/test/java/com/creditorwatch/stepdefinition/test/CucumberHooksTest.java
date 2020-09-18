package com.creditorwatch.stepdefinition.test;

import com.creditorwatch.stepdefinition.testbase.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;

public class CucumberHooksTest extends TestBase {
    //   Global hooks
    @Before(order = 0)
    public void setUP() {
        try {
            init();
        } catch (IOException e) {
        }
    }

    //   Global hooks
    @After(order = 0)
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
