package usingAllLocators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ExampleGoogleSearch extends BaseSettings {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		driver = ExampleGoogleSearch.RunBrowser("IE");
		
		//Maximise the browser window
		driver.manage().window().maximize();
		
		//Navigate to the YAHOO website
		driver.get("https://www.google.com/");
			
		//Define the page load timeout
		driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
			
		//Implicit wait - Dynamic wait 
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
	
		//Type on Google Edit box
		/*ID locating strategy cannot be used as the ID attribute is not present in the HTML script of 
		Google Edit box.*/
		/*Working -> Using name locating strategy  as the NAME attribute is present in the HTML script 
		of Google Edit box*/
		//driver.findElement(By.name("q")).sendKeys("Selenium RC");
		//Class name locating strategy cannot be used as it is a compound class value
		/*Working --> Using tagname locating strategy , it is working . INPUT tag is not unique in the 
		web page but it is the first INPUT tag from top of the DOM and so selenium performs action 
		correctly on the correct element*/
		//driver.findElement(By.tagName("input")).sendKeys("Selenium RC");
		//LinkText locating strategy cannot be used as this is an edit box and not a link
		//Partial Link Text locating strategy cannot be used as this is an edit box and not a link
		//XPATH location strategy - from inspect element of chrome but shows exception -->  org.openqa.selenium.NoSuchElementException
		//driver.findElement(By.xpath("/html/body/div[2]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Selenium RC");
		//Working --> CssSeelctor locating strategy got from inspect element of chrome is working
		driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input")).sendKeys("Selenium RC");
	
	
	
		//Click on Google Search Button
		/*ID locating strategy cannot be used as the ID attribute is not present in the HTML script of 
		Google Search buttton.*/
		/*Working -> Using name locating strategy  as the NAME attribute is present in the HTML script 
		of Google Search buttton.*/
		//driver.findElement(By.name("btnK")).submit();
		/*Working --> Class name locating strategy is working even if the class attribute value is not 
		a section in CSS file (STYLE TAB OF INSPECT ELEMENT.*/
		//driver.findElement(By.className("gNO89b")).submit();
		/*Working --> Using tagname locating strategy , it is working . INPUT tag is not unique in the 
		web page but it is the first INPUT tag from top of the DOM . But the baction performed is not 
		typing but SUBMITTING. So based on action defined, it is performing the action on the first button from top*/
		//driver.findElement(By.tagName("input")).submit();
		//LinkText locating strategy cannot be used as this is an button and not a link
		//Partial Link Text locating strategy cannot be used as this is an button and not a link
		//XPATH location strategy - from inspect element of chrome but shows exception -->  org.openqa.selenium.NoSuchElementException
		//driver.findElement(By.xpath("/html/body/div[2]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).submit();
		//Working --> CssSeelctor locating strategy got from inspect element of chrome is working
		driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.gNO89b")).submit();
	
	
	}

}
