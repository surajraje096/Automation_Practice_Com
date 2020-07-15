package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.actiondriver.Action;
import com.amazon.qa.base.TestBase;

public class PaymentPage extends TestBase{
	@FindBy(xpath="(//span[text()='(order processing will be longer)'])[1]")
	WebElement bankwiremethod;
	
	@FindBy(xpath="(//span[text()='(order processing will be longer)'])[2]")
	WebElement paybycheckemethod;
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrdearSummaryPage checkedonpeymentmethod() throws Throwable {
	Action.click(driver, bankwiremethod);
	return new OrdearSummaryPage();
	}

	

}
