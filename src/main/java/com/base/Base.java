package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.FindFriendPage;
import com.pages.Loginpage;
import com.pages.MarketPlacePage;
import com.pages.ProfilePage;
import com.pages.HomePage;
import com.utility.utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	protected static WebDriver driver;
	protected static WebElement element;
	protected static FileInputStream file;
	protected static Properties prop;
	protected static utility util;
	protected static FileInputStream excelfile;
	protected static XSSFWorkbook xWorkBook;
	protected static XSSFSheet xSheet;
	protected static Object[][] data;
	protected static Loginpage loginp;
	protected static String message;
	protected static FindFriendPage findpage;
	protected static ProfilePage profile;
	protected static HomePage homePage;
	protected static MarketPlacePage marketplace;
	
	
	
	
	
	

	static {

		WebDriverManager.chromedriver().setup();
	}
	
       // Give the path of xlsx sheet and name of that particular sheet
	protected final static String FILE_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "main" + File.separator + "resources" + File.separator + "Repository" + File.separator
			+ "LoginTestData.xlsx";
	
	/**
	 *  To Load the Properties file in file.io
	 */
	
	public Base() {
		try {
			// create a constructor for loading the config. property
			prop = new Properties();
			file = new FileInputStream(
					".\\src\\main\\resources\\config.properties");// path of config.properties from project folder
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
