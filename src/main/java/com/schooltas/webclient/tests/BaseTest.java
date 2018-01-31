package com.schooltas.webclient.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.schooltas.webclient.pages.homepage.HomePage;
import com.schooltas.webclient.utils.ActionUtils;
import com.schooltas.webclient.utils.BrowserFactory;
import com.schooltas.webclient.utils.ILoginConstants;

public class BaseTest implements ILoginConstants{

	protected static WebDriver driver;
	protected HomePage homePage;

	@BeforeTest
	public final void beforeTest() {
		System.out.println("BeforeTest");
		System.setProperty("webdriver.chrome.driver", "/Users/dantal/Desktop/chromedriver");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ccostea\\Documents\\chromedriver.exe");
		driver = BrowserFactory.startBrowser("chrome", "https://mijn-test.schooltas.net");
		ActionUtils.loginAs("publisher");
		homePage = PageFactory.initElements(driver, HomePage.class);
	}

	@AfterTest
	public final void afterTest() {
		// Close the instance of browser
		driver.quit();
	}
}
