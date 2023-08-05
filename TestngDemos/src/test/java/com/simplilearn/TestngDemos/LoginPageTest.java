package com.simplilearn.TestngDemos;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {

	ChromeDriver driver;
	LoginPage page;
	
	
	
	@BeforeTest()
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		page = new LoginPage(driver);
	}
	
	@Test
	public void testLogin() {
		boolean loginResult = page.loginUser("tuser6794@gmail.com", "tuser6794@gmail.com");
		Assert.assertTrue(loginResult);
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
