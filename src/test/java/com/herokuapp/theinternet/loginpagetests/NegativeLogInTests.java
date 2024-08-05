package com.herokuapp.theinternet.loginpagetests;

import java.util.Map;

import com.herokuapp.theinternet.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class NegativeLogInTests extends BaseTest {

	@DataProvider(name = "data")
	public Object [][] loginData () {
	return new Object[][] {{"2", "incorrectUsername", "SuperSecretPassword", "Your username is invalid!"},
			{"3", "tomsmith", "incorrectPassword", "Your password is invalid!"}};
	}

	
	@Test(priority = 1, dataProvider = "data")
	public void negativeLogInTest(String no, String username, String password, String expectedErrorMessage) {
		
		log.info("Starting negativeLogInTest #" + no);

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click on Form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

		// execute negative login
		loginPage.negativeLogIn(username, password);

		// wait for error message
		loginPage.waitForErrorMessage();
		String message = loginPage.getErrorMessageText();

		// Verification
		Assert.assertTrue(message.contains(expectedErrorMessage), "Message doesn't contain expected text.");
	}
}
