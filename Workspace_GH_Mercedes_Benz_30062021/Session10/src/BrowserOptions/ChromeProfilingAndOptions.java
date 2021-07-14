package BrowserOptions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;



public class ChromeProfilingAndOptions {
	
	//NOTE: THe below code will work in Selenium 4.0.0 beta and  in Selenium 3.141.59
	
	public static void main(String [] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		
		//Creating logs by Chrome - 1st way
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chrome.log");
		
		//Creating logs by Chrome - 2nd way
		//System.setProperty("webdriver.chrome.logfile", "chrome.log");
		
		//To open Chrome driver executable in silent mode. In this no logs generated
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		
		ChromeOptions ops = new ChromeOptions();
		//ops.setBinary("");
		//ops.setPageLoadStrategy(strategy)
		ops.addArguments("--disable-notifications");
		ops.addArguments("--start-maximized");
		ops.addArguments("ignore-certificate-errors");
		//ops.addArguments("--proxy-server=http://89.2872.292.2:9090");
		
		//Test PRofile of Chrome
		ops.addArguments("user-data-dir=C:\\Users\\lenovo\\AppData\\Local\\Google\\Chrome\\User");
		
		//Kaushik Profile
		//ops.addArguments("user-data-dir=C:\\Users\\lenovo\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
		
		
		
		
		ChromeDriver cd = new ChromeDriver(ops);
		cd.get("http://pushengage.com/demo");
		// 100 lines
		
	}

}
