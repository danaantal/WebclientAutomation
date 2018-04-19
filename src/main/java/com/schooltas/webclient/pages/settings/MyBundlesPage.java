package com.schooltas.webclient.pages.settings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.webclient.utils.ActionUtils;

public class MyBundlesPage {

    @FindBy(how = How.CSS, using = "#popover-screen-bundles button")
    private WebElement doneButton;

    @FindBy(how = How.CSS, using = "#popover-screen-bundles .inside-scroll")
    private WebElement listOfLicenses;

    @FindBy(id = "new-bundlecode")
    private WebElement licenseCodeInputField;

    @FindBy(how = How.CSS, using = "#form-addbundle .st-submit")
    private WebElement addButton;

    @FindBy(how = How.CSS, using = "#alert-popup .white:nth-of-type(4)")
    private WebElement okErrorButton;

    // demo license button and screen??

    public void addLicense(String licenseCode) {
    	
        ActionUtils.waitForElementToBeDisplayed(licenseCodeInputField);
        
        licenseCodeInputField.sendKeys(licenseCode);
        
        addButton.click();
        
        
    }
    
    public void clickOkErrorButton(){
    	
    	ActionUtils.waitForElementToBeDisplayed(okErrorButton);
        okErrorButton.click();
    } 

    public void closeWindow() {
    	
        ActionUtils.waitForElementToBeClickable(doneButton);
        doneButton.click();
    }

}
