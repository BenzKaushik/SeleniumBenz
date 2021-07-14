package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class Utils {
	
	public WebDriver driver;
	public  String actualTitle;
	public  String expectedTitle;
	public  String actualText;
	public  String expectedText;
	public  String actualAttributeValue;
	public  String expectedAttributeValue;
	
	public Utils(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	//Function for Stepwise screenshot
	public  void stepWiseScreenshot(String stepName) {
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
	
	//Verification function for title
	public  void VerifyTitle(String expectedTitle, String msg) {
		this.expectedTitle = expectedTitle;
		actualTitle = driver.getTitle();
		if(actualTitle.equals(this.expectedTitle)) {
			System.out.println("Title verification passed for "+msg);
			
		}else {
			System.out.println("Title verification failed for "+msg);
		}
		
	}
	
	//Verification function for text present in element
	public  void VerifyText(String expectedText, String locatorType, String locatorValue, String msg){
		this.expectedText = expectedText;
		if(locatorType.equals("id")) {
			actualText = driver.findElement(By.id(locatorValue)).getText();
			if(actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for "+msg);
			}else {
				System.out.println("Text verification failed for "+msg);
			}
		}else if(locatorType.equals("className")) {
			actualText = driver.findElement(By.className(locatorValue)).getText();
			if(actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for "+msg);
			}else {
				System.out.println("Text verification failed for "+msg);
			}
		}else if(locatorType.equals("name")) {
			actualText = driver.findElement(By.name(locatorValue)).getText();
			if(actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for "+msg);
			}else {
				System.out.println("Text verification failed for "+msg);
			}
		}else if(locatorType.equals("tagName")) {
			actualText = driver.findElement(By.tagName(locatorValue)).getText();
			if(actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for "+msg);
			}else {
				System.out.println("Text verification failed for "+msg);
			}
		}else if(locatorType.equals("linkText")) {
			actualText = driver.findElement(By.linkText(locatorValue)).getText();
			if(actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for "+msg);
			}else {
				System.out.println("Text verification failed for "+msg);
			}
		}else if(locatorType.equals("partialLinkText")) {
			actualText = driver.findElement(By.partialLinkText(locatorValue)).getText();
			if(actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for "+msg);
			}else {
				System.out.println("Text verification failed for "+msg);
			}
		}else if(locatorType.equals("xpath")) {
			actualText = driver.findElement(By.xpath(locatorValue)).getText();
			if(actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for "+msg);
			}else {
				System.out.println("Text verification failed for "+msg);
			}
		}else if(locatorType.equals("cssSelector")) {
			actualText = driver.findElement(By.cssSelector(locatorValue)).getText();
			if(actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for "+msg);
			}else {
				System.out.println("Text verification failed for "+msg);
			}
		}
		
	}
	//Verify function for attribute value present in element's HTML script
	public  void VerifyAttributeValue(String expectedAttributeValue, String locatorType, String locatorValue, String msg, String attributeName) {
		this.expectedAttributeValue = expectedAttributeValue;
		if(locatorType.equals("id") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("id");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("id") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("name");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("id") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("class");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("id") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("value");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("id") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("src");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("id") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("href");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("className") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("id");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("className") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("name");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("className") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("class");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("className") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("value");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("className") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("src");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("className") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("href");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("name") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("id");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("name") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("name");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("name") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("class");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("name") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("value");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("name") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("src");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("name") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("href");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("tagName") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("id");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("tagName") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("name");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("tagName") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("class");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("tagName") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("value");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("tagName") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("src");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("tagName") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("href");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("linkText") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("id");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("linkText") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("name");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("linkText") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("class");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("linkText") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("value");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("linkText") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("src");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("linkText") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("href");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("partialLinkText") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("id");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("partialLinkText") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("name");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("partialLinkText") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("class");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("partialLinkText") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("value");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("partialLinkText") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("src");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("partialLinkText") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("href");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("xpath") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("id");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("xpath") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("name");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("xpath") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("class");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("xpath") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("value");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("xpath") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("src");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("xpath") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("href");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("cssSelector") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("id");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("cssSelector") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("name");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("cssSelector") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("class");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("cssSelector") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("value");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("cssSelector") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("src");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("cssSelector") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("href");
			if(actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}
	}
	
	//Function to check if pop up created by HTML script is existing
	public  void IsPopUpHTMLPresent(String locatorVal) {
		//Xpath and cssSelector are positions of the element.
		//No two element will have the same position
		//So no two elements will have the same xpath or cssSelector
		//So value of "x" can be either zero or 1
		//x = 0 --> element is not present by the xpath value or cssSelector value that we are passing
		//x = 1 --> element is  present by the xpath value or cssSelector value that we are passing
		int x = driver.findElements(By.xpath(locatorVal)).size();
		if(x == 0) {
			System.out.println("Pop is not present");
		}else {
			System.out.println("Pop is present");
			driver.findElement(By.xpath(locatorVal)).click();
		}
		//driver.findElement(By.xpath("/html/body/div[3]/div/button")).click();
	}
	
	//Function to check if element is existing
	public boolean isElementPresent(String xpathVal) {
		int x = driver.findElements(By.xpath(xpathVal)).size();
		//So value of "x" can be either zero or 1
		//x = 0 --> element is not present by the xpath value or cssSelector value that we are passing
		//x = 1 --> element is  present by the xpath value or cssSelector value that we are passing
		if(x == 0) {
			System.out.println("Element is not present");
			return false;
		}else {
			System.out.println("Element is present");
			return true;
		}
	}
	
	//Assertion/Validation function for title
	public  void AssertTitle(String expectedTitle, String msg) {
		this.expectedTitle = expectedTitle;
		actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, this.expectedTitle, "Title verification failed for "+msg);	
	}

	//Assertion/Validation function for text present in element
	public  void AssertText(String expectedText, String locatorType, String locatorValue, String msg){
		this.expectedText = expectedText;
		if(locatorType.equals("id")) {
			actualText = driver.findElement(By.id(locatorValue)).getText();
			Assert.assertEquals(actualText, this.expectedText, "Text verification failed for "+msg);	
		}else if(locatorType.equals("className")) {
			actualText = driver.findElement(By.className(locatorValue)).getText();
			Assert.assertEquals(actualText, this.expectedText, "Text verification failed for "+msg);	
		}else if(locatorType.equals("name")) {
			actualText = driver.findElement(By.name(locatorValue)).getText();
			Assert.assertEquals(actualText, this.expectedText, "Text verification failed for "+msg);	
		}else if(locatorType.equals("tagName")) {
			actualText = driver.findElement(By.tagName(locatorValue)).getText();
			Assert.assertEquals(actualText, this.expectedText, "Text verification failed for "+msg);	
		}else if(locatorType.equals("linkText")) {
			actualText = driver.findElement(By.linkText(locatorValue)).getText();
			Assert.assertEquals(actualText, this.expectedText, "Text verification failed for "+msg);	
		}else if(locatorType.equals("partialLinkText")) {
			actualText = driver.findElement(By.partialLinkText(locatorValue)).getText();
			Assert.assertEquals(actualText, this.expectedText, "Title verification failed for "+"Text verification failed for "+msg);	
		}else if(locatorType.equals("xpath")) {
			actualText = driver.findElement(By.xpath(locatorValue)).getText();
			Assert.assertEquals(actualText, this.expectedText, "Text verification failed for "+msg);	
		}else if(locatorType.equals("cssSelector")) {
			actualText = driver.findElement(By.cssSelector(locatorValue)).getText();
			Assert.assertEquals(actualText, this.expectedText, "Text verification failed for "+msg);	
		}
		
	}	
	
	
	//Assertion/Validation function for attribute value present in element's HTML script
	public  void AssertAttributeValue(String expectedAttributeValue, String locatorType, String locatorValue, String msg, String attributeName) {
		this.expectedAttributeValue = expectedAttributeValue;
		if(locatorType.equals("id") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("id");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("id") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("name");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("id") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("class");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("id") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("value");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("id") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("src");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("id") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("href");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("className") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("id");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("className") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("name");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("className") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("class");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("className") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("value");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("className") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("src");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("className") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("href");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("name") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("id");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("name") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("name");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("name") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("class");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("name") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("value");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("name") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("src");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("name") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("href");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("tagName") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("id");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("tagName") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("name");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("tagName") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("class");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("tagName") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("value");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("tagName") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("src");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("tagName") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("href");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("linkText") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("id");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("linkText") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("name");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("linkText") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("class");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("linkText") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("value");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("linkText") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("src");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("linkText") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("href");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("partialLinkText") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("id");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("partialLinkText") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("name");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("partialLinkText") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("class");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("partialLinkText") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("value");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("partialLinkText") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("src");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("partialLinkText") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("href");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("xpath") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("id");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("xpath") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("name");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("xpath") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("class");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("xpath") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("value");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("xpath") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("src");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("xpath") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("href");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("cssSelector") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("id");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("cssSelector") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("name");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("cssSelector") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("class");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("cssSelector") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("value");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("cssSelector") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("src");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}else if(locatorType.equals("cssSelector") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("href");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue, "Attribute value verification failed for "+msg);	
		}
	}	
		
	//Function for failed screenshot
	public  void FailScreenshot(String stepName) {
		try {
			Date d = new Date();
			String newDateformat = d.toString().replace(" ", "_").replace(":", "_");
			TakesScreenshot scr = (TakesScreenshot)driver;
			File tempFile = scr.getScreenshotAs(OutputType.FILE);
			//Permanent location address
			File permanentFile = new File(System.getProperty("user.dir")+"\\FailedScreenshot\\"+stepName+"_"+newDateformat+".png");
			//Copy from temporary location to permanent location
			FileUtils.copyFile(tempFile, permanentFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
