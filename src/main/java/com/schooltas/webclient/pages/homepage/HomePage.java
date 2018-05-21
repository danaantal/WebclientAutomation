package com.schooltas.webclient.pages.homepage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.schooltas.webclient.pages.notePage.NotebookPage;
import com.schooltas.webclient.utils.ActionUtils;

public class HomePage {

	private static WebDriver driver;

    public HomePage(WebDriver driver) {

        HomePage.driver = driver;
    }
	
    @FindBy(how = How.CSS, using = "#welcome-header .gear")
    private WebElement showUserMenuButton;

    @FindBy(how = How.CSS, using = "#welcome-header .popout-right")
    private WebElement listUserMenuOptions;

    @FindBy(how = How.CSS, using = "ol li:nth-of-type(3) .course")
    private WebElement homepageCoursesListItem;

    @FindBy(id = "courses")
    private WebElement homepageCoursesList;

    @FindBy(id = "user-name")
    private WebElement userNameText;
    
    @FindBy(id = "schooltas-van")
    private WebElement goToHomepage;
    
    @FindBy(how = How.XPATH, using= "//html[contains(@class,'expanded')]")
    private WebElement notebookExpanded;

	public void showUserMenu() {

		try {
			if (notebookExpanded.isEnabled()) {

				NotebookPage notebookPage = PageFactory.initElements(driver, NotebookPage.class);

				notebookPage.expandCollapseNotebook();

				ActionUtils.waitForElementToBeClickable(showUserMenuButton);
				showUserMenuButton.click();
			}
		} catch (Exception e) {
			ActionUtils.waitForElementToBeClickable(showUserMenuButton);
			showUserMenuButton.click();
		}
	}

    private void findUserMenuOptions(List<WebElement> children, String menuOptionName) {

        for (WebElement element : children) {
            if (element.getText().equals(menuOptionName)) {
                element.click();
                return;
            }
        }
    }
    
    public void goToHomepage(){
    	
    	ActionUtils.waitForElementToBeClickable(goToHomepage);
    	goToHomepage.click();
    }

    public void clickUserMenuOption(String menuOptionName) {
    	
        List<WebElement> children = listUserMenuOptions.findElements(By.xpath(".//*"));
        findUserMenuOptions(children, menuOptionName);
    }

    public void waitCoursesToLoad() {
    	
        ActionUtils.waitForElementToBeClickable(homepageCoursesListItem);
        
    }

    private boolean findHomepageCoursesList(String courseName) {
    	
        List<WebElement> courses = homepageCoursesList.findElements(By.xpath(".//*"));
        
        for (WebElement element : courses) {
            if (element.getText().equals(courseName)) {
                return true;
            }
        }
        return false;
    }

    public void clickHomepageCourseItem(String courseName) {
    	
        List<WebElement> courses = homepageCoursesList.findElements(By.xpath(".//*"));
        
        for (WebElement element : courses) {
            if (element.getText().equals(courseName)) {
                element.click();
                return;
            }
        }
    }

    public void checkIfTheCourseIsHidden(String courseName) {
    	
        assertFalse(findHomepageCoursesList(courseName));
    }

    public void checkIfTheCourseIsDisplayed(String courseName) {
    	
        assertTrue(findHomepageCoursesList(courseName));
    }
}
