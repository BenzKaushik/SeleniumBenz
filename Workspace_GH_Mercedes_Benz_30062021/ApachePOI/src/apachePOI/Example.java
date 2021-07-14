package apachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Example {

	public static void main(String[] args) throws IOException {


		/* 1)When the extension of excel is dot XLS (.xls) , use HSSFWorkbook(Horrible Spreadsheet Format) class file.
		 * 2)Most the excel sheet have extension of dot XLSX (.xlsx). Fo this extension , we need to use the
		 * XSSFWorkbook (Open Office XML Spreadsheet Format) class.
		 * 3) When we are reading from Excel file, the excel file can be in OPEN STATE.
		 * 4) When we are writing to excel file, the excel file should be in close state, otherwise
		 * we will see EXCEPTION.
		 * 5) Remember to save data in String format in excel sheet. Convert number to String by using
		 * single APOSTOPHE (') before the number and click on ENTER button of the keyboard. Save the
		 * excel sheet.
		 */
		
		//Reading from Excel
		//1. Go to the workbook by giving its path and loading data in BYTE format
		FileInputStream fis = new FileInputStream("C:\\Users\\lenovo\\Desktop\\Test.xlsx");
		
		//2) Object of XSSFWorkbook to load the excel workbook
		XSSFWorkbook xl = new XSSFWorkbook(fis);
		
		//3) Load the sheet in the workbook
		XSSFSheet xs = xl.getSheetAt(0);
		
		//4) Go to the first row
		XSSFRow xr = xs.getRow(0);
		
		//5) Go the first column 
		XSSFCell xc = xr.getCell(0);
		
		//6) Get the data from Cell
		String val1 = xc.getStringCellValue();
		System.out.println(val1);
		String val2 = xc.toString();
		System.out.println(val2);
		
		//Get the value at first row first column
		String val3 = xl.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
		System.out.println(val3);
		
		//Get the value at third row third column
		String val4 = xl.getSheetAt(0).getRow(2).getCell(2).getStringCellValue();
		System.out.println(val4);
		
		//Get the value at third row first column
		String val5 = xl.getSheetAt(0).getRow(2).getCell(0).getStringCellValue();
		System.out.println(val5);
		
		System.out.println("*******************************");
		
		//Get all data from all row all columns
		int numRows = xs.getLastRowNum(); //All row filled with data except the first row which is considered as heading
		//System.out.println("ROws:"+numRows);
		
		for(int x = 1; x<=numRows; x++) {
			int noOfColumns = xs.getRow(x).getPhysicalNumberOfCells();
			//System.out.println(noOfColumns);
			for(int y = 0; y<noOfColumns; y++) {
				System.out.println(xl.getSheetAt(0).getRow(x).getCell(y).getStringCellValue());
			}
		}
		 
		System.out.println("*******************************");
		
		//Writing to  Excel
		//1. Go to the workbook by giving its path and loading data in BYTE format
		FileInputStream fis1 = new FileInputStream("C:\\Users\\lenovo\\Desktop\\Test.xlsx");
				
		//2) Object of XSSFWorkbook to load the excel workbook
		XSSFWorkbook xl1 = new XSSFWorkbook(fis1);
				
		//3) Load the sheet in the workbook
		XSSFSheet xs1 = xl1.getSheetAt(0);
		
		//4) Go to the first row
		XSSFRow xr1 = xs1.getRow(0);
		
		//5) Create cell in first row
		XSSFCell xc1 = xr1.createCell(3);
		
		//6) Set the value
		xc1.setCellValue("Address");
		
		//Write in second row fourth column
		xl1.getSheetAt(0).getRow(1).createCell(3).setCellValue("Bangalore");
		
		//Write in third row fourth column
		xl1.getSheetAt(0).getRow(2).createCell(3).setCellValue("New York");
		
		//Write in fourth row fourth column
		xl1.getSheetAt(0).getRow(3).createCell(3).setCellValue("Delhi");
		
		//Here we need to specify where you want to save file
		FileOutputStream fout =new FileOutputStream("C:\\Users\\lenovo\\Desktop\\Test.xlsx");
		
		//Write to the excel
		xl1.write(fout);
		
		//Close the output Stream
		fout.close();
		
		
	}

}
