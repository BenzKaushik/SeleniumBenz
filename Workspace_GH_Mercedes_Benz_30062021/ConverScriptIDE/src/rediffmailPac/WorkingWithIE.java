package rediffmailPac;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WorkingWithIE {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		/*Before we run script in IE browser, do the following settings:
		 * 
		 * 1) Zoom should be set to 100%  AND
		 * Tool of IE>Choose Zoom option and set to 100%
		 * 
		 * If Zoom no tset to 100% --> org.openqa.selenium.SessionNotCreatedException:
		 * 
		 * 2) Set the same security level for Internet, Local Intranet and Trusted Sites AND:
		 * Tools> Internet options>Security> Give the same security level for  Internet, Local Intranet 
		 * and Trusted Sites> Click on apply
		 * 
		 * 3) Set the PROTECTED MODE CHECKBOX to ON OR OFF for INternet,  Local Intranet and Trusted Sites
		 * and Restricted Sites
		 * 
		 * org.openqa.selenium.SessionNotCreatedException: Unexpected error launching Internet Explorer. 
		 * Protected Mode settings are not the same for all zones. Enable Protected Mode must be set to 
		 * the same value (enabled or disabled) for all zones.
		 * 
		 * Tools> Internet options>Security> Enable or diable the checkbox for PROTECTED MODE for  Internet, 
		 * Local Intranet, Trusted Sites and Restricted Sites> Click on apply
		 * 
		 * IF any of the three is left, we will get WEBDRIVER EXCEPTION
		 */
		
		//Creating the environment variable to make the system under stand the path of edgedriver executable 
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.IE.driver", path+"\\IEDriverServer.exe") ;
		
		//Control the browser - finding elements on the application opened in browser and performing action like click, type, etc.
	    driver = new InternetExplorerDriver();
	    
	    //Get () method is used to navigate to URL
	    driver.get("https://www.google.co.in");
	    //IF protocol is not given the exception is --> org.openqa.selenium.InvalidArgumentException: Specified URL (www.google.co.in) is not valid.
	   
	    //Maximise the window
	    driver.manage().window().maximize();
	    
	    
	    //Click on the google edit box
	    driver.findElement(By.name("q")).sendKeys("Selenium");
	    
	    
	   
	    //Click on Google Search button
	    driver.findElement(By.name("btnK")).click();
	    
	    
	   
	    //Close the current browser window
	    driver.close();
		

	}

}
