package com.creditorwatch.page;

import com.creditorwatch.pagebase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HowToAvoidThePreferencePaymentTrapPage extends PageBase {
    @FindBy(xpath="//div[@class='entry-content']")
    public WebElement contentAricle;

    public HowToAvoidThePreferencePaymentTrapPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getContentArticle() {
        return contentAricle;
    }

}
