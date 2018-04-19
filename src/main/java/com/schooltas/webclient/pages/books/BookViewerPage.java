package com.schooltas.webclient.pages.books;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.webclient.utils.ActionUtils;

public class BookViewerPage {

    @FindBy(how = How.CSS, using = ".toolbar-dashboard")
    private WebElement backToMyBooksPageButton;

    @FindBy(how = How.CSS, using = ".toolbar-search")
    private WebElement searchBookButton;

    @FindBy(how = How.CSS, using = ".queryBox input")
    private WebElement searchInputField;

    @FindBy(how = How.CSS, using = ".close-search")
    private WebElement closeSearchButton;

    @FindBy(how = How.CSS, using = ".prikker-container")
    private List<WebElement> pageOverlay;

    @FindBy(id = "booktitle-popup")
    private WebElement bookTitlePopup;

    @FindBy(how = How.XPATH, using = "//button[contains(.,'wordweb')]")
    private WebElement createWordwebButton;

    @FindBy(how = How.XPATH, using = "//button[contains(.,'new pin')]")
    private WebElement createPinButton;

    @FindBy(how = How.CSS, using = ".shown-transition [lang-ref-target]")
    private WebElement wordwebTopicInputField;

    @FindBy(how = How.CSS, using = ".form-footer [type='submit']")
    private WebElement saveWordwebTopicButton;

    @FindBy(how = How.CSS, using = ".divided [type]")
    private WebElement startWordwebButton;

    @FindBy(how = How.CSS, using = ".remove-button")
    WebElement removeWordwebButton;

    public void goToMyBooksList() {
    	
        backToMyBooksPageButton.click();
    }

    public void addWordweb() {
    	
        ActionUtils.waitForElementToBeClickable(createWordwebButton);
        createWordwebButton.click();
        
        wordwebTopicInputField.sendKeys("Automated Wordweb");
        
        saveWordwebTopicButton.click();
    }
    
    public void addNotePin(){
    
    	
    }
    
    public void rightClick() {
    	
        ActionUtils.waitForElementToBeDisplayed(bookTitlePopup);
        ActionUtils.waitForElementToBeDisplayed(pageOverlay.get(0));
        ActionUtils.rightClick(pageOverlay.get(0));
    }

    public void checkBookViewerIsLoaded() {
    	
        ActionUtils.waitForElementToBeDisplayed(backToMyBooksPageButton);
    }
}
