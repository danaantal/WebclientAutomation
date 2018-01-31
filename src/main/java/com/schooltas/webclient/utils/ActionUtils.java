package com.schooltas.webclient.utils;

import org.openqa.selenium.support.PageFactory;

import com.schooltas.webclient.pages.loginpage.LoginPage;
import com.schooltas.webclient.tests.BaseTest;


public class ActionUtils extends BaseTest{
	public static void loginAs(String organization) {

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		if (organization == "publisher") {
			loginPage.login(TEST_PUBLISHER_EMAIL, TEST_PUBLISHER_PASS);
		} else if (organization == "distributor") {
			loginPage.login(TEST_DISTRIBUTOR_EMAIL, TEST_DISTRIBUTOR_PASS);
		} else if (organization == "school") {
			loginPage.login(TEST_SCHOOL_EMAIL, TEST_SCHOOL_PASS);
		}
	}

}
