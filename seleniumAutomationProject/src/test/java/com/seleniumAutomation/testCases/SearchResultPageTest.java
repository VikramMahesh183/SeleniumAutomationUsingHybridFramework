package com.seleniumAutomation.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.seleniumAutomation.base.BaseClass;
import com.seleniumAutomation.dataProvider.DataProviders;
import com.seleniumAutomation.pageObjects.IndexPage;
import com.seleniumAutomation.pageObjects.SearchResultPage;
import com.seleniumAutomation.utility.Log;

public class SearchResultPageTest extends BaseClass {
	private IndexPage indexPage;
	private SearchResultPage searchResultPage;

	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws IOException {
		BaseClass.launchApp(browser);
	}

	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider = "searchProduct", dataProviderClass = DataProviders.class, groups="Smoke")
	public void productAvailabilityTest(String product) throws Throwable {
		Log.startTestCase("productAvailabilityTest");
		indexPage= new IndexPage();
		searchResultPage=indexPage.searchProduct(product);
		boolean result=searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
		Log.endTestCase("productAvailabilityTest");
	}
}
