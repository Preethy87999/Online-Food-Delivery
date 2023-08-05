package com.simplilearn.webtesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest 
{
	WebDriver driver;
	String url ="https://blacktulipflowers.in/flowers/flower-delivery-chennai/?gclid=Cj0KCQjwjryjBhD0ARIsAMLvnF8_deDwW5oNBNT0TI6g6bWBV8CG2qvX3R-4OyFTNdgKBE_SdG9Sa0waAt0GEALw_wcB";
    
	@BeforeTest
	void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@AfterTest
	void tearDown() {
		driver.quit();
	}
}
