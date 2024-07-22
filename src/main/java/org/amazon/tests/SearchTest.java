package org.amazon.tests;

import java.io.IOException;

import org.amazon.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchTest extends Browser{

	
	public WebDriver driver;
	
	@BeforeTest
	public void getInitialize() throws IOException
	{
		driver=getBrowser();
		driver.get("http://www.amazon.in/");
	}
	
	@Test
	public void pages() throws InterruptedException
	{
		
		SearchPage sp=new SearchPage(driver);
		sp.title();
        sp.searchResults().sendKeys("realme x2 pro");
    	Thread.sleep(1000L);
		sp.clickSearch().click();
		Thread.sleep(1000L);
		sp.isDisplayed();
	    
	}
	
	@AfterTest
	public void tearDown1()
	{
		driver.close();
	}
}
