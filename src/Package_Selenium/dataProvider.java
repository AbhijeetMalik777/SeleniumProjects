package Package_Selenium;

import java.io.FileInputStream;
//import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {
	DataFormatter formatter = new DataFormatter();
	@Test(dataProvider ="testData")
	public void testcaseData (String Login, String Password)
	
	
	{
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.cssSelector("input[placeholder = 'Email address or phone number']")).sendKeys(Login);
		driver.findElement(By.id("pass")).sendKeys(Password);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		driver.quit();
		
		//System.out.println(Login+ " " + Password);
	}
	
	@DataProvider(name="testData")
	public Object[][] getdataProvider() throws IOException {
	
	FileInputStream file = new FileInputStream ("C:\\Users\\abhij\\OneDrive\\Desktop\\TestData01.xlsx");
	XSSFWorkbook book= new XSSFWorkbook(file);
	XSSFSheet sheet = book.getSheetAt(0);
	int rowCount = sheet.getPhysicalNumberOfRows();
	XSSFRow row = sheet.getRow(0);
	int colCount = row.getLastCellNum();
	Object data [][] =new Object [rowCount-1][colCount];
	for (int i = 0; i<rowCount-1;i++)
		{
			row = sheet.getRow(i+1);
			for(int j=0; j<colCount ; j++)
			{
				XSSFCell cell =row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
			}
		}
return data;
	}
}