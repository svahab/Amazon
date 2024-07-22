package org.amazon.tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.amazon.pages.AddToCart;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddCartTest extends Browser
{

	public WebDriver driver;
	
	@BeforeTest
	public void intializeBrowser() throws IOException
	{
		driver=getBrowser();
		driver.get("http://www.amazon.in/");
	}
	
	@Test
	public void getText() throws InterruptedException 
	{
		AddToCart ac=new AddToCart(driver);
		ac.title1();
		
		ac.searchResults1().sendKeys("realme x2 pro");
		
		
		ac.clickSearch1().click();
		
		ac.isDisplayed1();
	
		ac.clickText1().click();
		
	   // ac.getWindow();
		
		
		
		
		 Set<String> window = driver.getWindowHandles();
		  Iterator<String> iterator = window.iterator();
		  String parent =iterator.next();
		  String child = iterator.next();
		  
		  driver.switchTo().window(child);
		 
//		  WebDriverWait wait=new WebDriverWait(driver,10);
//		  wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
		  Thread.sleep(6000L);
		  
	   ac.clickAdd();
	}
	
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
}
