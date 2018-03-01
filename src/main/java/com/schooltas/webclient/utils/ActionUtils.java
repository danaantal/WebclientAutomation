package com.schooltas.webclient.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.schooltas.webclient.pages.loginpage.LoginPage;
import com.schooltas.webclient.tests.BaseTest;


public class ActionUtils extends BaseTest{
	public static void loginAs(String organization) throws InterruptedException {

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		if (organization == "publisher") {
			loginPage.login(TEST_PUBLISHER_EMAIL, TEST_PUBLISHER_PASS);
		} else if (organization == "distributor") {
			loginPage.login(TEST_DISTRIBUTOR_EMAIL, TEST_DISTRIBUTOR_PASS);
		} else if (organization == "school") {
			loginPage.login(TEST_SCHOOL_EMAIL, TEST_SCHOOL_PASS);
		}
	}
	
	public static void WaitForElementToBeDisplayed(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void WaitForTextToBeDisplayed(WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public static void WaitForElementToBeClickable(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
