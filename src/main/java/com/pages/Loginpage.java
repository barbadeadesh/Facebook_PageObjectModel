package com.pages;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Base;
import com.utility.utility;

// In this class we create different methods for verify Home page title by taking the data from diff. location 

public class Loginpage extends Base {
	/**
	 * Constructor: To Initialize the WebElements generated from FindBy Annotation
	 */

	@FindBy(id = "email")
	WebElement emailId;

	@FindBy(name = "pass")
	WebElement password;

	@FindBy(name = "login")
	WebElement loginBtn;

	@FindBy(xpath = "//a[@aria-label='Home']")
	WebElement homebtn;

	@FindBy(xpath = "//div[@class=\"clearfix _5466 _44mg\"]/div[2]")
	WebElement ErrorMsg;

	/**
	 * Constructor: To Initialize the WebElements generated from FindBy Annotation
	 */
	public Loginpage() {

		PageFactory.initElements(driver, this);
	}

	WebDriverWait wait = new WebDriverWait(driver, 90);

	/**
	 * To verify Home Page Title with Config data
	 */
	public void LoginUser() {

		try {
			emailId.sendKeys(prop.getProperty("emailId"));
			password.sendKeys(prop.getProperty("password"));
			wait.until(ExpectedConditions.visibilityOfAllElements(loginBtn));
			loginBtn.click();
			wait.until(ExpectedConditions.visibilityOfAllElements(homebtn));
		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method: To verify Home Page Title with Xlsx file
	 */
	public void LoginUserUsingXlsx() {
		try {
			List<List<String>> values = new LinkedList<List<String>>(); //// list is use for store the data and
																		//// linkedlist is use for getting the data
			values.addAll(utility.excelreader());
			emailId.sendKeys(values.get(0).get(0));

			password.sendKeys(values.get(0).get(1));
			wait.until(ExpectedConditions.visibilityOfAllElements(loginBtn));
			loginBtn.click();
//			wait.until(ExpectedConditions.visibilityOfAllElements(homebtn));
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * To verify Error message while entering Invalid credentials
	 */
	public String validateInvalidLoginCred() {
		try {
			List<List<String>> values = new LinkedList<List<String>>();// list is use for store the data and linkedlist
																		// is use for getting the data
			values.addAll(utility.excelreader());
			emailId.sendKeys(values.get(1).get(0));
			password.sendKeys(values.get(1).get(1));
			wait.until(ExpectedConditions.visibilityOfAllElements(loginBtn));
			loginBtn.click();

			message = ErrorMsg.getText(); // Here ErrorMsg is web Element & getText is method
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	/**
	 * To verify Homepagetitle
	 */
	public String verifyHomePage() {
		String homePageTitle = driver.getTitle(); // By using getTitle method we get the title of that particular url
		return homePageTitle;
	}
	
	public static  String verifyposttime() {
		 WebElement timeofpost = driver.findElement(By.xpath("(//a[arie-label='1 m']//span)[1]"));
		 String posttime= timeofpost.getText();
		 System.out.println("Post Time: " +posttime);
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
		 executor.executeScript("window.scrollBy(0,400)");
		 return  posttime;
		
	}
	
	
	
	
	

}
