package com.schooltas.webclient.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.schooltas.webclient.utils.ActionUtils;
import com.schooltas.webclient.utils.BrowserFactory;
import com.schooltas.webclient.utils.ILoginConstants;

public class BaseTest implements ILoginConstants{

    protected static WebDriver driver;

    @BeforeTest
    public final void beforeTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/dantal/Desktop/chromedriver");
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\ccostea\\Documents\\chromedriver.exe");
        driver = BrowserFactory.startBrowser("chrome", "https://mijn-test.schooltas.net");
        ActionUtils.loginAs("publisher");
    }

<<<<<<< Updated upstream
	@AfterTest
	public final void afterTest() throws InterruptedException{
		// Close the instance of browser
		Thread.sleep(1000);
		driver.quit();
	}
=======
    @AfterTest
    public final void afterTest() {
        // Close the instance of browser
        driver.quit();
    }
>>>>>>> Stashed changes
}
