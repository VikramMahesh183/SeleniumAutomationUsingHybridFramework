package com.seleniumAutomation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.seleniumAutomation.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {

	@FindBy(xpath = "//p/strong[contains(text(),'Your order on My Store is complete.')]")
	private WebElement confirmMessage;

	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public String validateConfirmMessage() {
		String confirmMsg = confirmMessage.getText();
		return confirmMsg;
	}

}
