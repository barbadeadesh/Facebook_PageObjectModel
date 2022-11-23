package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MarketPlacePage extends Loginpage {
	@FindBy(xpath = "//span[text()='Marketplace']")
	WebElement marketplacebtnbtn;

	/**
	 * Method: To Find Friend in facebook
	 */
	public void userMarketPlace() {
		try {

			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			homebtn.click();
			Thread.sleep(2000);
			
			marketplacebtnbtn.click();
			Thread.sleep(2000);

			JavascriptExecutor js = (JavascriptExecutor) driver;

			// scroll down on the webpage
			js.executeScript("window.scrollBy(0, 300)");

			// scroll up on the webpage
			js.executeScript("window.scrollBy(0, -300)");
			Thread.sleep(3000);

			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
