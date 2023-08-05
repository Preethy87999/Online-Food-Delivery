package com.simplilearn.onlinefood;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class cart {
ChromeDriver driver;
public cart(ChromeDriver driver) {
	this.driver = driver;
	
}
	public  void cartPage() {
		List<WebElement> listitem = driver.findElements(By.cssSelector(".typography-4.list-item__name.flex-1.px-10.pt-10"));
		int j=0;
		
		for(int i=0;i<listitem.size();i++)
	     {
		 j++;
	     String product = listitem.get(i).getText();
	     String productName = null;
		if(product.contains(productName))
	     {
	     driver.findElements(By.cssSelector(".button.button--md.button--green.flex-1.font-semibold")).get(i).click();
	     //break;
	     if(j==productName.length()) {
	    	 break;
	     }
	     }
	     } 
	}
}
