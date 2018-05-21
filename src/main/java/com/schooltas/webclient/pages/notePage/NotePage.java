package com.schooltas.webclient.pages.notePage;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.webclient.utils.ActionUtils;

public class NotePage {

    @FindBy(how = How.CSS, using = "textarea:nth-child(2)")
    private WebElement noteTextInputArea;

    @FindBy(how = How.CLASS_NAME, using = "newTag")
    private WebElement tagTextArea;

    @FindBy(how = How.CSS, using = "div.body")
	public List<WebElement> noteText;

    @FindBy(how = How.CSS, using = ".editMode .createUpdateNote")
    private WebElement saveButton;

    @FindBy(how = How.CSS, using = ".editMode .button-cancel")
    private WebElement cancelButton;

    @FindBy(how = How.CSS, using = ".editMode [type='file']")
    private WebElement addAttachmentButton;

    @FindBy(how = How.CSS, using = ".goto-prikker")
    private List<WebElement> goToPinNoteButton;

    @FindBy(how = How.CSS, using = ".button-edit")
    private List<WebElement> editNoteButton;

    @FindBy(how = How.CSS, using = ".button-delete")
    private List<WebElement> deleteButton;

    @FindBy(how = How.CSS, using = ".popout-button-delete")
    private List<WebElement> confirmDeletionButton;

    @FindBy(how = How.CSS, using = ".popout-button-cancel")
    private List<WebElement> cancelDeletionButton;

    @FindBy(how = How.CSS, using = ".button-fav")
    private List<WebElement> favouriteButton;

    public void addNoteContent() {
    	
        ActionUtils.waitForElementToBeDisplayed(noteTextInputArea);
        noteTextInputArea.sendKeys("Test note Search&Delete");
        
        tagTextArea.sendKeys("Test Tag");
        
        addAttachmentButton.sendKeys("E:\\WebclientAutomation\\lib\\testGIF.gif");
    }

    public void saveNote() {
    	
        saveButton.click();
    }

    public void clickEditButton() {
    	
        ActionUtils.waitForElementToBeClickable(editNoteButton.get(0));
        editNoteButton.get(0).click();
    }

    public void changeNoteContent() {
    	
        noteTextInputArea.clear();
        
        noteTextInputArea.sendKeys("This is Edited");
    }

    public void makeNoteFavourite() {
    	
        ActionUtils.waitForElementToBeDisplayed(favouriteButton.get(0));
        favouriteButton.get(0).click();
    }

    public void deleteNote(){
    	
        ActionUtils.waitForElementToBeClickable(deleteButton.get(0));
        deleteButton.get(0).click();
        confirmDeletionButton.get(0).click();
    }

    public void checkNoteIsCreated() {
    	
        ActionUtils.waitForTextToBeDisplayed(noteText.get(0), "Test note Search&Delete");
        assertEquals(noteText.get(0).getText(), "Test note Search&Delete");
    }

    public void checkNoteIsEdited() {
    	
        ActionUtils.waitForTextToBeDisplayed(noteText.get(0), "This is Edited");
        assertEquals(noteText.get(0).getText(), "This is Edited");
    }

    public void checkNoteIsDisplayedAfterSearch(String text) {
    	
        ActionUtils.waitForTextToBeDisplayed(noteText.get(0), text);
        assertEquals(noteText.get(0).getText(), text);
    }

    public void checkNoteIsDeleted() throws InterruptedException {
    	
    	Thread.sleep(1000);
    	assertEquals(noteText.size(),0);
    	

    }
}
