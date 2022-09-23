package com.seleniumAutomation.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.seleniumAutomation.actionDriver.Action;
import com.seleniumAutomation.base.BaseClass;
import com.seleniumAutomation.dataProvider.DataProviders;
import com.seleniumAutomation.pageObjects.HomePage;
import com.seleniumAutomation.pageObjects.IndexPage;
import com.seleniumAutomation.pageObjects.LoginPage;
import com.seleniumAutomation.utility.Log;

public class LoginPageTest extends BaseClass {
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

	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups= {"Smoke","Sanity"})
	public void loginTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("user is going to click on SignIn");
		loginPage = indexPage.clickOnSignIn();
		Log.info("Enter Username and Password");
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login(uname, pswd);
		Action.implicitWait(getDriver(), 10);
		String actualURL = homePage.getCurrURL();
		String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login is Sucess");
		Log.endTestCase("loginTest");
	}
}
