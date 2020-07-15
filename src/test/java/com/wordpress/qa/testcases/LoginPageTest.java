

package com.wordpress.qa.testcases;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.IndexPage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.util.testRunmode;
import com.amazon.qa.util.testUtil;






public class LoginPageTest extends TestBase {


	String sheetname = "EmailId&Pass";
	IndexPage IndexPag;
	LoginPage LoginPag;
	HomePage   HomePag;
	
	@BeforeTest
	public void isSkip()
	{
		if(!testRunmode.isExecutable("LoginPageTest")){
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
	public void loginTest(String email,String password) throws Throwable {
		IndexPag = new IndexPage();
		LoginPag =IndexPag.clickonsingin();
		HomePag=LoginPag.login("email","password");
		String actuurl=HomePag.currenturl();
		String expurl = "http://automationpractice.com/index.php?controller=authentication";
		Assert.assertEquals(actuurl, expurl);
	}

	@DataProvider
	public static Object[][] getData()
	{

	  return testUtil.getData("LoginTest");
	}


}
