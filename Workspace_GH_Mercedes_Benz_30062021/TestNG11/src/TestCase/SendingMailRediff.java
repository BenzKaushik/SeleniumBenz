package TestCase;

import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseSettings;
import Utilities.Utils;

public class SendingMailRediff extends BaseSettings{

	public   WebDriver driver;
	public   WebDriverWait w;
	public  WebElement wb;
	public  Actions act;
	public  Point p;
	public  JavascriptExecutor j;
	
	
	@Test(dataProvider = "SendingEmailRediffData")
	public  void SendingEmailRediff(Hashtable<String , String> h) throws InterruptedException  {
			  
		
		driver = SendingMailRediff.RunBrowser(h.get("Browser")); //Like to run in Chrome and Edge - parameterization point 1
		
		Utils u = new Utils(driver);
		
		//Navigate to Rediffmail login page
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		u.stepWiseScreenshot("Navigate Rediff Login Page_"+h.get("Browser"));
		
		//Define the page load timeout
		driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
					
		//Implicit wait - Dynamic wait 
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
				
		//Explicit Wait 
		w = new WebDriverWait(driver, 20L);
		
		//Type on Username -parameterization point 2
		driver.findElement(By.xpath("//*[@id=\"login1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"login1\"]")).sendKeys(h.get("UName"));
		
		u.stepWiseScreenshot("Type on username of  Rediff Login Page_"+h.get("Browser"));
		
		//Type on Password-parameterization point 3
		driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(h.get("Pwd"));
		
		u.stepWiseScreenshot("Type on password of  Rediff Login Page_"+h.get("Browser"));
		
		Thread.sleep(3000L);
		
		//Click on Sign In button
		driver.findElement(By.xpath("//input[@name = 'proceed']")).submit();
		
		u.stepWiseScreenshot("Click on sign in button  of  Rediff Login Page_"+h.get("Browser"));
		
		//Wait until the text "Write Mail " is present
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"boxscroll\"]/li[1]/a/b"), "Write mail"));
		
		//Click on Write Mail Link
		driver.findElement(By.xpath("//*[@id=\"boxscroll\"]/li[1]/a")).click();
		
		u.stepWiseScreenshot("Click  on Write mail of  Rediff Login Page_"+h.get("Browser"));
		
		//Ajax component - wait until the text "Send" is seen.
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//a[text() = 'Send']"), "Send"));
		
		//Type on the TO field - parameterization point 4
		driver.findElement(By.xpath("//*[@id=\"TO_IDcmp2\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"TO_IDcmp2\"]")).sendKeys(h.get("TField"));
		driver.findElement(By.xpath("//*[@id=\"TO_IDcmp2\"]")).sendKeys(Keys.RETURN);
		
		u.stepWiseScreenshot("Type on TO field  of  Rediff Login Page_"+h.get("Browser"));
		
		//Type on the SUBJECT edit box-parameterization point 5
		driver.findElement(By.xpath("//*[@id=\"rd_compose_cmp2\"]/ul/li[4]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"rd_compose_cmp2\"]/ul/li[4]/input")).sendKeys(h.get("SField"));
		
		u.stepWiseScreenshot("Type on SUBJECT field  of  Rediff Login Page_"+h.get("Browser"));
	
		//Switch to the frame
		wb = driver.findElement(By.cssSelector("#cke_1_contents > iframe"));
		driver.switchTo().frame(wb);
		
		//Type on the COMPOSE edit box -parameterization point 6
		driver.findElement(By.xpath("/html/body")).click();
		driver.findElement(By.xpath("/html/body")).sendKeys(h.get("CField"));
		
		u.stepWiseScreenshot("Type on COMPOSE field  of  Rediff Login Page_"+h.get("Browser"));
		
		//Switch back to main page from Frame
		driver.switchTo().defaultContent();
		
		//Click on SEND button
		driver.findElement(By.xpath("//*[@id=\"rd_compose_cmp2\"]/div[1]/a[1]")).click();
		
		u.stepWiseScreenshot("Click  on Send button of  Rediff Login Page_"+h.get("Browser"));
		
		//Wait for the text "Your mail is sent"
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"rdNotify\"]"), "Your mail has been sent"));
		
		//Wait until the text LOGOUT is present
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//a[text() = 'Logout']"), "Logout"));
		
		
		//Click on Logout
		driver.findElement(By.xpath("//a[text() = 'Logout']")).click();
		
		u.stepWiseScreenshot("Click  on Logout link of  Rediff Login Page_"+h.get("Browser"));
		
		//Close the App
		driver.quit();
	}
	
	@DataProvider
	public Object[][] SendingEmailRediffData(){
		
		/*
		 * Object[][]obj = new Object[2][6];
		 * 
		 * //Define the data for first run obj[0][0] = "Chrome";//Browser Name obj[0][1]
		 * = "selenium.testmay2017";//Username obj[0][2] = "test@1234";//Password
		 * obj[0][3] = "kaushik.aryaan@gmail.com";//TO field obj[0][4] =
		 * "Test Mail";//SUBJECT field obj[0][5] = "Test Mail Sent"; //COMPOSE field
		 * 
		 * //Define the data for second run obj[1][0] = "Edge";//Browser Name obj[1][1]
		 * = "selenium.testmay2017";//Username obj[1][2] = "test@1234";//Password
		 * obj[1][3] = "arundhoti.mukherjee@gmail.com";//TO field obj[1][4] =
		 * "Development Mail";//SUBJECT field obj[1][5] = "Development Mail Sent";
		 * //COMPOSE field
		 */		
		
		Object[][]obj = new Object[2][1];
		
		//Data for the first run
		Hashtable<String, String> tab1 = new Hashtable<String, String>();
		tab1.put("Browser", "Chrome");
		tab1.put("UName", "selenium.testmay2017");
		tab1.put("Pwd", "test@1234");
		tab1.put("TField", "kaushik.aryaan@gmail.com");
		tab1.put("SField", "Test Mail");
		tab1.put("CField", "Test Mail Sent");
		
		
		//Data for the first run
		Hashtable<String, String> tab2 = new Hashtable<String, String>();
		tab2.put("Browser", "Edge");
		tab2.put("UName", "selenium.testmay2017");
		tab2.put("Pwd", "test@1234");
		tab2.put("TField", "arundhoti.mukherjee@gmail.com");
		tab2.put("SField", "Development Mail");
		tab2.put("CField", "Development Mail Sent");	
		
		obj[0][0] = tab1;
		obj[1][0] = tab2;
		
		return obj;
	}

}
