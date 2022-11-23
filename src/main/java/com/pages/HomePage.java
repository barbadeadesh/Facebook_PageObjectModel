package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Loginpage {

	@FindBy(xpath = "//span[contains(text(),'Photo/video')]")
	WebElement photovideobtn;

	@FindBy(xpath = " //span[contains(text(),'Add photos/videos')]")
	WebElement addbtn;

	@FindBy(xpath = "//span[contains(text(),'Post')]")
	WebElement postbtn;

	@FindBy(xpath = "//span[text()='Adeshh Barbadee']")
	WebElement profilebtn;

	@FindBy(xpath = "//div[@class='rtxb060y hpj0pwwo lc19xlkw l4uc2m3f mfclru0v t7p7dqev']")
	WebElement timelinebtn;

	@FindBy(xpath = "//p[@class='cr00lzj9 kmwttqpk kjdc1dyq l7ghb35v m8h3af8h']")
	WebElement timelinebox;

	@FindBy(xpath = "//div[@aria-label='Post']")
	WebElement postbtnn;

	@FindBy(xpath = "//span[text()=\"What's on your mind, Adeshh?\"]")
	WebElement TextPostbtn;

	@FindBy(xpath = "//p[@class=\"xdj266r x11i5rnm xat24cr x1mh8g0r x16tdsg8\"] ")
	WebElement TextTypePostbtn;

	/**
	 * To post video in facebook
	 */
	public void userHomepagevideo() {
		try {

			homebtn.click();
			wait.until(ExpectedConditions.visibilityOfAllElements(photovideobtn));
			photovideobtn.click();
			wait.until(ExpectedConditions.visibilityOfAllElements(addbtn));
			addbtn.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			Thread.sleep(5000);
			Runtime.getRuntime().exec(".\\src\\main\\resources\\Repository\\video.exe").waitFor(90, TimeUnit.SECONDS);
			Thread.sleep(5000);
			postbtn.click();
			wait.until(ExpectedConditions.visibilityOfAllElements(homebtn));
			homebtn.click();
			Thread.sleep(50000);
			profilebtn.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;

			// scroll down on the webpage
			js.executeScript("window.scrollBy(0, 300)");

		} catch (Exception e) {

		}
	}

	public void userTextPost() {
		wait.until(ExpectedConditions.visibilityOfAllElements(homebtn));
		homebtn.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(TextPostbtn));
		TextPostbtn.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(TextTypePostbtn));
		TextTypePostbtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(TextTypePostbtn));
		TextTypePostbtn.sendKeys("Hi Guyz.");
		wait.until(ExpectedConditions.visibilityOfAllElements(postbtn));
		postbtn.click();

	}
}
