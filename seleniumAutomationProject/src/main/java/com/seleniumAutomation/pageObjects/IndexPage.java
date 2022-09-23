package com.seleniumAutomation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.seleniumAutomation.actionDriver.ActionImpl;
import com.seleniumAutomation.base.BaseClass;

public class IndexPage extends BaseClass {
	ActionImpl action = new ActionImpl();

	@FindBy(xpath = "//a[@class='login']")
	private WebElement signInBtn;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement myStoreLogo;

	@FindBy(id = "search_query_top")
	private WebElement searchProductBox;

	@FindBy(name = "submit_search")
	private WebElement searchButton;

	// when IndexPage class is called this constructor would be called and all the
	// webelements would be initialized
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public LoginPage clickOnSignIn() throws Throwable {
		action.fluentWait(getDriver(), signInBtn, 10);
		action.click(getDriver(), signInBtn);
		return new LoginPage();
	}

	public boolean validateLogo() throws Throwable {
		return action.isDisplayed(getDriver(), myStoreLogo);
	}

	public String getMyStoreTitle() {
		String myStoreTitle = getDriver().getTitle();
		return myStoreTitle;
	}

	public SearchResultPage searchProduct(String productName) throws Throwable {
		action.type(searchProductBox, productName);
		action.scrollByVisibilityOfElement(getDriver(), searchButton);
		action.click(getDriver(), searchButton);
		return new SearchResultPage();
	}

}
