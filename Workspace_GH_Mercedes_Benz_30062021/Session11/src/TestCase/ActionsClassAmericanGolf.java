package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseSettings;
import Utilities.Utils;

public class ActionsClassAmericanGolf extends BaseSettings{
	
	public static  WebDriver driver;
	public static  WebDriverWait w;
	public static WebElement wb;
	public static Actions act;
	
	//Works in EDGE< FIREFOX and CHROME
	public static void main(String[] args) {
		driver = ActionsClassAmericanGolf.RunBrowser("Edge");
		
		//CReate the object of Utils class
		Utils u = new Utils(driver);
		
		//Maximise the browser window
		driver.manage().window().maximize();
		
		//Navigate to the Rediffmail Form Creation website
		driver.get("https://www.americangolf.co.uk/");
		
		//StepWise Screenshot after navigation to Rediffmail form cration page to take the screenshot
		u.stepWiseScreenshot("Navigate Amaerican Golf");
			
		//Define the page load timeout
		driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
			
		//Implicit wait - Dynamic wait 
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		//Explicit Wait 
		w = new WebDriverWait(driver, 20L);
		
		//To handle POP UP created by HTML
		u.IsPopUpHTMLPresent("/html/body/div[2]/div[1]/div[1]/div/div/div/div/div/span");
		
		//Accept the cookie pop up - Accept button
		//driver.findElement(By.xpath("//*[@id='termly-code-snippet-support']/div/div/div/div/div[2]/button[2]")).click();
		u.IsPopUpHTMLPresent("//*[@id='termly-code-snippet-support']/div/div/div/div/div[2]/button[2]");
		
		//Hovering mouse over GOLF clubs menu button
		//driver.findElement(By.xpath("//*[@id=\"header-navigation\"]/div[1]/ul/li[2]/a")).click();
		act = new Actions(driver);
		//Address of GOLF CLUBS  menu button
		wb = driver.findElement(By.xpath("//*[@id='header-navigation']/div[1]/ul/li[2]/a"));
		act.moveToElement(wb);//Hovering technique
		act.build().perform();
		
		//Wait until the WEDGE is present by its text
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='CLUBS_1']/ul/li[2]/ul/li[2]/a/span"), "Wedges"));
				
		
		//Click on WEDGES sub menu button of GOLF CLUBS button
		//driver.findElement(By.xpath("//*[@id=\"CLUBS_1\"]/ul/li[2]/ul/li[2]/a/span")).click();
		//The below code gives MOVE TARGET OUT OF BOUNDARY EXCEPTION
		act = new Actions(driver);
		//Address of WEDGES sub menu button
		wb = driver.findElement(By.xpath("//*[@id='CLUBS_1']/ul/li[2]/ul/li[2]/a/span"));
		act.moveToElement(wb).click();//Clicking technique
		act.build().perform();
		
		//wait until the text GOLF WEDGES is present in WEDGES page
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/div/h1"), "Golf Wedges"));
		
		//Scroll until the slider is visible in viewport of browser
		Point p = driver.findElement(By.xpath("//*[@id=\"secondary\"]/div[1]/div[8]/div/div/div[1]/div/div/div[1]/div")).getLocation();
		int xCords = p.x;//127
		System.out.println("X Coordinate of left point of slider in wedges page : "+xCords);
		int yCords = p.y;//1800
		System.out.println("Y Coordinate of left point of slider in wedges page : "+yCords);
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("window.scrollTo(0, 1400);", "");
		
		//Print out the minimum price before sliding the slider from left to right
		String priceBeforeSliding = driver.findElement(By.xpath("//*[@id=\"secondary\"]/div[1]/div[8]/div/div/div[2]/div[1]")).getText();
		System.out.println("Price before Sliding: "+priceBeforeSliding);
		
		//Slide the slider from LEFT POINT towards right
		act = new Actions(driver);
		//Address of left point of the slider 
		wb = driver.findElement(By.xpath("//*[@id=\"secondary\"]/div[1]/div[8]/div/div/div[1]/div/div/div[1]/div"));
		act.dragAndDropBy(wb, 40, 0);
		act.build().perform();
		
		//Print out the minimum price after sliding the slider from left to right
		String priceAfterSliding = driver.findElement(By.xpath("//*[@id=\"secondary\"]/div[1]/div[8]/div/div/div[2]/div[1]")).getText();
		System.out.println("Price after Sliding: "+priceAfterSliding);
																
		//Close the browser
		driver.quit();
		
	}

}
