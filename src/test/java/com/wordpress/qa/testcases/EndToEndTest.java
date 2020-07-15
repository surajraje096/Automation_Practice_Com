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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.AddressPage;
import com.amazon.qa.pages.AddtocartPage;
import com.amazon.qa.pages.IndexPage;
import com.amazon.qa.pages.OrderPage;
import com.amazon.qa.pages.PaymentPage;
import com.amazon.qa.pages.SearchResultPage;
import com.amazon.qa.pages.shipingPage;
import com.amazon.qa.util.testRunmode;
import com.amazon.qa.util.testUtil;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.OrdearSummaryPage;
import com.amazon.qa.pages.OrderConfirmationPage;
public class EndToEndTest extends TestBase{
	
	IndexPage IndexPag;
	SearchResultPage SearchResultPage;
	AddtocartPage AddtocartPage;
	OrderPage OrderPage;
	LoginPage LoginPage;
	AddressPage AddressPage;
	shipingPage shipingPage;
    PaymentPage PaymentPage;
    OrdearSummaryPage OrdearSummaryPage; 
    OrderConfirmationPage OrderConfirmationPage;
    
    @BeforeTest
	public void isSkip()
	{
		if(!testRunmode.isExecutable("EndToEndTest")){
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

	@Test(dataProvider="getData")
	public void EndtoEndTest(String email,String password) throws Throwable {
		IndexPag = new IndexPage();
		SearchResultPage = IndexPag.SearchProduct(prop.getProperty("Product"));
		AddtocartPage = SearchResultPage.clickonProduct();
		AddtocartPage.EnterQuantity(prop.getProperty("Quantity"));
		AddtocartPage.selectsize();
		AddtocartPage.clicktocartbtn();
		Thread.sleep(3000);
		OrderPage=AddtocartPage.clickoncheckedbtn();
		LoginPage=OrderPage.clickincheckout();
		AddressPage=LoginPage.login1("email","password");
		shipingPage=AddressPage.clickonCheckout();
		shipingPage.checkedTheturm();
		PaymentPage=shipingPage.clickonproceedtocheckout();
		OrdearSummaryPage=PaymentPage.checkedonpeymentmethod();
		OrderConfirmationPage=OrdearSummaryPage.clickonconfermorderbtn();
		String AcualMsg=OrderConfirmationPage.validateconfurmmsg();
	    String expectedMsg ="Your order on My Store is complete.";
	    Assert .assertEquals(AcualMsg, expectedMsg);
	}
	@DataProvider
	public static Object[][] getData()
	{

	  return testUtil.getData("LoginTest");
	}
}
