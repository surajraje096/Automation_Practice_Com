package com.wordpress.qa.testcases;


import java.io.IOException;

import org.apache.log4j.Logger;
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
import com.amazon.qa.util.testRunmode;


public class IndexPageTest extends TestBase{
	
	IndexPage IndexPag;
	
	@BeforeTest
	public void isSkip()
	{
		if(!testRunmode.isExecutable("IndexPageTest")){
			throw new SkipException("Skipping the testcase as runmode is set to No");
		}
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		 app_logs.debug("lonch the chrome browser");
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
		app_logs.debug("close the chrome browser");
	}
	@Test(priority =1)
	public void verifilogo() throws Throwable {
		IndexPag = new IndexPage();
		boolean result =IndexPag.validatelogo();
		Assert.assertTrue(result);
		app_logs.debug("verifi logo");
	}
	
	@Test(priority=2)
	public void verifieTital() throws Throwable {
		app_logs.debug("verifi tital");
	String actTital=IndexPag.getmystoarTital();
	Assert.assertEquals(actTital, "My Store");
	}


}
