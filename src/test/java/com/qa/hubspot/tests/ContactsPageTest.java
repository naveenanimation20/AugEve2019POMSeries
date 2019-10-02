package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ExcelUtil;

public class ContactsPageTest {

	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.goToContactsPage();
	}

	@Test(priority = 1)
	public void contactsPageHeaderTest() {
		String header = contactsPage.getContactsPageHeader();
		System.out.println("contacts page header is : " + header);
		Assert.assertEquals(header, Constants.CONTACTS_PAGE_HEADER);
	}

	@DataProvider
	public Object[][] getContactsData(){
		Object data[][] = ExcelUtil.getTestData("contacts");
		return data;
	}
	
	
	@Test(priority = 2, dataProvider = "getContactsData")
	public void createNewContactTest(String emailid, String firstname, String lastname, String jobtitle) {
		contactsPage.createNewContact(emailid, firstname, lastname, jobtitle);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
