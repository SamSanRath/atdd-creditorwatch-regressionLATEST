package com.creditorwatch.page;

import com.creditorwatch.pagebase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlogPage extends PageBase {

    @FindBy(xpath = "//select[@id='cat']")
    private WebElement drpdwnCategory;

    public BlogPage(WebDriver driver) {
        super(driver);
    }

    public void selectCategoryDropDwn(String categoryType) {
        selectDropDownByVisibleText(drpdwnCategory, categoryType);
    }
}
