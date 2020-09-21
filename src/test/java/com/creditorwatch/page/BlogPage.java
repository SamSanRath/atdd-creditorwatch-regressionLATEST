package com.creditorwatch.page;

import com.creditorwatch.pagebase.PageBase;
import com.creditorwatch.stepdefinition.testbase.TestBase;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogPage extends PageBase {

    @FindBy(xpath = "//select[@id='cat']")
    private WebElement drpdwnCategory;
    @FindBy(xpath = "//div[@id='content']")
    private WebElement areaNewsContent;

    public BlogPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getDrpdwnCategory(){
        return drpdwnCategory;
    }

    public WebElement getAreaNewsContent() {
        return areaNewsContent;
    }

    public void selectCategoryDropDwn(String categoryType) {
        selectDropDownByVisibleText(drpdwnCategory, categoryType);
    }
 /*   public void tbd(){
        for (int i=1;i<getDrpDwnList().size();i++) {
            System.out.println(getDrpDwnList().get(i).getText());
            drpdwnCategory.sendKeys(getDrpDwnList().get(i).getText());
            TestBase testBase = PageFactory.initElements(driver, TestBase.class);
            testBase.validateHyperLinks(areaNewsContent);
        }
    }*/
}
