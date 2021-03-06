package com.schooltas.webclient.tests.booksTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.schooltas.webclient.pages.books.BookViewerPage;
import com.schooltas.webclient.pages.books.MyBooksPage;
import com.schooltas.webclient.pages.homepage.HomePage;
import com.schooltas.webclient.tests.BaseTest;

public class BookViewerTests extends BaseTest {

    private static HomePage homepage;
    private static MyBooksPage myBooksPage;
    private static BookViewerPage bookViewerPage;

    @BeforeClass
    public static void initTemplates() {
        homepage = PageFactory.initElements(driver, HomePage.class);
        myBooksPage = PageFactory.initElements(driver, MyBooksPage.class);
        bookViewerPage = PageFactory.initElements(driver, BookViewerPage.class);
    }

    @Test(priority = 1)
    public void addDeleteWordweb(){

        homepage.waitCoursesToLoad();
        
        homepage.clickHomepageCourseItem("English");
        
        myBooksPage.clickBook("Test book TOC #1");
        
        bookViewerPage.checkBookViewerIsLoaded();
        bookViewerPage.rightClick();
        bookViewerPage.addWordweb();
        
        bookViewerPage.deleteWordweb();

    }
    
    @Test(priority = 2)
    public void addDeletePinOnBook(){
    	
    	bookViewerPage.goToMyBooksList();
    	
    	homepage.waitCoursesToLoad();
        
        homepage.clickHomepageCourseItem("English");
    	myBooksPage.clickBook("Test book TOC #1");
        
        bookViewerPage.checkBookViewerIsLoaded();
        bookViewerPage.rightClick();
        bookViewerPage.addNotePin();
        
        bookViewerPage.deleteNotePin();
        
        bookViewerPage.goToMyBooksList();
    }
}
