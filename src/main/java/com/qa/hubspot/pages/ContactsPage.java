package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.ElementActions;

public class ContactsPage extends BasePage {

	WebDriver driver;
	ElementActions elementActions;

	By header = By.cssSelector("h1.private-header__heading>i18n-string");
	By createContactButton = By.xpath("//button[@data-button-use='primary']//span[text()='Create contact']");
	By createContactFormButton = By.xpath("//div[text()='Create contact']");

	By email = By.xpath("//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);

	}

	public String getContactsPageHeader() {
		return elementActions.doGetText(header);
	}

	public void createNewContact(String emailId, String FN, String LN, String jobtitle) {
		elementActions.waitForElementClickable(createContactButton);
		elementActions.doClickByActions(createContactButton);
		elementActions.doSendKeys(email, emailId);
		elementActions.doSendKeys(firstName, FN);
		elementActions.doSendKeys(lastName, LN);
		elementActions.doSendKeys(jobTitle, jobtitle);
		elementActions.doClickByActions(createContactFormButton);
	}
	
	public void test(){
		System.out.println("test method");
	}

}
