package com.creditorwatch.page;

import com.creditorwatch.pagebase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HowToAvoidThePreferencePaymentTrapPage extends PageBase {
    @FindBy(xpath = "//div[@class='entry-content']")
    private WebElement contentArticle;

    public HowToAvoidThePreferencePaymentTrapPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getContentArticle() {
        return contentArticle;
    }

    public boolean isHowToAvdPrefPymTrpPage(String title) {
        boolean flag = false;
        if (driver.getTitle().equalsIgnoreCase(title)) {
            flag = true;
        }
        return flag;
    }
}
