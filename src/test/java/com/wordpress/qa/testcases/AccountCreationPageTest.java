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
import com.amazon.qa.pages.AccountCreationPage;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.IndexPage;
import com.amazon.qa.pages.LoginPage;

import com.amazon.qa.util.testRunmode;





public class AccountCreationPageTest extends TestBase {

	IndexPage IndexPag;
	LoginPage LoginPag;
	AccountCreationPage AccountCreationPag;
	@BeforeTest
	public void isSkip()
	{
		if(!testRunmode.isExecutable("AccountCreationPageTest")){
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
	public void wishlistTest() throws Throwable {
		IndexPag = new IndexPage();
		LoginPag = IndexPag.clickonsingin();
		AccountCreationPag = LoginPag.CreatnewAccount(prop.getProperty("newEmail"));
		boolean result = AccountCreationPag.validateAccountCreatpage();
		Assert.assertTrue(result);
	}

}
