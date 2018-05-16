package com.schooltas.webclient.utils;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.schooltas.webclient.pages.loginpage.LoginPage;
import com.schooltas.webclient.tests.BaseTest;

public class ActionUtils extends BaseTest {
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

	public static void waitForElementToBeDisplayed(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElementToBeInvisible(WebElement element, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, 1);

		for (int attempt = 0; attempt < waitTime; attempt++) {
			try {
				System.out.println("[" + attempt + "]" + "Displayed: " + element.isDisplayed());
				wait.until(ExpectedConditions.invisibilityOf(element));
				break;
			} catch (Exception e) {
			//	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			}
		}
	}

	public static void waitForTextToBeDisplayed(WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public static void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void rightClick(WebElement element) {
		try {
			Actions action = new Actions(driver).contextClick(element);
			action.build().perform();

			System.out.println("Sucessfully Right clicked on the element");
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + element + " was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Element " + element + " was not clickable " + e.getStackTrace());
		}

	}

	public static void moveMouse(WebElement element) {
		Actions action = new Actions(driver).moveToElement(element);
		action.build().perform();
	}
}
