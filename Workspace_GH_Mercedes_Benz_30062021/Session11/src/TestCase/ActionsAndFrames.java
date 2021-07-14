package TestCase;

import java.time.Duration;
import java.util.List;
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

import Base.BaseSettings;
import Utilities.Utils;

public class ActionsAndFrames extends BaseSettings{
	
	public static  WebDriver driver;
	public static  WebDriverWait w;
	public static WebElement wb;
	public static Actions act;
	public static Point p;
	public static JavascriptExecutor j;
	

	public static void main(String[] args) {

		driver = ActionsAndFrames.RunBrowser("Chrome");
		
		//CReate the object of Utils class
		Utils u = new Utils(driver);
		
		//Maximise the browser window
		driver.manage().window().maximize();
		
		//Navigate to the Jquery dragable page website
		driver.get("https://jqueryui.com/draggable/");
		
		//StepWise Screenshot after navigation to Jquery dragable page website
		u.stepWiseScreenshot("Navigate JQuery Draggable Page");
			
		//Define the page load timeout
		driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
			
		//Implicit wait - Dynamic wait 
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		//Explicit Wait 
		w = new WebDriverWait(driver, 20L);// TODO Auto-generated method stub
		
		//Explicit wait - for the text "Draggable" to be present
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"content\"]/h1"), "Draggable"));

		//Scroll until "Search" Element
		//Scroll until the draggable element is visible in viewport of browser
		//Getting the coords of SEARCH edit box in draggable page
		p = driver.findElement(By.xpath("//*[@id=\"main\"]/form/label/span[2]/input")).getLocation();
		int xCords = p.x;//939
		System.out.println("X Coordinate of Search edit box : "+xCords);
		int yCords = p.y;//389
		System.out.println("Y Coordinate of Search edit box  : "+yCords);
		String convertedString = Integer.toString(yCords);
		j = (JavascriptExecutor)driver;
		j.executeScript("window.scrollTo(0, "+convertedString+");", "");
			
		
		//Switch to frame present draggable page
		/* 
		 * We can switch to frame by three overloading methods:
		 * 1) frame(int index)--> Switch to frame by index number of frame
		 * 2) frame(String id or String name ) --> Switch to frame by ID attribute value present in frame's 
		 * HTML script or by NAME attribute value present in frame's HTML script.
		 * 3) frame(WebElement element) --> Switch to the frame by the address of frame
		 */
		//Switch to the frame by address
		//Address of the frame - can be kept by any of the 8 different locating strategy
		wb = driver.findElement(By.cssSelector("#content > iframe"));
		driver.switchTo().frame(wb);
		
		
		
		//Drag the element 
		act  = new Actions(driver);
		//Address of the element to be dragged in X and Y coordinates
		//No Such Element exception comes - not because of de- synchronization as we have used explicit wait at line 51
		//No Such Element exception comes  also because of frames present 
		//Frame is a webpage embedded inside another web page
		//If the below element is inside frame, then we need to switch focus of selenium from main page to frame
		//Before we drag, we need to switch to frame
		wb = driver.findElement(By.xpath("//*[@id=\"draggable\"]")); 
		act.dragAndDropBy(wb, 100, 60);
		act.build().perform();
				
		//Move focus from frame to main page
		driver.switchTo().defaultContent();
		
		//Click on Droppable LInk
		//Shows no such element exception as the droppable link is not part of the frame.
		//Focus is on frame - move focus back to main page from frame
		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[2]/a")).click();
		
		
		
		//Scroll until "Search" Element
		//Scroll until the droappable element is visible in viewport of browser
		//Getting the coords of SEARCH edit box in droppable page
		p = driver.findElement(By.xpath("//*[@id=\"main\"]/form/label/span[2]/input")).getLocation();
		int xCords1 = p.x;
		System.out.println("X Coordinate of Search edit box : "+xCords1);
		int yCords1 = p.y;
		System.out.println("Y Coordinate of Search edit box  : "+yCords1);
		String convertedString1 = Integer.toString(yCords1);
		j = (JavascriptExecutor)driver;
		j.executeScript("window.scrollTo(0, "+convertedString1+");", "");
		
		//Switch to the frame present in droppable page by index number - Where only frame is present
		//We have find how many frames are there in order to switch to the frame by index number
//		List<WebElement> allFrames = driver.findElements(By.tagName("iframe"));
//		//Number of frames in the webpage - droppable web page
//		int numFrames = allFrames.size();
//		System.out.println("Number of frames in the droppable web page are "+numFrames);
//		driver.switchTo().frame(0);
		
		
		//Switch to the frame present in droppable page by index number - Multi frames in a web page
		List<WebElement> allFrames = driver.findElements(By.tagName("iframe"));
		//Number of frames in the webpage - droppable web page
		int numFrames = allFrames.size();
		System.out.println("Number of frames in the droppable web page are "+numFrames);
		for(int x = 0; x<numFrames; x++) {
			String expectedSrcAttributeVal = "https://jqueryui.com/resources/demos/droppable/default.html";
			String expectedClassAttributeVal  = "demo-frame";
			String actualSrcAttributeVal = allFrames.get(x).getAttribute("src");
			String actualClassAttributeVal = allFrames.get(x).getAttribute("class");
			if(actualSrcAttributeVal.equals(expectedSrcAttributeVal)  &&  actualClassAttributeVal.equals(expectedClassAttributeVal)) {
				driver.switchTo().frame(x);
			}
		}
		
		//Use Actions class to drab and drop the element from source to destination
		act  = new Actions(driver);
		wb = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
		WebElement wbDestination = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
		act.dragAndDrop(wb, wbDestination);
		act.build().perform();
		
		//Move focus from frame to main page
		driver.switchTo().defaultContent();
		
		//Right click or context click anywhere
		//We need to use Actions class to do context click
//		act  = new Actions(driver);
//		act.contextClick(); //Anywhere the cursor is present
//		act.pause(Duration.ofMillis(3000L));
//		act.build().perform();
		
		
		
		//Right click or context click on RESIZABLE link
		act  = new Actions(driver);
		wb = driver.findElement(By.cssSelector("#sidebar > aside:nth-child(1) > ul > li:nth-child(3) > a"));
		act.contextClick(wb); //On the element
		act.pause(Duration.ofMillis(3000L));
		act.build().perform();
		
		
		//Close the browser
		//driver.quit();
		
		
	}

}
