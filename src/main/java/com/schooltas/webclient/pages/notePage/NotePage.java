package com.schooltas.webclient.pages.notePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

<<<<<<< Updated upstream
import java.util.List;

=======
>>>>>>> Stashed changes
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.webclient.utils.ActionUtils;


public class NotePage {
<<<<<<< Updated upstream
		
	@FindBy(how = How.CSS, using = "textarea:nth-child(2)")
	WebElement noteTextInputArea;
		
	@FindBy(how = How.CLASS_NAME, using = "newTag")
	WebElement tagTextArea;
	
	@FindBy(how = How.CSS, using = "div.body")
	List<WebElement> noteText;
	
	@FindBy(how = How.CSS, using = ".editMode .createUpdateNote")
	WebElement saveButton;
	
	@FindBy(how = How.CSS, using = ".editMode .button-cancel")
	WebElement cancelButton;
	
	@FindBy(how = How.CSS, using = ".editMode [type='file']")
	WebElement addAttachmentButton;
	
	@FindBy(how = How.CSS, using = ".goto-prikker")
	List<WebElement> goToPinNoteButton;
	
	@FindBy(how = How.CSS, using = ".button-edit")
	List<WebElement> editNoteButton;
	
	@FindBy(how = How.CSS, using = ".button-delete")
	List<WebElement> deleteButton;
	
	@FindBy(how = How.CSS, using = ".popout-button-delete")
	List<WebElement> confirmDeletionButton;
	
	@FindBy(how = How.CSS, using = ".popout-button-cancel")
	List<WebElement> cancelDeletionButton;
	
	@FindBy(how = How.CSS, using = ".button-fav")
	List<WebElement> favouriteButton;
	
	
		
	public void addNoteContent(){
		ActionUtils.WaitForElementToBeDisplayed(noteTextInputArea);
		noteTextInputArea.sendKeys("TEST NOTE \n www.google.ro");
		tagTextArea.sendKeys("Test Tag");
		addAttachmentButton.sendKeys("E:\\book_new.jpg");
	}
	
	public void saveNote(){
		saveButton.click();
	}
		
	public void clickEditButton(){
		ActionUtils.WaitForElementToBeClickable(editNoteButton.get(0));
		editNoteButton.get(0).click();
	}
	
	public void changeNoteContent(){
		noteTextInputArea.clear();
		noteTextInputArea.sendKeys("This is Edited");
	}
	
	public void makeNoteFavourite(){
		ActionUtils.WaitForElementToBeClickable(favouriteButton.get(0));
		favouriteButton.get(0).click();
	}
	
	public void deleteNote(){
		ActionUtils.WaitForElementToBeClickable(deleteButton.get(0));
		deleteButton.get(0).click();
		confirmDeletionButton.get(0).click();
	}
	
	public void checkNoteIsCreated(){
		ActionUtils.WaitForTextToBeDisplayed(noteText.get(0),"TEST NOTE www.google.ro");
		assertEquals(noteText.get(0).getText(),"TEST NOTE www.google.ro");		
	}
	public void checkNoteIsEdited(){
		ActionUtils.WaitForTextToBeDisplayed(noteText.get(0),"This is Edited");
		assertEquals(noteText.get(0).getText(),"This is Edited");		
	}
	
	public void checkNoteIsDisplayedAfterSearch(String text){
		ActionUtils.WaitForTextToBeDisplayed(noteText.get(0),text);
		assertEquals(noteText.get(0).getText(),text);
	}
	
	public void checkNoteIsDeleted(){
		ActionUtils.WaitForElementToBeDisplayed(noteText.get(0));
		assertNotEquals(noteText.get(0).getText(),"This is Edited");
	}
=======

    @FindBy(how = How.XPATH, using = "//textarea[@class='body-textarea']")
    WebElement noteTextArea;

    @FindBy(how = How.CLASS_NAME, using = "newTag")
    WebElement tagTextArea;

    @FindBy(how = How.XPATH, using = "(//div[@class='body'])[1]")
    public WebElement noteText;

    @FindBy(how = How.XPATH, using = "(//div[@class='button green button-save createUpdateNote'])[1]")
    WebElement firstSaveButton;

    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'edit')])[1]")
    WebElement firstCancelButton;

    @FindBy(how = How.XPATH, using = "(//input[contains(@class,'attachment-file')])[1]")
    WebElement addAttachmentButton;

    @FindBy(how = How.XPATH, using = "(//div[@class='button goto-prikker'])[1]")
    WebElement goToPinNoteButton;

    @FindBy(how = How.XPATH, using = "(//div[@class='button button-edit'])[1]")
    WebElement editNoteButton;

    @FindBy(how = How.XPATH, using = "(//div[@class='button-delete'])[1]")
    WebElement deleteButton;

    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'popout-button-delete')])[1]")
    WebElement confirmDeletionButton;

    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'popout-button-cancel')])[1]")
    WebElement cancelDeletionButton;

    @FindBy(how = How.XPATH, using = "(//div[@class='button-fav'])[1]")
    WebElement favouriteButton;


    public void addNoteContent(){
        ActionUtils.WaitForElementToBeDisplayed(noteTextArea);
        noteTextArea.sendKeys("TEST NOTE \n www.google.ro");
        tagTextArea.sendKeys("Test Tag");
        addAttachmentButton.sendKeys("E:\\book_new.jpg");
    }

    public void saveNote(){
        firstSaveButton.click();
    }

    public void clickEditButton(){
        ActionUtils.WaitForElementToBeClickable(editNoteButton);
        editNoteButton.click();
    }

    public void changeNoteContent(){
        noteTextArea.clear();
        noteTextArea.sendKeys("This is Edited");
    }

    public void makeNoteFavourite(){
        ActionUtils.WaitForElementToBeClickable(favouriteButton);
        favouriteButton.click();
    }

    public void deleteNote(){
        ActionUtils.WaitForElementToBeClickable(deleteButton);
        deleteButton.click();
        confirmDeletionButton.click();
    }

    public void checkNoteIsCreated(){
        ActionUtils.WaitForTextToBeDisplayed(noteText,"TEST NOTE www.google.ro");
        assertEquals(noteText.getText(),"TEST NOTE www.google.ro");
    }
    public void checkNoteIsEdited(){
        ActionUtils.WaitForTextToBeDisplayed(noteText,"This is Edited");
        assertEquals(noteText.getText(),"This is Edited");
    }

    public void checkNoteIsDisplayedAfterSearch(String text){
        ActionUtils.WaitForTextToBeDisplayed(noteText,text);
        assertEquals(noteText.getText(),text);
    }

    public void checkNoteIsDeleted(){
        ActionUtils.WaitForElementToBeDisplayed(noteText);
        assertNotEquals(noteText.getText(),"This is Edited");
    }
>>>>>>> Stashed changes
}
