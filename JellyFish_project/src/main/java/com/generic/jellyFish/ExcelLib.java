package com.generic.jellyFish;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib 
{
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\anand.srivastava\\git\\repository\\JellyFish_project\\dataFiles\\data.xlsx";
	   public static Object[][] getExceldata(String sheetname) throws EncryptedDocumentException, IOException
	   {
		     FileInputStream fis=new FileInputStream(TESTDATA_SHEET_PATH);
		    
			   Workbook wb=WorkbookFactory.create(fis);
			   Sheet sh = wb.getSheet(sheetname);
			   int number_rows = sh.getLastRowNum();
			   int cellcount = sh.getRow(0).getLastCellNum();
			   Object[][] arrayExcelData=new Object[number_rows][cellcount];
			   for(int i =0;i<number_rows;i++)
			   {
				   for(int k =0;k<cellcount;k++)	
					   	
					   
				   {
					   arrayExcelData[i][k] = sh.getRow(i + 1).getCell(k).toString();
					   
					 
				   }
			   }
	     
			   return arrayExcelData; 
		  }
	  
}
