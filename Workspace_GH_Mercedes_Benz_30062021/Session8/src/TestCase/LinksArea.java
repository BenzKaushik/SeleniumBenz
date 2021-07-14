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

public class LinksArea extends BaseSettings{
	
	public static  WebDriver driver;
	public static  WebDriverWait w;

	public static void main(String[] args) throws InterruptedException {
		
		driver = LinksArea.RunBrowser("Chrome");
	
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
		 */
		
		//Keeping the address of LATEST BUSINESS NEW area
		WebElement addressLatestBusinessNewsArea = driver.findElement(By.cssSelector("#page > section.module.module--collapse-images.module--collapse-images.module--highlight.module--editors-picks > div > div > div.most-popular"));
		//From the area , find out how many links are present dynamically
		List<WebElement> allLinksArea = addressLatestBusinessNewsArea.findElements(By.tagName("a"));
		int numLinksArea = allLinksArea.size();
		System.out.println("Number of links in LATEST BUSINESS NEWS area are "+numLinksArea);

		System.out.println("************************************************************");
		
		//Click on the links one by one (sequentially) and get the title of link page. After that cme back to landing page 
		for(int x = 0; x<numLinksArea; x++) {
			//1. Stale Element reference exception is coming on line 93
			/*2. Why stale element reference exception coming on line 93? 
			 * We have created cache memory at line 62 where allLinksArea variable is defined,This allLinksArea 
			 * variable is attached to addressLatestBusinessNewsArea variable at line number 60 as from this 
			 * variable we are getting number of links from the area. 
			 * 
			 * These two cache memories at line 60 and 62 are created in the webpage BBC.com at line 29.So 
			 * when we click on the link page at line 92, the cache memory got lost.
			 * 
			 * At line 103 we are coming back to BBC.com page . Here the system is not able to understand what 
			 * is that variable allLinksArea variable at line 93. So it show Stale Element Reference Exception.
			 * 
			 * After coming to BBC page back at line 103, recreate the CACHE memory
			 */
			
			/*Recreate the cache memory as soon as we enter the  loop - recreation will avoid 
			stale element reference exception*/
			
			addressLatestBusinessNewsArea = driver.findElement(By.cssSelector("#page > section.module.module--collapse-images.module--collapse-images.module--highlight.module--editors-picks > div > div > div.most-popular"));
			allLinksArea = addressLatestBusinessNewsArea.findElements(By.tagName("a"));
			
			
			//Click on the link
			allLinksArea.get(x).click();
			
			//Thread.sleep - give some time to open the link page
			Thread.sleep(3000L);
			
			//Print the title of link page
			String titleLinkPage = driver.getTitle();
			System.out.println("Title of the link with index number "+x+" is "+titleLinkPage);
			
			//Come back to Landing page
			driver.get("https://www.bbc.com/");
		}
	}

}
