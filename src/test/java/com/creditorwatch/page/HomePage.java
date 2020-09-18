package com.creditorwatch.page;

import com.creditorwatch.pagebase.PageBase;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
