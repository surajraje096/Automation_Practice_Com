package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.actiondriver.Action;
import com.amazon.qa.base.TestBase;

public class SearchResultPage extends TestBase{
	@FindBy(xpath="(//img[@class='replace-2x img-responsive'])[2]")
	WebElement productresult;
	
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isproductavailable() throws Throwable {
		return Action.isDisplayed(driver, productresult);
	}
	
	public AddtocartPage clickonProduct() throws Throwable {
		Action.click(driver, productresult);
		return new AddtocartPage();
	}

}
