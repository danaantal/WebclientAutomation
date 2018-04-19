package com.schooltas.webclient.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.schooltas.webclient.utils.ActionUtils;
import com.schooltas.webclient.utils.BrowserFactory;
import com.schooltas.webclient.utils.ILoginConstants;

public class BaseTest implements ILoginConstants {

    protected static WebDriver driver;

    @BeforeTest
    public final void beforeTest() throws InterruptedException {
        System.out.println("BeforeTest");
        // System.setProperty("webdriver.chrome.driver", "/Users/dantal/Desktop/chromedriver");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\ccostea\\Documents\\geckodriver.exe");
        driver = BrowserFactory.startBrowser("firefox", "https://mijn-test.schooltas.net");
        ActionUtils.loginAs("publisher");
    }

    @AfterTest
    public final void afterTest() throws InterruptedException {
        // Close the instance of browser
        Thread.sleep(1000);
        driver.quit();
    }
}
