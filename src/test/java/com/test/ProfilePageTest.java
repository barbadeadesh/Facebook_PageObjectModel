package com.test;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.HomePage;
import com.pages.Loginpage;

import com.pages.ProfilePage;

import com.utility.utility;

import log4j.Log4jPatternLayout;

@Listeners(com.utility.Listner.class)

public class ProfilePageTest extends Base {

	public ProfilePageTest() {
		super();
	}

	final static Logger log = Logger.getLogger(ProfilePageTest.class);

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
	 * To upload profile picture in facebook
	 */
	@Test
	public void UploadProfileImage() {
		loginp = new Loginpage();
		loginp.LoginUserUsingXlsx();
		profile = new ProfilePage();
		profile.uploadUserProfileImage();

	}
	/*
	 * Like the facebook post
	 */
	@Test
	public void likePost() throws InterruptedException {
		loginp = new Loginpage();
		loginp.LoginUserUsingXlsx();
		profile= new ProfilePage ();
		profile.userHomePageLikePost();
		
	}
	
	@Test
	
	public void commentpost () throws Exception {
		loginp = new Loginpage();
		loginp.LoginUserUsingXlsx();
		profile= new ProfilePage ();
		profile.comment();
		
		
	}

	@AfterMethod
	public void terminateDriver() {

		try {

			util.closedriver();

		} catch (Exception e) {

		}

	}
}
