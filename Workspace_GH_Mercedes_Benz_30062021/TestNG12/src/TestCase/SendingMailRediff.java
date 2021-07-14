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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseSettings;
import Utilities.Utils;
import repo.Data;

public class SendingMailRediff extends BaseSettings{

	public   WebDriver driver;
	public   WebDriverWait w;
	public  WebElement wb;
	public  Actions act;
	public  Point p;
	public  JavascriptExecutor j;
	public Utils u;
	
	//Connecting the dataprovider annotation  name parameter value called as  "sendMailData" with the test annotation
	//Give the class in which "sendMailData" is present
	@Test(dataProvider = "sendMailData", dataProviderClass = Data.class)
	public  void SendingEmailRediff(Hashtable<String , String> h) throws InterruptedException  {
			  
		
		driver = SendingMailRediff.RunBrowser(h.get("Browser")); //Like to run in Chrome and Edge - parameterization point 1
		
		u = new Utils(driver);
		
		//Navigate to Rediffmail login page
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		//Assert by title on landing page
		u.AssertTitle("Rediffmail", "the landing page of Rediffmail");
		
		u.stepWiseScreenshot("Navigate Rediff Login Page_"+h.get("Browser"));
		
		//Define the page load timeout
		driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
					
		//Implicit wait - Dynamic wait 
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
				
		//Explicit Wait 
		w = new WebDriverWait(driver, 20L);
		
		//Assert  by the text "Username"
		u.AssertText("Username", "xpath", "//p[text() = 'Username']", "for the text Username");
		
		//Type on Username -parameterization point 2
		driver.findElement(By.xpath("//*[@id=\"login1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"login1\"]")).sendKeys(h.get("UName"));
		
		u.stepWiseScreenshot("Type on username of  Rediff Login Page_"+h.get("Browser"));
		
		//Assert  by the text "Password"
		u.AssertText("Password", "xpath", "//p[text() = 'Password']", "for the text Password");
		
		
		//Type on Password-parameterization point 3
		driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(h.get("Pwd"));
		
		u.stepWiseScreenshot("Type on password of  Rediff Login Page_"+h.get("Browser"));
		
		Thread.sleep(3000L);
		
		//Assert by the attribute "name" whose value is "proceed"
		u.AssertAttributeValue("proceed", "xpath", "//input[@name = 'proceed']", "for the attribute name", "name");
		
		//Click on Sign In button
		driver.findElement(By.xpath("//input[@name = 'proceed']")).click();;
		
		u.stepWiseScreenshot("Click on sign in button  of  Rediff Login Page_"+h.get("Browser"));
		
		//Wait until the text "Write Mail " is present
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"boxscroll\"]/li[1]/a/b"), "Write mail"));
		
		
		//Assert  by the text "Write Mail"
		u.AssertText("Write mail", "xpath", "//*[@id='boxscroll']/li[1]/a/b", "for the text Write Mail");
		
		
		//Click on Write Mail Link
		driver.findElement(By.xpath("//*[@id=\"boxscroll\"]/li[1]/a")).click();
		
		u.stepWiseScreenshot("Click  on Write mail of  Rediff Login Page_"+h.get("Browser"));
		
		//Ajax component - wait until the text "Send" is seen.
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//a[text() = 'Send']"), "Send"));
		
		//Assert by text "To:"
		u.AssertText("To:", "xpath", "//label[text()='To:']", "for the text To:");
		
		
		//Type on the TO field - parameterization point 4
		driver.findElement(By.xpath("//*[@id=\"TO_IDcmp2\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"TO_IDcmp2\"]")).sendKeys(h.get("TField"));
		driver.findElement(By.xpath("//*[@id=\"TO_IDcmp2\"]")).sendKeys(Keys.RETURN);
		
		u.stepWiseScreenshot("Type on TO field  of  Rediff Login Page_"+h.get("Browser"));
		
		//Assert by text "Subject:"
		u.AssertText("Subject:", "xpath", "//label[text()='Subject:']", "for the text Subject:");
				
		
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
		
		//Assert by the text "Send"
		u.AssertText("Send", "xpath", "//a[text()='Send']", "for the text Send");
		
		//Click on SEND button
		driver.findElement(By.xpath("//*[@id=\"rd_compose_cmp2\"]/div[1]/a[1]")).click();
		
		u.stepWiseScreenshot("Click  on Send button of  Rediff Login Page_"+h.get("Browser"));
		
		//Wait for the text "Your mail is sent"
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"rdNotify\"]"), "Your mail has been sent"));
		
		//Wait until the text LOGOUT is present
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//a[text() = 'Logout']"), "Logout"));
		
		
		//Assert by the text "Logout"
		u.AssertText("Logou", "xpath", "//a[text() = 'Logout']", "for the text Logout");
				
		
		//Click on Logout
		driver.findElement(By.xpath("//a[text() = 'Logout']")).click();
		
		u.stepWiseScreenshot("Click  on Logout link of  Rediff Login Page_"+h.get("Browser"));
		
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		int x = result.getStatus();
		System.out.println(x);
		if(x == ITestResult.FAILURE) {
			//u = new Utils(driver);
			u.FailScreenshot(result.getName()); //Screenshot file name will come with test annotation method name
		}
		
		//Close the App
		driver.quit();
		
	}
	
	
}
