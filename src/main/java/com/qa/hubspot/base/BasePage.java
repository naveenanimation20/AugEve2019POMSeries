package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author NaveenKhunteta
 *
 */
public class BasePage {

	public WebDriver driver;
	Properties prop;

	/**
	 * this method is used to initalize the driver on the basis of browser
	 * 
	 * @return driver
	 */
	public WebDriver init_driver(Properties prop) {

		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("please define the proper browser value....");
		}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get(url);
		return driver;
	}

	/**
	 * this method is used to get the properties from config prop file
	 * 
	 * @return prop
	 */
	public Properties init_properties() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("/Users/NaveenKhunteta/Documents/workspace/AugEvePOMSeries/"
					+ "src/main/java/com/qa/hubspot/config/config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}

}
