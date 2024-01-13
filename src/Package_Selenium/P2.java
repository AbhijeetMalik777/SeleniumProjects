package Package_Selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class P2 {

	public ArrayList<String> getdata(String testcaseName) throws IOException
	{
		ArrayList<String> list = new ArrayList<String>();
		FileInputStream file = new FileInputStream("C:\\Users\\abhij\\OneDrive\\Desktop\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Iterator<Row> rows = sheet.iterator();
		Row firstrow = rows.next(); 
		Iterator<Cell> cell = firstrow.cellIterator();
		int k=0;
		int coloumn =0; 
		while(cell.hasNext()) 
		{
			Cell value = cell.next();
			if(value.getStringCellValue().equalsIgnoreCase("Test")) 
			{
				coloumn =k;
			}
			k++;
		}
		
				
		System.out.println(coloumn);
		
		while(rows.hasNext())
		{
			Row row = rows.next();
			if(row.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName)) 
			{
				Iterator<Cell> ce = row.cellIterator();
						while (ce.hasNext())
						{
							Cell c = ce.next();
							if(c.getCellType()==CellType.STRING) 
							{
								list.add(c.getStringCellValue());
							}
							else {
						 list.add(NumberToTextConverter.toText(c.getNumericCellValue()));	
							}
						}
			}
		}
				return list;
	}
		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			
		}

	}



