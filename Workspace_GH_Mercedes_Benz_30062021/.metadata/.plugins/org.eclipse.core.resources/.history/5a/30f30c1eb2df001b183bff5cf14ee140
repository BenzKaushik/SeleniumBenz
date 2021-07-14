package Base;

import javax.management.openmbean.OpenMBeanAttributeInfoSupport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseSettings {
	
	public static  WebDriver driver;
	
	//Function to run on the browser
	public static WebDriver RunBrowser(String expectedBrowserName) {
		
		if(expectedBrowserName.equals("Chrome")) {
			//Create an environment variable to tell system the location of chromedriver.exe
			//Use chromedriver.exe to find the executable of CHrome browser and invoke the Chrome browser
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			
			//Creating logs by Chrome - 1st way
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chrome.log");
			
			ChromeOptions ops = new ChromeOptions();
			//Disallow notifications
			ops.addArguments("--disable-notifications");
			//Disable information bars
			ops.addArguments("disable-infobars");
			
			//Create and object of ChromeDriver class
			//The Chromedriver class controls the Chrome browser
			driver  = new ChromeDriver(ops);
			
			return driver;
		}else if(expectedBrowserName.equals("Firefox")) {
			//Create an environment variable to tell system the location of geckodriver.exe
			//Use geckodriver.exe to find the executable of Firefox browser and invoke the Firefox browser
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\geckodriver.exe");
			
			//LogFile of Firefox
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "firefox.log");
			
			FirefoxOptions ops  = new FirefoxOptions();
			//Disallow notifications
			ops.addArguments("--disable-notifications");
			//Disable information bars
			ops.addArguments("disable-infobars");
			
			/*FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("dom.webnotifications.enabled", false);
			//USe the setPRofile method of FirefoxOptins class
			ops.setProfile(profile);
			driver  = new FirefoxDriver(ops);*/
			
			//Create and object of FirefoxDriver class
			//The Firefoxdriver class controls the Firefox browser
			driver  = new FirefoxDriver(ops);
			
			
			return driver;
		}else if(expectedBrowserName.equals("IE")) {
			//Create an environment variable to tell system the location of IEDriverServer.exe
			//Use IEDriverServer.exe to find the executable of IE browser and invoke the IE browser
			System.setProperty("webdriver.IE.driver", System.getProperty("user.dir")+"\\IEDriverServer.exe");
			//System.setProperty("webdriver.IE.driver", "C:\\driver\\IEDriverServer.exe");
			
			//Set the logging level
			System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGLEVEL_PROPERTY, "INFO");
			//Create the log
			System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY, "ie.log");
			
			
			
			//DesiredCapabilities  - This class to used to do browser settings
			//Unexpected Alert is handles and so it is made to true
			DesiredCapabilities cap = new DesiredCapabilities();
			//cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, false);
			
			InternetExplorerOptions ops = new InternetExplorerOptions();
			ops.merge(cap);
			
			//Create and object of InternetExplorerDriver class
			//The InternetExplorerDriver class controls the IE browser
			driver  = new InternetExplorerDriver(ops);
			
			return driver;
		}else if(expectedBrowserName.equals("Edge")) {
			//Create an environment variable to tell system the location of msedgedriver.exe
			//Use msedgedriver.exe to find the executable of EDGE browser and invoke the EDGE browser
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\msedgedriver.exe");
			
			System.setProperty(EdgeDriverService.EDGE_DRIVER_LOG_PROPERTY,"edge.log");	
			
			EdgeOptions ops = new EdgeOptions();
			//ops.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true);
			
			
			//Create and object of EdgeDriver class
			//The EdgeDriver class controls the IE browser
			driver  = new EdgeDriver(ops);
			
			return driver;
		}
		
		return driver;
	}

}
