package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseSettings {
	
	public static  WebDriver driver;
	
	//Function to run on the browser
	public static WebDriver RunBrowser(String expectedBrowserName) {
		
		if(expectedBrowserName.equals("Chrome")) {
			//Create an environment variable to tell system the location of chromedriver.exe
			//Use chromedriver.exe to find the executable of CHrome browser and invoke the Chrome browser
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			
			//Create and object of ChromeDriver class
			//The Chromedriver class controls the Chrome browser
			driver  = new ChromeDriver();
			
			return driver;
		}else if(expectedBrowserName.equals("Firefox")) {
			//Create an environment variable to tell system the location of geckodriver.exe
			//Use geckodriver.exe to find the executable of Firefox browser and invoke the Firefox browser
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\geckodriver.exe");
			
			//Create and object of FirefoxDriver class
			//The Firefoxdriver class controls the Firefox browser
			driver  = new FirefoxDriver();
			
			return driver;
		}else if(expectedBrowserName.equals("IE")) {
			//Create an environment variable to tell system the location of IEDriverServer.exe
			//Use IEDriverServer.exe to find the executable of IE browser and invoke the IE browser
			System.setProperty("webdriver.IE.driver", System.getProperty("user.dir")+"\\IEDriverServer.exe");
			//System.setProperty("webdriver.IE.driver", "C:\\driver\\IEDriverServer.exe");
			
			//Create and object of InternetExplorerDriver class
			//The InternetExplorerDriver class controls the IE browser
			driver  = new InternetExplorerDriver();
			
			return driver;
		}else if(expectedBrowserName.equals("Edge")) {
			//Create an environment variable to tell system the location of msedgedriver.exe
			//Use msedgedriver.exe to find the executable of EDGE browser and invoke the EDGE browser
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\msedgedriver.exe");
			
			//Create and object of EdgeDriver class
			//The EdgeDriver class controls the IE browser
			driver  = new EdgeDriver();
			
			return driver;
		}
		
		return driver;
	}

}
