package com.creditorwatch.stepdefinition.test;

import com.creditorwatch.page.BlogPage;
import com.creditorwatch.page.HomePage;
import com.creditorwatch.page.HowToAvoidThePreferencePaymentTrapPage;
import com.creditorwatch.page.RiskManagementPage;
import com.creditorwatch.stepdefinition.testbase.TestBase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public class ValidateLinksTest extends TestBase {

    @When("i click blog")
    public void i_click_blog() {
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        homePage.getNavBar().goToBlogPage();

    }

    @Then("i should go to blog page")
    public void i_should_go_to_blog_page() {
    }

    @When("i select {string} of categories dropdown")
    public RiskManagementPage i_select_Risk_Management_of_categories_dropdown(String categoryType) throws InterruptedException {
        BlogPage blogPage = PageFactory.initElements(driver,BlogPage.class);
        blogPage.selectCategoryDropDwn(categoryType);
        Thread.sleep(10000);
        return PageFactory.initElements(driver,RiskManagementPage.class);
    }

    @Then("i should go to risk management page")
    public void i_should_go_to_risk_management_page() {
    }

    @When("i click How to Avoid the Preference Payment Trap")
    public void i_click_How_to_Avoid_the_Preference_Payment_Trap() {
        RiskManagementPage riskManagementPage = PageFactory.initElements(driver,RiskManagementPage.class);
        riskManagementPage.goTohowToAvoidPrefPaymntTrpPage();
    }

    @Then("i should go to How to Avoid the Preference Payment Trap page")
    public void i_should_go_to_How_to_Avoid_the_Preference_Payment_Trap_page() {

    }
    @Then("all the linkTexts in the article should be validated")
    public void all_the_linkTexts_in_the_article_should_be_validated() {
        HowToAvoidThePreferencePaymentTrapPage howToAvoidThePreferencePaymentTrapPage = PageFactory.initElements(driver,HowToAvoidThePreferencePaymentTrapPage.class);
        validateHyperLinks(howToAvoidThePreferencePaymentTrapPage.getContentArticle());

    }

    @When("i select Due Diligence of categories dropdown")
    public void i_select_Due_Diligence_of_categories_dropdown() {
    }

    @Then("i should go to Due Diligence page")
    public void i_should_go_to_Due_Diligence_page() {
    }




}
