package org.amazon.tests;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.amazon.pages.AmazonPayPage;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AmazonPayTest extends Browser
{
	public WebDriver driver;
	
	DataFormatter formatter =new DataFormatter();

	@BeforeTest
	public void getPayPage() throws IOException
	{
		driver=getBrowser();
		//driver.get("http://www.amazon.in/");
	}
	
	@Test(dataProvider="data")
	public void getProvider(String mobilenum) throws InterruptedException
	{
		driver.get("http://www.amazon.in/");
		AmazonPayPage ap = new AmazonPayPage(driver);
		ap.getPaylink().click();

		ap.getMRecharge().click();
		Thread.sleep(1000L);
		ap.getNumber1().sendKeys(mobilenum);
		Thread.sleep(1000L);
		//ap.getOperator().click();
		Thread.sleep(1000L);
		
		//sim
		
		ap.getPlan().click();
		Thread.sleep(1000L);
	
		
	    ap.getPlans().click();
		Thread.sleep(1000L);
		ap.continuePay().click();
		Thread.sleep(4000L);
		ap.getLoginPage();
		//System.out.println("Mobile no="+" "+mobilenum);
		
	}

	@DataProvider(name="data")
	public Object[][] getData() throws IOException
	{

		File fi=new File("C:\\Users\\vahab\\ExcelFiles\\ExcelSheet1.xlsx");
		FileInputStream fis=new FileInputStream(fi);
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet sheet=  wb.getSheetAt(0);
        int rowcount= sheet.getPhysicalNumberOfRows();
        XSSFRow row= sheet.getRow(0);
       int colCount= row.getLastCellNum();
       Object data[][] =new Object[rowcount-1][colCount];
       for(int i=0;i<rowcount-1;i++)
       {
    	  row= sheet.getRow(i+1);
    	   for(int j=0;j<colCount;j++)
    	   {
    		   
    		   XSSFCell cell=row.getCell(j);
    		   
    		   data[i][j]=formatter.formatCellValue(cell);
    	   }
       }
        return data;
		
		
	
		
	}
	
	
	  @AfterTest 
	  public void tearDown4()
	  {
		  driver.close(); 
	  }
	 
}
