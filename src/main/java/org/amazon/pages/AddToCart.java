package org.amazon.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart 
{

	public WebDriver driver;

	public AddToCart(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "twotabsearchtextbox")
	WebElement search1;
	
	@FindBy(id = "nav-search-submit-button")
	WebElement searchclick1;
	
	@FindBy(xpath = "//div[@data-asin='B082B3G9DV']/div/span/div/div/div[2]/div[2]/div/div/div[1]/h2/a/span")
	WebElement element1;
	
	@FindBy(xpath = "//div[@data-asin='B082B3G9DV']/div/span/div/div/div[2]/div[2]/div/div/div[1]/h2/a/span")
	WebElement text1;
	
	@FindBy(id="add-to-cart-button")
	WebElement addcart;
	

	public void title1() 
	{
		String homeTitle = driver.getTitle();
		System.out.println(homeTitle);
	}

	public WebElement searchResults1() 
	{
		return search1;
	}

	public WebElement clickSearch1()
	{
		return searchclick1;
	}

	public WebElement isDisplayed1() 
	{
		/*
		 * String actual="Realme X2 Pro (Neptune Blue, 8GB RAM, 128GB Storage)";
		 * Assert.assertEquals(actual, element.getText());
		 */
		System.out.println(element1.isDisplayed());
		return element1;
	}

	public WebElement clickText1()
	{
		return text1;
	}

	/*
	 * public void getWindow()
	 *  {
	 *   Set<String> window = driver.getWindowHandles();
	 * Iterator<String> iterator = window.iterator(); String parent =
	 * iterator.next(); String child = iterator.next();
	 * 
	 * driver.switchTo().window(child);
	 */
		

	

	public void clickAdd() 
	{
		
		Actions action = new Actions(driver);

		action.moveToElement(addcart).click().perform();
	}

}
