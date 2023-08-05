package com.simplilearn.WebSiteTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BookStore {

	ChromeDriver driver;
	LoginPage page;
	
	@BeforeSuite
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Reporter.log("ChromeDriver Initialized");
		driver.manage().window().maximize();
		page = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Lanuch of Page"); 
		
	}
	
	@Test(priority=1)
	public void verifyHomePage() {
		String expectedTitle = "Account – The Botanics Shop at Royal Botanic Garden Edinburgh";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Test: verify homepage");
		Reporter.log("HomePage...");
	}
	
	@Test(priority=2)
	public void verifyLogin() {
		boolean loginResult = page.loginUser("preethycse20@gmail.com", "Preethy58#");
		Assert.assertTrue(loginResult);
		System.out.println("Test: verify Loginpage");
		Reporter.log("LoginPage...");
	}
	
	@Test(priority=7)
	public void errorLogin() {
		boolean loginResult = page.loginUser("preethycse20@gmail.com", "Preethy5#");
		Assert.assertTrue(loginResult);
		Reporter.log("Error LoginPage...");
	}
	
	@Test(priority=5)
	public void cartAdd() {
		driver.get("https://rbgeshop.org/products/discover-the-botanic-cottage?_pos=1&_psq=disc&_ss=e&_v=1.0");
		driver.findElement(By.id("ProductSubmitButton-template--16038120980634__main")).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String addedItem = driver.findElement(By.cssSelector(".cart-notification-product__name.h4")).getText();
		System.out.println(addedItem);
		driver.findElement(By.xpath("//button[@class='cart-notification__close modal__close-button link link--text focus-inset']//*[name()='svg']")).click();
		driver.findElement(By.id("cart-icon-bubble")).click();
        driver.findElement(By.cssSelector(".icon.icon-cart")).getText();
        String expectedItem = driver.findElement(By.cssSelector(".cart-item__name.h4.break")).getText();
        Assert.assertEquals(addedItem,expectedItem);
        System.out.println("Test: verify Cartpage");
        Reporter.log("CartPage..");
	}
	
	@Test(priority=4)
	public void searchBox() {
		
		//driver.get("https://rbgeshop.org/");
		driver.findElement(By.xpath("(//*[name()='svg'][@class='modal__toggle-open icon icon-search'])[1]")).click();
		driver.findElement(By.id("Search-In-Modal")).sendKeys("Discover the Botanic Cottage");
		driver.findElement(By.cssSelector("button[aria-label='Search']")).click();
		String expectedUrl = "https://rbgeshop.org/en-us/search?q=Discover+the+Botanic+Cottage&options%5Bprefix%5D=last";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		System.out.println("Test: verify Searchpage");
		Reporter.log("SearchPage...");
	}
	@Test(priority=3)
	public void registerPage() {
		driver.findElement(By.cssSelector(".header__icon.header__icon--account.link.focus-inset.small-hide")).click();
		driver.findElement(By.linkText("Create account")).click();
		driver.findElement(By.id("RegisterForm-FirstName")).sendKeys("Preethy");
		driver.findElement(By.id("RegisterForm-LastName")).sendKeys("V S");
		driver.findElement(By.id("RegisterForm-FirstName")).clear();
		driver.findElement(By.id("RegisterForm-LastName")).clear();
		System.out.println("Test: verify hRegisterpage");
		Reporter.log("RegisterPage ...");
	}
	
	
	@AfterSuite(alwaysRun=true)
	public void closeBrowser() {
		driver.close();
		Reporter.log("Application Closed...");
		System.out.println("AfterTest: closeBrowser");
		
	}
}
