package org.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

	public WebDriver driver;
	
	String actualTitile;
	String homeTitle;
	String paytitle;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@id='nav-xshop']/a[3]")
	WebElement paylink;

	
	public void getTitleName() {
		actualTitile = driver.getTitle();
		System.out.print(actualTitile + " ");
	}

	public WebElement getLink() {
		return paylink;
	}

	public String getPayTitle() {
		 paytitle = driver.getTitle();
		System.out.println("AmazonPay title =" + " " + paytitle);
		return paytitle;
	}

	public void navBack() {
		driver.navigate().back();

	}

	public String getHoemTitle() {
		homeTitle = driver.getTitle();
		System.out.println(homeTitle);
		return homeTitle;
	}

	public void verifyTitle() {
		Assert.assertEquals(actualTitile, homeTitle);
	}
}
