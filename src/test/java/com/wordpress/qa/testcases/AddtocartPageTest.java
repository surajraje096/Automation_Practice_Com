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
import com.amazon.qa.pages.IndexPage;
import com.amazon.qa.pages.SearchResultPage;
import com.amazon.qa.util.testRunmode;
import 	com.amazon.qa.pages.AddtocartPage;
public class AddtocartPageTest extends TestBase{
	
	IndexPage IndexPag;
	SearchResultPage SearchResultPage;
	AddtocartPage AddtocartPage;
	
	
	@BeforeTest
	public void isSkip()
	{
		if(!testRunmode.isExecutable("AddtocartPageTest")){
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

	@Test(priority=1)
	public void AddtocartTest() throws Throwable {
		IndexPag = new IndexPage();
		SearchResultPage=IndexPag.SearchProduct(prop.getProperty("Product"));
		AddtocartPage= SearchResultPage.clickonProduct();
		AddtocartPage.EnterQuantity(prop.getProperty("Quantity"));
		AddtocartPage.selectsize();
		AddtocartPage.clicktocartbtn();
		 boolean result =AddtocartPage.validatetocart();
		 Assert.assertTrue(result);
		
		
		
		
		
	}

}
