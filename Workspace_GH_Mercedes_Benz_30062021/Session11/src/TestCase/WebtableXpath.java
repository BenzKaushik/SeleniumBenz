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

public class WebtableXpath extends BaseSettings{
	public static  WebDriver driver;
	public static  WebDriverWait w;
	public static WebElement wb;
	public static Actions act;
	public static Point p;
	public static JavascriptExecutor j;

	public static void main(String[] args) {
		
		driver = WebtableXpath.RunBrowser("Chrome");
		
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
		String str1 = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th[3]")).getText();
		System.out.println("Text in third column of the heading of the table is "+str1);
	
		System.out.println("*****************************************");
		
		//Want to get text from fifth column of the heading 
		String str2 = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th[5]")).getText();
		System.out.println("Text in fifth column of the heading of the table is "+str2);
		
		System.out.println("*****************************************");
		
		//Want to get text from first column of the heading 
		String str3 = driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th[1]")).getText();
		System.out.println("Text in first column of the heading of the table is "+str3);
		
		System.out.println("*****************************************");
		
		//Want to get text from first column of the heading 
		String str4 = driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th")).getText();
		System.out.println("Text in first column of the heading of the table is "+str4);
			
		System.out.println("*****************************************");
		
		//Want to get all data from all column of the heading 
		List<WebElement> l1 = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
		int a = l1.size();
		System.out.println("Number of elements having same xpath are "+a);
		for(int x = 0; x<a; x++) {
			String str5 = l1.get(x).getText();
			System.out.println(str5);
		}
		
		System.out.println("*****************************************");
		
		//Want to get all data from all column of the heading 
		List<WebElement> l2 = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr"));
		int b = l2.size();
		System.out.println("Number of elements having same xpath are "+b);
		for(int x = 0; x<b; x++) {
			String str6 = l2.get(x).getText();
			System.out.println(str6);
		}
		
		System.out.println("*****************************************");
		
		//Want to get text from first column of the first row of the body of the table
		String str7 = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[1]/td[1]")).getText();
		System.out.println("text present in first column of the first row of the body of the table is "+str7);
	
	
		System.out.println("*****************************************");
	
		//Want to get text from fourth column of the last row of the body of the table
		String str8 = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[387]/td[4]")).getText();
		System.out.println("text present in fourth column of the last row of the body of the table is "+str8);
	
	
		System.out.println("*****************************************");
		
		//Want to get text from first column of the first row of the body of the table
		String str9 =  driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[1]/td")).getText();
		System.out.println("text present in first column of the first row of the body of the table is "+str9);
		
		System.out.println("*****************************************");
		
		//Want to get text from all column of the first row of the body of the table
		List<WebElement> l3 = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[1]/td"));
		int c = l3.size();
		System.out.println("Number of elements having same xpath are "+c);
		for(int x = 0; x<c; x++) {
			String str10 = l3.get(x).getText();
			System.out.println(str10);
		}
		
		System.out.println("*****************************************");
		
		//Want to get text from all column of the first row of the body of the table
		List<WebElement> l4 = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[1]"));
		int d = l4.size();
		System.out.println("Number of elements having same xpath are "+d);
		for(int x = 0; x<d; x++) {
			String str11 = l4.get(x).getText();
			System.out.println(str11);
		}
		
		System.out.println("****************ROW WISE*************************");
		
		//Want to get text from all column of the last row of the body of the table
		List<WebElement> l5 = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[387]/td"));
		int e = l5.size();
		System.out.println("Number of elements having same xpath are "+e);
		for(int x = 0; x<e; x++) {
			String str12 = l5.get(x).getText();
			System.out.println(str12);
		}				
				
		System.out.println("***************COLUMNWISE**************************");
				
		//Want to get text from all column of the last row of the body of the table
		List<WebElement> l6 = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[387]"));
		int f = l6.size();
		System.out.println("Number of elements having same xpath are "+f);
		for(int x = 0; x<f; x++) {
			String str13 = l6.get(x).getText();
			System.out.println(str13);
		}				
	
		System.out.println("*****************************************");
	
	
		//Want to get text from all rows of the first column of the body of the table
		List<WebElement> l7 = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
		int g = l7.size();
		System.out.println("Number of elements having same xpath are "+g);
		for(int x = 0; x<g; x++) {
			String str14 = l7.get(x).getText();
			System.out.println(str14);
		}
		
		
		//Want to get text from all rows of the last column of the body of the table
	
		System.out.println("*****************************************");
		
		
		//Want to get text from all rows of the last column of the body of the table
		List<WebElement> l8 = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[5]"));
		int h = l8.size();
		System.out.println("Number of elements having same xpath are "+h);
		for(int x = 0; x<h; x++) {
			String str15 = l8.get(x).getText();
			System.out.println(str15);
		}
	}

}
