package org.amazon.tests;

import java.io.IOException;

import org.amazon.pages.AmazonPayPage;
import org.amazon.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonTests extends Browser {
	public WebDriver driver;

	@BeforeTest
	public void getInitialize() throws IOException {
		driver = getBrowser();
		driver.get("http://www.amazon.in/");
	}

	@Test
	public void setUp() throws InterruptedException
	{

		HomePage hp = new HomePage(driver);
		hp.getTitleName();

		hp.getLink().click();
		hp.getPayTitle();

		hp.navBack();

		hp.getHoemTitle();
		hp.verifyTitle();

		
	}

	@AfterTest
	public void tearDown3() {
		driver.close();
	}
}
