package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class DealsPage extends BasePage {
	WebDriver driver;

	public DealsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void createDeal(){
		System.out.println("create deal ...");
	}
	
	public String getDealPageTitle(){
		return driver.getTitle();
	}
	
	
	

}
