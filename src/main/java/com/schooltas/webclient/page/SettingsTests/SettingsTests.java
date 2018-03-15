package com.schooltas.webclient.page.SettingsTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.schooltas.webclient.page.Settings.LanguagePage;
import com.schooltas.webclient.page.Settings.MyAccountPage;
import com.schooltas.webclient.page.Settings.MyBundlesPage;
import com.schooltas.webclient.page.Settings.MyCoursesPage;
import com.schooltas.webclient.page.Settings.MySubscriptionsPage;
import com.schooltas.webclient.pages.homepage.HomePage;
import com.schooltas.webclient.tests.BaseTest;

public class SettingsTests extends BaseTest {

    public HomePage homePage;

    @BeforeClass
    public void init() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void addLicense() {

        MyBundlesPage myBundlePage = PageFactory.initElements(driver, MyBundlesPage.class);

        homePage.showUserMenu();
        homePage.clickUserMenuOption("my bundles");

        myBundlePage.addLicense("123abcd1");

        myBundlePage.closeWindow();
    }

    @Test
    public void addSubscription() {

        MySubscriptionsPage mySubscriptionsPage = PageFactory.initElements(driver, MySubscriptionsPage.class);

        homePage.showUserMenu();
        homePage.clickUserMenuOption("my subscriptions");

        mySubscriptionsPage.addSubscription("121212");

        mySubscriptionsPage.closeWindow();
    }

    @Test
    public void changeAvatar() {

        MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);

        homePage.showUserMenu();
        homePage.clickUserMenuOption("my account");

        myAccountPage.changeAvatar();
        myAccountPage.closeWindow();
    }

    @Test
    public void changeName() {

        MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);

        homePage.showUserMenu();
        homePage.clickUserMenuOption("my account");

        myAccountPage.changeName("Dana", "DanaLast");

        myAccountPage.checkIfNameIsChanged("Dana", "DanaLast");
        myAccountPage.closeWindow();
    }

    @Test
    public void changePassword() {

        MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);

        homePage.showUserMenu();
        homePage.clickUserMenuOption("my account");

        myAccountPage.changePassword("test23", "test23");

        myAccountPage.checkIfPasswordIsChanged();
        myAccountPage.closeWindow();
    }

    @Test
    public void hideCourse() {

        MyCoursesPage myCoursesPage = PageFactory.initElements(driver, MyCoursesPage.class);

        myCoursesPage.waitCoursesToLoad();

        homePage.showUserMenu();

        homePage.clickUserMenuOption("my courses");
        myCoursesPage.clickCourse("Academy");
        myCoursesPage.closeWindow();

        myCoursesPage.waitCoursesToLoad();
        myCoursesPage.checkIfTheCourseIsHidden("Academy");
    }

    @Test
    public void showCourse() {

        MyCoursesPage myCoursesPage = PageFactory.initElements(driver, MyCoursesPage.class);

        myCoursesPage.waitCoursesToLoad();

        homePage.showUserMenu();

        homePage.clickUserMenuOption("my courses");

        myCoursesPage.clickCourse("Academy");
        myCoursesPage.closeWindow();

        myCoursesPage.waitCoursesToLoad();
        myCoursesPage.checkIfTheCourseIsDisplayed("Academy");
    }

    @Test
    public void changeLanguage() {

        LanguagePage languagePage = PageFactory.initElements(driver, LanguagePage.class);

        homePage.showUserMenu();
        homePage.clickUserMenuOption("language");

        languagePage.expandLanguageList();

        languagePage.clickLanguage("Nederlands");
        languagePage.confirmLanguageChange();

        homePage.showUserMenu();
        homePage.clickUserMenuOption("taal");

        languagePage.expandLanguageList();
        languagePage.clickLanguage("English");
        languagePage.confirmLanguageChange();
    }
}
