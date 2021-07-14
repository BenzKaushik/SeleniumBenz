package TestCase;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseSettings;
import Utilities.Utils;



public class WorkingWithLinks extends BaseSettings {
	
	public static  WebDriver driver;
	public static  WebDriverWait w;

	
	public static void main(String [] args) {
		
		driver = WorkingWithLinks.RunBrowser("Chrome");
		
		Utils u = new Utils(driver);
		
		//Maximise the browser window
		driver.manage().window().maximize();
		
		//Navigate to the BBC website
		driver.get("https://www.bbc.com/");
		
		//StepWise Screenshot after navigation to BBC to take the screenshot
		u.stepWiseScreenshot("Navigate BBC");
			
		//Define the page load timeout
		driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
			
		//Implicit wait - Dynamic wait 
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		//Explicit Wait 
		w = new WebDriverWait(driver, 30L);
		
		//To check the condition that the text "Welcome to BBC.com" is present in a locator address
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='page']/section[2]/h2/span"), "Welcome to BBC.com"));
		
		//Verify the title of the landing page
		u.VerifyTitle("BBC - Homepage", "for landing page");
		
		//Verify the text "Welcome to BBC.com" 
		u.VerifyText("Welcome to BBC.com", "xpath", "//*[@id='page']/section[2]/h2/span", "the text Welcome to BBC.com");
	
		//Req1) To check the number of links in the BBC website
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int numLinks = allLinks.size();
		System.out.println("Number of links in BBC website are "+numLinks);
		
		System.out.println("********************************************************************");
		
		/*The below code is giving STALE ELEMENT REFERENCE EXCEPTION. Please do not handle this exception 
		with TRY CATCH BLOCK.
		
		This exception comes when CACHED memory is lost. Cached memory is created for objects and their references
		*/
		//Req2) To get the text of all links
		
		for(int x = 0; x<numLinks; x++) {
			//Every time the STALE ELEMENT REFERENCE EXCEPTION is coming in concern with "allLinks" variable
			/*That means when the value of variable "x" is increasing, the cache memory in "allLinks " 
			variable is getting lost.*/
			/*Recreation of cache memory as below after incrementing the value of variable "x" 
			so that STALE ELEMENT REFERENCE EXCEPTION does not come.*/
			allLinks = driver.findElements(By.tagName("a")); 
			String textLinks = allLinks.get(x).getText();
			System.out.println("Link Index number is "+x+" and the text of the link is : "+textLinks);
		}
		
		System.out.println("********************************************************************");
		
		//Req3) To get the attribute values for all links, Attribute can be class, name, id and href
		for(int x = 0; x<numLinks; x++) {
			allLinks = driver.findElements(By.tagName("a")); 
			String getAttValID = allLinks.get(x).getAttribute("id");
			String getAttValName = allLinks.get(x).getAttribute("name");
			String getAttValClass = allLinks.get(x).getAttribute("class");
			String getAttValHref = allLinks.get(x).getAttribute("href");
			System.out.println("Link Index number is "+x+" : href value : "+getAttValHref+" : class value : "
					+getAttValClass+" : ID value : "+getAttValID+" : Name value : "+getAttValName );
			
		}
		
		System.out.println("********************************************************************");
		/*
		 * 1)isDisplayed function returns a BOOLEAN value.
		 * 2) isDisplayed function is TRUE if the DISPLAY property is switched ON by the coder
		 * 3) isDisplayed function is FALSE if the DISPLAY property is switched OFF by the coder
		 * 4) If DISPLAY is switched ON by coder, then we will get the text of the link.
		 * 5) If DISPLAY is switched OFF by coder, then we will not get the text of the link
		 * 
		 * Factors which affects  DIAPLAY property: 
		 * 
		 * 1) If VISIBILITY PROPERTY by the coder is disabled, DISPLAY will be OFF.
		 * 2) If the element/UI/control/web elements is not present in the VIEWPORT of the browser,
		 * DISPLAY will be OFF.
		 * 3) If the width and height of the element/UI/control/web elements is ZERO pixel, 
		 * DISPLAY will be OFF.
		 * 
		 * If any of the above criteria is met, DISPLAY will be auto OFF.
		 * 
		 * Display				Text			Final Result
		 * -------				----			------------
		 * ON					Defined			Text will be seen.
		 * ON					Undefined		Text will not be seen
		 * OFF					Defined			Text will not be seen
		 * OFF					Undefined		Text will not be seen	
		 * 
		 * 
		 * 
		 * 
		 */
		
		
		//Req4)To use the isDisplayed function for all links and also get the text of all links
		for(int x = 0; x<numLinks; x++) {
			
			allLinks = driver.findElements(By.tagName("a")); 
			String textLinks = allLinks.get(x).getText();
			boolean linkDisplayResult = allLinks.get(x).isDisplayed();
			boolean linkEnableResult = allLinks.get(x).isEnabled();
			System.out.println("Link Index number is "+x+" and the text of the link is : "+textLinks+
					" with Display Property as : "+linkDisplayResult+" and the eneabled property as : "+
					linkEnableResult);
		}
		
	}
	
	

}
