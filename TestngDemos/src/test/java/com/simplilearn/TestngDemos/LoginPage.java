package com.simplilearn.TestngDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private ChromeDriver driver;
	private static final String URL = "https://newsapi.org/login";
	
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
	
	//Methods
	public void initailzedWebElements() {
		email = By.id("Email");
		password  = By.id("Password");
		login = By.tagName("button");
	}
	
	public boolean loginUser(String loginEmailText, String loginPasswordText) {
		driver.findElement(email).sendKeys(loginEmailText);
		driver.findElement(password).sendKeys(loginPasswordText);
		driver.findElement(login).click();
		
		String afterloginURL = "https://newsapi.org/account";
		boolean until = new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions.urlToBe(afterloginURL));
		
		return until;
	}
}
