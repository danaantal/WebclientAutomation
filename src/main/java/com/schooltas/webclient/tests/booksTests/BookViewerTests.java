package com.schooltas.webclient.tests.booksTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.schooltas.webclient.pages.books.BookViewerPage;
import com.schooltas.webclient.pages.books.MyBooksPage;
import com.schooltas.webclient.pages.homepage.Homepage;
import com.schooltas.webclient.tests.BaseTest;

public class BookViewerTests extends BaseTest {
	
	private static Homepage homepage;
	private static MyBooksPage myBooksPage;
	private static BookViewerPage bookViewerPage;
	
	@BeforeClass
	public static void initTemplates() {
		homepage = PageFactory.initElements(driver, Homepage.class);
		myBooksPage = PageFactory.initElements(driver, MyBooksPage.class);
		bookViewerPage = PageFactory.initElements(driver, BookViewerPage.class);
    }
	
	@Test
	public void openBookViewer(){
						
		homepage.waitCoursesToLoad();
		homepage.clickHomepageCourseItem("English");
		myBooksPage.clickBook("Driving Technical Change 2");
		bookViewerPage.checkBookViewerIsLoaded();
		bookViewerPage.goToMyBooksList();
	}
	
	@Test
	public void addWordweb(){
		
		homepage.waitCoursesToLoad();
		homepage.clickHomepageCourseItem("English");
		myBooksPage.clickBook("Test book TOC #1");
		bookViewerPage.checkBookViewerIsLoaded();
		bookViewerPage.rightClick();
		bookViewerPage.addWordweb();
	}
}
