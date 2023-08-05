package com.simplilearn.WebSiteTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private ChromeDriver driver;
	private static final String URL = "https://rbgeshop.org/";
	
	//Attributes
	private By email;
	private By password;
	private By login;
	
	
	//Constructor
	public LoginPage(ChromeDriver driver) {
		this.driver = driver;
		this.driver.get(URL);
		
		initailzedWebElements();
	}
	
	
	public void initailzedWebElements() {
		driver.findElement(By.cssSelector(".header__icon.header__icon--account.link.focus-inset.small-hide")).click();
		email = By.id("CustomerEmail");
		password  = By.id("CustomerPassword");
		login = By.cssSelector("form[id='customer_login'] button");
	}
	
	
	
	public boolean loginUser(String loginEmailText, String loginPasswordText) {
		driver.findElement(email).sendKeys(loginEmailText);
		driver.findElement(password).sendKeys(loginPasswordText);
		driver.findElement(login).click();
		String afterloginURL = "https://rbgeshop.org/en-us/challenge";
		boolean until = new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions.urlToBe(afterloginURL));
		
		return until;
		
		
	}
}
