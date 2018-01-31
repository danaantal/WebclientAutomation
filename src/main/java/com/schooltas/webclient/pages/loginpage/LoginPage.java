package com.schooltas.webclient.pages.loginpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private static WebDriver driver;

	public LoginPage(WebDriver driver) {
		LoginPage.driver = driver;
	}

	@FindBy(id = "login-email")
	WebElement emailField;

	@FindBy(id = "login-password")
	WebElement passwordField;

	@FindBy(id = "logins")
	WebElement loginBtn;

	@FindBy(how = How.CLASS_NAME, using = "alert-overlay")
	WebElement alertOverlay;


	public void login(String email, String password) {
		WaitForElementToFinish(alertOverlay);
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		loginBtn.click();

	}

	public void WaitForElementToFinish(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

}
