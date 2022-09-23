package com.seleniumAutomation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.seleniumAutomation.actionDriver.ActionImpl;
import com.seleniumAutomation.base.BaseClass;

public class PaymentPage extends BaseClass {
	
	ActionImpl action = new ActionImpl();
	
	@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
	private WebElement bankWireMethod;
	
	@FindBy(xpath = "//a[contains(text(),'Pay by check')]")
	private WebElement payByCheckMethod;
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSummary clickOnPaymentMethod() throws Throwable {
		action.click(getDriver(), bankWireMethod);
		return new OrderSummary();
	}

}
