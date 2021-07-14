package TestCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import Base.BaseSettings;
import Utilities.Utils;

public class JavascriptCodes extends BaseSettings{

	public static  WebDriver driver;
	public static  WebDriverWait w;
	public static WebElement wb;
	public static Actions act;
	public static Point p;
	public static JavascriptExecutor j;
	public static Pattern p1;
	public static Screen scr;
	
	
	public static void main(String[] args) throws InterruptedException, IOException, FindFailed {
	    
		
		driver = JavascriptCodes.RunBrowser("Chrome");
		
		Utils u = new Utils(driver);
		
		j = (JavascriptExecutor)driver;
		
		//Navigate to Rediffmail Page Creation Webpage
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		//Define the page load timeout
		driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
					
		//Implicit wait - Dynamic wait 
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
				
		//Explicit Wait 
		w = new WebDriverWait(driver, 20L);
		
		//To get the URL of a webpage
		String url=  j.executeScript("return document.URL;").toString();
		System.out.println(url);
		
		//To get the domain name
		String domainName=  j.executeScript("return document.domain;").toString();
		System.out.println(domainName);
		
		//To get the Height and Width of a web page
		j.executeScript("return window.innerHeight;").toString();
		//j.executeScript("return window.innerWidth;�").toString();
		
		
		//To get the Title of our webpage
		String titleText =  j.executeScript("return document.title;").toString();
		System.out.println(titleText);
		
		//Type on full name
		wb = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input"));
		j.executeScript("arguments[0].setAttribute('value', '" + "Kaushik Mukherjee" +"')", wb);
		
		//Type on Rediffmail ID Edit box
		wb = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]"));
		j.executeScript("arguments[0].setAttribute('value', '" + "kaushik2412" +"')", wb);
		
		//Click on Check Availability button
		wb = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[2]"));
		j.executeScript("arguments[0].click();", wb);
		
		//Click on Checkbox - To Handle Checkbox by passing the value as true or false
		wb = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[15]/td[2]/table/tbody/tr/td[1]/input"));
		//j.executeScript("document.getElementById('enter element id').checked=false;");
		j.executeScript("arguments[0].click();", wb);
		
		//Drop Down  - ISD and choose USA
		wb = driver.findElement(By.xpath("//*[@id=\"div_mob\"]/table/tbody/tr/td[3]/div[2]"));
		j.executeScript("arguments[0].click();", wb);
		wb = driver.findElement(By.xpath("//*[@id=\"country_id\"]/ul/li[2]"));
		j.executeScript("arguments[0].click();", wb);
		
		Thread.sleep(5000L);
		
		//Drop Down - Day created with Select tag and choose 03 option
		wb = driver.findElement(By.cssSelector("#tblcrtac > tbody > tr:nth-child(23) > td:nth-child(3) > select:nth-child(1)"));
		//j.executeScript("arguments[0].click();", wb);
		//To generate Alert Pop window after clicking on Day drp down
		//j.executeScript("alert('Day drop down clicked');");
		//wb = driver.findElement(By.cssSelector("#tblcrtac > tbody > tr:nth-child(23) > td:nth-child(3) > select:nth-child(1) > option:nth-child(4)"));
		//j.executeScript("arguments[0].click();", wb);
		Select s = new Select(wb);
		s.selectByVisibleText("03");
		
		
		//Choose Radio button  - Female
		wb = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[2]"));
		j.executeScript("arguments[0].click();", wb);
		
		//To generate Alert Pop window in Selenium Webdriver
		j.executeScript("alert('Testing Finished ');");
	
		Alert a = driver.switchTo().alert();
		a.accept();
	
	}
	
	

}
