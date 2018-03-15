package com.schooltas.webclient.pages.settings;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.webclient.utils.ActionUtils;

public class LanguagePage {

    @FindBy(how = How.CSS, using = "#alert-popup .current-language")
    WebElement currentLanguage;

    @FindBy(how = How.CSS, using = "#alert-popup .language-select")
    WebElement listOfAvailableLanguages;

    @FindBy(how = How.CSS, using = ".btn-custom")
    WebElement okButton;

    @FindBy(how = How.CSS, using = "#alert-popup .white:nth-of-type(5)")
    WebElement cancelButton;

    public void expandLanguageList() {
        currentLanguage.click();
    }

    public void confirmLanguageChange() {
        okButton.click();
    }

    public void findLanguagesList(List<WebElement> children, String languageName) {

        for (WebElement element : children) {
            if (element.getText().equals(languageName)) {
                element.click();
                return;
            }
        }
    }

    public void clickLanguage(String languageName) {
        ActionUtils.waitForElementToBeClickable(listOfAvailableLanguages);
        List<WebElement> children = listOfAvailableLanguages.findElements(By.xpath(".//*"));
        findLanguagesList(children, languageName);
    }
}
