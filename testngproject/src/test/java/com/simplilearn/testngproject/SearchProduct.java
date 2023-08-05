package com.simplilearn.testngproject;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchProduct {

	ChromeDriver driver;
	public static final String URL = "https://blacktulipflowers.in/";
	
	public SearchProduct(ChromeDriver driver2) {
		this.driver = driver;
		this.driver.get(URL);
		searchbar();
	}

	@Test
	public void searchbar() {
		
		driver.findElement(By.cssSelector("input[placeholder='Search in...']")).sendKeys("sweet");
		
		
	}
}
