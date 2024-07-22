package Automate.Amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import org.amazon.tests.Browser;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Checking extends Browser
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
		SimpleService sp = new SimpleService(driver);
		sp.getNumber1().sendKeys(mobilenum);
		sp.getOperator().click();
	
	
	
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
}
