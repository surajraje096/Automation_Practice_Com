/**
 * 
 */
package com.amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.qa.actiondriver.Action;
import com.amazon.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id = "email")
	WebElement Username;

	@FindBy(name = "passwd")
	WebElement password;

	@FindBy(id = "SubmitLogin")
	WebElement signbtn;
	
	@FindBy(xpath = "//span[text()[normalize-space()='Sign in']]")
	WebElement signbtnfinal;

	@FindBy(name = "email_create")
	WebElement elementFornewAccount;

	@FindBy(name = "SubmitCreate")
	WebElement ceratnewAccountbtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

public HomePage login(String uname ,String pwsd) throws Throwable {
	Action.type(Username, uname);
	Action.type(password, pwsd);
	Action.click(driver, signbtn);
return new HomePage();
}

public AddressPage login1(String uname ,String pwsd) throws Throwable {
	Action.type(Username, uname);
	Action.type(password, pwsd);
	Action.click(driver, signbtn);
return new AddressPage();
}


public AccountCreationPage CreatnewAccount(String newEmail ) throws Throwable {
	Action.type(elementFornewAccount, newEmail);
	Action.click(driver, ceratnewAccountbtn);
	
return new AccountCreationPage();
}

}
