package com.schooltas.webclient.page.Settings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.webclient.utils.ActionUtils;

public class MyBundlesPage {

	@FindBy(how = How.CSS, using = "#popover-screen-bundles button")
	WebElement doneButton;
	
	@FindBy(how = How.CSS, using = "#popover-screen-bundles .inside-scroll")
	WebElement listOfLicenses;
	
	@FindBy(id="new-bundlecode")
	WebElement licenseCodeInputField;
	
	@FindBy(how = How.CSS, using = "#form-addbundle .st-submit")
	WebElement addButton;
	
	@FindBy(how = How.CSS, using = "#alert-popup .white:nth-of-type(4)")
	WebElement okErrorButton;
		
	//demo license button and screen??
	
	
	public void addLicense(String licenseCode){
		ActionUtils.WaitForElementToBeDisplayed(licenseCodeInputField);
		licenseCodeInputField.sendKeys(licenseCode);
		addButton.click();
		ActionUtils.WaitForElementToBeDisplayed(okErrorButton);
		okErrorButton.click();
	}
	
	public void closeWindow(){
		ActionUtils.WaitForElementToBeClickable(doneButton);
		doneButton.click();
	}
	
}