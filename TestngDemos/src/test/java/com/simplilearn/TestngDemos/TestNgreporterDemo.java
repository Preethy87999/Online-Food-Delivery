package com.simplilearn.TestngDemos;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgreporterDemo {

	@Test
	public void testReport() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		Reporter.log("ChromeDriver Initialized");
		driver.manage().window().maximize();
		Reporter.log("Browser window Maximized");
		
		driver.get("https://www.google.com");
		Reporter.log("Web Page Google Opened");
		
		driver.close();
		Reporter.log("Application Closed...");
		
	}
}
