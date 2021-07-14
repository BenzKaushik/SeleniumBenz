package htmlUnitDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class ExampleHtmlUnitDriver {
	
	//HTMLUNITDRIVER DOC-->https://www.javadoc.io/doc/org.seleniumhq.selenium/selenium-htmlunit-driver/latest/org/openqa/selenium/htmlunit/HtmlUnitDriver.html#HtmlUnitDriver-boolean-

	public static void main(String[] args) {


		//CReate an object of HTMLUnitDriver
		HtmlUnitDriver driver  = new HtmlUnitDriver();
		
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
		
		//
		
	}

}
