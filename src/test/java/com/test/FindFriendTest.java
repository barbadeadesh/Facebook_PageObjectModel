package com.test;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.FindFriendPage;
import com.pages.Loginpage;
import com.utility.utility;
@Listeners(com.utility.Listner.class)
public class FindFriendTest extends Base {

	public FindFriendTest() {
		super();
	}

	final static Logger log = Logger.getLogger(FindFriendTest.class);
	
	@BeforeMethod
	public void triggerDriver() {
		try {

			utility.intilization(prop.getProperty("browser"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	
	public void FriendFindPost() {
        
		loginp= new Loginpage();
		loginp.LoginUserUsingXlsx();
		findpage = new FindFriendPage();
		findpage.userFindFriend();

	}

	@SuppressWarnings("static-access")
	public void terminateDriver() {

		try {
			Thread.sleep(2000);
			util.closedriver();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
