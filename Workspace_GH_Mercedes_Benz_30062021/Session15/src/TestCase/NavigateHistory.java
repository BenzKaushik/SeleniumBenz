package TestCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import Base.BaseSettings;
import Utilities.Utils;

public class NavigateHistory extends BaseSettings{

	public static  WebDriver driver;
	public static  WebDriverWait w;
	public static WebElement wb;
	public static Actions act;
	public static Point p;
	public static JavascriptExecutor j;
	public static Pattern p1;
	public static Screen scr;
	
	
	public static void main(String[] args) throws InterruptedException, IOException, FindFailed {
	    
		//AbstractWebDriverEventListener doc --> https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/events/AbstractWebDriverEventListener.html#afterNavigateForward(org.openqa.selenium.WebDriver)
		//WebDriverEventListener --> https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/events/WebDriverEventListener.html
		//EventFiringWebDriver - > https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/events/EventFiringWebDriver.html
		
		
		
		driver = NavigateHistory.RunBrowser("Edge");
		
		//Utils u = new Utils(driver);
		
		EventFiringWebDriver eDriver = new EventFiringWebDriver(driver);
		
				
		//Class where abstract methods required are defined with their own body
		MyListener m = new MyListener();
		
		//Registration of WebDriverEventListener
		eDriver.register(m);
		
		
		
		//Navigate to Rediff page
		eDriver.navigate().to("https://www.rediff.com/");
		
		//Define the page load timeout
		eDriver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
					
		//Implicit wait - Dynamic wait 
		eDriver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
				
		//Explicit Wait 
		w = new WebDriverWait(eDriver, 20L);
		
		//Wait until the title of the landing page is seen
		w.until(ExpectedConditions.titleIs("Rediff.com: News | Rediffmail | Stock Quotes | Shopping"));
		
		//Print the title of landing page
		String titleLandingPage = eDriver.getTitle();
		System.out.println("Title of the Rediff landing page is "+titleLandingPage);
		
		//Click on Rediffmail
		eDriver.findElement(By.xpath("//a[text() = 'Rediffmail']")).click();
		
		//Wait until the text "Username " is present in rediffmail landing page
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p[text() = 'Username']"), "Username"));
		
		//Print the title of rediffmail page
		String titleRefiffmailPage = eDriver.getTitle();
		System.out.println("Title of the Rediffmail landing page is "+titleRefiffmailPage);
		
		Thread.sleep(3000L);
		
		//Use the back button to navigate to rediff page
		eDriver.navigate().back();
		
		
		//Wait until the title of the Rediff landing page is seen
		w.until(ExpectedConditions.titleIs("Rediff.com: News | Rediffmail | Stock Quotes | Shopping"));
				
		
		//Print the title of landing page
		String titleLandingPage1 = eDriver.getTitle();
		System.out.println("Title of the Rediff landing page after navigating pack is "+titleLandingPage1);
		
		Thread.sleep(3000L);
		
		//NAvigate forward to go to Rediffmail landing page
		eDriver.navigate().forward();
		
		
		//Wait until the text "Username " is present in rediffmail landing page
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p[text() = 'Username']"), "Username"));
				
		
		
		
				
	}
	
	

}
