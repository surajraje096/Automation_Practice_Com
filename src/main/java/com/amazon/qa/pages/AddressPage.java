package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.actiondriver.Action;
import com.amazon.qa.base.TestBase;

public class AddressPage extends TestBase{
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proccedtocheckedbtn;
	
	public AddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	public shipingPage clickonCheckout() throws Throwable {
		 Action.click(driver, proccedtocheckedbtn);
		 return new shipingPage();
	}

}
