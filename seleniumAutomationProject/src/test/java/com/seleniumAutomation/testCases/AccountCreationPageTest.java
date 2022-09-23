package com.seleniumAutomation.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.seleniumAutomation.base.BaseClass;
import com.seleniumAutomation.dataProvider.DataProviders;
import com.seleniumAutomation.pageObjects.AccountCreationPage;
import com.seleniumAutomation.pageObjects.IndexPage;
import com.seleniumAutomation.pageObjects.LoginPage;
import com.seleniumAutomation.utility.Log;

public class AccountCreationPageTest extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginPage;
	private AccountCreationPage acountCreationPage;

	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws IOException {
		BaseClass.launchApp(browser);
	}

	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}

	@Test(dataProvider = "email", dataProviderClass = DataProviders.class, groups="Sanity")
	public void verifyCreateAccountPageTest(String newEmail) throws Throwable {
		Log.startTestCase("verifyCreateAccountPageTest");
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		// acountCreationPage=loginPage.createNewAccount(prop.getProperty("email"));
		acountCreationPage = loginPage.createNewAccount(newEmail);
		boolean result = acountCreationPage.validateAcountCreatePage();
		Assert.assertTrue(result);
		Log.endTestCase("verifyCreateAccountPageTest");
	}

}
