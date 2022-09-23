package com.seleniumAutomation.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.seleniumAutomation.base.BaseClass;
import com.seleniumAutomation.dataProvider.DataProviders;
import com.seleniumAutomation.pageObjects.AddToCartPage;
import com.seleniumAutomation.pageObjects.IndexPage;
import com.seleniumAutomation.pageObjects.SearchResultPage;
import com.seleniumAutomation.utility.Log;

public class AddToCartPageTest extends BaseClass{
	private IndexPage indexPage;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws IOException {
		BaseClass.launchApp(browser);
	}

	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider = "getProduct", dataProviderClass = DataProviders.class, groups={"Regression","Sanity"})
	public void addToCartTest(String product, String qty, String size) throws Throwable {
		Log.startTestCase("addToCartTest");
		indexPage= new IndexPage();
		searchResultPage=indexPage.searchProduct(product);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		boolean result=addToCartPage.validateAddtoCart();
		Assert.assertTrue(result);
		Log.endTestCase("addToCartTest");
		
	}
}
