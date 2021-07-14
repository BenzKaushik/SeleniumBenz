package webElementPac;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExampleWebElementInterface extends BaseSettings{
	
	public static WebDriver driver;
	public static String actualTitle;
	public static String expectedTitle;
	public static String actualText;
	public static String expectedText;
	public static String actualAttributeValue;
	public static String expectedAttributeValue;

	public static void main(String[] args) {
		
		

		driver = ExampleWebElementInterface.RunBrowser("Chrome");
		
		//Maximise the browser window
		driver.manage().window().maximize();
		
		//Navigate to the YAHOO website
		driver.get("https://www.bbc.com/");
			
		//Define the page load timeout
		driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
			
		//Implicit wait - Dynamic wait 
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		
		
		//Explicit wait - Dynamic Wait 
		WebDriverWait wait = new WebDriverWait(driver, 20L); //20 Second
		
		
		//Close the pop up
		ExampleWebElementInterface.IsPopUpHTMLPresent("/html/body/div[3]/div/button");


		//Verify the title for landing page
		ExampleWebElementInterface.VerifyTitle("Welcome to BBC.com", "landing page");
		
		//Verify the text Welcome to BBC.com in the landing page
		ExampleWebElementInterface.VerifyText("Welcome to BBC.com", "xpath", "//*[@id='page']/section[2]/h2/span", "landing page");
		
		//Verify the attribute value of href for the element BBC link
		ExampleWebElementInterface.VerifyAttributeValue("https://www.bbc.com", "cssSelector", "#orb-header > div.orb-nav-pri-container.b-r.b-g-p > div.orb-nav-section.orb-nav-blocks > a", "href attribute for BBC Element", "href");
	
		
		//Find out the number of links in the landing page
		List<WebElement>  allLinks = driver.findElements(By.tagName("a"));
		int numOfLink = allLinks.size();
		System.out.println("Number of links in BBC landing page are "+numOfLink);
		
		//Find out the number of edit boxes in the landing page
		List<WebElement>  allElementTagnameInput = driver.findElements(By.tagName("input"));
		//System.out.println("Number of links in BBC landing page are "+numOfLink);
		int counter = 0;
		for(int x = 0; x<allElementTagnameInput.size(); x++) {
			String actualAttributeVal = allElementTagnameInput.get(x).getAttribute("type");
			String expectedAttributeVal = "text";
			if(actualAttributeVal.equals(expectedAttributeVal)) {
				counter = counter+1; //1,2,3
			}
		}
		System.out.println("Number of edit box with type value equal to text are "+counter);
		
		
		//Click on the link "Australia to halve arrivals to fight Delta strain"
		WebElement addressLink = driver.findElement(By.partialLinkText("Australia to halve arrivals"));
		addressLink.click();
		//driver.findElement(By.partialLinkText("Australia to halve arrivals")).click();
		
		//wait for the element(Close button) located by xpath
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/button")));
		
		
		//Check if pop up is present . If present will close
		//ExampleWebElementInterface.IsPopUpHTMLPresent("/html/body/div[3]/div/button");
		
		//WebDriverWait  - dynamic wait
		//Wait for the text in the Australia link page - text is "Covid: Australia to halve arrivals and trial home quarantine"
		//This text is present in "h1" html tag
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='main-heading']"), "Covid: Australia to halve arrivals and trial home quarantine"));
		
		//Verify the title of link page
		ExampleWebElementInterface.VerifyTitle("Covid: Australia to halve arrivals and trial home quarantine - BBC News", "Australia link page");
		
		//Title of link page
		String titleLinkPage = driver.getTitle();
		System.out.println("Title of the link page is "+titleLinkPage);
		
		//wait for the element(Close button) located by xpath
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/button")));
		
		//Check if pop up is present . If present will close
		ExampleWebElementInterface.IsPopUpHTMLPresent("/html/body/div[3]/div/button");
		
		//Close the browser
		driver.quit();
	}
	
	//Verification function for title
	public static void VerifyTitle(String expectedTitle, String msg) {
		ExampleWebElementInterface.expectedTitle = expectedTitle;
		actualTitle = driver.getTitle();
		if(actualTitle.equals(ExampleWebElementInterface.expectedTitle)) {
			System.out.println("Title verification passed for "+msg);
			
		}else {
			System.out.println("Title verification failed for "+msg);
		}
		
	}
	
	//Verification function for text present in element
	public static void VerifyText(String expectedText, String locatorType, String locatorValue, String msg){
		ExampleWebElementInterface.expectedText = expectedText;
		if(locatorType.equals("id")) {
			actualText = driver.findElement(By.id(locatorValue)).getText();
			if(actualText.equals(ExampleWebElementInterface.expectedText)) {
				System.out.println("Text verification passed for "+msg);
			}else {
				System.out.println("Text verification failed for "+msg);
			}
		}else if(locatorType.equals("className")) {
			actualText = driver.findElement(By.className(locatorValue)).getText();
			if(actualText.equals(ExampleWebElementInterface.expectedText)) {
				System.out.println("Text verification passed for "+msg);
			}else {
				System.out.println("Text verification failed for "+msg);
			}
		}else if(locatorType.equals("name")) {
			actualText = driver.findElement(By.name(locatorValue)).getText();
			if(actualText.equals(ExampleWebElementInterface.expectedText)) {
				System.out.println("Text verification passed for "+msg);
			}else {
				System.out.println("Text verification failed for "+msg);
			}
		}else if(locatorType.equals("tagName")) {
			actualText = driver.findElement(By.tagName(locatorValue)).getText();
			if(actualText.equals(ExampleWebElementInterface.expectedText)) {
				System.out.println("Text verification passed for "+msg);
			}else {
				System.out.println("Text verification failed for "+msg);
			}
		}else if(locatorType.equals("linkText")) {
			actualText = driver.findElement(By.linkText(locatorValue)).getText();
			if(actualText.equals(ExampleWebElementInterface.expectedText)) {
				System.out.println("Text verification passed for "+msg);
			}else {
				System.out.println("Text verification failed for "+msg);
			}
		}else if(locatorType.equals("partialLinkText")) {
			actualText = driver.findElement(By.partialLinkText(locatorValue)).getText();
			if(actualText.equals(ExampleWebElementInterface.expectedText)) {
				System.out.println("Text verification passed for "+msg);
			}else {
				System.out.println("Text verification failed for "+msg);
			}
		}else if(locatorType.equals("xpath")) {
			actualText = driver.findElement(By.xpath(locatorValue)).getText();
			if(actualText.equals(ExampleWebElementInterface.expectedText)) {
				System.out.println("Text verification passed for "+msg);
			}else {
				System.out.println("Text verification failed for "+msg);
			}
		}else if(locatorType.equals("cssSelector")) {
			actualText = driver.findElement(By.cssSelector(locatorValue)).getText();
			if(actualText.equals(ExampleWebElementInterface.expectedText)) {
				System.out.println("Text verification passed for "+msg);
			}else {
				System.out.println("Text verification failed for "+msg);
			}
		}
		
	}
	//Verification function for attribute value present in element's HTML script
	public static void VerifyAttributeValue(String expectedAttributeValue, String locatorType, String locatorValue, String msg, String attributeName) {
		ExampleWebElementInterface.expectedAttributeValue = expectedAttributeValue;
		if(locatorType.equals("id") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("id");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("id") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("name");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("id") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("class");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("id") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("value");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("id") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("src");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("id") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.id(locatorValue)).getAttribute("href");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("className") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("id");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("className") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("name");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("className") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("class");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("className") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("value");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("className") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("src");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("className") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.className(locatorValue)).getAttribute("href");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("name") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("id");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("name") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("name");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("name") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("class");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("name") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("value");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("name") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("src");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("name") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.name(locatorValue)).getAttribute("href");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("tagName") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("id");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("tagName") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("name");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("tagName") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("class");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("tagName") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("value");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("tagName") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("src");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("tagName") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.tagName(locatorValue)).getAttribute("href");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("linkText") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("id");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("linkText") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("name");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("linkText") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("class");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("linkText") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("value");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("linkText") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("src");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("linkText") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.linkText(locatorValue)).getAttribute("href");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("partialLinkText") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("id");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("partialLinkText") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("name");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("partialLinkText") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("class");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("partialLinkText") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("value");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("partialLinkText") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("src");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("partialLinkText") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.partialLinkText(locatorValue)).getAttribute("href");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("xpath") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("id");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("xpath") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("name");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("xpath") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("class");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("xpath") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("value");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("xpath") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("src");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("xpath") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.xpath(locatorValue)).getAttribute("href");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("cssSelector") && attributeName.equals("id")) {
			actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("id");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("cssSelector") && attributeName.equals("name")) {
			actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("name");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("cssSelector") && attributeName.equals("class")) {
			actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("class");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("cssSelector") && attributeName.equals("value")) {
			actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("value");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("cssSelector") && attributeName.equals("src")) {
			actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("src");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}else if(locatorType.equals("cssSelector") && attributeName.equals("href")) {
			actualAttributeValue  = driver.findElement(By.cssSelector(locatorValue)).getAttribute("href");
			if(actualAttributeValue.equals(ExampleWebElementInterface.expectedAttributeValue)) {
				System.out.println("Attribute value verification passed for "+msg);
			}else {
				System.out.println("Attribute value verification failed for "+msg);
			}
		}
	}
	
	public static void IsPopUpHTMLPresent(String locatorVal) {
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

}
