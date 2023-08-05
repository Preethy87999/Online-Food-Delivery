package com.simplilearn.onlinefood;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest 
{
	ChromeDriver driver;
	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Reporter.log("ChromeDriver Initialized");
		driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
	     driver.get("https://www.pizzahut.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Lanuch of Page");
	}
	
	@Test
	public void verifyHomePage() {
		String expectedTitle = "Order Pizza Online - Delivery and Takeaway";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Test: verify homepage");
		
	}
	
	@Test
	public void searchLocation() throws InterruptedException {
		
     	driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Chennai Institute of Technology, Sarathy Nagar, Kundrathur, Chennai, Tamil Nadu, India");
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div/div/div/div[1]/div[2]")).click();
	     
	     driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/form/div/div[2]/div/button")).click();
	    Thread.sleep(2000);
	   
	     driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/button")).click();
	     Thread.sleep(1000);
	     driver.findElement(By.cssSelector(".button.button--secondary.text-center")).click();
         String expectedUrl = "https://www.pizzahut.co.in/order/deals/";
	     String actualUrl = driver.getCurrentUrl();
	     Assert.assertEquals(actualUrl,expectedUrl);
	     
	     driver.findElement(By.xpath("(//div[contains(@class,'list-item__image')])[2]")).click();
	     Thread.sleep(1000);
	     driver.findElement(By.cssSelector(".button.button--green.mb-10")).click();
	     String productName = "Awesome American Cheesy";
	     
	     List<WebElement> listitem = driver.findElements(By.cssSelector(".typography-4.list-item__name.flex-1.px-10.pt-10"));

	     for(int i=0;i<listitem.size();i++)
	     {
	     String product = listitem.get(i).getText();
	     if(product.contains("Awesome American Cheesy"))
         {
	     driver.findElements(By.cssSelector(".button.button--md.button--green.flex-1.font-semibold")).get(i).click();
	     break;
	     }
	     } 
	     driver.findElement(By.linkText("Sides")).click();
	     
	     String productName1 = "Spicy Baked Chicken Wings";
	     List<WebElement> listitem1 = driver.findElements(By.cssSelector(".typography-4.list-item__name.flex-1.px-10.pt-10"));

	     for(int i=0;i<listitem1.size();i++)
	     {
	     String product = listitem1.get(i).getText();
	     if(product.contains("Spicy Baked Chicken Wings"))
	     {
	     driver.findElements(By.cssSelector(".button.button--md.button--green.flex-1.font-semibold")).get(i).click();
	     break;
	     }
	     } 

	     driver.findElement(By.linkText("Drinks")).click();
	     
	     String productName3 = "Mirinda";
	     List<WebElement> listitem3 = driver.findElements(By.cssSelector(".typography-4.list-item__name.flex-1.px-10.pt-10"));

	     for(int i=0;i<listitem3.size();i++)
	     {
	     String product = listitem3.get(i).getText();
	     if(product.contains("Mirinda"))
	     {
	     driver.findElements(By.cssSelector(".button.button--md.button--green.flex-1.font-semibold")).get(i).click();
	     break;
	     }
	     } 
	     driver.findElement(By.className("basket-checkout")).click();
	     Thread.sleep(1000);

	     String expectedUrl2 = "https://www.pizzahut.co.in/order/checkout/";
	     String actualUrl2 = driver.getCurrentUrl();
	     Assert.assertEquals(actualUrl2,expectedUrl2);
	    
	    driver.findElement(By.id("checkout__name")).sendKeys("Priya");
	    driver.findElement(By.id("checkout__phone")).sendKeys("9888458864");
	    driver.findElement(By.id("checkout__email")).sendKeys("priya@gmail.com");
	    driver.findElement(By.cssSelector(".sc-fzqMdD.eohbfP")).click();
	    driver.findElement(By.xpath("//button[normalize-space()='Cancel']")).click();
	   

	}
	
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
		driver.close();
		
		System.out.println("AfterTest: closeBrowser");
		
	}
}