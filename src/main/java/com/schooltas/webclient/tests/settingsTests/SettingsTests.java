package com.schooltas.webclient.tests.settingsTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.schooltas.webclient.pages.homepage.HomePage;
import com.schooltas.webclient.pages.settings.LanguagePage;
import com.schooltas.webclient.pages.settings.MyAccountPage;
import com.schooltas.webclient.pages.settings.MyBundlesPage;
import com.schooltas.webclient.pages.settings.MyCoursesPage;
import com.schooltas.webclient.pages.settings.MySubscriptionsPage;
import com.schooltas.webclient.tests.BaseTest;

public class SettingsTests extends BaseTest {

    private HomePage homepage;

    @BeforeClass
    public void init() {
        homepage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void addLicense() {

        MyBundlesPage myBundlePage = PageFactory.initElements(driver, MyBundlesPage.class);

        homepage.showUserMenu();
        homepage.clickUserMenuOption("my bundles");

        myBundlePage.addLicense("123abcd1");
        myBundlePage.closeWindow();
    }

    @Test
    public void addSubscription() {
        MySubscriptionsPage mySubscriptionsPage = PageFactory.initElements(driver, MySubscriptionsPage.class);

        homepage.showUserMenu();
        homepage.clickUserMenuOption("my subscriptions");

        mySubscriptionsPage.addSubscription("121212");
        mySubscriptionsPage.closeWindow();
    }

    @Test
    public void changeAvatar() {
        MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);

        homepage.showUserMenu();
        homepage.clickUserMenuOption("my account");

        myAccountPage.changeAvatar();
        myAccountPage.closeWindow();
    }

    @Test
    public void changeName() {
        MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);

        homepage.showUserMenu();

        homepage.clickUserMenuOption("my account");

        myAccountPage.changeName("Dana", "AutomationTest");

        myAccountPage.checkIfNameIsChanged("Dana", "AutomationTest");
        myAccountPage.closeWindow();
    }

    @Test
    public void changePassword() {

        MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);

        homepage.showUserMenu();

        homepage.clickUserMenuOption("my account");

        myAccountPage.changePassword("test23", "test23");
        myAccountPage.checkIfPasswordIsChanged();

        myAccountPage.closeWindow();
    }

    @Test
    public void hideCourse() {

        MyCoursesPage myCoursesPage = PageFactory.initElements(driver, MyCoursesPage.class);

        homepage.waitCoursesToLoad();
        homepage.showUserMenu();

        homepage.clickUserMenuOption("my courses");
        myCoursesPage.clickCourse("Academy");

        myCoursesPage.closeWindow();

        homepage.waitCoursesToLoad();
        homepage.checkIfTheCourseIsHidden("Academy");
    }

    @Test
    public void showCourse() {

        MyCoursesPage myCoursesPage = PageFactory.initElements(driver, MyCoursesPage.class);

        homepage.waitCoursesToLoad();
        homepage.showUserMenu();

        homepage.clickUserMenuOption("my courses");
        myCoursesPage.clickCourse("Academy");

        myCoursesPage.closeWindow();
        homepage.waitCoursesToLoad();
        homepage.checkIfTheCourseIsDisplayed("Academy");
    }

    @Test
    public void changeLanguage() {

        LanguagePage languagePage = PageFactory.initElements(driver, LanguagePage.class);

        homepage.showUserMenu();
        homepage.clickUserMenuOption("language");

        languagePage.expandLanguageList();
        languagePage.clickLanguage("Nederlands");
        languagePage.confirmLanguageChange();

        homepage.showUserMenu();
        homepage.clickUserMenuOption("taal");

        languagePage.expandLanguageList();
        languagePage.clickLanguage("English");
        languagePage.confirmLanguageChange();
    }
}
