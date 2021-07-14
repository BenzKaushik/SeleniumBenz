package usingAllLocatorsFirefox;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//TakesScreenshot Interface Doc --> https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/TakesScreenshot.html
//GetScreenshotAs(OutputType) - method of TakesScreenshot 
/*
 * Output Type is an INTERFACE 
 * 
 * 1) Output Type can be as Base64 - that means in encrypted format
 *2) Output Type can be as Bytes - that means in raw bytes
 *3)Output Type can be as File - this will temporary file and gets deleted when JVM exits.
 * 
 * This file from TEMPORARY LOCATION has to be copied to PERMANENT LOCATION. For copying we use
 * the copyFiles method present in FileUtils class. FileUtils class is present in COMMON IO API.
 * 
 * The output type file can be in PNG fornmat or JPEG FORMAT
 * 
 * 
 */


public class ExampleGoogleSearch extends BaseSettings {
	
	public static WebDriver driver;
	public static WebDriverWait w;

	public static void main(String[] args) throws IOException, InterruptedException {
		driver = ExampleGoogleSearch.RunBrowser("Firefox");
		
		//Maximise the browser window
		driver.manage().window().maximize();
		
		//Navigate to the YAHOO website
		driver.get("https://www.google.com/");
		
		//StepWise Screenshot after navigation to googleto take the screenshot
		//Casting the driver 
		/*
		 * TakesScreenshot scr = (TakesScreenshot)driver; File tempFile =
		 * scr.getScreenshotAs(OutputType.FILE); //Permanent location address File
		 * permanentFile = new
		 * File(System.getProperty("user.dir")+"\\StepwiseScreenshot\\Navigate.png");
		 * //Copy from temporary location to permanent location
		 * FileUtils.copyFile(tempFile, permanentFile);
		 */
		ExampleGoogleSearch.stepWiseScreenshot("NavigateGoogle");
			
		//Define the page load timeout
		driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
			
		//Implicit wait - Dynamic wait 
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		//Explicit Wait 
		w = new WebDriverWait(driver, 30L);
		
	
		//Type on Google Edit box
		/*ID locating strategy cannot be used as the ID attribute is not present in the HTML script of 
		Google Edit box.*/
		/*Working -> Using name locating strategy  as the NAME attribute is present in the HTML script 
		of Google Edit box*/
		//driver.findElement(By.name("q")).sendKeys("Selenium RC");
		//Class name locating strategy cannot be used as it is a compound class value
		//driver.findElement(By.className("gLFyf gsfi")).sendKeys("Selenium RC");
		/*Working --> Using tagname locating strategy , it is working . INPUT tag is not unique in the 
		web page but it is the first INPUT tag from top of the DOM and so selenium performs action 
		correctly on the correct element*/
		//driver.findElement(By.tagName("input")).sendKeys("Selenium RC");
		//LinkText locating strategy cannot be used as this is an edit box and not a link
		//Partial Link Text locating strategy cannot be used as this is an edit box and not a link
		//Working for Chrome and Firefox - XPATH location strategy - from inspect element of Firefox and Chrome 
		//driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Selenium RC");
		//Working --> CssSeelctor locating strategy got from inspect element of chrome is working
		//driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input")).sendKeys("Selenium RC");
		//Firefox and Chrome--> When running with a value which is part of compound class value , it is showing ecxception -->  org.openqa.selenium.ElementNotInteractableException: Element <div class="pR49Ae gsfi"> is not reachable by keyboard
		//driver.findElement(By.cssSelector(".gsfi")).sendKeys("Selenium RC");
		//Firefox --> When running with a value which is part of compound class value , it is working fine.
		driver.findElement(By.cssSelector(".gLFyf")).sendKeys("Selenium RC");
		
		//StepWise Screenshot after Typing on google edit box
		ExampleGoogleSearch.stepWiseScreenshot("TypedGoogleEditBox");
		
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
		web page but it is the first INPUT tag from top of the DOM . But the action performed is not 
		typing but SUBMITTING. So based on action defined, it is performing the action on the first button from top*/
		//driver.findElement(By.tagName("input")).submit();
		//LinkText locating strategy cannot be used as this is an button and not a link
		//Partial Link Text locating strategy cannot be used as this is an button and not a link
		//XPATH location strategy from Chrome - from inspect element of chrome but shows exception on CHrome and Firefox -->  org.openqa.selenium.NoSuchElementException
		//driver.findElement(By.xpath("/html/body/div[2]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).submit();							
		//Xpath from Firefox - Workis fine for both
		//driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).submit();
		//Working --> CssSeelctor locating strategy got from inspect element of chrome is working in Chrome and Firefox
		//driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.gNO89b")).submit();
		//Working --> CssSeelctor locating strategy got from inspect element of Firefox is working in Chrome and Firefox
		driver.findElement(By.cssSelector(".FPdoLc > center:nth-child(1) > input:nth-child(1)")).submit();
	
		Thread.sleep(5000L);
		
		//Take a screenshot after the title condition is met
		w.until(ExpectedConditions.titleIs("Selenium RC - Google Search"));
		
		//Take a screenshot after the text condition is met
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[7]/div/div[9]/div[1]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div[1]/a/h3"), "What is Selenium RC : Difference from Webdriver ..."));
		
		//StepWise Screenshot after Clicking on google search button
		ExampleGoogleSearch.stepWiseScreenshot("ClickedGoogleSearchButton");
		
		//Close the browser
		driver.quit();
		
	}
	
	//Function for Stepwise screenshot
	public static void stepWiseScreenshot(String stepName) {
		
		try {
			Date d = new Date();
			String newDateformat = d.toString().replace(" ", "_").replace(":", "_");
			TakesScreenshot scr = (TakesScreenshot)driver;
			File tempFile = scr.getScreenshotAs(OutputType.FILE);
			//Permanent location address
			File permanentFile = new File(System.getProperty("user.dir")+"\\StepwiseScreenshot\\"+stepName+"_"+newDateformat+".png");
			//Copy from temporary location to permanent location
			FileUtils.copyFile(tempFile, permanentFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
