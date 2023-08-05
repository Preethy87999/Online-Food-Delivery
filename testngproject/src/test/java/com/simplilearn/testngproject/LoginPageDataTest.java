package com.simplilearn.testngproject;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageDataTest {

	ChromeDriver driver;
	LoginPageData page;
	SearchProduct product;
	
	
	
	@BeforeMethod
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		page = new LoginPageData(driver);
		//product = new SearchProduct(driver);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test
	public void testLogin() {
		
		boolean loginResult = page.loginUser("preethycse20", "Preethy55#");
		AssertJUnit.assertTrue(loginResult);
	}
	
	
	
	@AfterMethod
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}


