package com.schooltas.webclient.pages.notePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.Keys;

import com.schooltas.webclient.utils.ActionUtils;

public class NotebookPage {

    @FindBy(how = How.CSS, using = ".button-toggle-schrift")
    private WebElement expandCollapseButton;

    @FindBy(how = How.CSS, using = "#button-new")
    private WebElement addButton;

    @FindBy(id = "filter")
    private WebElement searchTextField;

    @FindBy(id = "schrift-course")
    private WebElement expandSubjectsListButton;

    @FindBy(how = How.CSS, using = ".viewport")
    private WebElement subjectsList;

    @FindBy(id = "button-toggle-favorites")
    private WebElement favouritesFilter;

    @FindBy(how = How.CSS, using = ".existingNote")
    private WebElement noteArea;

    public void clickAddButton() {

        ActionUtils.waitForElementToBeDisplayed(noteArea);
        addButton.click();
    }

    public void expandCollapseNotebook() {

        ActionUtils.waitForElementToBeDisplayed(noteArea);
        expandCollapseButton.click();
    }

    public void focusNote() {

        ActionUtils.waitForElementToBeClickable(noteArea);
        noteArea.click();
    }

    public void searchNote(String text) {

        ActionUtils.waitForElementToBeDisplayed(noteArea);
        
        searchTextField.sendKeys(text);
        
        ActionUtils.waitForElementToBeClickable(noteArea);
    }

    public void clearSearchField() {
    	
    	searchTextField.click();
    	searchTextField.sendKeys(Keys.chord(Keys.CONTROL,"a"));
    	searchTextField.sendKeys(Keys.DELETE);
    }

    public void expandSubjectList() {

        ActionUtils.waitForElementToBeClickable(expandSubjectsListButton);
        expandSubjectsListButton.click();
    }

    private  void findSubjectsListItem(List<WebElement> children, String subjectName) {

        for (WebElement element : children) {
            if (element.getText().equals(subjectName)) {
                element.click();
                return;
            }
        }
    }

    public void clickSubjectsListItem(String subjectName) {

        List<WebElement> children = subjectsList.findElements(By.xpath(".//*"));
        
        findSubjectsListItem(children, subjectName);
    }

}
