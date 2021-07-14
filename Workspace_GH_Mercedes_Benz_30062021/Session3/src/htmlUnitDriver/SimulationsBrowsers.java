package htmlUnitDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class SimulationsBrowsers {

	public static void main(String[] args) {
		
		//CReate an object of HTMLUnitDriver and simulate other browsers
		HtmlUnitDriver driver  = new HtmlUnitDriver(BrowserVersion.CHROME);
		//HtmlUnitDriver driver  = new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER);
		//HtmlUnitDriver driver  = new HtmlUnitDriver(BrowserVersion.FIREFOX);
		
		
		BrowserVersion bv = driver.getBrowserVersion();
		String appName = bv.getApplicationName();
		System.out.println(appName);
		String vendor = bv.getVendor();
		System.out.println(vendor);
		int brVer = bv.getBrowserVersionNumeric();
		System.out.println(brVer);
		
		
		//Maximize the browser window
		driver.manage().window().maximize();
		
		//NAvigate to BBC website
		driver.get("https://www.bbc.com/");
		
		//Title of the landing page
		String titleLandingPage = driver.getTitle();
		System.out.println("Title of the landing page is "+titleLandingPage);
		
		//Click on the news link - China won't be bullied
		driver.findElement(By.linkText("China won't be bullied, says Xi on 100th anniversary")).click();

		//Get the title of link page
		String titleLinkPage = driver.getTitle();
		System.out.println("Title of the Link page is "+titleLinkPage);
		
		//Close the browser
		driver.quit();
		
	}

}
