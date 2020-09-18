package com.creditorwatch.pagebase;

import com.creditorwatch.common.NavBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
    protected WebDriver driver;
    NavBar navBar;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        navBar = PageFactory.initElements(driver, NavBar.class);
    }

    public NavBar getNavBar() {
        return navBar;
    }

    public void selectDropDownByIndex(WebElement element, int index) {
        try {
            Select select = new Select(element);
            select.selectByIndex(index);
        } catch (Exception e) {
        }
    }

    public void selectDropDownByVisibleText(WebElement element, String categoryType) {
        element.sendKeys(categoryType);
    }

    public void click(WebElement element) {
        element.click();
    }
}
