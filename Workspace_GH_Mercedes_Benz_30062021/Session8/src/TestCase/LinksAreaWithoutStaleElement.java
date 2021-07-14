package TestCase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseSettings;
import Utilities.Utils;

public class LinksAreaWithoutStaleElement extends BaseSettings{
	public static  WebDriver driver;
	public static  WebDriverWait w;

	public static void main(String[] args) throws InterruptedException {
		
	
		
		driver = LinksAreaWithoutStaleElement.RunBrowser("Chrome");
	
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

		
		/*Req - 1)Works on the links present in an area of a page.
		 * 2) Click on the links sequentially and print the title of the link page
		 * 3) Come back to landing page i.e. BBC page
		 * 4) These above 3 points should be used until all links in the area are dealt with
		 * 
		 * Do not want to get STALE ELEMENT REFERENCE EXCEPTION at all.
		 */
		
		String part1 = "//*[@id='page']/section[7]/div/div/div[2]/div/ul/li[";
		String part2 = "]/a";
		
	
		
		
		//int n ;
		/*
		 * for(n = 1; n<=5 ; n++){ //Click on the link
		 * driver.findElement(By.xpath(part1+n+part2)).click();
		 * 
		 * //Give some to open the link page and before the title is achieved from link
		 * page Thread.sleep(3000L);
		 * 
		 * //Get the title of link page String titlePage = driver.getTitle();
		 * System.out.println("Title of the link page is "+titlePage); //Come back to
		 * BBC.com driver.get("https://www.bbc.com/"); }
		 */
		
		int n = 1;
		//While loop should run those number of times as the number of links
		/*Can't we use a theory where we will first check if a link is present.If link is present , 
		then run the while loop. So create a function which will check that link is present and pas
		this function as argument of WHILE loop.*/
		while(u.isElementPresent(part1+n+part2)) {
			
			//Click on the link
			driver.findElement(By.xpath(part1+n+part2)).click();
			 
			 //Give some to open the link page and before the title is achieved from link page 
			Thread.sleep(3000L);
			 
			//Get the title of link page 
			String titlePage = driver.getTitle();
			System.out.println("Title of the link page is "+titlePage); 
			
			//Come back to BBC.com 
			driver.get("https://www.bbc.com/"); 
			
			n = n+1;
		}
	}
	

	
	
}
