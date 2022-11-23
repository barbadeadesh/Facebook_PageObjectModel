package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends Loginpage {

	@FindBy(xpath = "//span[text()='Adeshh Barbadee']")
	WebElement profilebtn;

	@FindBy(xpath = "//div[@aria-label='Update profile picture']")
	WebElement upldbtn;

	@FindBy(xpath = "//div[@aria-label='Upload Photo']")
	WebElement uploadphotobtn;

	@FindBy(xpath = "//div[@aria-label='Save']")
	WebElement savebtn;

	@FindBy(xpath = "//div[@aria-label='Like']")
	WebElement likebtn;

	@FindBy(xpath = "//a[@aria-label='Home']")
	WebElement homebtn;
	
	@FindBy(xpath = "(//div[@aria-label='Write a comment'])[1]")
	WebElement commentbox;

	/**
	 * Method: To Upload profile image of user in facebook
	 */
	public void uploadUserProfileImage() {
		try {

			wait.until(ExpectedConditions.visibilityOfAllElements(profilebtn));
			wait.until(ExpectedConditions.elementToBeClickable(profilebtn));
			profilebtn.click();
			wait.until(ExpectedConditions.visibilityOfAllElements(upldbtn));
			upldbtn.click();
			wait.until(ExpectedConditions.visibilityOfAllElements(uploadphotobtn));

			uploadphotobtn.click();

			Runtime.getRuntime().exec(".\\src\\main\\resources\\Repository\\xyz.exe");
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfAllElements(savebtn));
			savebtn.click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(homebtn));
			homebtn.click();

			wait.until(ExpectedConditions.elementToBeClickable(profilebtn));
			profilebtn.click();
			Thread.sleep(2000);
			driver.navigate().refresh();

			JavascriptExecutor js = (JavascriptExecutor) driver; // for scrollup and down we use javascript executer
																	// interface method
			js.executeScript("window.scrollBy(0, 800)");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void userHomePageLikePost() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfAllElements(profilebtn));
		profilebtn.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfAllElements(likebtn));
		Thread.sleep(2000);
		likebtn.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfAllElements(homebtn));
		Thread.sleep(2000);
		homebtn.click();
		Thread.sleep(2000);
	}

	public void comment() throws Exception {

		wait.until(ExpectedConditions.visibilityOfAllElements(homebtn));
		homebtn.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(profilebtn));
		wait.until(ExpectedConditions.elementToBeClickable(profilebtn));

		profilebtn.click();

		int x = commentbox.getLocation().getX();
		int y = commentbox.getLocation().getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + ", " + y + ")");
		wait.until(ExpectedConditions.elementToBeClickable(commentbox));
		commentbox.sendKeys("MSD");

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
}
