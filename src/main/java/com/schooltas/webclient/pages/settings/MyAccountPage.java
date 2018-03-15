package com.schooltas.webclient.pages.settings;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.webclient.utils.ActionUtils;

public class MyAccountPage {
	
	@FindBy(how = How.CSS, using = "#popover-screen-profile [type='submit']")
	WebElement doneButton;
	
	@FindBy(id="file-avatar")
	WebElement changeAvatarButton;
	
	@FindBy(how = How.CSS, using = "#profiel-naam-display")
	WebElement changeNameButton;
	
	@FindBy(how = How.CSS, using = "#profiel-wachtwoord-display")
	WebElement changePasswordButton;
	
	@FindBy(how = How.CSS, using = "#popover-screen-name button")
	WebElement backToMyAccountButton;
	
	@FindBy(id="change-firstname")
	WebElement firstNameInputField;
	
	@FindBy(id="change-lastname")
	WebElement lastNameInputField;
	
	@FindBy(how = How.CSS, using = "#form-changename .st-submit")
	WebElement saveNameButton;
	
	@FindBy(id="current-password")
	WebElement currentPasswordInputField;
	
	@FindBy(id="new-password1")
	WebElement newPasswordInputField;
	
	@FindBy(id="new-password2")
	WebElement repeatPasswordInputField;
	
	@FindBy(how = How.CSS, using = "#form-changepassword .st-submit")
	WebElement savePasswordButton;
	
	@FindBy(how = How.CSS, using = "#popover-screen-ok .header")
	WebElement passwordChangeConfirmationMessage;
	
	@FindBy(how = How.XPATH, using = "//div[@id='popover-screen-ok']/button[@type='button']")
	WebElement backToMyAccountAfterPasswordChangeButton;
	
	public void changeAvatar(){
		changeAvatarButton.sendKeys("E:\\book_new.jpg");		
	}
	
	public void changeName(String firstName, String lastName){
		ActionUtils.WaitForElementToBeDisplayed(changeNameButton);
		changeNameButton.click();
		firstNameInputField.clear();
		firstNameInputField.sendKeys(firstName);
		lastNameInputField.clear();
		lastNameInputField.sendKeys(lastName);
		saveNameButton.click();
	}
	
	public void changePassword(String currentPassword, String newPassword){
		ActionUtils.WaitForElementToBeDisplayed(changePasswordButton);
		changePasswordButton.click();
		currentPasswordInputField.sendKeys(currentPassword);
		newPasswordInputField.sendKeys(newPassword);
		repeatPasswordInputField.sendKeys(newPassword);
		savePasswordButton.click();		
	}
		
	public void closeWindow(){
		ActionUtils.WaitForElementToBeClickable(doneButton);
		doneButton.click();
	}
	
	public void checkIfNameIsChanged(String firstName, String lastName){
		ActionUtils.WaitForElementToBeDisplayed(changeNameButton);
		assertEquals(changeNameButton.getText(), firstName.concat(" " + lastName));
	}
	
	public void checkIfPasswordIsChanged(){
		ActionUtils.WaitForElementToBeDisplayed(passwordChangeConfirmationMessage);
		assertEquals(passwordChangeConfirmationMessage.getText(), "Your password has been changed.");
		ActionUtils.WaitForElementToBeClickable(backToMyAccountAfterPasswordChangeButton);
		backToMyAccountAfterPasswordChangeButton.click();
	}
}
