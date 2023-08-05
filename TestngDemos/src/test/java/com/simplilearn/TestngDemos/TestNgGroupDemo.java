package com.simplilearn.TestngDemos;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgGroupDemo {

	ChromeDriver driver;
	
	@BeforeTest
	public void before() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test(groups = {"testgroup1"})
	public void testTitle() {
		driver.get("https://newsapi.org/");
		String expectedTitle = "News API – Search News and Blog Articles on the Web";
		String actualTitle = driver.getTitle();
		AssertJUnit.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(groups = {"testgroup2"})
	public void testClick() {
		driver.get("https://newsapi.org/");
		driver.findElement(By.xpath("/html/body/header/div/nav[1]/div[1]/a")).click();
		String expectedUrl = "https://newsapi.org/docs/get-started";
		String actualUrl = driver.getTitle();	
		AssertJUnit.assertEquals(actualUrl, expectedUrl);
	}
	
	@AfterTest
	public void after() {
		driver.close();
	}
}
