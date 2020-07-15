/**
 * 
 */
package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.actiondriver.Action;
import com.amazon.qa.base.TestBase;


public class HomePage extends TestBase {
	
	@FindBy(xpath = "//span[text()='My wishlists']")
	WebElement MYwishlist;
	
	@FindBy(xpath="//span[text()='Order history and details']")
	WebElement orderhistory;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateMYwishlist() throws Throwable {
		return Action.isDisplayed(driver, MYwishlist);
	}
	
	public boolean validateoredehistory() throws Throwable {
		return Action.isDisplayed(driver, orderhistory);
	}
	


	public String currenturl() {
		String currenturl=driver.getCurrentUrl();
		return currenturl;
		
	}


}
