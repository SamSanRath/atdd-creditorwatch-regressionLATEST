package com.creditorwatch.page;

import com.creditorwatch.pagebase.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RiskManagementPage extends PageBase {

    @FindBy(xpath="//strong[contains(text(),'Risk Managementt')]")
    private WebElement lbl_pageIdentifier;
    @FindBy(xpath="//a[contains(text(),'How to Avoid the Preference Payment Trap')]")
    private WebElement lnk_howToAvoidPrefPaymntTrp;

    public RiskManagementPage(WebDriver driver) {
        super(driver);
    }

    public void goToHowToAvoidPrefPaymntTrpPage() {
        click(lnk_howToAvoidPrefPaymntTrp);
    }

    public boolean isRiskManagementPage(String title){
        boolean flag = false;
        System.out.println("Page Title is: "+driver.getTitle());
        if (driver.getTitle().equalsIgnoreCase(title)){
            flag = true;
        }
        return flag;
    }
}
