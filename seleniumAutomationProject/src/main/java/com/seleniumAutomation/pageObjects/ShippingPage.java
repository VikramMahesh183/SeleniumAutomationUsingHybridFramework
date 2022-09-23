package com.seleniumAutomation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.seleniumAutomation.actionDriver.ActionImpl;
import com.seleniumAutomation.base.BaseClass;

public class ShippingPage extends BaseClass {
	
	ActionImpl action = new ActionImpl();
	
	@FindBy(id="cgv")
	private WebElement terms;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void checkTheTerms() throws Throwable {
		action.click(getDriver(), terms);
	}
	
	public PaymentPage clickOnProceedToCheckOut() throws Throwable {
		action.click(getDriver(), proceedToCheckOutBtn);
		return new PaymentPage();
	}

}
