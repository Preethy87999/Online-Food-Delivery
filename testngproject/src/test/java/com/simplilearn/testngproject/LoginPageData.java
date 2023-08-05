package com.simplilearn.testngproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageData {

	private ChromeDriver driver;
	private static final String URL = "https://blacktulipflowers.in/";
	
	//Attributes
	private By email;
	private By password;
	private By login;
	
	
	//Constructor
	public LoginPageData(ChromeDriver driver) {
		this.driver = driver;
		this.driver.get(URL);
		
		initailzedWebElements();
	}
	
	//Methods
	public void initailzedWebElements() {
		email = By.id("username");
		password  = By.id("password");
		login = By.cssSelector("button[value='Sign In']");
	}
	
	public boolean loginUser(String loginEmailText, String loginPasswordText) {
		driver.findElement(By.xpath("(//i[@class='w-icon-account'])[1]")).click();
		driver.findElement(email).sendKeys(loginEmailText);
		driver.findElement(password).sendKeys(loginPasswordText);
		driver.findElement(login).click();
		
		String afterloginURL = "https://blacktulipflowers.in/";
		boolean until = new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions.urlToBe(afterloginURL));
		
		return until;
	}
	
	

}
