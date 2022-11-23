package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;

public class FindFriendPage extends Loginpage {

	// find the webelement by using @findBy Annotation
	@FindBy(xpath = "//span[text()='Find friends']")
	WebElement findfriedbtn;
	@FindBy(xpath = "//span[text()='Suggestions']")
	WebElement suggestionsbtn;

	/**
	 * Method: To Find Friend in facebook
	 */
	public void userFindFriend() {
		/*
		 * Here we use try-catch statements to handle unwanted errors during the
		 * execution of a program.
		 * 
		 */

		/*
		 * The try statement allows you to define a block of code to be tested
		 */
		try {
		
			wait.until(ExpectedConditions.visibilityOfAllElements(findfriedbtn));
			findfriedbtn.click();
			wait.until(ExpectedConditions.visibilityOfAllElements(suggestionsbtn));
			suggestionsbtn.click();

			/*
			 * The catch statement allows you to define a block of code to be executed, if
			 * an error occurs in the try block.
			 */

			/*
			 * 1- e is a reference to the instance of the Exception. 2-The printStackTrace()
			 * is used to handle exceptions and errors.
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
