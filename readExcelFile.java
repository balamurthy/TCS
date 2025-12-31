package SanityTests;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//How to read excel files using Apache POI

public class readExcelFile {
//adding comment
	static XSSFCell s_username;
	static XSSFCell s_password;


	public static void main (String [] args) throws IOException, InterruptedException{
		
		//I have placed an excel file 'Test.xlsx' in my e Drive 
		FileInputStream fis = new FileInputStream("src/test/resources/xlFile.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		

		System.out.println("There are : " + sheet.getLastRowNum() + " rows in the Excel file");
		
		int rowcount = sheet.getLastRowNum();
		for (int i = 1; i < rowcount +1; i ++) {
			
			s_username = sheet.getRow(i).getCell(0);
			s_password = sheet.getRow(i).getCell(1);
			
			displayValues(s_username,s_password);
		}
		//String cellval = cell.getStringCellValue();

	}	
	
	static void displayValues(XSSFCell un,XSSFCell pw) throws InterruptedException

	{

		System.out.println("Username is:" + un + " Password is : " + pw);

		
		
	}


}


