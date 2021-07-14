package htmlUnitDriver;

import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class enebaleJavascript {

	public static void main(String[] args) {
		
		//CReate an object of HTMLUnitDriver and enabling Javascript so that html unit driver handles javascipr in browser
		HtmlUnitDriver driver  = new HtmlUnitDriver(true);
		
		//Disable the warning in console when Javascript is enabled
		java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF); 
		
		//Maximize the browser window
		driver.manage().window().maximize();
		
		//NAvigate to BBC website
		driver.get("https://www.bbc.com/");
		
		//Title of the landing page
		String titleLandingPage = driver.getTitle();
		System.out.println("Title of the landing page is "+titleLandingPage);
		
		//Get the text of China won't be bullied
		String text = driver.findElement(By.xpath("//*[@id='page']/section[3]/div/ul/li[1]/div/div[2]/h3/a")).getText();
		System.out.println("Text of the link is "+text);
		
		
		//Click on the news link - China won't be bullied
		driver.findElement(By.linkText("China won't be bullied, says Xi on 100th anniversary")).click();

		//Get the title of link page
		String titleLinkPage = driver.getTitle();
		System.out.println("Title of the Link page is "+titleLinkPage);
		
		//Close the browser
		driver.quit();
		

	}

}
