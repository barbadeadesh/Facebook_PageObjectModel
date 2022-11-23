package com.test;

import java.util.LinkedList;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.Base;
import com.utility.utility;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Browser extends Base {

	static {

		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
	}

	/**
	 * Method: To Run Initialize method before running each Testcases
	 */

	@BeforeClass
	public void triggerDriver() {
		try {
			utility.intilization(prop.getProperty("browser"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@DataProvider(name = "LoginData")
	public Object[][] dataTest() {
		Object[][] data = new Object[2][2];
		data[0][0] = "7620840421";
		data[0][1] = "Adesh@8888073562";
		return data;

	}

	/**
	 * Method: To use excel reader
	 */
	@Test
	public void Login() {
		try {
			List<List<String>> values = new LinkedList<List<String>>();
			values.addAll(utility.excelreader());

			String url = prop.getProperty("baseURL");
			driver.get(url);
			System.out.println("Values from exel fle username:" + values.get(0).get(0));
			driver.findElement(By.id("email")).sendKeys(values.get(0).get(0));
			System.out.println("Values from exel fle password:" + values.get(0).get(1));
			driver.findElement(By.id("pass")).sendKeys(values.get(0).get(1));

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * Method: To Run Terminate method after running each Testcases
	 */

	@SuppressWarnings("static-access")
	@AfterClass
	public void terminateDriver() {
		try {

			Thread.sleep(4000);
			util.closedriver();
		} catch (Exception e) {

		}
	}
}
