package com.creditorwatch.stepdefinition.testbase;

import com.creditorwatch.stepdefinition.test.ValidateLinksTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    private final static Logger logger = Logger.getLogger(ValidateLinksTest.class.getName());
    public static Properties config = null;
    public static Properties OR = null;
    public static WebDriver webdriver = null;
    public static EventFiringWebDriver driver = null;
    public static boolean isloggedIn = false;

    public void init() throws IOException {

        if (driver == null) {
            // Config.properties file initialization.
            config = new Properties();
            FileInputStream fileinputstream = new FileInputStream(System.getProperty("user.dir") + File.separator +
                    "src" + File.separator + "test" + File.separator + "resources" + File.separator + "config.properties");
            config.load(fileinputstream);
            if (config.getProperty("browserType").equals(BrowserType.FIREFOX)) {
                WebDriverManager.firefoxdriver().setup();
                webdriver = new FirefoxDriver();
            } else if (config.getProperty("browserType").equals(BrowserType.CHROME)) {
                WebDriverManager.chromedriver().setup();
                webdriver = new ChromeDriver();
            } else if (config.getProperty("browserType").equals(BrowserType.EDGE)) {
                WebDriverManager.edgedriver().setup();
                webdriver = new EdgeDriver();
            }
            driver = new EventFiringWebDriver(webdriver);
            driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(config.getProperty("site"));
        }
    }

    public void validateHyperLinks(WebElement window) {

        String linkText;
        HttpURLConnection huc = null;
        int respCode = 200;
        // Not using the Set because there may be different links with same texts
        List<WebElement> links = window.findElements(By.tagName("a"));
        Iterator<WebElement> it = links.iterator();
        SoftAssert softAssert = new SoftAssert();
        logger.info("Links are below: ");
        while (it.hasNext()) {
            linkText = it.next().getAttribute("href");
            logger.info(linkText);
            try {
                huc = (HttpURLConnection) (new URL(linkText).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();
                logger.info(String.valueOf(respCode));
                softAssert.assertTrue(respCode < 400, "\"" + linkText + "\" is broken!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        softAssert.assertAll();
    }
}
