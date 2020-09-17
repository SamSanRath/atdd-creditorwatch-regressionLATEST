package com.creditorwatch.stepdefinition.test;

import com.creditorwatch.stepdefinition.testbase.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;


import java.io.IOException;

public class CucumberHooksTest extends TestBase {
    //   Global hooks
    @Before(order=0)
    public void setUP() {
        try {
            init();
        } catch (IOException e) {
        }
    }
    @After(order=0)
    public void tearDown() {
        driver.quit();
        driver=null;
    }

}
