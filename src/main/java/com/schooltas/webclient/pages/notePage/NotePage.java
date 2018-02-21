package com.schooltas.webclient.pages.notePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class NotePage extends NotebookPage{
	
	public NotePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.XPATH, using = "//textarea[@class='body-textarea']")
	WebElement noteTextArea;
		
	@FindBy(how = How.CLASS_NAME, using = "newTag")
	WebElement tagTextArea;
	
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
	
	@FindBy(how = How.XPATH, using = "(//div[@class='body'])[1]")
	WebElement noteText;
		
	public void addNoteContent(){
		WaitForElementToBeDisplayed(noteTextArea);
		noteTextArea.sendKeys("TEST NOTE \n www.google.ro");
		tagTextArea.sendKeys("Test Tag");
		addAttachmentButton.sendKeys("E:/DOWNLOADS/book_new.jpg");
	}
	
	public void saveNote(){
		firstSaveButton.click();
	}
		
	public void clickEditButton(){
		WaitForElementToBeClickable(editNoteButton);
		editNoteButton.click();
	}
	
	public void changeNoteContent(){
		noteTextArea.clear();
		noteTextArea.sendKeys("This is Edited");
	}
	
	public void deleteNote(){
		WaitForElementToBeClickable(deleteButton);
		deleteButton.click();
		confirmDeletionButton.click();
	}
	
	public void checkNoteIsCreated(){
		WaitForTextToBeDisplayed(noteText,"TEST NOTE www.google.ro");
		assertEquals(noteText.getText(),"TEST NOTE www.google.ro");		
	}
	public void checkNoteIsEdited(){
		WaitForTextToBeDisplayed(noteText,"This is Edited");
		assertEquals(noteText.getText(),"This is Edited");		
	}
	
	public void checkNoteIsDeleted(){
		WaitForElementToBeDisplayed(noteText);
		assertNotEquals(noteText.getText(),"This is Edited");
	}
	
}
