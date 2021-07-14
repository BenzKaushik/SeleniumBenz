package part2;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import usingAllLocatorsFirefox.BaseSettings;
import usingAllLocatorsFirefox.ExampleGoogleSearch;


public class EchoWebsite extends BaseSettings{
	
	public static WebDriver driver;
	public static WebDriverWait w;
	public static String actualAttributeValue;
	public static String expectedAttributeValue;

	public static void main(String[] args) throws InterruptedException {

		driver = EchoWebsite.RunBrowser("Chrome");
		
		//Maximise the browser window
		driver.manage().window().maximize();
		
		//Navigate to the YAHOO website
		driver.get("http://www.echoecho.com/htmlforms14.htm");
		
		//StepWise Screenshot after navigation to googleto take the screenshot
		EchoWebsite.stepWiseScreenshot("NavigateEchoecho");
			
		//Define the page load timeout
		driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
			
		//Implicit wait - Dynamic wait 
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		//Explicit Wait 
		w = new WebDriverWait(driver, 30L);
		
		//Find out the number of edit boxes in the landing page with type value equal to "TEXT"
		List<WebElement>  allElementTagnameInput = driver.findElements(By.tagName("input"));
		int counter = 0;
		for(int x = 0; x<allElementTagnameInput.size(); x++) {
			String actualAttributeVal = allElementTagnameInput.get(x).getAttribute("type");
			String expectedAttributeVal = "text";
			if(actualAttributeVal.equals(expectedAttributeVal)) {
				counter = counter+1; //1,2,3
			}
		}
		System.out.println("Number of edit box with type value equal to text are "+counter);
		
		//Verify that the attribute value for the “Value” attribute is “Enter your name here!”
		EchoWebsite.VerifyAttributeValue("Enter your name here!", "xpath", "/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td/input[1]", " value attribute", "value");
	
		//Click on the image UI
		//xpath - taken from browser opened by Selenium
		//driver.findElement(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td/input[2]")).click();
		//cssSelecor - taken from browser opened by Selenium								 
		driver.findElement(By.cssSelector("body > div:nth-child(2) > table:nth-child(14) > tbody > tr > td.main > table > tbody > tr > td > div > span > form > table:nth-child(58) > tbody > tr > td > table > tbody > tr > td > input[type=image]:nth-child(4)")).click();
		
		
		Thread.sleep(3000L);
		
		//The alert is not created by HTML as we cannot SPY with INSPECT ELEMENT
		//The alert is created by Javascript
		//To handle Javascript alerts we need to ue the ALERT INTERFACE
		//Alert Interface Doc -https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/Alert.html
		//To work with Javascript alert, we need to Switch from Main window to alert window
		Alert a = driver.switchTo().alert();
		String text = a.getText();
		System.out.println("Text present in alert is "+text);
		a.accept();//Click on OK BUTTON
		//a.dismiss();//Cancel the alert
		//a.sendKeys("Kaushik Mukherjee");
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
	
	//Verification function for attribute value present in element's HTML script
		public static void VerifyAttributeValue(String expectedAttributeValue, String locatorType, String locatorValue, String msg, String attributeName) {
			EchoWebsite.expectedAttributeValue = expectedAttributeValue;
			if(locatorType.equals("id") && attributeName.equals("id")) {
				actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("id");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("id") && attributeName.equals("name")) {
				actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("name");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("id") && attributeName.equals("class")) {
				actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("class");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("id") && attributeName.equals("value")) {
				actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("value");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("id") && attributeName.equals("src")) {
				actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("src");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("id") && attributeName.equals("href")) {
				actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("href");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("className") && attributeName.equals("id")) {
				actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("id");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("className") && attributeName.equals("name")) {
				actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("name");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("className") && attributeName.equals("class")) {
				actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("class");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("className") && attributeName.equals("value")) {
				actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("value");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("className") && attributeName.equals("src")) {
				actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("src");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("className") && attributeName.equals("href")) {
				actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("href");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("name") && attributeName.equals("id")) {
				actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("id");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("name") && attributeName.equals("name")) {
				actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("name");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("name") && attributeName.equals("class")) {
				actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("class");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("name") && attributeName.equals("value")) {
				actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("value");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("name") && attributeName.equals("src")) {
				actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("src");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("name") && attributeName.equals("href")) {
				actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("href");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("tagName") && attributeName.equals("id")) {
				actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("id");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("tagName") && attributeName.equals("name")) {
				actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("name");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("tagName") && attributeName.equals("class")) {
				actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("class");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("tagName") && attributeName.equals("value")) {
				actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("value");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("tagName") && attributeName.equals("src")) {
				actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("src");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("tagName") && attributeName.equals("href")) {
				actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("href");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("linkText") && attributeName.equals("id")) {
				actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("id");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("linkText") && attributeName.equals("name")) {
				actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("name");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("linkText") && attributeName.equals("class")) {
				actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("class");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("linkText") && attributeName.equals("value")) {
				actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("value");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("linkText") && attributeName.equals("src")) {
				actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("src");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("linkText") && attributeName.equals("href")) {
				actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("href");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("partialLinkText") && attributeName.equals("id")) {
				actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("id");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("partialLinkText") && attributeName.equals("name")) {
				actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("name");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("partialLinkText") && attributeName.equals("class")) {
				actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("class");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("partialLinkText") && attributeName.equals("value")) {
				actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("value");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("partialLinkText") && attributeName.equals("src")) {
				actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("src");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("partialLinkText") && attributeName.equals("href")) {
				actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("href");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("xpath") && attributeName.equals("id")) {
				actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("id");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("xpath") && attributeName.equals("name")) {
				actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("name");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("xpath") && attributeName.equals("class")) {
				actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("class");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("xpath") && attributeName.equals("value")) {
				actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("value");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("xpath") && attributeName.equals("src")) {
				actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("src");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("xpath") && attributeName.equals("href")) {
				actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("href");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("cssSelector") && attributeName.equals("id")) {
				actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("id");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("cssSelector") && attributeName.equals("name")) {
				actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("name");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("cssSelector") && attributeName.equals("class")) {
				actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("class");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("cssSelector") && attributeName.equals("value")) {
				actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("value");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("cssSelector") && attributeName.equals("src")) {
				actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("src");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}else if(locatorType.equals("cssSelector") && attributeName.equals("href")) {
				actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("href");
				if(actualAttributeValue.equals(EchoWebsite.expectedAttributeValue)) {
					System.out.println("Attribute value verification passed for "+msg);
				}else {
					System.out.println("Attribute value verification failed for "+msg);
				}
			}
		}
		


}
