package com.schooltas.webclient.tests.noteTests;



import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.schooltas.webclient.pages.notePage.NotePage;
import com.schooltas.webclient.pages.notePage.NotebookPage;
import com.schooltas.webclient.tests.BaseTest;

public class NoteTests extends BaseTest{

	@Test(priority = 1)
	public void createNewNote(){
		NotebookPage notebookPage = PageFactory.initElements(driver, NotebookPage.class);
		NotePage notePage = PageFactory.initElements(driver, NotePage.class);

		notebookPage.clickAddButton();
		notePage.addNoteContent();
		notePage.saveNote();
		notePage.checkNoteIsCreated();
		
	}
	
	@Test(priority = 2)
	public void createNoteInSubject(){
		NotebookPage notebookPage = PageFactory.initElements(driver, NotebookPage.class);
		NotePage notePage = PageFactory.initElements(driver, NotePage.class);
		
		notebookPage.expandCollapseNotebook();
		notebookPage.expandSubjectList();
		notebookPage.clickSubjectsListItem("English");
		notebookPage.clickAddButton();
		notePage.addNoteContent();
		notePage.saveNote();
		notePage.checkNoteIsCreated();
	}
	
	@Test(priority = 3)
	public void editNote(){
		NotebookPage notebookPage = PageFactory.initElements(driver, NotebookPage.class);
		NotePage notePage = PageFactory.initElements(driver, NotePage.class);
		
		notebookPage.expandCollapseNotebook();
		notebookPage.focusNote();
		notePage.clickEditButton();
		notePage.changeNoteContent();
		notePage.saveNote();
		notePage.checkNoteIsEdited();
	}
	
	@Test(priority = 4)
	public void searchNote(){
		NotebookPage notebookPage = PageFactory.initElements(driver, NotebookPage.class);
		NotePage notePage = PageFactory.initElements(driver, NotePage.class);
		
		notebookPage.expandCollapseNotebook();
		notebookPage.clearSearchField();
		notebookPage.searchNote("google.ro");
		//notebookPage.focusNote();
		notePage.checkNoteIsDisplayedAfterSearch("TEST NOTE\nGoogle");
		notebookPage.clearSearchField();
		notebookPage.searchNote("This is Edited");
		//notebookPage.focusNote();
		notePage.checkNoteIsDisplayedAfterSearch("This is Edited");			
	}
	
	@Test(priority = 5)
	public void makeNoteFavourite(){
		NotebookPage notebookPage = PageFactory.initElements(driver, NotebookPage.class);
		NotePage notePage = PageFactory.initElements(driver, NotePage.class);
		
		notebookPage.expandCollapseNotebook();
		notebookPage.focusNote();
		notePage.makeNoteFavourite();		
	}
	
	@Test(priority = 6,invocationCount = 2)
	public void deleteNote(){
		NotebookPage notebookPage = PageFactory.initElements(driver, NotebookPage.class);
		NotePage notePage = PageFactory.initElements(driver, NotePage.class);
		
		notebookPage.expandCollapseNotebook();
		notebookPage.focusNote();
		notePage.deleteNote();
		notebookPage.clearSearchField();
		notePage.checkNoteIsDeleted();
	}
}
