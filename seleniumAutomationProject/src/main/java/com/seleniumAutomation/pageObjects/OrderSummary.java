package com.seleniumAutomation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.seleniumAutomation.actionDriver.ActionImpl;
import com.seleniumAutomation.base.BaseClass;

public class OrderSummary extends BaseClass {
	
	ActionImpl action = new ActionImpl();
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	private WebElement confirmOrderBtn;
	
	public OrderSummary() {
		PageFactory.initElements(getDriver(), this);
	}

	public OrderConfirmationPage clickOnconfirmOrderBtn() throws Throwable {
		action.click(getDriver(), confirmOrderBtn);
		return new OrderConfirmationPage();
	}
	
}
