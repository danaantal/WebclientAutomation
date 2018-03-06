package com.schooltas.webclient.page.Settings;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.schooltas.webclient.utils.ActionUtils;

public class MyCoursesPage {
	
	@FindBy(how = How.CSS, using = "ol li:nth-of-type(2) .course")
	WebElement homepageCoursesListItem;
	
	@FindBy(id="courses")
	WebElement homepageCoursesList;
	
	@FindBy(how = How.CSS, using = "#popover-screen-mysubjects [type]")
	WebElement doneButton;
	
	@FindBy(how = How.CSS, using = ".courses-list")
	WebElement coursesList;
	
	public void findCoursesList(List<WebElement> children, String courseName){
		
		for(WebElement element : children){
			if(element.getText().equals(courseName)){
				element.click();
				return;
			}
		}
	}
	
	public void clickCourse(String courseName){
		ActionUtils.WaitForElementToBeClickable(coursesList);
		List<WebElement> children = coursesList.findElements(By.xpath(".//*"));
		findCoursesList(children, courseName);
	}
	
	public void closeWindow(){
		ActionUtils.WaitForElementToBeClickable(doneButton);
		doneButton.click();
	}
	
	public void waitCoursesToLoad(){
		ActionUtils.WaitForElementToBeClickable(homepageCoursesListItem);
	}
	
	public boolean findHomepageCoursesList(String courseName){
		List<WebElement> courses = homepageCoursesList.findElements(By.xpath(".//*"));
		for(WebElement element : courses){
			if(element.getText().equals(courseName)){
				return true;
			}			
		}
		return false;
	}
	
	public void checkIfTheCourseIsHidden(String courseName){
		assertFalse(findHomepageCoursesList(courseName));
	}
	
	public void checkIfTheCourseIsDisplayed(String courseName){
		assertTrue(findHomepageCoursesList(courseName));
	}
}
