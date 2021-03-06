package com.schooltas.webclient.pages.books;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.schooltas.webclient.utils.ActionUtils;

public class MyBooksPage {

	// private final WebDriver driver;
	//
	// public MyBooksPage(WebDriver driver){
	// this.driver = driver;
	// }

	@FindBy(id = "books")
	private WebElement listOfBooks;

	@FindBy(how = How.CSS, using = "#book-list-filter [type]")
	private WebElement filterBooksInputField;

	@FindBy(id = "#books-edit-start")
	private WebElement editBooksListButton;

	@FindBy(id = "books-edit-end")
	private WebElement doneButton;

	@FindBy(how = How.CSS, using = ".book-hide")
	private List<WebElement> hideOrShowBookButton;

	@FindBy(how = How.CSS, using = ".book-download")
	private List<WebElement> downloadBookButton;

	@FindBy(how = How.CSS, using = ".book-stored")
	private List<WebElement> bookDownloadedLabel;

	private void findBooksList(List<WebElement> children, String bookName) {

		for (WebElement element : children) {
			if (element.getText().equals(bookName)) {
				element.click();
				return;
			}
		}
	}

	public void clickBook(String bookName) {

		List<WebElement> children = listOfBooks.findElements(By.xpath(".//*"));
		findBooksList(children, bookName);
	}

	public void searchBook(String searchTerm) {
		
		filterBooksInputField.clear();
		filterBooksInputField.sendKeys(searchTerm);
	}

	public void clearSearchField() {
		
		ActionUtils.waitForElementToBeDisplayed(filterBooksInputField);
		filterBooksInputField.clear();
	}

	public void downloadBook() {
		
		ActionUtils.waitForElementToBeDisplayed(downloadBookButton.get(0));
		downloadBookButton.get(0).click();
	}

	public void checkBookIsDownloaded() {
		
		ActionUtils.waitForElementToBeDisplayed(bookDownloadedLabel.get(0));
	}

}
