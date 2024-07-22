package org.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AmazonPayPage {

	public WebDriver driver;
	
	
	public AmazonPayPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//div[@id='nav-xshop']/a[3]")
	WebElement linkpay;
	
	@FindBy(xpath = "//div[@id='MobileRecharge']/span/a/div[2]")
	WebElement mrecharge;
	
	@FindBy(id="mobileNumberTextInputId")
	WebElement phnum;
	
	//click on operator div
	/*
	 * @FindBy(id="operatorAndCircleTextInputId") WebElement operator;
	 */
	
	//click on sim name
	@FindBy(xpath="//label/input[@value='Jio~JIO_PRE']")
	WebElement sim;
	
	@FindBy(id="amountTextInputId")
	WebElement rechargeclick;
	
	@FindBy(xpath="//*[@id=\"RECOMMENDED\"]/tbody/tr[1]/td/div[1]/div[2]/span/span/input")
	WebElement plan;
	
	@FindBy(id="payButtonText")
	WebElement continuepay;
	
	
	public WebElement getPaylink()
	{
		return linkpay; 
	}
	
	public WebElement getMRecharge()
	{
		return mrecharge; 
	}
	
	

	public WebElement getNumber1() {
		
		return phnum;
	}
	
//	public WebElement getOperator() {
//		
//		return operator;
//	}
	
	//sim
    public WebElement getSim() {
		
		return sim;
	}
	
	public WebElement getPlan() {
		
		return rechargeclick;
	}
	
	public WebElement getPlans() {
		
		return plan;
	}
	
	public WebElement continuePay() {
		
		return continuepay;
	}
	
	public void getLoginPage()
	{
		String actual=driver.getTitle();
		System.out.println(actual);
		String expected="Amazon Sign In";
	Assert.assertEquals(actual, expected);
	}
	
}
