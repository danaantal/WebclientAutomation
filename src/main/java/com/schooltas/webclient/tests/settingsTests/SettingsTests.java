package com.schooltas.webclient.tests.settingsTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.webclient.pages.homepage.Homepage;
import com.schooltas.webclient.pages.settings.LanguagePage;
import com.schooltas.webclient.pages.settings.MyAccountPage;
import com.schooltas.webclient.pages.settings.MyBundlesPage;
import com.schooltas.webclient.pages.settings.MyCoursesPage;
import com.schooltas.webclient.pages.settings.MySubscriptionsPage;
import com.schooltas.webclient.tests.BaseTest;


public class SettingsTests extends BaseTest {
	
	@Test
	public void addLicense(){
		Homepage homepage = PageFactory.initElements(driver, Homepage.class);
		MyBundlesPage myBundlePage = PageFactory.initElements(driver, MyBundlesPage.class);
				
		homepage.showUserMenu();
		homepage.clickUserMenuOption("my bundles");
		myBundlePage.addLicense("123abcd1");
		myBundlePage.closeWindow();
	}
	
	@Test
	public void addSubscription(){
		Homepage homepage = PageFactory.initElements(driver, Homepage.class);
		MySubscriptionsPage mySubscriptionsPage = PageFactory.initElements(driver, MySubscriptionsPage.class);
		
		homepage.showUserMenu();
		homepage.clickUserMenuOption("my subscriptions");
		mySubscriptionsPage.addSubscription("121212");
		mySubscriptionsPage.closeWindow();
	}
	
	@Test
	public void changeAvatar(){
		Homepage homepage = PageFactory.initElements(driver, Homepage.class);
		MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
		
		homepage.showUserMenu();
		homepage.clickUserMenuOption("my account");
		myAccountPage.changeAvatar();
		myAccountPage.closeWindow();
	}
	
	@Test
	public void changeName(){
		Homepage homepage = PageFactory.initElements(driver, Homepage.class);
		MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
		
		homepage.showUserMenu();
		homepage.clickUserMenuOption("my account");
		myAccountPage.changeName("Dana", "AutomationTest");
		myAccountPage.checkIfNameIsChanged("Dana", "AutomationTest");
		myAccountPage.closeWindow();
	}
	
	@Test
	public void changePassword(){
		Homepage homepage = PageFactory.initElements(driver, Homepage.class);
		MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
		
		homepage.showUserMenu();
		homepage.clickUserMenuOption("my account");
		myAccountPage.changePassword("test23", "test23");
		myAccountPage.checkIfPasswordIsChanged();
		myAccountPage.closeWindow();
	}
	
	@Test
	public void hideCourse(){
		Homepage homepage = PageFactory.initElements(driver, Homepage.class);
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
	public void showCourse(){
		Homepage homepage = PageFactory.initElements(driver, Homepage.class);
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
	public void changeLanguage(){
		Homepage homepage = PageFactory.initElements(driver, Homepage.class);
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
