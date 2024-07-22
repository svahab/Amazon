package org.amazon.tests;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser 
{

	public WebDriver driver;
	
	public WebDriver getBrowser() throws IOException
	{
		Properties ps=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\vahab\\Appium-Training\\Amazon\\src\\main\\java\\org\\amazon\\tests\\data.properties");
		ps.load(fis);
	    String browserName=	ps.getProperty("browser");
	    if(browserName.equalsIgnoreCase("chrome"))
	    {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Browserdrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
	    }
		/*
		 * else if(browserName.equalsIgnoreCase("firefox")) {
		 * 
		 * } else if(browserName.equalsIgnoreCase("InternetExplorer")) {
		 * 
		 * }
		 */
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		return driver;
		
	}
}
