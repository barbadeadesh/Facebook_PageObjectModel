package com.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.Loginpage;
import com.pages.ProfilePage;
import com.pages.HomePage;
import com.utility.utility;

import log4j.Log4jPatternLayout;

@Listeners(com.utility.Listner.class)
public class HomepageTest extends Base {

	public HomepageTest() {
		super();
	}

	final static Logger log = Logger.getLogger(Log4jPatternLayout.class);

	/**
	 * To Run Initialize method before running each Testcases
	 */
	@BeforeMethod
	public void triggerDriver() {
		try {
			utility.intilization(prop.getProperty("browser"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * To upload video in facebook
	 */
	@Test
	public void UploadProfilevideo() {
		loginp = new Loginpage();
		loginp.LoginUserUsingXlsx();
		homePage = new HomePage();
		homePage.userHomepagevideo();
	}
	
	@Test
	
	public void Status() {
		loginp = new Loginpage();
		loginp.LoginUserUsingXlsx();
		homePage = new HomePage();
		homePage.userTextPost();
	}

	@AfterMethod
	public void terminateDriver() {

		try {

			util.closedriver();

		} catch (Exception e) {

		}

	}

}
