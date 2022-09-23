package com.seleniumAutomation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumAutomation.actionDriver.Action;
import com.seleniumAutomation.base.BaseClass;

public class LoginPage extends BaseClass {

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

	public HomePage login(String uname, String pswd) throws Throwable {
		Action.scrollByVisibilityOfElement(getDriver(), userName);
		Action.type(userName, uname);
		Action.type(password, pswd);
		Action.click(getDriver(), signInBtn);
		return new HomePage();
	}

	public AddressPage login(String uname, String pswd, AddressPage addressPage) throws Throwable {
		Action.scrollByVisibilityOfElement(getDriver(), userName);
		Action.type(userName, uname);
		Action.type(password, pswd);
		Action.click(getDriver(), signInBtn);
		Thread.sleep(2000);
		addressPage = new AddressPage();
		return addressPage;
	}

	public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
		Action.type(emailForNewAccount, newEmail);
		Action.moveToElement(getDriver(), createNewAccountBtn);
		Action.click(getDriver(), createNewAccountBtn);
	    Action.implicitWait(getDriver(), 10);
		return new AccountCreationPage();
	}

}
