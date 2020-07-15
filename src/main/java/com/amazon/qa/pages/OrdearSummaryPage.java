package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.actiondriver.Action;
import com.amazon.qa.base.TestBase;

public class OrdearSummaryPage extends TestBase {
	
	@FindBy(xpath="//span[text()='I confirm my order']")
	WebElement confurmordarbtn;
	
	public OrdearSummaryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderConfirmationPage clickonconfermorderbtn() throws Throwable {
	Action.click(driver, confurmordarbtn);
	return new OrderConfirmationPage();
	}


}
