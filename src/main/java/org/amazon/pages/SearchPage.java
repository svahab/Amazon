package org.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

public class SearchPage {

	public WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);;
	}
	
	
	@FindBy(id="twotabsearchtextbox") WebElement search;
	@FindBy(id="nav-search-submit-button") WebElement searchclick;
	@FindBy(xpath="//div[@data-asin='B082B3G9DV']//div[@class='a-section a-spacing-none']/h2/a") WebElement element;
	
	
	public void title()
	{
	String homeTitle=driver.getTitle();
	System.out.println(homeTitle);
	}
	
	public WebElement searchResults()
	{
		return search;
	}
	
	public WebElement clickSearch()
	{
		return searchclick;
	}
	
	public WebElement isDisplayed()
	{
		/*
		 * String actual="Realme X2 Pro (Neptune Blue, 8GB RAM, 128GB Storage)";
		 * Assert.assertEquals(actual, element.getText());
		 */
		System.out.println(element.isDisplayed());
		return element;
	}
	
}
