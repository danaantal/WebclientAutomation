package com.schooltas.webclient.pages.books;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.schooltas.webclient.pages.notePage.NotePage;
import com.schooltas.webclient.utils.ActionUtils;

public class BookViewerPage {

	private static WebDriver driver;
	
	public BookViewerPage(WebDriver driver) {

		BookViewerPage.driver = driver;
    }
    
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

    @FindBy(how = How.CSS, using = ".wordweb")
    private List<WebElement> listOfWordwebPins;
    
    @FindBy(how = How.XPATH, using = "//button[contains(.,'new pin')]")
    private WebElement createPinButton;

    @FindBy(how = How.CSS, using = ".prikker.my-note")
    private List<WebElement> listOfNotePins;
    
    @FindBy(how = How.CSS, using = ".shown-transition [lang-ref-target]")
    private WebElement wordwebTopicInputField;

    @FindBy(how = How.CSS, using = ".form-footer [type='submit']")
    private WebElement saveWordwebTopicButton;

    @FindBy(how = How.CSS, using = ".divided [type]")
    private WebElement startWordwebButton;

    @FindBy(how = How.CSS, using = ".remove-button")
    WebElement removeWordwebButton;

    @FindBy(how = How.CSS, using = ".popup-cnt.shown .marker-popup-delete")
    WebElement deleteNotePinButton;
    
    @FindBy(how = How.CSS, using = ".show .red:nth-of-type(1)")
    WebElement deleteOptionIncludeNote;
    
    @FindBy(how = How.CSS, using = ".show .red:nth-of-type(2)")
    WebElement deleteOptionJustPin;
    
    
    
    public void goToMyBooksList() {
    	
    	backToMyBooksPageButton.click();
    }

    public void addWordweb() {
    	
        ActionUtils.waitForElementToBeClickable(createWordwebButton);
        createWordwebButton.click();
        
        ActionUtils.waitForElementToBeDisplayed(wordwebTopicInputField);
        wordwebTopicInputField.sendKeys("Automated Wordweb");
        
        saveWordwebTopicButton.click();
    }
    
    public void deleteWordweb(){

    	ActionUtils.waitForElementToBeClickable(removeWordwebButton);
    	removeWordwebButton.click();
    	
    }
    
    public void addNotePin(){
    	NotePage notePage = PageFactory.initElements(driver, NotePage.class);
    	ActionUtils.waitForElementToBeClickable(createPinButton);
    	
    	createPinButton.click();
    	notePage.addNoteContent();
    	notePage.saveNote();
    	
    }
    
    public void deleteNotePin(){
    	ActionUtils.waitForElementToBeClickable(listOfNotePins.get(0));
    	listOfNotePins.get(0).click();
    	
    	ActionUtils.waitForElementToBeClickable(deleteNotePinButton);
    	deleteNotePinButton.click();
    	deleteOptionIncludeNote.click();
    	
    }
 
    public void rightClick() {
    	
    	ActionUtils.waitForElementToBeInvisible(bookTitlePopup, 10);
        ActionUtils.waitForElementToBeDisplayed(pageOverlay.get(0));
        
        ActionUtils.rightClick(pageOverlay.get(0));
    }

    public void checkBookViewerIsLoaded() {
        ActionUtils.waitForElementToBeDisplayed(backToMyBooksPageButton);
    }
}
