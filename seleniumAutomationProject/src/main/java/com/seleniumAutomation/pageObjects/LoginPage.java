package com.seleniumAutomation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.seleniumAutomation.actionDriver.ActionImpl;
import com.seleniumAutomation.base.BaseClass;

public class LoginPage extends BaseClass {

	ActionImpl action = new ActionImpl();
	
	@FindBy(xpath = "//*[@id=\"email\"]")
	private WebElement userName;

	@FindBy(xpath = "//*[@id=\"passwd\"]")
	private WebElement password;

	@FindBy(id = "SubmitLogin")
	private WebElement signInBtn;

	@FindBy(name = "email_create")
	private WebElement emailForNewAccount;

	@FindBy(name = "SubmitCreate")
	private WebElement createNewAccountBtn;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	//Polymorphism-->method overloading
	public HomePage login(String uname, String pswd) throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.click(getDriver(), signInBtn);
		return new HomePage();
	}

	//Polymorphism-->method overloading
	public AddressPage login(String uname, String pswd, AddressPage addressPage) throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.click(getDriver(), signInBtn);
		Thread.sleep(2000);
		addressPage = new AddressPage();
		return addressPage;
	}

	public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
		action.type(emailForNewAccount, newEmail);
		action.moveToElement(getDriver(), createNewAccountBtn);
		action.click(getDriver(), createNewAccountBtn);
	    action.implicitWait(getDriver(), 10);
		return new AccountCreationPage();
	}

}
