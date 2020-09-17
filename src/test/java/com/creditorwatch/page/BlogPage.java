package com.creditorwatch.page;

import com.creditorwatch.pagebase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogPage extends PageBase {
    @FindBy(xpath="//select[@id='cat']")
    public WebElement drpdwn_Category;

    public BlogPage(WebDriver driver) {
        super(driver);
    }
    public void selectCategoryDropDwn(String categoryType){
        selectDropDownByVisibleText(drpdwn_Category,categoryType);
    }

}
