package com.schooltas.webclient.pages.homePageTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.webclient.pages.homepage.HomePage;
import com.schooltas.webclient.tests.BaseTest;

public class LogoutTest extends BaseTest {
	
	@Test
	public void logout(){
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		homePage.showUserMenu();
		homePage.clickUserMenuOption("logout");
	}
}
