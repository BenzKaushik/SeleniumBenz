package TestCase;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseSettings;
import Utilities.Utils;

public class CookieAmericanGolf extends BaseSettings{
	
	public static  WebDriver driver;
	public static  WebDriverWait w;
	public static WebElement wb;

	public static void main(String[] args) {
		driver = CookieAmericanGolf.RunBrowser("Chrome");
		
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
		
		//Accept the cookie pop up - Accept button
		driver.findElement(By.xpath("//*[@id=\"termly-code-snippet-support\"]/div/div/div/div/div[2]/button[2]")).click();
		
		
		//Cookies are temporary files
		/*Cookie have a name, the domain name from which cookie has come, expiry date in unix timestamp, 
		and a unique COOKIE ID.*/
		//What is Unix time stamp? --> https://www.unixtimestamp.com/
		//Cookies were created by IBM and the first cookie to be released was JAn 1 1970.
		//So every cookie has a expire period which is set from Jan 1 1970
		/*There are two kinds of cookie: 1) Per Session cookie 2) Persistent cookie.
		 * 
		 * 1) Per Session cookie - As soon as the session gets closed the cookie expires.
		 * 
		 * 2) Persistent cookie - cookie will not get killed on closing the session, but will 
		 * expire after some hours, minutes, days,etc. This time for expiration is defined in 
		 * persistent cookie as a UNIX TIMESTAMP.
		 */
		
		
		
		//Cookies in Selenium - get all cookies used in the website "https://www.americangolf.co.uk/"
		Set<Cookie> allCookie = driver.manage().getCookies();
		Iterator<Cookie> iter = allCookie.iterator();
		//If the data is present in SET , the hasNext() method return boolean true
		//If the data is not present in SET , the hasNext() method return boolean false
		//Until and unless data is there in SET, while loop will run
		
		while(iter.hasNext()) {
			//System.out.println(iter.next());
			Cookie c = iter.next();
			String val = c.toString();
			System.out.println(val);
			System.out.println("******************************************");
		}
		
		//Create a cookie - Use the Cookie class
		//Cookie c = new Cookie();
		
		//Delete all cookies of https://www.americangolf.co.uk/
		 //driver.manage().deleteAllCookies();
		 
		 System.out.println("**********Getting cookies after deleteing all**********");
		 
		//Cookies in Selenium after deleting all - get all cookies used in the website "https://www.americangolf.co.uk/"
		//The below method WORKS
		/*
		 * Set<Cookie> allCookie1 = driver.manage().getCookies(); Iterator<Cookie> iter1
		 * = allCookie1.iterator(); //If the data is present in SET , the hasNext()
		 * method return boolean true //If the data is not present in SET , the
		 * hasNext() method return boolean false //Until and unless data is there in
		 * SET, while loop will run while(iter1.hasNext()) {
		 * System.out.println(iter1.next());
		 * System.out.println("******************************************"); }
		 */	
		 
		 System.out.println("**********Getting cookies after deleteing one**********");
		 
		 driver.manage().deleteCookieNamed("_pk_ses.3.38d9=1;");
		 
		 Set<Cookie> allCookie1 = driver.manage().getCookies(); 
		  Iterator<Cookie> iter1 = allCookie1.iterator(); 
		  //If the data is present in SET , the hasNext() method return boolean true 
		  //If the data is not present in SET , thehasNext() method return boolean false 
		  //Until and unless data is there in SET, while loop will run 
		  while(iter1.hasNext()) {
			  System.out.println(iter1.next());
			  System.out.println("******************************************"); 
		  }		 
			  
			 	
	}

}
