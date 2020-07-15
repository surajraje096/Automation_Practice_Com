package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.actiondriver.Action;
import com.amazon.qa.base.TestBase;

public class AccountCreationPage extends TestBase{
	@FindBy(xpath="//h1[text()='Create an account']")
	WebElement fromtital;
	
	
	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateAccountCreatpage() throws Throwable {
		return Action.isDisplayed(driver, fromtital);
	}

}
