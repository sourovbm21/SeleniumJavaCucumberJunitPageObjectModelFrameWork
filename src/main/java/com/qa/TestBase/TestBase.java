package com.qa.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.qa.utils.TimeUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	/**
	 * This is super class of all classes
	 * @author Tohidur Rahman
	 */

	public static Properties pro;
	public static FileInputStream fis;
	public static WebDriver driver;

	public void driver_int() throws IOException {

		pro = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/" + "qa/config/config.properties");

		pro.load(fis);
		String browser_Name = pro.getProperty("browser");

		if (browser_Name.equalsIgnoreCase("chrome")) {

//			ChromeOptions cop = new ChromeOptions();
//			cop.addArguments("--headless");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser_Name.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser_Name.equalsIgnoreCase("edge")) {
			//

		} else if (browser_Name.equalsIgnoreCase("safari")) {
			//

		} else if (browser_Name.equalsIgnoreCase("opera")) {
			//
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(TimeUtility.implicit_TimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TimeUtility.page_Load_TimeOut, TimeUnit.SECONDS);

	}

}
