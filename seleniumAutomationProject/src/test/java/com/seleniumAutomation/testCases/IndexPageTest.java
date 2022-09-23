package com.seleniumAutomation.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.seleniumAutomation.base.BaseClass;
import com.seleniumAutomation.pageObjects.IndexPage;
import com.seleniumAutomation.utility.Log;

public class IndexPageTest extends BaseClass {
	private IndexPage indexPage;

	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws IOException {
		BaseClass.launchApp(browser);
	}
	
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups="Smoke")
	public void verifyLogo() throws Throwable {
		Log.startTestCase("verifyLogo");
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
		Log.endTestCase("verifyLogo");
	}

	@Test(groups="Smoke")
	public void verifyTitle() {
		Log.startTestCase("verifyTitle");
		String actTitle = indexPage.getMyStoreTitle();
		Assert.assertEquals(actTitle, "My Store");
		Log.endTestCase("verifyTitle");
	}

}
