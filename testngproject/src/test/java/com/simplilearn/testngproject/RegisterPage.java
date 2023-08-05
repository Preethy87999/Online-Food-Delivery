package com.simplilearn.testngproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

	private ChromeDriver driver;
	private static final String URL = "https://blacktulipflowers.in/";
	
	//Attributes
	private By email;
	private By checkbox;
	private By login;
	
	
	//Constructor
	public RegisterPage(ChromeDriver driver) {
		this.driver = driver;
		this.driver.get(URL);
		
		initailzedWebElements();
	}
	
	//Methods
	public void initailzedWebElements() {
		email = By.id("reg_email");
		checkbox = By.id("register-policy");   
		login = By.cssSelector("button[value='Sign In']");
	}
	
	public void registerData(String loginEmailText,String checkboxdata) {
		
		driver.findElement(By.xpath("(//i[@class='w-icon-account'])[1]")).click();
		driver.findElement(By.cssSelector(".nav-link[href='signup']")).click();
		driver.findElement(email).sendKeys(loginEmailText);
		driver.findElement(checkbox).isSelected();
		driver.findElement(By.cssSelector("button[value='Sign Up']")).click();
		String tdata = driver.findElement(By.cssSelector(".submit-status")).getText();
		System.out.println(tdata);
	}
}
