package com.schooltas.webclient.pages.homepage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.webclient.utils.ActionUtils;

public class HomePage {

    @FindBy(how = How.CLASS_NAME, using = "gear")
    WebElement showUserMenuButton;

    @FindBy(how = How.CSS, using = "#welcome-header .popout-right")
    WebElement listUserMenuOptions;

    public void showUserMenu() {
        ActionUtils.WaitForElementToBeClickable(showUserMenuButton);
        showUserMenuButton.click();
    }

    public void findUserMenuOptions(List<WebElement> children, String menuOptionName) {

        for (WebElement element : children) {
            if (element.getText().equals(menuOptionName)) {
                element.click();
                return;
            }
        }
    }

    public void clickUserMenuOption(String menuOptionName) {
        List<WebElement> children = listUserMenuOptions.findElements(By.xpath(".//*"));
        findUserMenuOptions(children, menuOptionName);
    }
}
