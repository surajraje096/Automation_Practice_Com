package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.actiondriver.Action;
import com.amazon.qa.base.TestBase;

public class IndexPage extends TestBase {

	@FindBy(linkText = "Sign in")
	WebElement signin;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement logo;
	
	@FindBy(id = "search_query_top")
	WebElement searchProductBox;
	
	@FindBy(name = "submit_search")
	WebElement searchBtn;

	public IndexPage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickonsingin() throws Throwable {
		Action.click(driver, signin);
		return new LoginPage();
	}

	public boolean validatelogo() throws Throwable {
		return Action.isDisplayed(driver, logo);
	}

	public String getmystoarTital() {
		String mystoarTital = driver.getTitle();
		return mystoarTital;
	}
	public SearchResultPage SearchProduct( String productname) throws Throwable {
		Action.type(searchProductBox, productname);
		Action.click(driver, searchBtn);
		Thread.sleep(5000);
		return new SearchResultPage();
	}
	
}
