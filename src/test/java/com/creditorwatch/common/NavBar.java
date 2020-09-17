package com.creditorwatch.common;

import com.creditorwatch.page.BlogPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavBar {
    WebDriver driver;
    @FindBy(xpath="//ul[@class='nav navbar-nav navbar-right cw-navbar']//a[contains(text(),'Blog')]")
    public WebElement lnk_Blog;





    public NavBar(WebDriver driver){
        this.driver = driver;
    }
    public void goToBlogPagee(){
        lnk_Blog.click();
    }
    public BlogPage goToBlogPage(){
        lnk_Blog.click();
        return PageFactory.initElements(driver,BlogPage.class);
    }



}
