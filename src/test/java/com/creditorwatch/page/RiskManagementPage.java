package com.creditorwatch.page;

import com.creditorwatch.pagebase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RiskManagementPage extends PageBase {
    public RiskManagementPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath="//strong[contains(text(),'Risk Management')]")
    public WebElement lbl_pgeIdefr_riskManagement;
    @FindBy(xpath="//a[contains(text(),'How to Avoid the Preference Payment Trap')]")
    public WebElement lnk_howToAvoidPrefPaymntTrp;


    public void goTohowToAvoidPrefPaymntTrpPage() {
        click(lnk_howToAvoidPrefPaymntTrp);
    }
}
