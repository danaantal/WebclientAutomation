package com.schooltas.webclient.pages.settings;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.webclient.utils.ActionUtils;

public class MyCoursesPage {
    // please add access modifiers for all the declared webelements in all the classes

    @FindBy(how = How.CSS, using = "#popover-screen-mysubjects [type]")
    WebElement doneButton;

    @FindBy(how = How.CSS, using = ".courses-list")
    WebElement coursesList;

    // if you have methods that are used only inside the class make them private
    // change this in all the classes you have

    public void findCoursesList(List<WebElement> children, String courseName) {

        for (WebElement element : children) {
            if (element.getText().equals(courseName)) {
                element.click();
                return;
            }
        }
    }

    public void clickCourse(String courseName) {
        ActionUtils.WaitForElementToBeClickable(coursesList);
        List<WebElement> children = coursesList.findElements(By.xpath(".//*"));
        findCoursesList(children, courseName);
    }

    public void closeWindow() {
        ActionUtils.WaitForElementToBeClickable(doneButton);
        doneButton.click();
    }

}
