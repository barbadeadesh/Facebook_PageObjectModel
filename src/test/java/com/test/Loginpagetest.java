package com.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.Loginpage;
import com.utility.utility;

@Listeners(com.utility.Listner.class)
public class Loginpagetest extends Base {

	public Loginpagetest() {

		super();
	}

	/**
	 * To Run Initialize method before running each Testcases and To Open browser
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
	 * To Test Login Page is working or not using config file
	 */

	@Test(priority = 1)
	public void validLoginPagewithConfigDataTest() {

		loginp = new Loginpage();
		loginp.LoginUser();
		String homePageTitle = loginp.verifyHomePage();
		assertEquals(homePageTitle, "Facebook");

	}

	/**
	 * To Test Login Page is working or not using XLSX file
	 */

	@Test(priority = 2)

	public void validLoginPageWithXlsxDataTest() {

		loginp = new Loginpage();
		loginp.LoginUserUsingXlsx();

		String homePageTitle = loginp.verifyHomePage();
		assertEquals(homePageTitle, "Facebook");

	}

	/**
	 * To Test Login Page is giving error message or not while inserting wrong
	 * crediantials
	 */

//	@SuppressWarnings("static-access")
//	@Test(priority = 3)
//	public void validateInvalidLoginCred() {
//		loginp = new Loginpage();
//		message = loginp.validateInvalidLoginCred();
//
//		assertEquals(message, "password that you've entered is incorrect. Forgotten password?");
//
//	}

	/**
	 * To Run Terminate method after running each Testcases
	 */

	@SuppressWarnings("static-access")
	@AfterMethod
	public void terminateDriver() {

		try {

			util.closedriver();

		} catch (Exception e) {

		}

	}
}