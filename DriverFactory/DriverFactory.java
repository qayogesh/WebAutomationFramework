package com.web.framework.automation.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	public static WebDriver driver;

	public  static WebDriver getInstance(String browserName) {
		if (browserName.toUpperCase() == "CHROME") {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Projects\\automation\\src\\resources\\Application\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.toUpperCase() == "IE") {
			System.setProperty("webdriver.ie.driver",
					"C:\\Projects\\automation\\src\\resources\\Application\\iexplore.exe");
			driver = new InternetExplorerDriver();
		}
		return driver;
	}

}
