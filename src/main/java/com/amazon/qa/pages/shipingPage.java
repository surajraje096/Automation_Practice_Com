package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.actiondriver.Action;
import com.amazon.qa.base.TestBase;

public class shipingPage extends TestBase{
	
	@FindBy(id="cgv")
	WebElement turm;
	
	@FindBy(xpath="(//button[@type='submit']//span)[2]")
	WebElement proccedtocheckedbtn;
	
	public shipingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void checkedTheturm() throws Throwable {
	Action.click(driver, turm);
	}

	public PaymentPage clickonproceedtocheckout() throws Throwable {
		Action.click(driver, proccedtocheckedbtn);
		return new PaymentPage();
		}

}
