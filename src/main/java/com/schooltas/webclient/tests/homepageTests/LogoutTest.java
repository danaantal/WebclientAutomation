package com.schooltas.webclient.tests.homepageTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.webclient.pages.homepage.Homepage;
import com.schooltas.webclient.tests.BaseTest;

public class LogoutTest extends BaseTest {
	
	@Test
	public void logout(){
		Homepage homepage = PageFactory.initElements(driver, Homepage.class);
		
		homepage.showUserMenu();
		homepage.clickUserMenuOption("logout");
	}
}
