package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.actiondriver.Action;
import com.amazon.qa.base.TestBase;

public class OrderPage extends TestBase{
	
	@FindBy(xpath="//span[@class='price']//span[1]")
	WebElement unitprice;
	
	@FindBy(id="total_price")
	WebElement totalprice;
		
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proccerdcheckedbtn;
	
	public OrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public double getunitprice() throws Throwable {
		String unitprice1= unitprice.getText();
		String unit =unitprice1.replaceAll("[^a-zA-Z0-9]","");
		double finalunitprice=Double.parseDouble(unit);
		return finalunitprice/100;
	}
	
	public double getTotalprice() throws Throwable {
		String Totalprice1= totalprice.getText();
		String tot =Totalprice1.replaceAll("[^a-zA-Z0-9]","");
		double finaltotalprice=Double.parseDouble(tot);
		return finaltotalprice/100;
	}
	
	public LoginPage clickincheckout() throws Throwable {
		Action.click(driver, proccerdcheckedbtn);
		return new LoginPage();
	}
	
}
