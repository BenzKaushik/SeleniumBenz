package BrowserOptions;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.firefox.FirefoxDriver.Capability;
import org.openqa.selenium.ie.ElementScrollBehavior;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class IEOptionsExample {
	
	// notifications - no
	// binary - no
	// no profiling
	// proxy, certificates
	
	//Selenium 4.0.0_beta
	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\IEDriverServer.exe");
		
		//Set the logging level
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGLEVEL_PROPERTY, "INFO");
		//Create the log
		System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY, "ie.log");
		//Opening the IEDriverServer in silent mode by making the value as TRUE - this will create an empty log
		//System.setProperty(InternetExplorerDriverService.IE_DRIVER_SILENT_PROPERTY, "true");

		InternetExplorerOptions options = new InternetExplorerOptions();
		
		//Page load Strategy
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		
		//Scroll mode
		options.elementScrollTo(ElementScrollBehavior.BOTTOM);
		
		
		
		//Proxy Settings
		/*
		 * String proxy="82.288.287.22:8080"; Proxy p = new Proxy();
		 * p.setAutodetect(false); p.setProxyType(Proxy.ProxyType.MANUAL);
		 * p.setSocksProxy(proxy); options.setProxy(p);
		 */
		
		//DesiredCapabilities  - This class to used to do browser settings
		DesiredCapabilities cap = new DesiredCapabilities();
		
		//Proxy Settings
		String proxy="82.288.287.22:8080";
		Proxy p = new Proxy();
		p.setAutodetect(false);
		p.setProxyType(Proxy.ProxyType.MANUAL);
		p.setSocksProxy(proxy);
		
		//Setting the capability of IE browser with proxy 
		cap.setCapability(CapabilityType.PROXY, p);
		
		//Use the merge() method of InternetOptoions class to merge the capabilities
		options.merge(cap);
		
		InternetExplorerDriver ie = new InternetExplorerDriver(options);
		//InternetExplorerDriver ie = new InternetExplorerDriver();
		ie.get("https://expired.badssl.com/");
		
	   //Using javascript we are finding this  element "Continue to this website (not recommended). "
		//This element when spied upon will show the id value as "overridelink"
		ie.get("javascript:document.getElementById('overridelink').click();");// standard code
		
		
		
		
		
		
		
		
	}

}
