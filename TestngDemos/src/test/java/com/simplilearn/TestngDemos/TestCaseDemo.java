package com.simplilearn.TestngDemos;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCaseDemo {

	ChromeDriver driver;
	String url;
	@BeforeMethod
	public void init() {
		WebDriverManager.chromedriver().setup();
	       driver = new ChromeDriver();
	       url = "https://newsapi.org/";
	}
	
	@Test
	public void testCase() {
		driver.get(url);
		String expectedTitle = "News API – Search News and Blog Articles on the Web";
		String actualTitle = driver.getTitle();
		AssertJUnit.assertEquals(actualTitle, expectedTitle);
	}
	
	@AfterMethod
	public void destroy() {
		driver.close();
	}
}
