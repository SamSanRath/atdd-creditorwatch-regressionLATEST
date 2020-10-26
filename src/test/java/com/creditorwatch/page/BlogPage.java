package com.creditorwatch.page;

import com.creditorwatch.pagebase.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BlogPage extends PageBase {

    @FindBy(xpath = "//select[@id='cat']")
    private WebElement drpdwnCategory;
    @FindBy(xpath = "//div[@id='content']")
    private WebElement areaNewsContent;
    @FindBy(xpath = "//div/a[contains(text(),\"More articles\")]")
    private WebElement lnkMoreArticles;



    @FindBy(xpath = "//input[@id='s']")
    private WebElement txtBoxSearch;
    @FindBy(xpath = "//input[@id='searchsubmit']")
    private WebElement btnSearch;
    @FindBy(xpath = "//div[@id='content']")
    private WebElement areaSearchResults;


    public BlogPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getDrpdwnCategory(){
        return drpdwnCategory;
    }

    public WebElement getAreaNewsContent() {
        return areaNewsContent;
    }

  /*  public WebElement getTxtBoxSearch() {
        return txtBoxSearch;
    }*/

    public WebElement getBtnSearch() {
        return btnSearch;
    }

    public void selectCategoryDropDwn(String categoryType) {
        selectDropDownByVisibleText(drpdwnCategory, categoryType);
    }

    public void doSearch(String text) {
        setText(txtBoxSearch,text);
        click(btnSearch);

    }

    public void isKeywordInSearchResults(String keyword) {
        SoftAssert softAssert = new SoftAssert();
        List<WebElement>searchResultsList = new ArrayList<>();
        //int counter = 0;
        boolean isMoreArticlesLinkDisplayed = lnkMoreArticles.isDisplayed();
        while (isMoreArticlesLinkDisplayed){
            //counter++;
            try{
                List<WebElement>currentPageSearchResults = areaSearchResults.findElements(By.tagName("a"));
                searchResultsList = Stream.concat(searchResultsList.stream(),
                        currentPageSearchResults.stream())
                        .collect(Collectors.toList());
                WebDriverWait wait = new WebDriverWait(driver,2000);
                wait.until(ExpectedConditions.elementToBeClickable(lnkMoreArticles));
                lnkMoreArticles.click();
                isMoreArticlesLinkDisplayed = true;
            } catch (NoSuchElementException ignored){
                isMoreArticlesLinkDisplayed = false;
                break;
            }
        }
/*        while (lnkMoreArticles.isEnabled()) {
            System.out.println("Before Click"+lnkMoreArticles.isDisplayed());
            lnkMoreArticles.click();
            *//*searchResultsList = Stream.concat(searchResultsList.stream(),
                    areaSearchResults.findElements(By.tagName("a")).stream())
                    .collect(Collectors.toList());*//*
            searchResultsList.addAll(areaSearchResults.findElements(By.tagName("a"))); // Another way of concatenating lists
            System.out.println(searchResultsList.size());
            System.out.println("After click"+lnkMoreArticles.isDisplayed());
        }*/
        for (WebElement list:searchResultsList) {
            System.out.println("****************        Came here");
            System.out.println(list.getText()+"contains keyword :"+ list.getText().contains(keyword));
            softAssert.assertTrue(list.getText().contains(keyword));
        }
        softAssert.assertAll();
    }

 /*   public void tbd(){
        for (int i=1;i<getDrpDwnList().size();i++) {
            System.out.println(getDrpDwnList().get(i).getText());
            drpdwnCategory.sendKeys(getDrpDwnList().get(i).getText());
            TestBase testBase = PageFactory.initElements(driver, TestBase.class);
            testBase.validateHyperLinks(areaNewsContent);
        }
    }*/
}
