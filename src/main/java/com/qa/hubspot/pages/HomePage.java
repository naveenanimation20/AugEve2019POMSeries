package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementActions;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementActions elementActions;

	// locators/OR
	By header = By.cssSelector("h1.private-header__heading>i18n-string");
	By accountName = By.cssSelector("a#account-menu>span");
	By contactMainTab = By.id("nav-primary-contacts-branch");
	By contactChildTab = By.id("nav-secondary-contacts");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);

	}

	// page actions:
	public String getHomePageTitle() {
		return elementActions.waitForPageTitle(Constants.HOME_PAGE_TITLE);
	}

	public boolean isHomePageHeaderVisible() {
		return elementActions.isElementDisplayed(header);
	}

	public String getHomePageHeaderText() {
		return elementActions.doGetText(header);
	}

	public boolean isAccountNameVisible() {
		return elementActions.isElementDisplayed(accountName);
	}

	public String getAccountNameText() {
		return elementActions.doGetText(accountName);
	}

	public ContactsPage goToContactsPage() {
		clickOnContacts();
		return new ContactsPage(driver);
	}

	private void clickOnContacts() {
		elementActions.doClick(contactMainTab);
		elementActions.doClick(contactChildTab);
	}

	public void homepageVerify() {

	}

	public void homepage_urlTest() {

	}

	public void homepage_accountTest() {
		System.out.println("hp===account test");
	}

	public void homepage_headertest() {

	}

	public void homepage_profileTest() {

	}

	public void homePage_linkTest() {
		System.out.println("HII Link Test");

		System.out.println("testing....");
	}

}
