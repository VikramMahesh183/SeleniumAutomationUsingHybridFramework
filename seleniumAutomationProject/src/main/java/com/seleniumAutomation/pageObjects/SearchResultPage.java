package com.seleniumAutomation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumAutomation.actionDriver.Action;
import com.seleniumAutomation.base.BaseClass;

public class SearchResultPage extends BaseClass {
	
	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	private WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable() throws Throwable {
		return Action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCartPage clickOnProduct() throws Throwable {
		Action.click(getDriver(), productResult);
		return new AddToCartPage();
	}
	
}
