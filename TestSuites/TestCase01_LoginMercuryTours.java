package com.web.framework.automation.TestSuites;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.web.framework.automation.Data.ReadExcel;
import com.web.framework.automation.DriverFactory.DriverFactory;

public class TestCase01_LoginMercuryTours extends DriverFactory {
	WebDriver driver;
	
	@FindBy(name = "userName")
	@CacheLookup
	WebElement username;

	@FindBy(name = "password")
	@CacheLookup
	WebElement password;

	@FindBy(xpath = "//a[text()='SIGN-OFF']")
	@CacheLookup
	WebElement signOff;

	@FindBy(xpath = "//input[@value='Login' or @name='login']")
	@CacheLookup
	WebElement submit;

	@DataProvider
	public String[][] getTestData() throws IOException {
		ReadExcel read = new ReadExcel();
		System.out.println(read.getData());
		return read.getData();
	}

	@BeforeMethod
	public void setUp() {
    this.driver = DriverFactory.getInstance("CHROME");
		PageFactory.initElements(driver, this);
	}

	@Test(dataProvider = "getTestData")
	public void loginTest(String usernameData, String passwordData) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/mercurysignon.php");
		username.sendKeys(usernameData);
		password.sendKeys(passwordData);
		submit.click();
		Assert.assertEquals("SIGN-OFF", signOff.getText());
		driver.close();
	}

}
