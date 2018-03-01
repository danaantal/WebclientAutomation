package com.schooltas.webclient.page.SettingsTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.webclient.page.Settings.MyAccountPage;
import com.schooltas.webclient.page.Settings.MyBundlesPage;
import com.schooltas.webclient.page.Settings.MySubscriptionsPage;
import com.schooltas.webclient.pages.homepage.HomePage;
import com.schooltas.webclient.tests.BaseTest;

public class SettingsTests extends BaseTest {
	
	@Test
	public void addLicense(){
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		MyBundlesPage myBundlePage = PageFactory.initElements(driver, MyBundlesPage.class);
				
		homePage.showUserMenu();
		homePage.clickUserMenuOption("my bundles");
		myBundlePage.addLicense("123abcd1");
		myBundlePage.closeWindow();
	}
	
	@Test
	public void addSubscription(){
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		MySubscriptionsPage mySubscriptionsPage = PageFactory.initElements(driver, MySubscriptionsPage.class);
		
		homePage.showUserMenu();
		homePage.clickUserMenuOption("my subscriptions");
		mySubscriptionsPage.addSubscription("121212");
		mySubscriptionsPage.closeWindow();
	}
	
	@Test
	public void changeAvatar(){
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
		
		homePage.showUserMenu();
		homePage.clickUserMenuOption("my account");
		myAccountPage.changeAvatar();
		myAccountPage.closeWindow();
	}
	
	@Test
	public void changeName(){
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
		
		homePage.showUserMenu();
		homePage.clickUserMenuOption("my account");
		myAccountPage.changeName("Dana", "DanaLast");
		myAccountPage.checkIfNameIsChanged("Dana", "DanaLast");
		myAccountPage.closeWindow();
	}
	
	@Test
	public void changePassword(){
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
		
		homePage.showUserMenu();
		homePage.clickUserMenuOption("my account");
		myAccountPage.changePassword("test23", "test23");
		myAccountPage.checkIfPasswordIsChanged();
		myAccountPage.closeWindow();
	}
}
