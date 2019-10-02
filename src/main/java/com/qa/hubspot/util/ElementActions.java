package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {

	WebDriver driver;

	public ElementActions(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		waitForElementPresent(locator);
		WebElement element = null;

		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("some exception occurred while creating the element " + locator);
		}
		return element;
	}

	public void waitForElementPresent(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void waitForElementClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("some exception occurred while clicking on the element " + locator);
		}
	}
	
	public void doClickByActions(By locator){
		Actions actions = new Actions(driver);
		actions.click(getElement(locator)).build().perform();
	}

	public void doSendKeys(By locator, String value) {
		try {
			getElement(locator).clear();
			getElement(locator).sendKeys(value);
		} catch (Exception e) {
			System.out.println("some exception occurred while sending the key on the element " + locator);
		}
	}

	public String doGetText(By locator) {
		String text = null;
		try {
			text = getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("some exception occurred while getting the text of the element " + locator);
		}
		return text;
	}
	
	public String waitForPageTitle(String title){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	
	public boolean isElementDisplayed(By locator){
		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("some exception occurred while sending the key on the element " + locator);
			return false;
		}
	}

}
