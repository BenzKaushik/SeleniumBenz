package TestCase;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseSettings;
import Utilities.Utils;

public class MultiWindows extends BaseSettings{
	public static  WebDriver driver;
	

	public static void main(String[] args) {
		driver = MultiWindows.RunBrowser("Firefox");
		
		Utils u = new Utils(driver);
		
		//Maximise the browser window
		driver.manage().window().maximize();
		
		//Navigate to the BBC website
		driver.get("https://news.google.com");
		
		//Define the page load timeout
		driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
			
		//Implicit wait - Dynamic wait 
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		

		//Get the title of the landing page
		String titleLandingpage = driver.getTitle();
		System.out.println("Title of the landing page is "+titleLandingpage);
		
		//Click on the first NEWS . Since the position of first news will not change , only text will change
		//Position is what XPATH or CSS SE:LECTOR defines
		//So using xpath or can use CSS SELECTOR.
		driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div[2]/div/main/c-wiz/div[1]/div[3]/div/div/article/a")).click();
	
	
		/*Need to understand that what we did or at which point  because of which we opened a TABBED window, 
		or a new Window or a pop up windows(created by HTML script).
		
		*At that point use the below codes to get SESSIONID of all windows whether Selenium has focus or not.
		*
		*Use the getWindowHandles() method - to get Session iD of all windows
		*
		*
		*/
		
		//Just shown the getWindowHandle method 
		String mainWinID = driver.getWindowHandle();//Will get window id of the window which has focus of Selenium
		System.out.println("Session iD of the main window i.e. the window on which Slenium has focus is "+mainWinID);
	
		System.out.println("**************************************************************");
		
		//But we need to use getWindowHandles() method once a tabbed windows or pop up or new window get triggered
		Set<String> allWinSessionID = driver.getWindowHandles();
		Iterator<String> iter = allWinSessionID.iterator();
		String mainWinsID = iter.next();
		System.out.println("Main Window ID "+mainWinsID);
		String tabbedWinsID  = iter.next();
		System.out.println("Tabbed Window ID "+tabbedWinsID);
		//String tabbedWinsID1  =iter.next();//No Such Element exception
		//System.out.println(tabbedWinsID1);
		
		//Right now focus of Selenium is in Main window. Move focus to tabbed window
		driver.switchTo().window(tabbedWinsID);
		
		//How do we know that focus has moved to tabbed window? Lets get the title of tabbed windows
		String tabbedWinTitle = driver.getTitle();
		System.out.println("Tabbed Window title is "+tabbedWinTitle);
		
		//Verify the text "Ahead of cabinet reshuffle, Thaawarchand Gehlot appointed as Karnataka Governor" in tabbed window
		u.VerifyText("Ahead of cabinet reshuffle, Thaawarchand Gehlot appointed as Karnataka Governor, Sreedharan Pillai as Goa Governor", "xpath", "//*[@id=\"section\"]/div/div[2]/div/h1", "for tabbed window");
		
		//Move focus from tabbed window to main window
		driver.switchTo().window(mainWinsID);
		
		//Verify the HEADLINES text in main window
		u.VerifyText("Headlines", "xpath", "//*[@id=\"i23\"]/div[1]/h2/span/a", "for main window");
		
		//CLose the browser
		driver.quit();
		
	
	}

}
