package TestCase;

import java.io.IOException;
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
	
	
	@Test
	public  void SendingEmailRediff()  {
	  
		driver = SendingMailRediff.RunBrowser("Chrome");
		
		Utils u = new Utils(driver);
		
		//Navigate to Rediffmail login page
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		//Define the page load timeout
		driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
					
		//Implicit wait - Dynamic wait 
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
				
		//Explicit Wait 
		w = new WebDriverWait(driver, 20L);
		
		//Type on Username
		driver.findElement(By.xpath("//*[@id=\"login1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"login1\"]")).sendKeys("selenium.testmay2017");
		
		//Type on Password
		driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("test@1234");
		
		//Click on Sign In button
		driver.findElement(By.xpath("//input[@name = 'proceed']")).submit();
		
		//Wait until the text "Write Mail " is present
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"boxscroll\"]/li[1]/a/b"), "Write mail"));
		
		//Click on Write Mail Link
		driver.findElement(By.xpath("//*[@id=\"boxscroll\"]/li[1]/a")).click();
		
		//Ajax component - wait until the text "Send" is seen.
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//a[text() = 'Send']"), "Send"));
		
		//Type on the TO field
		driver.findElement(By.xpath("//*[@id=\"TO_IDcmp2\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"TO_IDcmp2\"]")).sendKeys("kaushik.aryaan@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"TO_IDcmp2\"]")).sendKeys(Keys.RETURN);
		
		//Type on the SUBJECT edit box
		driver.findElement(By.xpath("//*[@id=\"rd_compose_cmp2\"]/ul/li[4]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"rd_compose_cmp2\"]/ul/li[4]/input")).sendKeys("Test Mail");
	
		//Switch to the frame
		wb = driver.findElement(By.cssSelector("#cke_1_contents > iframe"));
		driver.switchTo().frame(wb);
		
		//Type on the COMPOSE edit box
		driver.findElement(By.xpath("/html/body")).click();
		driver.findElement(By.xpath("/html/body")).sendKeys("Test Mail Sent");
		
		//Switch back to main page from Frame
		driver.switchTo().defaultContent();
		
		//Click on SEND button
		driver.findElement(By.xpath("//*[@id=\"rd_compose_cmp2\"]/div[1]/a[1]")).click();
		
		//Wait for the text "Your mail is sent"
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"rdNotify\"]"), "Your mail has been sent"));
		
		//Wait until the text LOGOUT is present
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//a[text() = 'Logout']"), "Logout"));
		
		
		//Click on Logout
		driver.findElement(By.xpath("//a[text() = 'Logout']")).click();
		
		//Close the App
		driver.quit();
	}
	
	

}
