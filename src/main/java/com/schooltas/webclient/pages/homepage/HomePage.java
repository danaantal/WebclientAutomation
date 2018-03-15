package com.schooltas.webclient.pages.homepage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.webclient.utils.ActionUtils;

public class HomePage {

    @FindBy(how = How.CSS, using = "#welcome-header .gear")
    WebElement showUserMenuButton;

    @FindBy(how = How.CSS, using = "#welcome-header .popout-right")
    WebElement listUserMenuOptions;

    @FindBy(how = How.CSS, using = "ol li:nth-of-type(2) .course")
    WebElement homepageCoursesListItem;

    @FindBy(id = "courses")
    WebElement homepageCoursesList;

    @FindBy(id = "user-name")
    WebElement userNameText;

    public void showUserMenu() {

        ActionUtils.waitForElementToBeDisplayed(showUserMenuButton);
        showUserMenuButton.click();
    }

    public void findUserMenuOptions(List<WebElement> children, String menuOptionName) {

        for (WebElement element : children) {
            if (element.getText().equals(menuOptionName)) {
                element.click();
                return;
            }
        }
    }

    public void clickUserMenuOption(String menuOptionName) {
        List<WebElement> children = listUserMenuOptions.findElements(By.xpath(".//*"));
        findUserMenuOptions(children, menuOptionName);
    }

    public void waitCoursesToLoad() {
        ActionUtils.waitForElementToBeClickable(homepageCoursesListItem);
    }

    public boolean findHomepageCoursesList(String courseName) {
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
