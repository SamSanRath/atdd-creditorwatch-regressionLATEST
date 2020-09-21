package com.creditorwatch.stepdefinition.test;

import com.creditorwatch.page.*;
import com.creditorwatch.stepdefinition.testbase.TestBase;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;

public class ValidateLinksTest extends TestBase {

    @When("i click blog")
    public void i_click_blog() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.getNavBar().goToBlogPage();
    }

    @Then("i should go to blog page")
    public void i_should_go_to_blog_page() {
    }

    @When("i select {string} of categories dropdown")
    public RiskManagementPage i_select_Risk_Management_of_categories_dropdown(String categoryType) throws InterruptedException {
        BlogPage blogPage = PageFactory.initElements(driver, BlogPage.class);
        blogPage.selectCategoryDropDwn(categoryType);
        return PageFactory.initElements(driver, RiskManagementPage.class);
    }

    @Then("i should go to risk management page and page title should be {string}")
    public void i_should_go_to_risk_management_page(String title) {
        RiskManagementPage riskManagementPage = PageFactory.initElements(driver, RiskManagementPage.class);
        Assert.assertTrue(riskManagementPage.isRiskManagementPage(title));
    }

    @When("i click How to Avoid the Preference Payment Trap")
    public void i_click_How_to_Avoid_the_Preference_Payment_Trap() {
        RiskManagementPage riskManagementPage = PageFactory.initElements(driver, RiskManagementPage.class);
        riskManagementPage.goToHowToAvoidPrefPaymntTrpPage();
    }

    @Then("i should go to How to Avoid the Preference Payment Trap page and title should be {string}")
    public void i_should_go_to_How_to_Avoid_the_Preference_Payment_Trap_page_and_title_should_be(String title) {
        HowToAvoidThePreferencePaymentTrapPage howToAvoidThePreferencePaymentTrapPage = PageFactory.initElements(driver, HowToAvoidThePreferencePaymentTrapPage.class);
        Assert.assertTrue(howToAvoidThePreferencePaymentTrapPage.isHowToAvdPrefPymTrpPage(title));
    }

    @Then("all the linkTexts in the article should be validated")
    public void all_the_linkTexts_in_the_article_should_be_validated() {
        HowToAvoidThePreferencePaymentTrapPage howToAvoidThePreferencePaymentTrapPage = PageFactory.initElements(driver, HowToAvoidThePreferencePaymentTrapPage.class);
        validateHyperLinks(howToAvoidThePreferencePaymentTrapPage.getContentArticle());
    }

    @Then("i should go to Due Diligence page and page title should be")
        public void i_should_go_to_Due_Diligence_page_and_page_title_should_be(List<String> pageTitle) {
        String title = pageTitle.get(0);
        DueDiligencePage dueDiligencePage = PageFactory.initElements(driver, DueDiligencePage.class);
        Assert.assertTrue(dueDiligencePage.isDueDiligencePage(title));
    }

    @When("i click Company Financial Statements: Identifying Signs of Business Failure")
    public void i_click_Company_Financial_Statements_Identifying_Signs_of_Business_Failure() {
        DueDiligencePage dueDiligencePage = PageFactory.initElements(driver, DueDiligencePage.class);
        dueDiligencePage.goToComFinancialStatPage();
    }

    @Then("i should go to Company Financial Statements page and title should be {string}")
    public void i_should_go_to_Company_Financial_Statements_page_and_title_should_be(String title) {
        CompanyFinancialStatementsPage companyFinancialStatementsPage = PageFactory.initElements(driver, CompanyFinancialStatementsPage.class);
        Assert.assertTrue(companyFinancialStatementsPage.ComFinStatPage(title));
    }

    @Then("all the linkTexts in the article of Company Financial Statements should be validated")
    public void all_the_linkTexts_in_the_article_of_Company_Financial_Statements_should_be_validated() {
        CompanyFinancialStatementsPage companyFinancialStatementsPage = PageFactory.initElements(driver, CompanyFinancialStatementsPage.class);
        validateHyperLinks(companyFinancialStatementsPage.getContentArticle());
    }

    @When("i go through categories dropdown one at a time and then all the links should be validated")
    public void i_go_through_categories_dropdown_one_at_a_time() {
        BlogPage blogPage = PageFactory.initElements(driver,BlogPage.class);

            for (int i=1;i<blogPage.getDrpDwnList().size();i++) {
                System.out.println(blogPage.getDrpDwnList().get(i).getText());
                blogPage.getDrpdwnCategory().sendKeys(blogPage.getDrpDwnList().get(i).getText());
                //TestBase testBase = PageFactory.initElements(driver, TestBase.class);
                validateHyperLinks(blogPage.getAreaNewsContent());
            }
    }
}
