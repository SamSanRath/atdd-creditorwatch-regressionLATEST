package com.creditorwatch.page;

import com.creditorwatch.pagebase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompanyFinancialStatementsPage extends PageBase {
    @FindBy(xpath="//article[@id='post-7961']")
    public WebElement content_article;

    public CompanyFinancialStatementsPage(WebDriver driver) {
        super(driver);
    }

}
