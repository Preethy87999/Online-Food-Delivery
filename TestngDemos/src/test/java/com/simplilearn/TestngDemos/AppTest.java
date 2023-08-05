package com.simplilearn.TestngDemos;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest 
{
	ChromeDriver driver;
	
	@BeforeTest
	public void  launchBrowser() {
	       WebDriverManager.chromedriver().setup();
	       driver = new ChromeDriver();
	       driver.get("https://simplilearn.net/");
	       System.out.println("BeforeTest: launchbrowser");
	}
	@Test
	public void verifyHomePage() {
		String expectedTitle = "Simplilearn | Online Courses - Bootcamp & Certification Platform";
		String actualTitle = driver.getTitle();
		AssertJUnit.assertEquals(actualTitle, expectedTitle);
		
		System.out.println("Test: verify homepage");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		System.out.println("AfterTest: closeBrowser");
	}
}