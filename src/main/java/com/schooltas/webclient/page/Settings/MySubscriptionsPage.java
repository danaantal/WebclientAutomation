package com.schooltas.webclient.page.Settings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.webclient.utils.ActionUtils;

public class MySubscriptionsPage {

    @FindBy(how = How.CSS, using = "#popover-screen-subscriptions [type='button']")
    WebElement doneButton;

    @FindBy(how = How.CSS, using = "#popover-screen-subscriptions .subscription-list")
    WebElement listOfSubscriptions;

    @FindBy(id = "new-subscriptioncode")
    WebElement subscriptionCodeInputField;

    @FindBy(how = How.CSS, using = "#form-addsubscription button")
    WebElement addButton;

    @FindBy(how = How.CSS, using = "#alert-popup .white:nth-of-type(4)")
    WebElement okErrorButton;

    public void addSubscription(String subscriptionCode) {
        ActionUtils.WaitForElementToBeDisplayed(subscriptionCodeInputField);
        subscriptionCodeInputField.sendKeys(subscriptionCode);
        addButton.click();
        ActionUtils.WaitForElementToBeDisplayed(okErrorButton);
        okErrorButton.click();
    }

    public void closeWindow() {
        ActionUtils.WaitForElementToBeClickable(doneButton);
        doneButton.click();
    }
}
