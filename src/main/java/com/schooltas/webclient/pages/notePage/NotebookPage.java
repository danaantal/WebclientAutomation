package com.schooltas.webclient.pages.notePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotebookPage {
	
	private static WebDriver driver;

	public NotebookPage(WebDriver driver) {
		
		NotebookPage.driver = driver;
	}
	
	@FindBy(how = How.CLASS_NAME, using = "button-toggle-schrift")
	WebElement expandCollapseButton;
	
	@FindBy(how = How.CSS, using = "#button-new")
	WebElement addButton;
		
	@FindBy(id="filter")
	WebElement searchTextField;
	
	@FindBy(how = How.XPATH, using = "//div[@id='schrift-course']")
	WebElement expandSubjectsListButton;
	
	@FindBy(how = How.XPATH, using = "(//div[@class='viewport'])")
	WebElement subjectsList;
			
	@FindBy(id="button-toggle-favorites")
	WebElement favouritesButton;
	
	@FindBy(how=How.XPATH, using = "(//div[contains(@class,'note existing')])[1]")
	WebElement noteArea;
	
	public void clickAddButton() {
		
		NotePage notePage = PageFactory.initElements(driver, NotePage.class);
		
		notePage.WaitForElementToBeDisplayed(noteArea);
		addButton.click(); 
	}
	
	public void expandCollapseNotebook(){
		
		WaitForElementToBeDisplayed(noteArea);
		expandCollapseButton.click();
	}
	
	public void focusNote(){
		
		WaitForElementToBeClickable(noteArea);
		noteArea.click();
	}
	
	public void searchNote(){
		
		WaitForElementToBeDisplayed(noteArea);
		searchTextField.sendKeys("google");
		WaitForElementToBeDisplayed(noteArea);
	}
	
	public void clearSearchField(){
		
		searchTextField.clear();
	}
	public void expandSubjectList(){
		
		WaitForElementToBeClickable(expandSubjectsListButton);
		expandSubjectsListButton.click();
	}
		
	public void clickSubjectsListItem(String subjectName){
		
		List<WebElement> children = subjectsList.findElements(By.xpath(".//*"));
		findSubjectsListItem(children, subjectName);
	}
	
	public void findSubjectsListItem(List<WebElement> children, String subjectName){
		
		for(WebElement element : children){
			if(element.getText().equals(subjectName)){
				element.click();
			}
		}
	}
	
	public void WaitForElementToBeDisplayed(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void WaitForTextToBeDisplayed(WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public void WaitForElementToBeClickable(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}
