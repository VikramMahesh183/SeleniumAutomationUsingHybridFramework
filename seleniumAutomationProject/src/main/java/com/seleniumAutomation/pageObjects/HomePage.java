package com.seleniumAutomation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumAutomation.actionDriver.Action;
import com.seleniumAutomation.base.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(xpath="//span[text()='My wishlists']")
	private WebElement myWishList;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	private WebElement orderHistory;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	
	public boolean validateMyWishList() throws Throwable {
		return Action.isDisplayed(getDriver(), myWishList);
	}
	
	public boolean validateOrderHistory() throws Throwable {
		return Action.isDisplayed(getDriver(), orderHistory);
	}
	
	public String getCurrURL() throws Throwable {
		String homePageURL=getDriver().getCurrentUrl();
		return homePageURL;
	}
}
