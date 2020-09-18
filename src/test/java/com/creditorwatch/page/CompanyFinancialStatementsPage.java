package com.creditorwatch.page;

import com.creditorwatch.pagebase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompanyFinancialStatementsPage extends PageBase {
    @FindBy(xpath="//article[@id='post-7961']")
    private WebElement content_article;

    public CompanyFinancialStatementsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getContentArticle() {
        return content_article;
    }

    public boolean ComFinStatPage(String title) {
        boolean flag = false;
        if(driver.getTitle().equalsIgnoreCase(title)){
            flag = true;
        }
        return flag;
    }
}
