package com.schooltas.webclient.pages.notePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.webclient.utils.ActionUtils;

public class NotebookPage {

	@FindBy(how = How.CSS, using = ".button-toggle-schrift")
	WebElement expandCollapseButton;
	
	@FindBy(how = How.CSS, using = "#button-new")
	WebElement addButton;
		
	@FindBy(id="filter")
	WebElement searchTextField;
	
	@FindBy(id="schrift-course")
	WebElement expandSubjectsListButton;
	
	@FindBy(how = How.CSS, using = ".viewport")
	WebElement subjectsList;
			
	@FindBy(id="button-toggle-favorites")
	WebElement favouritesFilter;
	
	@FindBy(how=How.CSS, using = ".existingNote")
	WebElement noteArea;
	
	public void clickAddButton() {
				
		ActionUtils.WaitForElementToBeDisplayed(noteArea);
		addButton.click(); 
	}
	public void expandCollapseNotebook(){
		
		ActionUtils.WaitForElementToBeDisplayed(noteArea);
		expandCollapseButton.click();
	}
	
	public void focusNote(){
		
		ActionUtils.WaitForElementToBeClickable(noteArea);
		noteArea.click();
	}
	
	public void searchNote(String text){		
		
		ActionUtils.WaitForElementToBeDisplayed(noteArea);
		searchTextField.sendKeys(text);
		ActionUtils.WaitForElementToBeDisplayed(noteArea);
	}
	
	public void clearSearchField(){
		
		searchTextField.clear();
	}
	
	public void expandSubjectList(){
		
		ActionUtils.WaitForElementToBeClickable(expandSubjectsListButton);
		expandSubjectsListButton.click();
	}
	
	public void findSubjectsListItem(List<WebElement> children, String subjectName){
		
		for(WebElement element : children){
			if(element.getText().equals(subjectName)){
				element.click();
				return;
			}
		}
	}
	
	public void clickSubjectsListItem(String subjectName){
		
		List<WebElement> children = subjectsList.findElements(By.xpath(".//*"));
		findSubjectsListItem(children, subjectName);
	}
	
}
