package com.schooltas.webclient.tests.noteTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.schooltas.webclient.pages.notePage.NotePage;
import com.schooltas.webclient.pages.notePage.NotebookPage;
import com.schooltas.webclient.tests.BaseTest;
import com.schooltas.webclient.utils.ActionUtils;

public class NoteTests extends BaseTest{

	public static NotebookPage notebookPage;
	public static NotePage notePage;
	
	@BeforeClass
	public static void initTemplates(){
		notebookPage = PageFactory.initElements(driver, NotebookPage.class);
		notePage = PageFactory.initElements(driver, NotePage.class);
	}
	
	
	@Test(priority = 1)
	public void createNewNote(){
		notebookPage.clickAddButton();
		
		notePage.addNoteContent();
		
		notePage.saveNote();
		
		notePage.checkNoteIsCreated();
		
	}
	
	@Test(priority = 2)
	public void createNoteInSubject(){
		//notebookPage.expandCollapseNotebook();
		
		notebookPage.expandSubjectList();
		notebookPage.clickSubjectsListItem("English");
		
		notebookPage.clickAddButton();
		
		notePage.addNoteContent();
		notePage.saveNote();
		notePage.checkNoteIsCreated();
	}
	
	@Test(priority = 3)
	public void editNote() throws InterruptedException{
		//notebookPage.expandCollapseNotebook();
		
		Thread.sleep(1000);
		
		notebookPage.expandSubjectList();
		notebookPage.clickSubjectsListItem("Everything");
		
		notebookPage.focusNote();
		notePage.clickEditButton();
		
		notePage.changeNoteContent();
		notePage.saveNote();
		notePage.checkNoteIsEdited();
	}
	
	@Test(priority = 4)
	public void makeNoteFavourite(){
		ActionUtils.waitForElementToBeDisplayed(notePage.noteText.get(0));
		notePage.makeNoteFavourite();	
	}
	
	@Test(priority = 5)
	public void searchAndDeleteNote() throws InterruptedException{
		//notebookPage.expandCollapseNotebook();
		
		notebookPage.searchNote("Delete");
		Thread.sleep(1000);
		notePage.checkNoteIsDisplayedAfterSearch("Test note Search&Delete");
		
		notebookPage.focusNote();
		notePage.deleteNote();
		notePage.checkNoteIsDeleted();
				
		notebookPage.clearSearchField();
		
		notebookPage.searchNote("This is Edited");
		Thread.sleep(1000);
		notePage.checkNoteIsDisplayedAfterSearch("This is Edited");

		//notebookPage.focusNote();
		notePage.deleteNote();
		notePage.checkNoteIsDeleted();
		
		notebookPage.clearSearchField();
	}
}
