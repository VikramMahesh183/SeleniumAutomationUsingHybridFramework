package com.seleniumAutomation.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.seleniumAutomation.actionDriver.Action;
import com.seleniumAutomation.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	// public static WebDriver driver;

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void loadConfig() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		try {
			prop = new Properties();
			System.out.println("super constructor is invoked");
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void launchApp(String browserName) throws IOException {

		// String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// driver = new ChromeDriver();
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}

		Action.implicitWait(getDriver(), 200);
		Action.pageLoadTimeOut(getDriver(), 200);
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().window().maximize();

	}

	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}

}
