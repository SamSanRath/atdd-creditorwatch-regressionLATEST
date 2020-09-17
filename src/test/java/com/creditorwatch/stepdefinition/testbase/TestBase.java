package com.creditorwatch.stepdefinition.testbase;

import com.creditorwatch.stepdefinition.test.ValidateLinksTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class TestBase {
    public static Properties config = null;
    public static Properties OR = null;
    public static WebDriver webdriver = null;
    public static EventFiringWebDriver driver = null;
    public static boolean isloggedIn = false;

    private final static Logger logger = Logger.getLogger(ValidateLinksTest.class.getName());

    public void init() throws IOException {

        if(driver == null) {
            // Config.properties file initialization.
            config = new Properties();
            FileInputStream fileinputstream = new FileInputStream(System.getProperty("user.dir") + File.separator +
                    "src" + File.separator + "test" + File.separator + "resources" + File.separator + "config.properties");
            config.load(fileinputstream);

            /*
             * System.out.println(System.getProperty("user.dir")); // OR.properties file
             * initialization FileInputStream fileinputstream1 = new
             * FileInputStream(System.getProperty("user.dir")
             * +"//src//test//resources//com//cnglobal//expeedio//expeedio//utils//OR.properties"
             * ); OR.load(fileinputstream1);
             */

            if (config.getProperty("browserType").equals(BrowserType.FIREFOX)) {
                //System.setProperty("webdriver.gecko.driver", "C:\\Automation\\Selenium\\workspace\\Drivers\\geckodriver.exe");
                //webdriver = new FirefoxDriver();
                WebDriverManager.firefoxdriver().setup();
            } else if (config.getProperty("browserType").equals(BrowserType.CHROME)) {
                //DND   System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Selenium\\workspace\\Drivers\\chromedriver.exe");
                //DND
                WebDriverManager.chromedriver().setup();
                // 			--------IMPORTANT---------
                //WebDriverManager.chromedriver().setup();
                //	 		--------IMPORTANT ---------
                //DND   DesiredCapabilities desiredcapabilities = new DesiredCapabilities();
                //DND   desiredcapabilities.setCapability(capabilityName, value);
                //		 		--------IMPORTANT---------
                //DND   ChromeOptions options = new ChromeOptions();
                //DND   options.addArguments("--headless");
                //DND   webdriver = new ChromeDriver(options);

                webdriver = new ChromeDriver();
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
//        System.out.println("Links are below: ");
        while (it.hasNext()) {
            linkText = it.next().getAttribute("href");
            logger.info(linkText);
//                if(linkText==null || linkText.isEmpty()){
//                    System.out.println(linkText+" is null, blank OR empty");
//                }

            try {
                huc = (HttpURLConnection) (new URL(linkText).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();
                logger.info(String.valueOf(respCode));
                softAssert.assertTrue(respCode < 400, "\"" + linkText + "\" is broken!");
//                if(respCode >= 400){
//                    System.out.println(linkText+" is a broken link(CLIENT ERROR OR SERVER ERROR)"+ " & Response code is: "+ respCode);
//                }
//                else{
//                    //System.out.println(url+" is a valid link");
//                    continue;
//                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
        softAssert.assertAll();
    }
/*	public void tearDown(){
		Log.info("Driver is about to quit");
		driver.quit();
		driver=null;
		Log.info("Driver is null and did quit");
	}*/


}
