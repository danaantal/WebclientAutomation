package com.schooltas.webclient.tests.booksTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.schooltas.webclient.pages.books.MyBooksPage;
import com.schooltas.webclient.pages.homepage.HomePage;
import com.schooltas.webclient.tests.BaseTest;

public class MyBooksTests extends BaseTest {

    @Test
    public void searchAndDownloadBook() throws InterruptedException {
        HomePage homepage = PageFactory.initElements(driver, HomePage.class);
        MyBooksPage myBooksPage = PageFactory.initElements(driver, MyBooksPage.class);

        homepage.waitCoursesToLoad();
        homepage.clickHomepageCourseItem("English");
        myBooksPage.searchBook("toc"); // need to find a way to refresh list download buttons
        myBooksPage.downloadBook();
        homepage.clickHomepageCourseItem("English");
        myBooksPage.checkBookIsDownloaded();
        myBooksPage.clearSearchField();
    }
}
