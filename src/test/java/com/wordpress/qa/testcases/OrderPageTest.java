package com.wordpress.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.AddtocartPage;
import com.amazon.qa.pages.IndexPage;
import com.amazon.qa.pages.SearchResultPage;
import com.amazon.qa.util.testRunmode;
import com.amazon.qa.pages.OrderPage;

public class OrderPageTest extends TestBase {
	
	IndexPage IndexPag;
	SearchResultPage SearchResultPage;
	AddtocartPage AddtocartPage;
	OrderPage OrderPage;

	@BeforeTest
	public void isSkip()
	{
		if(!testRunmode.isExecutable("OrderPageTest")){
			throw new SkipException("Skipping the testcase as runmode is set to No");
		}
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void veryfieTotalPrice() throws Throwable {
		IndexPag = new IndexPage();
		SearchResultPage = IndexPag.SearchProduct(prop.getProperty("Product"));
		AddtocartPage = SearchResultPage.clickonProduct();
		AddtocartPage.EnterQuantity(prop.getProperty("Quantity"));
		AddtocartPage.selectsize();
		AddtocartPage.clicktocartbtn();
		Thread.sleep(3000);
		OrderPage = AddtocartPage.clickoncheckedbtn();
		Double unitprice = OrderPage.getunitprice();
		Double Totalprice = OrderPage.getTotalprice();
		Double TotalExpectedprice = (unitprice * 2) + 2;
		Assert.assertEquals(Totalprice, TotalExpectedprice);
		Thread.sleep(3000);

	}

}
