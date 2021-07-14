package TestCase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseSettings;
import Utilities.Utils;

public class WebtableCssSelector extends BaseSettings{
	public static  WebDriver driver;
	public static  WebDriverWait w;
	public static WebElement wb;
	public static Actions act;
	public static Point p;
	public static JavascriptExecutor j;

	public static void main(String[] args) {
		
		driver = WebtableCssSelector.RunBrowser("Chrome");
		
		//CReate the object of Utils class
		Utils u = new Utils(driver);
		
		//Maximise the browser window
		driver.manage().window().maximize();
		
		//Navigate to the Rediff Money gainer website - having dynamic table
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		
		//StepWise Screenshot after navigation to JRediff Money gainer website
		u.stepWiseScreenshot("Navigate Rediff Money gainer website");
			
		//Define the page load timeout
		driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
			
		//Implicit wait - Dynamic wait 
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		//Explicit Wait 
		w = new WebDriverWait(driver, 20L);// TODO Auto-generated method stub		// TODO Auto-generated method stub

		//Want to get text from third column of the heading 
		String str1 = driver.findElement(By.cssSelector("#leftcontainer > table > thead > tr > th:nth-child(3)")).getText();
		System.out.println("Text in third column of the heading of the table is "+str1);
	
		System.out.println("*****************************************");
		
		//Want to get text from fourth column of the heading 
		String str2 = driver.findElement(By.cssSelector("#leftcontainer > table > thead > tr > th:nth-child(4)")).getText();
		System.out.println("Text in fourth column of the heading of the table is "+str2);
		
		System.out.println("*****************************************");
		
		//Want to get text from first column of the heading 
		String str3a = driver.findElement(By.cssSelector("#leftcontainer > table > thead > tr > th:nth-child(1)")).getText();
		System.out.println("Text in first column of the heading of the table is "+str3a);
		
		String str3b = driver.findElement(By.cssSelector("#leftcontainer > table > thead > tr > th")).getText();
		System.out.println("Text in first column of the heading of the table is "+str3b);
		
		
		
		System.out.println("*****************Row Wise************************");
		
		//Want to get all data from all column of the heading 
		List<WebElement> l1 = driver.findElements(By.cssSelector("#leftcontainer > table > thead > tr > th"));
		int a = l1.size();
		System.out.println("Number of elements having same xpath are "+a);
		for(int x = 0; x<a; x++) {
			String str5 = l1.get(x).getText();
			System.out.println(str5);
		}
		
		System.out.println("***************Column Wise**************************");
		String str4 = driver.findElement(By.cssSelector("#leftcontainer > table > thead > tr")).getText();
		System.out.println("Text in first row of the heading of the table is " +str4);
		//Want to get all data from all column of the heading 
		List<WebElement> l2 = driver.findElements(By.cssSelector("#leftcontainer > table > thead > tr"));
		int b = l2.size();
		System.out.println("Number of elements having same xpath are "+b);
		System.out.println("Text in first row of the heading of the table is ");
		for(int x = 0; x<b; x++) {
			String str6 = l2.get(x).getText();
			System.out.println(str6);
		}
		
		System.out.println("*****************************************");
		
		//Want to get text from first column of the first row of the body of the table
		String str7 = driver.findElement(By.cssSelector("#leftcontainer > table > tbody > tr:nth-child(1) > td:nth-child(1)")).getText();
		System.out.println("Text present in first column of the first row of the body of the table is "+str7);
	
	
		System.out.println("*****************************************");
		//To find how many rows in body of the table dynamically
		List<WebElement> allDataRows = driver.findElements(By.cssSelector("#leftcontainer > table > tbody > tr"));
		int numRowsBodyTable = allDataRows.size();
		System.out.println("Number of rows in the body of the table are "+numRowsBodyTable);
		
		//To find how many columns in body of the table dynamically
		List<WebElement> allDataColumn = driver.findElements(By.cssSelector("#leftcontainer > table > tbody > tr:nth-child(1) > td"));
		int numColumnsBodyTable = allDataColumn.size();
		System.out.println("Number of columns in the body of the table are "+numColumnsBodyTable);
		
		
		//Want to get text from fourth column of the of the company L&T
		// First find out where is L &T
		//#leftcontainer > table > tbody > tr:nth-child(367) > td:nth-child(1) > a - random css selector
		//#leftcontainer > table > tbody > tr > td:nth-child(1) > a - find out how many elemenst ahev same Css Selector
		List<WebElement> allList = driver.findElements(By.cssSelector("#leftcontainer > table > tbody > tr > td:nth-child(1) > a"));
		int numElementWithSameCssSelector = allList.size();
		System.out.println("Number of elements with \"#leftcontainer > table > tbody > tr > td:nth-child(1) > a\" are "+numElementWithSameCssSelector );
		String expectedCompany = "L&T";
		for(int x = 0; x<numElementWithSameCssSelector; x++) {
			//Get the actual name of the company from all rows first column's anchor tag from the body of table
			String actualCompany = allList.get(x).getText();
			int y = x+1;
			if(actualCompany.equals(expectedCompany)) {
				String text = driver.findElement(By.cssSelector("#leftcontainer > table > tbody > tr:nth-child("+y+") > td:nth-child(4)")).getText();
				System.out.println("Text from fourth column of the company L&T is "+text);
			}
		}
		
		
		System.out.println("*****************************************");
		
		//Want to get text from first column of the first row of the body of the table
		String str9a =  driver.findElement(By.cssSelector("#leftcontainer > table > tbody > tr:nth-child(1) > td:nth-child(1)")).getText();
		System.out.println("Text present in first column of the first row of the body of the table is "+str9a);
		
		String str9b =  driver.findElement(By.cssSelector("#leftcontainer > table > tbody > tr:nth-child(1) > td")).getText();
		System.out.println("Text present in first column of the first row of the body of the table is "+str9b);
		
		
		System.out.println("****************ROW WISE*************************");
		
		//Want to get text from all column of the first row of the body of the table
		List<WebElement> l3 = driver.findElements(By.cssSelector("#leftcontainer > table > tbody > tr:nth-child(1) > td"));
		int c = l3.size();
		System.out.println("Number of elements having same CssSelector are "+c);
		for(int x = 0; x<c; x++) {
			String str10 = l3.get(x).getText();
			System.out.println(str10);
		}
		
		System.out.println("******************COLUMN WISE***********************");
		
		//Want to get text from all column of the first row of the body of the table
		List<WebElement> l4 = driver.findElements(By.cssSelector("#leftcontainer > table > tbody > tr:nth-child(1"));
		int d = l4.size();
		System.out.println("Number of elements having same CssSelector are "+d);
		for(int x = 0; x<d; x++) {
			String str11 = l4.get(x).getText();
			System.out.println(str11);
		}
		
		System.out.println("****************ROW WISE*************************");
			
		//Want to get text from all rows of the first column of the body of the table
		List<WebElement> l7 = driver.findElements(By.cssSelector("#leftcontainer > table > tbody > tr > td:nth-child(1) > a "));
		int g = l7.size();
		System.out.println("Number of elements having same CssSelector are "+g);
		for(int x = 0; x<g; x++) {
			String str14 = l7.get(x).getText();
			System.out.println(str14);
		}
		
		System.out.println("*****************************************");
		
		
		//Want to get text from all rows of the last column of the body of the table
		List<WebElement> l8 = driver.findElements(By.cssSelector("#leftcontainer > table > tbody > tr > td:nth-child(5)"));
		int h = l8.size();
		System.out.println("Number of elements having same cssSelector are "+h);
		for(int x = 0; x<h; x++) {
			String str15 = l8.get(x).getText();
			System.out.println(str15);
		}
		
		System.out.println("******************Whole body od table  - ROW WISE***********************");
		
		
		//Want to get text from all rows of the last column of the body of the table
		List<WebElement> l9 = driver.findElements(By.cssSelector("#leftcontainer > table > tbody > tr > td"));
		int i = l9.size();
		System.out.println("Number of elements having same cssSelector are "+i);
		for(int x = 0; x<i; x++) {
			String str16 = l9.get(x).getText();
			System.out.println(str16);
		}
		
		System.out.println("******************Whole body od table  - COLUMN WISE***********************");
		
		
		//Want to get text from all rows of the last column of the body of the table
		List<WebElement> l10 = driver.findElements(By.cssSelector("#leftcontainer > table > tbody > tr"));
		int j = l10.size();
		System.out.println("Number of elements having same cssSelector are "+i);
		for(int x = 0; x<j; x++) {
			String str17 = l10.get(x).getText();
			System.out.println(str17);
		}
		
		
	}

}
