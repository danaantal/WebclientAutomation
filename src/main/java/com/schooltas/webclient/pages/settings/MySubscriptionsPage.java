package com.schooltas.webclient.pages.settings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.webclient.utils.ActionUtils;

public class MySubscriptionsPage {

    @FindBy(how = How.CSS, using = "#popover-screen-subscriptions [type='button']")
    private WebElement doneButton;

    @FindBy(how = How.CSS, using = "#popover-screen-subscriptions .subscription-list")
    private WebElement listOfSubscriptions;

    @FindBy(id = "new-subscriptioncode")
    private WebElement subscriptionCodeInputField;

    @FindBy(how = How.CSS, using = "#form-addsubscription button")
    private WebElement addButton;

    @FindBy(how = How.CSS, using = "#alert-popup .white:nth-of-type(4)")
    private WebElement okErrorButton;

    public void addSubscription(String subscriptionCode) {
    	
        ActionUtils.waitForElementToBeDisplayed(subscriptionCodeInputField);
        subscriptionCodeInputField.sendKeys(subscriptionCode);
        
        addButton.click();
        
        ActionUtils.waitForElementToBeDisplayed(okErrorButton);
        okErrorButton.click();
    }

    public void closeWindow() {
    	
        ActionUtils.waitForElementToBeClickable(doneButton);
        doneButton.click();
    }
}
