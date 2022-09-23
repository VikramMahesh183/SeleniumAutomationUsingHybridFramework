package com.seleniumAutomation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.seleniumAutomation.actionDriver.ActionImpl;
import com.seleniumAutomation.base.BaseClass;

public class AddressPage extends BaseClass {
	ActionImpl action = new ActionImpl();
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckOut;
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public ShippingPage clickOnCheckOut() throws Throwable {
		action.click(getDriver(), proceedToCheckOut);
		return new ShippingPage();
	}
	
}
