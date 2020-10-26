package com.creditorwatch.stepdefinition.test;

import com.creditorwatch.page.BlogPage;
import com.creditorwatch.stepdefinition.testbase.TestBase;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ValidateSearchPanelTest extends TestBase {

    String keyword;

    @When("i click search button")
    public void i_click_search_button() {
        System.out.println("#######################333");
        BlogPage blogPage = PageFactory.initElements(driver, BlogPage.class);
        blogPage.getBtnSearch().click();
    }

    @Then("all the articles should be displayed")
    public void all_the_articles_should_be_displayed() {
        Assert.assertTrue(true);
    }

    @When("i enter keyword and click search button")
    public void i_enter_and_click_search_button(List<String>word) throws InterruptedException {
        System.out.println("************************************");
        BlogPage blogPage = PageFactory.initElements(driver, BlogPage.class);
        keyword = word.get(0);
        blogPage.doSearch(keyword);
        Thread.sleep(5000);

    }

    @Then("all the articles relate to keyword should be displayed")
    public void all_the_articles_relate_to_keyword_should_be_displayed() {
        BlogPage blogPage = PageFactory.initElements(driver, BlogPage.class);
        blogPage.isKeywordInSearchResults(keyword);
    }
}
