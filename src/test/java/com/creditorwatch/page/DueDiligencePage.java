package com.creditorwatch.page;

import com.creditorwatch.pagebase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DueDiligencePage extends PageBase {
    @FindBy(xpath = "//strong[contains(text(),'Due Diligence')]")
    private WebElement lbl_pgeIdefr_dueDiligence;
    @FindBy(xpath = "//a[contains(text(),'Company Financial Statements: Identifying Signs of')]")
    private WebElement lnk_comFinStatements;

    public DueDiligencePage(WebDriver driver) {
        super(driver);
    }

    public boolean isDueDiligencePage(String title) {
        boolean flag = false;
        if (driver.getTitle().equalsIgnoreCase(title)) {
            flag = true;
        }
        return flag;
    }

    public void goToComFinancialStatPage() {
        click(lnk_comFinStatements);
    }
}
