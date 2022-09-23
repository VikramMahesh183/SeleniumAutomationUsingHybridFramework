package com.seleniumAutomation.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.seleniumAutomation.base.BaseClass;
import com.seleniumAutomation.dataProvider.DataProviders;
import com.seleniumAutomation.pageObjects.HomePage;
import com.seleniumAutomation.pageObjects.IndexPage;
import com.seleniumAutomation.pageObjects.LoginPage;
import com.seleniumAutomation.utility.Log;

public class HomePageTest extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;

	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws IOException {
		BaseClass.launchApp(browser);
	}

	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups="Smoke")
	public void wishListTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("wishListTest");
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage = loginPage.login(uname,pswd);
		boolean result=homePage.validateMyWishList();
		Assert.assertTrue(result);
		Log.endTestCase("wishListTest");
	}
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups="Smoke")
	public void orderHistoryandDetailsTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("orderHistoryandDetailsTest");
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage = loginPage.login(uname,pswd);
		boolean result=homePage.validateOrderHistory();
		Assert.assertTrue(result);
		Log.endTestCase("orderHistoryandDetailsTest");
	}
}
