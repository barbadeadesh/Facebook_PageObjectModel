package com.test;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.Loginpage;
import com.pages.MarketPlacePage;
import com.utility.utility;

import log4j.Log4jPatternLayout;

@Listeners(com.utility.Listner.class)
public class MarketPlaceTest  extends Base{
	
	

	public MarketPlaceTest() {
		super();
	}
	
    final static Logger log = Logger.getLogger(Log4jPatternLayout.class);

	@BeforeMethod
	public void triggerDriver() {
		try {
			
			log.info("* Starting browser  *");

			utility.intilization(prop.getProperty("browser"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Test
	public void MarketPlacePost() {
		
		log.info("* Start case Market Place  Videos *");

		loginp = new Loginpage();
		loginp.LoginUser();
		marketplace= new MarketPlacePage();
		marketplace.userMarketPlace();
//		String homePageTitle = loginp.verifyHomePage();
//		assertEquals(homePageTitle, "Facebook Marketplace | Facebook");
		
		
	}
	
	
	@SuppressWarnings("static-access")
	@AfterMethod
	public void terminateDriver() {
		log.info("*End Test Case*");
		try {

			Thread.sleep(4000);
			util.closedriver();

		} catch (Exception e) {

		}
	}
	

}
