package com.schooltas.webclient.pages.settings;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.webclient.utils.ActionUtils;

public class MyAccountPage {

	@FindBy(how = How.CSS, using = "#popover-screen-profile [type='submit']")
	private WebElement doneButton;

	@FindBy(id = "file-avatar")
	private WebElement changeAvatarButton;

	@FindBy(how = How.CSS, using = "#profiel-naam-display")
	private WebElement changeNameButton;

	@FindBy(how = How.CSS, using = "#profiel-wachtwoord-display")
	private WebElement changePasswordButton;

	@FindBy(how = How.CSS, using = "#popover-screen-name button")
	private WebElement backToMyAccountButton;

	@FindBy(id = "change-firstname")
	private WebElement firstNameInputField;

	@FindBy(id = "change-lastname")
	private WebElement lastNameInputField;

	/*
	 * @FindBy(how = How.CSS, using = "#form-changename .st-submit") WebElement
	 * saveNameButton;
	 *
	 * @FindBy(how = How.CSS, using = "#form-changepassword .st-submit")
	 * WebElement savePasswordButton;
	 */

	// you can use:
	@FindBy(how = How.CSS, using = "input.st-submit.button.full.green")
	private List<WebElement> saveButtons;

	@FindBy(id = "current-password")
	private WebElement currentPasswordInputField;

	@FindBy(id = "new-password1")
	private WebElement newPasswordInputField;

	@FindBy(id = "new-password2")
	private WebElement repeatPasswordInputField;

	@FindBy(how = How.CSS, using = "#popover-screen-ok .header")
	private WebElement passwordChangeConfirmationMessage;

	@FindBy(how = How.XPATH, using = "//div[@id='popover-screen-ok']/button[@type='button']")
	private WebElement backToMyAccountAfterPasswordChangeButton;

	public void changeAvatar() {

		changeAvatarButton.sendKeys("E:\\book_new.jpg");
	}

	public void changeFirstName(String firstName) {

		ActionUtils.waitForElementToBeDisplayed(changeNameButton);

		changeNameButton.click();

		firstNameInputField.clear();

		firstNameInputField.sendKeys(firstName);
	}

	public void changeLastName(String lastName) {

		lastNameInputField.clear();

		lastNameInputField.sendKeys(lastName);
	}

	public void clickSaveButton(String placeOfSaveButton) {

		if (placeOfSaveButton.equals("name")) {

			saveButtons.get(0).click();
		}

		else if (placeOfSaveButton.equals("password")) {

			saveButtons.get(1).click();
		}
	}

	public void changePassword(String currentPassword, String newPassword) {

		ActionUtils.waitForElementToBeDisplayed(changePasswordButton);
		changePasswordButton.click();

		currentPasswordInputField.sendKeys(currentPassword);

		newPasswordInputField.sendKeys(newPassword);

		repeatPasswordInputField.sendKeys(newPassword);
	}

	public void closeWindow() {

		ActionUtils.waitForElementToBeDisplayed(doneButton);
		doneButton.click();
	}

	public void checkIfNameIsChanged(String firstName, String lastName) {

		ActionUtils.waitForElementToBeDisplayed(changeNameButton);
		assertEquals(changeNameButton.getText(), firstName.concat(" " + lastName));
	}

	public void checkIfPasswordIsChanged() {

		ActionUtils.waitForElementToBeDisplayed(passwordChangeConfirmationMessage);

		assertEquals(passwordChangeConfirmationMessage.getText(), "Your password has been changed.");

		ActionUtils.waitForElementToBeClickable(backToMyAccountAfterPasswordChangeButton);

		backToMyAccountAfterPasswordChangeButton.click();
	}
}
