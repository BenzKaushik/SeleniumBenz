package BrowserOptions;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;

//NOTE: THe below code will work in Selenium 4.0.0 beta and not in Selenium 3.141.59
public class EdgeDriverSel {
	// pre requisites - careful with edge version
	// logs
	// page load strategy
	// binary 
	// PROXY	
	// Profiling - NO
	// Notifications
	// certificate
	 
	
	public static void main(String[] args) {
		 
		//System.setProperty("webdriver.edge.driver", "C:\Users\lenovo\Desktop\Workspace_GH_Mercedes_Benz_30062021\Session10\msedgedriver.exe");
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\msedgedriver.exe");
		
		//First way to get log
		System.setProperty(EdgeDriverService.EDGE_DRIVER_LOG_PROPERTY,"edge.log");
		//Second way to get log
		System.setProperty("webdriver.edge.logfile", "edge.log");
		
		//Opening edge driver in Silent mode - no logs generated - first way
		//System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		//Opening edge driver in Silent mode - no logs generated - second way
		//System.setProperty("webdriver.edge.silentOutput","true");
		
		EdgeOptions options = new EdgeOptions();
		
		
		//options.setBinary(new File(""));
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		//options.addArguments("--proxy-server=http://83.209.94.87:8123");
		//options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		//options.addArguments("ignore-certificate-errors");
		//options.setHeadless(true);
		
		
		EdgeDriver driver = new EdgeDriver(options);// make sure previous session is closed
		//driver.get("https://www.pushengage.com/demo");
		//String title = driver.getTitle();
		//System.out.println(title);
		
		
		//Handling Certificates	 - use these codes when commenting line 44
		driver.get("https://untrusted-root.badssl.com/");
		//Click on Advance
		driver.findElement(By.id("details-button")).click();
		//Click on Proceed to Untrusted Website
		driver.findElement(By.id("proceed-link")).click();
		
	
	
	}

}
