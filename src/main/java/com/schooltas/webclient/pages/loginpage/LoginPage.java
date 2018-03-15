package com.schooltas.webclient.pages.loginpage;

import java.util.List;

import org.openqa.selenium.By;
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

    @FindBy(id = "percentageLoader")
    WebElement alertOverlay;

    @FindBy(how = How.CSS, using = "[lang-ref='BSSchooltasSlogan']")
    WebElement header;

    @FindBy(how = How.CSS, using = ".current-language")
    WebElement currentLanguage;

    @FindBy(how = How.CSS, using = ".language-select")
    WebElement languageList;

    public void login(String email, String password) throws InterruptedException {
        Thread.sleep(7000);
        currentLanguage.click();
        clickDesiredLanguage("English");
        WaitForHeaderToBeVisible();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginBtn.click();

    }

    public void findLanguageListOption(List<WebElement> children, String languageName) {

        for (WebElement element : children) {
            if (element.getText().equals(languageName)) {
                element.click();
                return;
            }
        }
    }

    public void clickDesiredLanguage(String languageName) {

        List<WebElement> children = languageList.findElements(By.xpath(".//*"));
        findLanguageListOption(children, languageName);
    }

    public void WaitForHeaderToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'reinvent learning')]")));
    }
}
