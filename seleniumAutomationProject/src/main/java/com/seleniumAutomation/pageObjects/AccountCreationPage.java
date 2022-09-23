package com.seleniumAutomation.pageObjects;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumAutomation.actionDriver.Action;
import com.seleniumAutomation.base.BaseClass;

public class AccountCreationPage extends BaseClass {
	
	@FindBy(xpath = "//*[@id=\"noSlide\"]/h1")
	private WebElement formTitle;
	
//	@FindBy(id = "uniform-id_gender1")
//	private WebElement mr;
//	
//	@FindBy(id = "id_gender2")
//	private WebElement mrs;
//
//	@FindBy(name = "customer_firstname")
//	private WebElement firstName;
//
//	@FindBy(name = "customer_lastname")
//	private WebElement lastName;
//
//	@FindBy(name = "passwd")
//	private WebElement passWord;
//
//	@FindBy(name = "days")
//	private WebElement days;
//
//	@FindBy(name = "months")
//	private WebElement months;
//
//	@FindBy(name = "years")
//	private WebElement years;
//
//	@FindBy(name = "firstname")
//	private WebElement customerNirstName;
//
//	@FindBy(name = "lastname")
//	private WebElement customerLastName;
//
//	@FindBy(name = "company")
//	private WebElement companyName;
//
//	@FindBy(name = "address1")
//	private WebElement address;
//
//	@FindBy(name = "city")
//	private WebElement city;
//
//	@FindBy(name = "id_state")
//	private WebElement state;
//
//	@FindBy(name = "postcode")
//	private WebElement postCode;
//
//	@FindBy(name = "id_country")
//	private WebElement country;
//
//	@FindBy(name = "phone")
//	private WebElement phone;
//
//	@FindBy(name = "phone_mobile")
//	private WebElement mobile;
//
//	@FindBy(name = "alias")
//	private WebElement ref;

	@FindBy(name = "submitAccount")
	private WebElement registerBtn;
	
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public HomePage validateRegistration() throws Throwable {
		registerBtn.click();
		return new HomePage();
	}
	
	public boolean validateAcountCreatePage() throws Throwable {
		 return Action.isDisplayed(getDriver(), formTitle);
	}
	
}
