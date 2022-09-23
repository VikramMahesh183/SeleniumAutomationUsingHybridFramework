package com.seleniumAutomation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumAutomation.actionDriver.Action;
import com.seleniumAutomation.base.BaseClass;

public class OrderPage extends BaseClass {
	
	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	private WebElement unitPrice;
	
	@FindBy(id="total_price")
	private WebElement totalPrice;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckOut;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public double getUnitPrice() {
		Action.fluentWait(getDriver(), unitPrice, 10);
		String unitPrice1=unitPrice.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");//to remove all special char-->1651
		double finalUnitPrice=Double.parseDouble(unit);//to convert string to double
		return finalUnitPrice/100;//-->16.51
	}
	
	public double getTotalPrice() {
		String totalPrice1=totalPrice.getText();
		String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalTotalPrice=Double.parseDouble(tot);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOnCheckOut() throws Throwable {
		Action.click(getDriver(), proceedToCheckOut);
		return new LoginPage();
	}
	
}
