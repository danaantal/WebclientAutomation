package com.schooltas.webclient.pages.settings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.webclient.utils.ActionUtils;

public class MyBundlesPage {

    @FindBy(how = How.CSS, using = "#popover-screen-bundles button")
    WebElement doneButton;

    @FindBy(how = How.CSS, using = "#popover-screen-bundles .inside-scroll")
    WebElement listOfLicenses;

    @FindBy(id = "new-bundlecode")
    WebElement licenseCodeInputField;

    @FindBy(how = How.CSS, using = "#form-addbundle .st-submit")
    WebElement addButton;

    @FindBy(how = How.CSS, using = "#alert-popup .white:nth-of-type(4)")
    WebElement okErrorButton;

    // demo license button and screen??

    public void addLicense(String licenseCode) {
        ActionUtils.waitForElementToBeDisplayed(licenseCodeInputField);
        licenseCodeInputField.sendKeys(licenseCode);
        addButton.click();
        ActionUtils.waitForElementToBeDisplayed(okErrorButton);
        okErrorButton.click();
    }

    // ^ split the method above into 2 different methods: add license and click ok in error popup

    public void closeWindow() {
        ActionUtils.waitForElementToBeClickable(doneButton);
        doneButton.click();
    }

}
