package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class HomePageTest {

	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void homePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("home page title is: " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void homePageHeaderTest() {
		Assert.assertTrue(homePage.isHomePageHeaderVisible());

		String headerText = homePage.getHomePageHeaderText();
		System.out.println("home page header text is: " + headerText);
		Assert.assertEquals(headerText, Constants.HOME_PAGE_HEADER);
	}

	@Test(priority = 3)
	public void loggedInUserTest() {
		Assert.assertTrue(homePage.isAccountNameVisible());

		String accountText = homePage.getAccountNameText();
		System.out.println("logged in user account is: " + accountText);
		Assert.assertEquals(accountText, prop.getProperty("accountname"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
