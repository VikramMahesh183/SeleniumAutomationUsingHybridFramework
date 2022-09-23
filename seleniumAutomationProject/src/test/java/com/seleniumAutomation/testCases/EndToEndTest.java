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
import com.seleniumAutomation.pageObjects.AddressPage;
import com.seleniumAutomation.pageObjects.IndexPage;
import com.seleniumAutomation.pageObjects.LoginPage;
import com.seleniumAutomation.pageObjects.OrderConfirmationPage;
import com.seleniumAutomation.pageObjects.OrderPage;
import com.seleniumAutomation.pageObjects.OrderSummary;
import com.seleniumAutomation.pageObjects.PaymentPage;
import com.seleniumAutomation.pageObjects.SearchResultPage;
import com.seleniumAutomation.pageObjects.ShippingPage;

public class EndToEndTest extends BaseClass {
	private IndexPage indexPage;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;
	private LoginPage loginPage;
	private AddressPage addressPage;
	private ShippingPage shippingPage;
	private PaymentPage paymentPage;
	private OrderSummary orderSummary;
	private OrderConfirmationPage orderConfPage;

	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws IOException {
		BaseClass.launchApp(browser);
	}

	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}

	@Test(dataProvider = "getProduct", dataProviderClass = DataProviders.class,groups="Regression")
	public void endToEndTest(String product, String qty, String size) throws Throwable {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct(product);
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnCheckOut();
		loginPage = orderPage.clickOnCheckOut();
		addressPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"), addressPage);
		shippingPage = addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		orderSummary = paymentPage.clickOnPaymentMethod();
		orderConfPage = orderSummary.clickOnconfirmOrderBtn();
		String actualMsg = orderConfPage.validateConfirmMessage();
		String expectedMsg ="Your order on My Store is complete.";
		Assert.assertEquals(actualMsg, expectedMsg);
		
	}

}
