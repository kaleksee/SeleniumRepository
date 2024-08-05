package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage extends BasePageObject {

	private String pageUrl = "http://the-internet.herokuapp.com/upload";

	private By choseFileFieldLocator = By.id("file-upload");
	private By uploadButtonLocator = By.id("file-submit");
	private By uploadedFilesLocator = By.id("uploaded-files");

	public FileUploaderPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Open FileUploaderPage with it's url */
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}

	/** Push Upload button */
	public void pushUploadButton() {
		log.info("Clicking on upload button");
		click(uploadButtonLocator);
	}

	/** Push Upload button */
	public void selectFile(String filePath) {
		log.info("Selecting '" + filePath + "'");
		type(filePath, choseFileFieldLocator);
		log.info("File selected");
	}

	/** Get names of uploaded files */
	public String getUploadedFilesNames() {
		String names = find(uploadedFilesLocator).getText();
		log.info("Uploaded files: " + names);
		return names;
	}

}