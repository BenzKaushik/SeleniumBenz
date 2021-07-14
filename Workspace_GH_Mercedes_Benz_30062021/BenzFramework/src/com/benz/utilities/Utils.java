package com.benz.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Utils {

	public WebDriver driver;
	public String actualTitle;
	public String expectedTitle;
	public String actualText;
	public String expectedText;
	public String actualAttributeValue;
	public String expectedAttributeValue;
	public WebDriverWait w;
	public Properties p;
	public WebElement wb;
	public Actions act;
	public Select s;
	public List<WebElement> allItems;

	public Utils(WebDriver driver) {
		this.driver = driver;
		p = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\com\\benz\\repo\\ObjectRepositories.properties");
			p.load(fis);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// Function for Stepwise screenshot
	public void stepWiseScreenshot(String stepName) {
		try {
			Date d = new Date();
			String newDateformat = d.toString().replace(" ", "_").replace(":", "_");
			TakesScreenshot scr = (TakesScreenshot) driver;
			File tempFile = scr.getScreenshotAs(OutputType.FILE);
			// Permanent location address
			File permanentFile = new File(System.getProperty("user.dir") + "\\StepwiseScreenshot\\" + stepName + "_"
					+ newDateformat + ".png");
			// Copy from temporary location to permanent location
			FileUtils.copyFile(tempFile, permanentFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Verification function for title
	public void VerifyTitle(String expectedTitle, String msg) {
		this.expectedTitle = expectedTitle;
		actualTitle = driver.getTitle();
		if (actualTitle.equals(this.expectedTitle)) {
			System.out.println("Title verification passed for " + msg);

		} else {
			System.out.println("Title verification failed for " + msg);
		}

	}

	// Verification function for text present in element
	public void VerifyText(String expectedText, String locatorType, String locatorValue, String msg) {
		this.expectedText = expectedText;
		if (locatorType.equals("id")) {
			actualText = driver.findElement(By.id(p.getProperty(locatorValue))).getText();
			if (actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for " + msg);
			} else {
				System.out.println("Text verification failed for " + msg);
			}
		} else if (locatorType.equals("className")) {
			actualText = driver.findElement(By.className(p.getProperty(locatorValue))).getText();
			if (actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for " + msg);
			} else {
				System.out.println("Text verification failed for " + msg);
			}
		} else if (locatorType.equals("name")) {
			actualText = driver.findElement(By.name(p.getProperty(locatorValue))).getText();
			if (actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for " + msg);
			} else {
				System.out.println("Text verification failed for " + msg);
			}
		} else if (locatorType.equals("tagName")) {
			actualText = driver.findElement(By.tagName(p.getProperty(locatorValue))).getText();
			if (actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for " + msg);
			} else {
				System.out.println("Text verification failed for " + msg);
			}
		} else if (locatorType.equals("linkText")) {
			actualText = driver.findElement(By.linkText(p.getProperty(locatorValue))).getText();
			if (actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for " + msg);
			} else {
				System.out.println("Text verification failed for " + msg);
			}
		} else if (locatorType.equals("partialLinkText")) {
			actualText = driver.findElement(By.partialLinkText(p.getProperty(locatorValue))).getText();
			if (actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for " + msg);
			} else {
				System.out.println("Text verification failed for " + msg);
			}
		} else if (locatorType.equals("xpath")) {
			actualText = driver.findElement(By.xpath(p.getProperty(locatorValue))).getText();
			if (actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for " + msg);
			} else {
				System.out.println("Text verification failed for " + msg);
			}
		} else if (locatorType.equals("cssSelector")) {
			actualText = driver.findElement(By.cssSelector(p.getProperty(locatorValue))).getText();
			if (actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for " + msg);
			} else {
				System.out.println("Text verification failed for " + msg);
			}
		}

	}

	// Function which returns a boolean value
	public boolean VerifyTextPresent(String expectedText, String locatorType, String locatorValue, String msg) {
		this.expectedText = expectedText;
		if (locatorType.equals("id")) {
			actualText = driver.findElement(By.id(p.getProperty(locatorValue))).getText();
			if (actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for " + msg);
				return true;
			} else {
				System.out.println("Text verification failed for " + msg);
				return false;
			}

		} else if (locatorType.equals("className")) {
			actualText = driver.findElement(By.className(p.getProperty(locatorValue))).getText();
			if (actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for " + msg);
				return true;
			} else {
				System.out.println("Text verification failed for " + msg);
				return false;
			}
		} else if (locatorType.equals("name")) {
			actualText = driver.findElement(By.name(p.getProperty(locatorValue))).getText();
			if (actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for " + msg);
				return true;
			} else {
				System.out.println("Text verification failed for " + msg);
				return false;
			}
		} else if (locatorType.equals("tagName")) {
			actualText = driver.findElement(By.tagName(p.getProperty(locatorValue))).getText();
			if (actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for " + msg);
				return true;
			} else {
				System.out.println("Text verification failed for " + msg);
				return false;
			}
		} else if (locatorType.equals("linkText")) {
			actualText = driver.findElement(By.linkText(p.getProperty(locatorValue))).getText();
			if (actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for " + msg);
				return true;
			} else {
				System.out.println("Text verification failed for " + msg);
				return false;
			}
		} else if (locatorType.equals("partialLinkText")) {
			actualText = driver.findElement(By.partialLinkText(p.getProperty(locatorValue))).getText();
			if (actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for " + msg);
				return true;
			} else {
				System.out.println("Text verification failed for " + msg);
				return false;
			}
		} else if (locatorType.equals("xpath")) {
			actualText = driver.findElement(By.xpath(p.getProperty(locatorValue))).getText();
			if (actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for " + msg);
				return true;
			} else {
				System.out.println("Text verification failed for " + msg);
				return false;
			}
		} else if (locatorType.equals("cssSelector")) {
			actualText = driver.findElement(By.cssSelector(p.getProperty(locatorValue))).getText();
			if (actualText.equals(this.expectedText)) {
				System.out.println("Text verification passed for " + msg);
				return true;
			} else {
				System.out.println("Text verification failed for " + msg);
				return false;
			}
		}
		return false;

	}

	// Verify function for attribute value present in element's HTML script
	public void VerifyAttributeValue(String expectedAttributeValue, String locatorType, String locatorValue, String msg,
			String attributeName) {
		this.expectedAttributeValue = expectedAttributeValue;
		if (locatorType.equals("id") && attributeName.equals("id")) {
			actualAttributeValue = driver.findElement(By.id(locatorValue)).getAttribute("id");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("id") && attributeName.equals("name")) {
			actualAttributeValue = driver.findElement(By.id(locatorValue)).getAttribute("name");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("id") && attributeName.equals("class")) {
			actualAttributeValue = driver.findElement(By.id(locatorValue)).getAttribute("class");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("id") && attributeName.equals("value")) {
			actualAttributeValue = driver.findElement(By.id(locatorValue)).getAttribute("value");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("id") && attributeName.equals("src")) {
			actualAttributeValue = driver.findElement(By.id(locatorValue)).getAttribute("src");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("id") && attributeName.equals("href")) {
			actualAttributeValue = driver.findElement(By.id(locatorValue)).getAttribute("href");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("className") && attributeName.equals("id")) {
			actualAttributeValue = driver.findElement(By.className(locatorValue)).getAttribute("id");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("className") && attributeName.equals("name")) {
			actualAttributeValue = driver.findElement(By.className(locatorValue)).getAttribute("name");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("className") && attributeName.equals("class")) {
			actualAttributeValue = driver.findElement(By.className(locatorValue)).getAttribute("class");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("className") && attributeName.equals("value")) {
			actualAttributeValue = driver.findElement(By.className(locatorValue)).getAttribute("value");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("className") && attributeName.equals("src")) {
			actualAttributeValue = driver.findElement(By.className(locatorValue)).getAttribute("src");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("className") && attributeName.equals("href")) {
			actualAttributeValue = driver.findElement(By.className(locatorValue)).getAttribute("href");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("name") && attributeName.equals("id")) {
			actualAttributeValue = driver.findElement(By.name(locatorValue)).getAttribute("id");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("name") && attributeName.equals("name")) {
			actualAttributeValue = driver.findElement(By.name(locatorValue)).getAttribute("name");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("name") && attributeName.equals("class")) {
			actualAttributeValue = driver.findElement(By.name(locatorValue)).getAttribute("class");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("name") && attributeName.equals("value")) {
			actualAttributeValue = driver.findElement(By.name(locatorValue)).getAttribute("value");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("name") && attributeName.equals("src")) {
			actualAttributeValue = driver.findElement(By.name(locatorValue)).getAttribute("src");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("name") && attributeName.equals("href")) {
			actualAttributeValue = driver.findElement(By.name(locatorValue)).getAttribute("href");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("tagName") && attributeName.equals("id")) {
			actualAttributeValue = driver.findElement(By.tagName(locatorValue)).getAttribute("id");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("tagName") && attributeName.equals("name")) {
			actualAttributeValue = driver.findElement(By.tagName(locatorValue)).getAttribute("name");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("tagName") && attributeName.equals("class")) {
			actualAttributeValue = driver.findElement(By.tagName(locatorValue)).getAttribute("class");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("tagName") && attributeName.equals("value")) {
			actualAttributeValue = driver.findElement(By.tagName(locatorValue)).getAttribute("value");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("tagName") && attributeName.equals("src")) {
			actualAttributeValue = driver.findElement(By.tagName(locatorValue)).getAttribute("src");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("tagName") && attributeName.equals("href")) {
			actualAttributeValue = driver.findElement(By.tagName(locatorValue)).getAttribute("href");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("linkText") && attributeName.equals("id")) {
			actualAttributeValue = driver.findElement(By.linkText(locatorValue)).getAttribute("id");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("linkText") && attributeName.equals("name")) {
			actualAttributeValue = driver.findElement(By.linkText(locatorValue)).getAttribute("name");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("linkText") && attributeName.equals("class")) {
			actualAttributeValue = driver.findElement(By.linkText(locatorValue)).getAttribute("class");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("linkText") && attributeName.equals("value")) {
			actualAttributeValue = driver.findElement(By.linkText(locatorValue)).getAttribute("value");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("linkText") && attributeName.equals("src")) {
			actualAttributeValue = driver.findElement(By.linkText(locatorValue)).getAttribute("src");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("linkText") && attributeName.equals("href")) {
			actualAttributeValue = driver.findElement(By.linkText(locatorValue)).getAttribute("href");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("partialLinkText") && attributeName.equals("id")) {
			actualAttributeValue = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("id");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("partialLinkText") && attributeName.equals("name")) {
			actualAttributeValue = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("name");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("partialLinkText") && attributeName.equals("class")) {
			actualAttributeValue = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("class");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("partialLinkText") && attributeName.equals("value")) {
			actualAttributeValue = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("value");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("partialLinkText") && attributeName.equals("src")) {
			actualAttributeValue = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("src");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("partialLinkText") && attributeName.equals("href")) {
			actualAttributeValue = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("href");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("xpath") && attributeName.equals("id")) {
			actualAttributeValue = driver.findElement(By.xpath(locatorValue)).getAttribute("id");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("xpath") && attributeName.equals("name")) {
			actualAttributeValue = driver.findElement(By.xpath(locatorValue)).getAttribute("name");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("xpath") && attributeName.equals("class")) {
			actualAttributeValue = driver.findElement(By.xpath(locatorValue)).getAttribute("class");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("xpath") && attributeName.equals("value")) {
			actualAttributeValue = driver.findElement(By.xpath(locatorValue)).getAttribute("value");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("xpath") && attributeName.equals("src")) {
			actualAttributeValue = driver.findElement(By.xpath(locatorValue)).getAttribute("src");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("xpath") && attributeName.equals("href")) {
			actualAttributeValue = driver.findElement(By.xpath(locatorValue)).getAttribute("href");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("cssSelector") && attributeName.equals("id")) {
			actualAttributeValue = driver.findElement(By.cssSelector(locatorValue)).getAttribute("id");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("cssSelector") && attributeName.equals("name")) {
			actualAttributeValue = driver.findElement(By.cssSelector(locatorValue)).getAttribute("name");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("cssSelector") && attributeName.equals("class")) {
			actualAttributeValue = driver.findElement(By.cssSelector(locatorValue)).getAttribute("class");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("cssSelector") && attributeName.equals("value")) {
			actualAttributeValue = driver.findElement(By.cssSelector(locatorValue)).getAttribute("value");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("cssSelector") && attributeName.equals("src")) {
			actualAttributeValue = driver.findElement(By.cssSelector(locatorValue)).getAttribute("src");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		} else if (locatorType.equals("cssSelector") && attributeName.equals("href")) {
			actualAttributeValue = driver.findElement(By.cssSelector(locatorValue)).getAttribute("href");
			if (actualAttributeValue.equals(this.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for " + msg);
			} else {
				System.out.println("Attribute value verification failed for " + msg);
			}
		}
	}

	// Function to check if pop up created by HTML script is existing
	public void IsPopUpHTMLPresent(String locatorVal) {
		// Xpath and cssSelector are positions of the element.
		// No two element will have the same position
		// So no two elements will have the same xpath or cssSelector
		// So value of "x" can be either zero or 1
		// x = 0 --> element is not present by the xpath value or cssSelector value that
		// we are passing
		// x = 1 --> element is present by the xpath value or cssSelector value that we
		// are passing
		int x = driver.findElements(By.xpath(locatorVal)).size();
		if (x == 0) {
			System.out.println("Pop is not present");
		} else {
			System.out.println("Pop is present");
			driver.findElement(By.xpath(locatorVal)).click();
		}
		// driver.findElement(By.xpath("/html/body/div[3]/div/button")).click();
	}

	// Function to check if element is existing
	public boolean isElementPresent(String xpathVal) {
		int x = driver.findElements(By.xpath(xpathVal)).size();
		// So value of "x" can be either zero or 1
		// x = 0 --> element is not present by the xpath value or cssSelector value that
		// we are passing
		// x = 1 --> element is present by the xpath value or cssSelector value that we
		// are passing
		if (x == 0) {
			System.out.println("Element is not present");
			return false;
		} else {
			System.out.println("Element is present");
			return true;
		}
	}

	// Assertion/Validation function for title
	public void AssertTitle(String expectedTitle, String msg) {
		this.expectedTitle = expectedTitle;
		actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, this.expectedTitle, "Title verification failed for " + msg);
	}

	// Assertion/Validation function for text present in element
	public void AssertText(String expectedText, String locatorType, String locatorValue, String msg) {
		this.expectedText = expectedText;
		if (locatorType.equals("id")) {
			actualText = driver.findElement(By.id(p.getProperty(locatorValue))).getText();
			Assert.assertEquals(actualText, this.expectedText, "Text verification failed for " + msg);
		} else if (locatorType.equals("className")) {
			actualText = driver.findElement(By.className(p.getProperty(locatorValue))).getText();
			Assert.assertEquals(actualText, this.expectedText, "Text verification failed for " + msg);
		} else if (locatorType.equals("name")) {
			actualText = driver.findElement(By.name(p.getProperty(locatorValue))).getText();
			Assert.assertEquals(actualText, this.expectedText, "Text verification failed for " + msg);
		} else if (locatorType.equals("tagName")) {
			actualText = driver.findElement(By.tagName(p.getProperty(locatorValue))).getText();
			Assert.assertEquals(actualText, this.expectedText, "Text verification failed for " + msg);
		} else if (locatorType.equals("linkText")) {
			actualText = driver.findElement(By.linkText(p.getProperty(locatorValue))).getText();
			Assert.assertEquals(actualText, this.expectedText, "Text verification failed for " + msg);
		} else if (locatorType.equals("partialLinkText")) {
			actualText = driver.findElement(By.partialLinkText(p.getProperty(locatorValue))).getText();
			Assert.assertEquals(actualText, this.expectedText,
					"Title verification failed for " + "Text verification failed for " + msg);
		} else if (locatorType.equals("xpath")) {
			actualText = driver.findElement(By.xpath(p.getProperty(locatorValue))).getText();
			Assert.assertEquals(actualText, this.expectedText, "Text verification failed for " + msg);
		} else if (locatorType.equals("cssSelector")) {
			actualText = driver.findElement(By.cssSelector(p.getProperty(locatorValue))).getText();
			Assert.assertEquals(actualText, this.expectedText, "Text verification failed for " + msg);
		}

	}

	// Assertion/Validation function for attribute value present in element's HTML
	// script
	public void AssertAttributeValue(String expectedAttributeValue, String locatorType, String locatorValue, String msg,
			String attributeName) {
		this.expectedAttributeValue = expectedAttributeValue;
		if (locatorType.equals("id") && attributeName.equals("id")) {
			actualAttributeValue = driver.findElement(By.id(p.getProperty(locatorValue))).getAttribute("id");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("id") && attributeName.equals("name")) {
			actualAttributeValue = driver.findElement(By.id(p.getProperty(locatorValue))).getAttribute("name");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("id") && attributeName.equals("class")) {
			actualAttributeValue = driver.findElement(By.id(p.getProperty(locatorValue))).getAttribute("class");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("id") && attributeName.equals("value")) {
			actualAttributeValue = driver.findElement(By.id(p.getProperty(locatorValue))).getAttribute("value");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("id") && attributeName.equals("src")) {
			actualAttributeValue = driver.findElement(By.id(p.getProperty(locatorValue))).getAttribute("src");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("id") && attributeName.equals("href")) {
			actualAttributeValue = driver.findElement(By.id(p.getProperty(locatorValue))).getAttribute("href");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("className") && attributeName.equals("id")) {
			actualAttributeValue = driver.findElement(By.className(p.getProperty(locatorValue))).getAttribute("id");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("className") && attributeName.equals("name")) {
			actualAttributeValue = driver.findElement(By.className(p.getProperty(locatorValue))).getAttribute("name");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("className") && attributeName.equals("class")) {
			actualAttributeValue = driver.findElement(By.className(p.getProperty(locatorValue))).getAttribute("class");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("className") && attributeName.equals("value")) {
			actualAttributeValue = driver.findElement(By.className(p.getProperty(locatorValue))).getAttribute("value");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("className") && attributeName.equals("src")) {
			actualAttributeValue = driver.findElement(By.className(p.getProperty(locatorValue))).getAttribute("src");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("className") && attributeName.equals("href")) {
			actualAttributeValue = driver.findElement(By.className(p.getProperty(locatorValue))).getAttribute("href");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("name") && attributeName.equals("id")) {
			actualAttributeValue = driver.findElement(By.name(p.getProperty(locatorValue))).getAttribute("id");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("name") && attributeName.equals("name")) {
			actualAttributeValue = driver.findElement(By.name(p.getProperty(locatorValue))).getAttribute("name");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("name") && attributeName.equals("class")) {
			actualAttributeValue = driver.findElement(By.name(p.getProperty(locatorValue))).getAttribute("class");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("name") && attributeName.equals("value")) {
			actualAttributeValue = driver.findElement(By.name(p.getProperty(locatorValue))).getAttribute("value");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("name") && attributeName.equals("src")) {
			actualAttributeValue = driver.findElement(By.name(p.getProperty(locatorValue))).getAttribute("src");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("name") && attributeName.equals("href")) {
			actualAttributeValue = driver.findElement(By.name(p.getProperty(locatorValue))).getAttribute("href");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("tagName") && attributeName.equals("id")) {
			actualAttributeValue = driver.findElement(By.tagName(p.getProperty(locatorValue))).getAttribute("id");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("tagName") && attributeName.equals("name")) {
			actualAttributeValue = driver.findElement(By.tagName(p.getProperty(locatorValue))).getAttribute("name");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("tagName") && attributeName.equals("class")) {
			actualAttributeValue = driver.findElement(By.tagName(p.getProperty(locatorValue))).getAttribute("class");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("tagName") && attributeName.equals("value")) {
			actualAttributeValue = driver.findElement(By.tagName(p.getProperty(locatorValue))).getAttribute("value");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("tagName") && attributeName.equals("src")) {
			actualAttributeValue = driver.findElement(By.tagName(p.getProperty(locatorValue))).getAttribute("src");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("tagName") && attributeName.equals("href")) {
			actualAttributeValue = driver.findElement(By.tagName(p.getProperty(locatorValue))).getAttribute("href");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("linkText") && attributeName.equals("id")) {
			actualAttributeValue = driver.findElement(By.linkText(p.getProperty(locatorValue))).getAttribute("id");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("linkText") && attributeName.equals("name")) {
			actualAttributeValue = driver.findElement(By.linkText(p.getProperty(locatorValue))).getAttribute("name");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("linkText") && attributeName.equals("class")) {
			actualAttributeValue = driver.findElement(By.linkText(p.getProperty(locatorValue))).getAttribute("class");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("linkText") && attributeName.equals("value")) {
			actualAttributeValue = driver.findElement(By.linkText(p.getProperty(locatorValue))).getAttribute("value");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("linkText") && attributeName.equals("src")) {
			actualAttributeValue = driver.findElement(By.linkText(p.getProperty(locatorValue))).getAttribute("src");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("linkText") && attributeName.equals("href")) {
			actualAttributeValue = driver.findElement(By.linkText(p.getProperty(locatorValue))).getAttribute("href");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("partialLinkText") && attributeName.equals("id")) {
			actualAttributeValue = driver.findElement(By.partialLinkText(p.getProperty(locatorValue))).getAttribute("id");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("partialLinkText") && attributeName.equals("name")) {
			actualAttributeValue = driver.findElement(By.partialLinkText(p.getProperty(locatorValue))).getAttribute("name");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("partialLinkText") && attributeName.equals("class")) {
			actualAttributeValue = driver.findElement(By.partialLinkText(p.getProperty(locatorValue))).getAttribute("class");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("partialLinkText") && attributeName.equals("value")) {
			actualAttributeValue = driver.findElement(By.partialLinkText(p.getProperty(locatorValue))).getAttribute("value");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("partialLinkText") && attributeName.equals("src")) {
			actualAttributeValue = driver.findElement(By.partialLinkText(p.getProperty(locatorValue))).getAttribute("src");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("partialLinkText") && attributeName.equals("href")) {
			actualAttributeValue = driver.findElement(By.partialLinkText(p.getProperty(locatorValue))).getAttribute("href");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("xpath") && attributeName.equals("id")) {
			actualAttributeValue = driver.findElement(By.xpath(p.getProperty(locatorValue))).getAttribute("id");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("xpath") && attributeName.equals("name")) {
			actualAttributeValue = driver.findElement(By.xpath(p.getProperty(locatorValue))).getAttribute("name");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("xpath") && attributeName.equals("class")) {
			actualAttributeValue = driver.findElement(By.xpath(p.getProperty(locatorValue))).getAttribute("class");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("xpath") && attributeName.equals("value")) {
			actualAttributeValue = driver.findElement(By.xpath(p.getProperty(locatorValue))).getAttribute("value");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("xpath") && attributeName.equals("src")) {
			actualAttributeValue = driver.findElement(By.xpath(p.getProperty(locatorValue))).getAttribute("src");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("xpath") && attributeName.equals("href")) {
			actualAttributeValue = driver.findElement(By.xpath(p.getProperty(locatorValue))).getAttribute("href");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("cssSelector") && attributeName.equals("id")) {
			actualAttributeValue = driver.findElement(By.cssSelector(p.getProperty(locatorValue))).getAttribute("id");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("cssSelector") && attributeName.equals("name")) {
			actualAttributeValue = driver.findElement(By.cssSelector(p.getProperty(locatorValue))).getAttribute("name");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("cssSelector") && attributeName.equals("class")) {
			actualAttributeValue = driver.findElement(By.cssSelector(p.getProperty(locatorValue))).getAttribute("class");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("cssSelector") && attributeName.equals("value")) {
			actualAttributeValue = driver.findElement(By.cssSelector(p.getProperty(locatorValue))).getAttribute("value");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("cssSelector") && attributeName.equals("src")) {
			actualAttributeValue = driver.findElement(By.cssSelector(p.getProperty(locatorValue))).getAttribute("src");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		} else if (locatorType.equals("cssSelector") && attributeName.equals("href")) {
			actualAttributeValue = driver.findElement(By.cssSelector(p.getProperty(locatorValue))).getAttribute("href");
			Assert.assertEquals(actualAttributeValue, this.expectedAttributeValue,
					"Attribute value verification failed for " + msg);
		}
	}

	// Function for failed screenshot - changed for Extent Report
	public String FailScreenshot(String stepName) {
		try {
			Date d = new Date();
			String newDateformat = d.toString().replace(" ", "_").replace(":", "_");
			TakesScreenshot scr = (TakesScreenshot) driver;
			File tempFile = scr.getScreenshotAs(OutputType.FILE);
			// Location path
			String path = System.getProperty("user.dir") + "\\FailedScreenshot\\" + stepName + "_" + newDateformat
					+ ".png";
			// Permanent location address
			File permanentFile = new File(path);
			// Copy from temporary location to permanent location
			FileUtils.copyFile(tempFile, permanentFile);
			return path;
		} catch (Exception e) {
			String msg = e.getMessage();// Will give message of exception
			return msg;
		}
	}

	// Functions for page load timeout
	public void pageLoadTime(long time) {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}

	// Function for Action to navigate - Keyword Function
	public void navigateURL(String URL) {
		driver.get(URL);

	}

	// Function for action to maximize browser Window - Keyword function
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	// Function for Implicit Wait
	public void implicitWaitElements(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	// Function for WebDribver Wait - text to be present
	public void explicitWaitText(String locatorType, String locatorValue, String text) {
		w = new WebDriverWait(driver, 30L);
		if (locatorType.equals("id")) {
			w.until(ExpectedConditions.textToBePresentInElementLocated(By.id(p.getProperty(locatorValue)), text));
		} else if (locatorType.equals("className")) {
			w.until(ExpectedConditions.textToBePresentInElementLocated(By.className(p.getProperty(locatorValue)),
					text));
		} else if (locatorType.equals("name")) {
			w.until(ExpectedConditions.textToBePresentInElementLocated(By.name(p.getProperty(locatorValue)), text));
		} else if (locatorType.equals("tagName")) {
			w.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName(p.getProperty(locatorValue)), text));
		} else if (locatorType.equals("linkText")) {
			w.until(ExpectedConditions.textToBePresentInElementLocated(By.linkText(p.getProperty(locatorValue)), text));
		} else if (locatorType.equals("partialLinkText")) {
			w.until(ExpectedConditions.textToBePresentInElementLocated(By.partialLinkText(p.getProperty(locatorValue)),
					text));
		} else if (locatorType.equals("xpath")) {
			w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(p.getProperty(locatorValue)), text));
		} else if (locatorType.equals("cssSelector")) {
			w.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(p.getProperty(locatorValue)),
					text));
		}

	}

	// Function based on Action of Typing - Keyword for typing on edit box
	public void typeEditBox(String locatorType, String locatorValue, String typeValue) {
		if (locatorType.equals("id")) {
			driver.findElement(By.id(p.getProperty(locatorValue))).click();
			driver.findElement(By.id(p.getProperty(locatorValue))).sendKeys(typeValue);
			//driver.findElement(By.id(p.getProperty(locatorValue))).sendKeys(Keys.RETURN);
		} else if (locatorType.equals("className")) {
			driver.findElement(By.className(p.getProperty(locatorValue))).click();
			driver.findElement(By.className(p.getProperty(locatorValue))).sendKeys(typeValue);
			//driver.findElement(By.className(p.getProperty(locatorValue))).sendKeys(Keys.RETURN);
		} else if (locatorType.equals("name")) {
			driver.findElement(By.name(p.getProperty(locatorValue))).click();
			driver.findElement(By.name(p.getProperty(locatorValue))).sendKeys(typeValue);
			//driver.findElement(By.name(p.getProperty(locatorValue))).sendKeys(Keys.RETURN);
		} else if (locatorType.equals("tagName")) {
			driver.findElement(By.tagName(p.getProperty(locatorValue))).click();
			driver.findElement(By.tagName(p.getProperty(locatorValue))).sendKeys(typeValue);
			//driver.findElement(By.tagName(p.getProperty(locatorValue))).sendKeys(Keys.RETURN);
		} else if (locatorType.equals("xpath")) {
			driver.findElement(By.xpath(p.getProperty(locatorValue))).click();
			driver.findElement(By.xpath(p.getProperty(locatorValue))).sendKeys(typeValue);
			//driver.findElement(By.xpath(p.getProperty(locatorValue))).sendKeys(Keys.RETURN);
		} else if (locatorType.equals("cssSelector")) {
			driver.findElement(By.cssSelector(p.getProperty(locatorValue))).click();
			driver.findElement(By.cssSelector(p.getProperty(locatorValue))).sendKeys(typeValue);
			//driver.findElement(By.cssSelector(p.getProperty(locatorValue))).sendKeys(Keys.RETURN);
		}

	}

	// Keyword function for clicking on Button using Actions Class
	public void clickButtonActions(String locatorType, String locatorValue) {
		act = new Actions(driver);
		if (locatorType.equals("id")) {
			wb = driver.findElement(By.id(p.getProperty(locatorValue)));
			act.moveToElement(wb).click();
			act.build().perform();
		} else if (locatorType.equals("className")) {
			wb = driver.findElement(By.className(p.getProperty(locatorValue)));
			act.moveToElement(wb).click();
			act.build().perform();
		} else if (locatorType.equals("name")) {
			wb = driver.findElement(By.name(p.getProperty(locatorValue)));
			act.moveToElement(wb).click();
			act.build().perform();
		} else if (locatorType.equals("tagName")) {
			wb = driver.findElement(By.tagName(p.getProperty(locatorValue)));
			act.moveToElement(wb).click();
			act.build().perform();
		} else if (locatorType.equals("linkText")) {
			wb = driver.findElement(By.linkText(p.getProperty(locatorValue)));
			act.moveToElement(wb).click();
			act.build().perform();
		} else if (locatorType.equals("partialLinkText")) {
			wb = driver.findElement(By.partialLinkText(p.getProperty(locatorValue)));
			act.moveToElement(wb).click();
			act.build().perform();
		} else if (locatorType.equals("xpath")) {
			wb = driver.findElement(By.xpath(p.getProperty(locatorValue)));
			act.moveToElement(wb).click();
			act.build().perform();
		} else if (locatorType.equals("cssSelector")) {
			wb = driver.findElement(By.cssSelector(p.getProperty(locatorValue)));
			act.moveToElement(wb).click();
			act.build().perform();
		}

	}

	// Function to Check if a checkbox or radio button is Selected
	public void isSelectedCheckBoxOrRadioButton(String locatorType, String locatorValue, String msg) {
		if (locatorType.equals("id")) {
			boolean sel = driver.findElement(By.id(p.getProperty(locatorValue))).isSelected();
			System.out.println(msg + " ? --> " + sel);

		} else if (locatorType.equals("className")) {
			boolean sel = driver.findElement(By.className(p.getProperty(locatorValue))).isSelected();
			System.out.println(msg + " ? --> " + sel);

		} else if (locatorType.equals("name")) {
			boolean sel = driver.findElement(By.name(p.getProperty(locatorValue))).isSelected();
			System.out.println(msg + " ? --> " + sel);

		} else if (locatorType.equals("tagName")) {
			boolean sel = driver.findElement(By.tagName(p.getProperty(locatorValue))).isSelected();
			System.out.println(msg + " ? --> " + sel);

		} else if (locatorType.equals("xpath")) {
			boolean sel = driver.findElement(By.xpath(p.getProperty(locatorValue))).isSelected();
			System.out.println(msg + " ? --> " + sel);

		} else if (locatorType.equals("cssSelector")) {
			boolean sel = driver.findElement(By.cssSelector(p.getProperty(locatorValue))).isSelected();
			System.out.println(msg + " ? --> " + sel);

		}

	}

	// Keyword function for Checkbox
	public void selectCheckbox(String locatorType, String locatorValue) {
		if (locatorType.equals("id")) {
			driver.findElement(By.id(p.getProperty(locatorValue))).click();
		} else if (locatorType.equals("className")) {
			driver.findElement(By.className(p.getProperty(locatorValue))).click();
		} else if (locatorType.equals("name")) {
			driver.findElement(By.name(p.getProperty(locatorValue))).click();
		} else if (locatorType.equals("tagName")) {
			driver.findElement(By.tagName(p.getProperty(locatorValue))).click();
		} else if (locatorType.equals("xpath")) {
			driver.findElement(By.xpath(p.getProperty(locatorValue))).click();
		} else if (locatorType.equals("cssSelector")) {
			driver.findElement(By.cssSelector(p.getProperty(locatorValue))).click();
		}

	}

	// Keyword function for drop down created by Select class - Select By index
	public void selectOptionIndex(String locatorType, String locatorValue, int indexNumber) {
		if (locatorType.equals("id")) {
			wb = driver.findElement(By.id(p.getProperty(locatorValue)));
			s = new Select(wb);
			s.selectByIndex(indexNumber);
		} else if (locatorType.equals("className")) {
			wb = driver.findElement(By.className(p.getProperty(locatorValue)));
			s = new Select(wb);
			s.selectByIndex(indexNumber);
		} else if (locatorType.equals("name")) {
			wb = driver.findElement(By.name(p.getProperty(locatorValue)));
			s = new Select(wb);
			s.selectByIndex(indexNumber);
		} else if (locatorType.equals("tagName")) {
			wb = driver.findElement(By.tagName(p.getProperty(locatorValue)));
			s = new Select(wb);
			s.selectByIndex(indexNumber);
		} else if (locatorType.equals("xpath")) {
			wb = driver.findElement(By.xpath(p.getProperty(locatorValue)));
			s = new Select(wb);
			s.selectByIndex(indexNumber);
		} else if (locatorType.equals("cssSelector")) {
			wb = driver.findElement(By.cssSelector(p.getProperty(locatorValue)));
			s = new Select(wb);
			s.selectByIndex(indexNumber);
		}
	}

	// Keyword function for drop down created by Select class - Select By value
	public void selectOptionValue(String locatorType, String locatorValue, String value) {
		if (locatorType.equals("id")) {
			wb = driver.findElement(By.id(p.getProperty(locatorValue)));
			s = new Select(wb);
			s.selectByValue(value);
		} else if (locatorType.equals("className")) {
			wb = driver.findElement(By.className(p.getProperty(locatorValue)));
			s = new Select(wb);
			s.selectByValue(value);
		} else if (locatorType.equals("name")) {
			wb = driver.findElement(By.name(p.getProperty(locatorValue)));
			s = new Select(wb);
			s.selectByValue(value);
		} else if (locatorType.equals("tagName")) {
			wb = driver.findElement(By.tagName(p.getProperty(locatorValue)));
			s = new Select(wb);
			s.selectByValue(value);
		} else if (locatorType.equals("xpath")) {
			wb = driver.findElement(By.xpath(p.getProperty(locatorValue)));
			s = new Select(wb);
			s.selectByValue(value);
		} else if (locatorType.equals("cssSelector")) {
			wb = driver.findElement(By.cssSelector(p.getProperty(locatorValue)));
			s = new Select(wb);
			s.selectByValue(value);
		}
	}

	// Keyword function for drop down created by Select class - Select By value
	public void selectOptionText(String locatorType, String locatorValue, String text) {
		if (locatorType.equals("id")) {
			wb = driver.findElement(By.id(p.getProperty(locatorValue)));
			s = new Select(wb);
			s.selectByVisibleText(text);
		} else if (locatorType.equals("className")) {
			wb = driver.findElement(By.className(p.getProperty(locatorValue)));
			s = new Select(wb);
			s.selectByVisibleText(text);
		} else if (locatorType.equals("name")) {
			wb = driver.findElement(By.name(p.getProperty(locatorValue)));
			s = new Select(wb);
			s.selectByVisibleText(text);
		} else if (locatorType.equals("tagName")) {
			wb = driver.findElement(By.tagName(p.getProperty(locatorValue)));
			s = new Select(wb);
			s.selectByVisibleText(text);
		} else if (locatorType.equals("xpath")) {
			wb = driver.findElement(By.xpath(p.getProperty(locatorValue)));
			s = new Select(wb);
			s.selectByVisibleText(text);
		} else if (locatorType.equals("cssSelector")) {
			wb = driver.findElement(By.cssSelector(p.getProperty(locatorValue)));
			s = new Select(wb);
			s.selectByVisibleText(text);
		}
	}
	
	//Keyword function for drop down created by Div tag
	public void dropDownSelection(String locatorType, String locatorValue, String optionLocatorValue) {
		if (locatorType.equals("id")) {
			//1. Click on the drop down to get the option
			driver.findElement(By.id(p.getProperty(locatorValue))).click();
			//2. The option of this drop down are created by UL - LI tag. GEt the options XPATH - USA
			driver.findElement(By.id(p.getProperty(optionLocatorValue))).click();
		} else if (locatorType.equals("className")) {
			//1. Click on the drop down to get the option
			driver.findElement(By.className(p.getProperty(locatorValue))).click();
			//2. The option of this drop down are created by UL - LI tag. GEt the options XPATH - USA
			driver.findElement(By.className(p.getProperty(optionLocatorValue))).click();
		} else if (locatorType.equals("name")) {
			//1. Click on the drop down to get the option
			driver.findElement(By.name(p.getProperty(locatorValue))).click();
			//2. The option of this drop down are created by UL - LI tag. GEt the options XPATH - USA
			driver.findElement(By.name(p.getProperty(optionLocatorValue))).click();
		} else if (locatorType.equals("tagName")) {
			//1. Click on the drop down to get the option
			driver.findElement(By.tagName(p.getProperty(locatorValue))).click();
			//2. The option of this drop down are created by UL - LI tag. GEt the options XPATH - USA
			driver.findElement(By.tagName(p.getProperty(optionLocatorValue))).click();
		} else if (locatorType.equals("xpath")) {
			//1. Click on the drop down to get the option
			driver.findElement(By.xpath(p.getProperty(locatorValue))).click();
			//2. The option of this drop down are created by UL - LI tag. GEt the options XPATH - USA
			driver.findElement(By.xpath(p.getProperty(optionLocatorValue))).click();
		} else if (locatorType.equals("cssSelector")) {
			//1. Click on the drop down to get the option
			driver.findElement(By.cssSelector(p.getProperty(locatorValue))).click();
			//2. The option of this drop down are created by UL - LI tag. GEt the options XPATH - USA
			driver.findElement(By.cssSelector(p.getProperty(optionLocatorValue))).click();
		}		
	}
	

	//Keyword function for Selecting Radio Button
	public void selectRadioButton(String locatorType, String locatorValue) {
		if (locatorType.equals("id")) {
			driver.findElement(By.id(p.getProperty(locatorValue))).click();
		} else if (locatorType.equals("className")) {
			driver.findElement(By.className(p.getProperty(locatorValue))).click();
		} else if (locatorType.equals("name")) {
			driver.findElement(By.name(p.getProperty(locatorValue))).click();
		} else if (locatorType.equals("tagName")) {
			driver.findElement(By.tagName(p.getProperty(locatorValue))).click();
		} else if (locatorType.equals("xpath")) {
			driver.findElement(By.xpath(p.getProperty(locatorValue))).click();
		} else if (locatorType.equals("cssSelector")) {
			driver.findElement(By.cssSelector(p.getProperty(locatorValue))).click();
		}

	}	
	
	//Keyword function for click on button
	public void clickButton(String locatorType, String locatorValue) {
		if (locatorType.equals("id")) {
			driver.findElement(By.id(p.getProperty(locatorValue))).click();
		} else if (locatorType.equals("className")) {
			driver.findElement(By.className(p.getProperty(locatorValue))).click();
		} else if (locatorType.equals("name")) {
			driver.findElement(By.name(p.getProperty(locatorValue))).click();
		} else if (locatorType.equals("tagName")) {
			driver.findElement(By.tagName(p.getProperty(locatorValue))).click();
		} else if (locatorType.equals("xpath")) {
			driver.findElement(By.xpath(p.getProperty(locatorValue))).click();
		} else if (locatorType.equals("cssSelector")) {
			driver.findElement(By.cssSelector(p.getProperty(locatorValue))).click();
		}
	}
	
	
	//Keyword function for click on button
	public void clickLink(String locatorType, String locatorValue) {
		if (locatorType.equals("id")) {
			driver.findElement(By.id(p.getProperty(locatorValue))).click();
		} else if (locatorType.equals("className")) {
			driver.findElement(By.className(p.getProperty(locatorValue))).click();
		} else if (locatorType.equals("name")) {
			driver.findElement(By.name(p.getProperty(locatorValue))).click();
		} else if (locatorType.equals("tagName")) {
			driver.findElement(By.tagName(p.getProperty(locatorValue))).click();
		} else if (locatorType.equals("xpath")) {
			driver.findElement(By.xpath(p.getProperty(locatorValue))).click();
		} else if (locatorType.equals("cssSelector")) {
			driver.findElement(By.cssSelector(p.getProperty(locatorValue))).click();
		}else if (locatorType.equals("linkText")) {
			driver.findElement(By.linkText(p.getProperty(locatorValue))).click();
		}else if (locatorType.equals("partialLinkText")) {
			driver.findElement(By.partialLinkText(p.getProperty(locatorValue))).click();
		}
	}
	
	
	// Function based on Action of Typing on Email edit box - Keyword for typing on edit box
		public void typeEditBoxEmail(String locatorType, String locatorValue, String typeValue) {
			if (locatorType.equals("id")) {
				driver.findElement(By.id(p.getProperty(locatorValue))).click();
				driver.findElement(By.id(p.getProperty(locatorValue))).sendKeys(typeValue);
				driver.findElement(By.id(p.getProperty(locatorValue))).sendKeys(Keys.RETURN);
			} else if (locatorType.equals("className")) {
				driver.findElement(By.className(p.getProperty(locatorValue))).click();
				driver.findElement(By.className(p.getProperty(locatorValue))).sendKeys(typeValue);
				driver.findElement(By.className(p.getProperty(locatorValue))).sendKeys(Keys.RETURN);
			} else if (locatorType.equals("name")) {
				driver.findElement(By.name(p.getProperty(locatorValue))).click();
				driver.findElement(By.name(p.getProperty(locatorValue))).sendKeys(typeValue);
				driver.findElement(By.name(p.getProperty(locatorValue))).sendKeys(Keys.RETURN);
			} else if (locatorType.equals("tagName")) {
				driver.findElement(By.tagName(p.getProperty(locatorValue))).click();
				driver.findElement(By.tagName(p.getProperty(locatorValue))).sendKeys(typeValue);
				driver.findElement(By.tagName(p.getProperty(locatorValue))).sendKeys(Keys.RETURN);
			} else if (locatorType.equals("xpath")) {
				driver.findElement(By.xpath(p.getProperty(locatorValue))).click();
				driver.findElement(By.xpath(p.getProperty(locatorValue))).sendKeys(typeValue);
				driver.findElement(By.xpath(p.getProperty(locatorValue))).sendKeys(Keys.RETURN);
			} else if (locatorType.equals("cssSelector")) {
				driver.findElement(By.cssSelector(p.getProperty(locatorValue))).click();
				driver.findElement(By.cssSelector(p.getProperty(locatorValue))).sendKeys(typeValue);
				driver.findElement(By.cssSelector(p.getProperty(locatorValue))).sendKeys(Keys.RETURN);
			}

		}

		//Keyword function for switching to frame by WebElement
		public void switchFrameWebElement(String locatorType, String locatorValue ) {
			if (locatorType.equals("id")) {
				wb = driver.findElement(By.id(p.getProperty(locatorValue)));
				driver.switchTo().frame(wb);
			} else if (locatorType.equals("className")) {
				wb = driver.findElement(By.className(p.getProperty(locatorValue)));
				driver.switchTo().frame(wb);
			} else if (locatorType.equals("name")) {
				wb = driver.findElement(By.name(p.getProperty(locatorValue)));
				driver.switchTo().frame(wb);
			} else if (locatorType.equals("tagName")) {
				wb = driver.findElement(By.tagName(p.getProperty(locatorValue)));
				driver.switchTo().frame(wb);
			} else if (locatorType.equals("xpath")) {
				wb = driver.findElement(By.xpath(p.getProperty(locatorValue)));
				driver.switchTo().frame(wb);
			} else if (locatorType.equals("cssSelector")) {
				wb = driver.findElement(By.cssSelector(p.getProperty(locatorValue)));
				driver.switchTo().frame(wb);
			}
		}
		
		//Keyword function to switch from frame to main page
		public void switchMainPage() {
			driver.switchTo().defaultContent();
		}
	
	
}
