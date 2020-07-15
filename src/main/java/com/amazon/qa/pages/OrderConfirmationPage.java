package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.actiondriver.Action;
import com.amazon.qa.base.TestBase;

public class OrderConfirmationPage extends TestBase {
	
	@FindBy(xpath="//strong[text()='Your order on My Store is complete.']")
	WebElement confurmmsg;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateconfurmmsg() throws Throwable {
		String confurmms = confurmmsg.getText();
	return confurmms;
	}

}
