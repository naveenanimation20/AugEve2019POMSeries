package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementActions;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {

	WebDriver driver;
	ElementActions elementActions;

	// 1. define OR/Page Objects: using By locator:
	By emailId = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");

	// 2. define a constructor:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	// 3. Page Actions/methods:
	@Step("getting login page title...")
	public String getLoginPageTitle() {
		return elementActions.waitForPageTitle(Constants.LOGIN_PAGE_TITLE);
	}

	@Step("login to application with username: {0} and password: {1}")
	public HomePage doLogin(String username, String pwd) {
		elementActions.doSendKeys(emailId, username);
		elementActions.doSendKeys(password, pwd);
		elementActions.doClick(loginButton);

		return new HomePage(driver);
	}

	@Step("sign up link verification...")
	public boolean signUpLinkIsDisplayed() {
		return elementActions.isElementDisplayed(signUpLink);
	}

}
