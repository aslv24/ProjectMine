package com.pm.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseClass {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static void setDriver(String browserName) {

		switch (browserName.toLowerCase()) {
		case "chrome":
			System.setProperty(PropertyReader.getProperty("chromeKey"), PropertyReader.getProperty("chromeValue"));
			driver.set(new ChromeDriver());
			break;

		case "edge":
			System.setProperty(PropertyReader.getProperty("edgeKey"), PropertyReader.getProperty("edgeValue"));
			driver.set(new EdgeDriver());
			break;

		case "firefox":
			System.setProperty(PropertyReader.getProperty("firefoxKey"), PropertyReader.getProperty("firefoxValue"));
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--allow-system-access");
			driver.set(new FirefoxDriver(options));
			break;

		default:
			String errorMessage = "❌ Undefined Browser Setup: '" + browserName
					+ "'. Please check browser configuration...";
			System.err.println(errorMessage);
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static WebDriver getDriver() {
		return driver.get();

	}
}
