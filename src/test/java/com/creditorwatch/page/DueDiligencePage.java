package com.creditorwatch.page;

import com.creditorwatch.pagebase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DueDiligencePage extends PageBase {
    public DueDiligencePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath="//strong[contains(text(),'Due Diligence')]")
    public WebElement lbl_pgeIdefr_dueDiligence;
    @FindBy(xpath="//a[contains(text(),'Company Financial Statements: Identifying Signs of')]")
    public WebElement lnk_comFinStatements;




}
