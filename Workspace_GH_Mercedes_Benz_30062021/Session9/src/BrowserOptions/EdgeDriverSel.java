package BrowserOptions;



import org.openqa.selenium.Keys;


import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class EdgeDriverSel {
	
	//NOTE: THe below code will work in Selenium 4.0.0 beta and not in Selenium 3.141.59
	
	public static void main(String[] args) {
	 
		System.setProperty("webdriver.edge.driver", "C:\\Users\\lenovo\\Desktop\\Workspace_GH_Mercedes_Benz_30062021\\Session9\\msedgedriver.exe");
		System.setProperty(EdgeDriverService.EDGE_DRIVER_LOG_PROPERTY,"edge.log");	
		
		
		EdgeOptions options = new EdgeOptions();
		
		//Setting Proxy server
		/*
		 * Proxy p = new Proxy(); p.setHttpProxy("192.168.1.1:5678");
		 * options.setProxy(p);
		 */
		
		//Set Page load Strategy
		//options.setPageLoadStrategy("EAGER");
		
		
		
		
		// NOTIFICATIONS and PROFILE
		EdgeDriver driver = new EdgeDriver(options);// make sure previous session is closed
		
		
		//Handle certificates
		driver.get("https://untrusted-root.badssl.com/");
		driver.manage().window().maximize();
		//Click on Advance
		driver.findElement(By.id("details-button")).click();
		//Click on Proceed to Untrusted Website
		driver.findElement(By.id("proceed-link")).click();
		
	
		
	
	}

}
