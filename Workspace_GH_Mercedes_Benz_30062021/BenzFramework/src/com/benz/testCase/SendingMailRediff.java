package com.benz.testCase;

import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.benz.base.BaseSettings;
import com.benz.repo.Data;
import com.benz.utilities.ExtentManager;
import com.benz.utilities.Utils;

public class SendingMailRediff extends BaseSettings{

	public   WebDriver driver;
	//public   WebDriverWait w;
	public  WebElement wb;
	public  Actions act;
	public  Point p;
	public  JavascriptExecutor j;
	public Utils u;
	public ExtentTest logger;
	
	//Use the getInstanceSparkReporter() method of ExtentSparkReporter class
	ExtentSparkReporter report = ExtentManager.getInstanceSparkReporter();
	
	//Use the getInstanceReporter() method which returns  ExtentReports class
	ExtentReports extent = ExtentManager.getInstanceReporter();
	
	@Test(dataProvider = "sendMailData", dataProviderClass = Data.class)
	public  void SendingEmailRediff(Hashtable<String , String> h) throws InterruptedException  {
			
		//Create the test case required for Extent report
		logger = extent.createTest("Sending mail from Rediffmail account Test Case - "+h.get("Browser"));
				
		//Create the category for testing - using the assign category method of ExtentTest class
		logger.assignCategory("Test Category Preference  - Functional");

				
		driver = SendingMailRediff.RunBrowser(h.get("Browser")); //Like to run in Chrome and Edge - parameterization point 1
		
		u = new Utils(driver);
		
		//Navigate to Rediffmail login page
		//driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		u.navigateURL("https://mail.rediff.com/cgi-bin/login.cgi");
		
		u.stepWiseScreenshot("Navigate Rediff Login Page_"+h.get("Browser"));
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.INFO, MarkupHelper.createLabel("Navigating to Rediffmal Account page for sending email", ExtentColor.BLUE));
				
		
		//Assert by title on landing page
		u.AssertTitle("Rediffmail", "the landing page of Rediffmail");
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.PASS, MarkupHelper.createLabel("Assertion for title in Rediffmail account landing page - Rediffmail Free Unlimited Storage", ExtentColor.GREEN));
					
		
		//Define the page load timeout
		//driver.manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
		u.pageLoadTime(30L);
					
		//Implicit wait - Dynamic wait 
		//driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
		u.implicitWaitElements(30L);
				
		//Explicit Wait 
		//w = new WebDriverWait(driver, 30L);
		
		//Assert  by the text "Username"
		//u.AssertText("Username", "xpath", "//p[text() = 'Username']", "for the text Username");
		u.AssertText("Username", "xpath", "assertText_xpath_UsernameEditBox1", "for the text Username");
		
		
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.PASS, MarkupHelper.createLabel("Assertion for text in USername edit box - Username", ExtentColor.GREEN));
							
				
		
		//Type on Username -parameterization point 2
		//driver.findElement(By.xpath("//*[@id=\"login1\"]")).click();
		//driver.findElement(By.xpath("//*[@id=\"login1\"]")).sendKeys(h.get("UName"));
		//u.typeEditBox("xpath", "//*[@id='login1']", h.get("UName"));
		u.typeEditBox("xpath", "typeUsername_xpath_UsernameEditBox1", h.get("UName"));
		
		u.stepWiseScreenshot("Type on username of  Rediff Login Page_"+h.get("Browser"));
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.INFO, MarkupHelper.createLabel("Types on Username edit box", ExtentColor.BLUE));
				
		
		//Assert  by the text "Password"
		//u.AssertText("Password", "xpath", "//p[text() = 'Password']", "for the text Password");
		u.AssertText("Password", "xpath", "assertText_xpath_PasswordEditBox1", "for the text Password");
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.PASS, MarkupHelper.createLabel("Assertion for text in Password edit box - Password", ExtentColor.GREEN));
				
		
		
		//Type on Password-parameterization point 3
		//driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
		//driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(h.get("Pwd"));
		//u.typeEditBox("xpath", "//*[@id='password']", h.get("Pwd"));
		u.typeEditBox("xpath", "typePassword_xpath_PasswordEditBox", h.get("Pwd"));
		
		u.stepWiseScreenshot("Type on password of  Rediff Login Page_"+h.get("Browser"));
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.INFO, MarkupHelper.createLabel("Types on Password edit box", ExtentColor.BLUE));
				
		
		Thread.sleep(3000L);
		
		//Assert by the attribute "name" whose value is "proceed"
		//u.AssertAttributeValue("proceed", "xpath", "//input[@name = 'proceed']", "for the attribute name", "name");
		u.AssertAttributeValue("proceed", "xpath", "assertAttributeValue_xpath_SignInButton1", "for the attribute name", "name");
		
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.PASS, MarkupHelper.createLabel("Assertion for attribute: \"name\" in html script of Sign in  button.", ExtentColor.GREEN));
				
		
		//Click on Sign In button
		//driver.findElement(By.xpath("//input[@name = 'proceed']")).click();
		u.clickButton("xpath", "clickSignIn_xpath_SignInButton1");
		
		u.stepWiseScreenshot("Click on sign in button  of  Rediff Login Page_"+h.get("Browser"));
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.INFO, MarkupHelper.createLabel("Click on Sign in button", ExtentColor.BLUE));
					
		
		//Wait until the text "Write Mail " is present
		//w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"boxscroll\"]/li[1]/a/b"), "Write mail"));
		//u.explicitWaitText("xpath", "//*[@id='boxscroll']/li[1]/a/b", "Write mail");
		u.explicitWaitText("xpath", "explicitWait_WriteMail_xpath1", "Write mail");
		
		//Assert  by the text "Write Mail"
		//u.AssertText("Write mail", "xpath", "//*[@id='boxscroll']/li[1]/a/b", "for the text Write Mail");
		u.AssertText("Write mail", "xpath", "assertText_xpath_WiteMailLink1", "for the text Write Mail");
		
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.PASS, MarkupHelper.createLabel("Assert for the text in Write Mail link - Write mail", ExtentColor.GREEN));
					
		
		
		//Click on Write Mail Link
		//driver.findElement(By.xpath("//*[@id=\"boxscroll\"]/li[1]/a")).click();
		u.clickLink("xpath", "clickWriteMail_xpath_WriteMailLink1");
		
		u.stepWiseScreenshot("Click  on Write mail of  Rediff Login Page_"+h.get("Browser"));
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.INFO, MarkupHelper.createLabel("Click on Write mail Link", ExtentColor.BLUE));
				
		
		//Ajax component - wait until the text "Send" is seen.
		//w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//a[text() = 'Send']"), "Send"));
		//u.explicitWaitText("xpath", "//a[text() = 'Send']", "Send");
		//u.explicitWaitText("xpath", "explicitWait_SendLink_xpath", "Send");
		
		//Assert by text "To:"
		//u.AssertText("To:", "xpath", "//label[text()='To:']", "for the text To:");
		//u.AssertText("To:", "xpath", "assertText_xpath_ToEditBox", "for the text To:");
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.PASS, MarkupHelper.createLabel("Assert for the text in TO edit box - To:", ExtentColor.GREEN));
							
				
		
		
		//Type on the TO field - parameterization point 4
		//*[@id="TO_IDcmp3"]
		//driver.findElement(By.xpath("//*[@id=\"TO_IDcmp2\"]")).click();
		//driver.findElement(By.xpath("//*[@id=\"TO_IDcmp2\"]")).sendKeys(h.get("TField"));
		//driver.findElement(By.xpath("//*[@id=\"TO_IDcmp2\"]")).sendKeys(Keys.RETURN);
		//u.typeEditBoxEmail("xpath", "//*[@id='TO_IDcmp2']", h.get("TField"));
		u.typeEditBoxEmail("xpath", "typeTo_xpath_ToEditBox1", h.get("TField"));
		
		
		u.stepWiseScreenshot("Type on TO field  of  Rediff Login Page_"+h.get("Browser"));
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.INFO, MarkupHelper.createLabel("Type on TO edit box", ExtentColor.BLUE));
						
				
		
		//Assert by text "Subject:"
		//u.AssertText("Subject:", "xpath", "//label[text()='Subject:']", "for the text Subject:");
		u.AssertText("Subject:", "xpath", "assertText_xpath_SubjectEditBox1", "for the text Subject:");
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.PASS, MarkupHelper.createLabel("Assert for the text in SUBJECT edit box - Subject:", ExtentColor.GREEN));
					
		
		//Type on the SUBJECT edit box-parameterization point 5
		//driver.findElement(By.xpath("//*[@id=\"rd_compose_cmp2\"]/ul/li[4]/input")).click();
		//driver.findElement(By.xpath("//*[@id=\"rd_compose_cmp2\"]/ul/li[4]/input")).sendKeys(h.get("SField"));
		//u.typeEditBox("xpath", "//*[@id='rd_compose_cmp2']/ul/li[4]/input", h.get("SField"));
		u.typeEditBox("xpath", "typeSubject_xpath_SubjectEditBox1", h.get("SField"));
		
		u.stepWiseScreenshot("Type on SUBJECT field  of  Rediff Login Page_"+h.get("Browser"));
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.INFO, MarkupHelper.createLabel("Type on SUBJECT edit box", ExtentColor.BLUE));
								
					
	
		//Switch to the frame
		//wb = driver.findElement(By.cssSelector("#cke_1_contents > iframe"));
		//driver.switchTo().frame(wb);
		u.switchFrameWebElement("cssSelector", "switchFrameCompose_cssSelector_ComposeFrame1");
		
		//Type on the COMPOSE edit box -parameterization point 6
		//driver.findElement(By.xpath("/html/body")).click();
		//driver.findElement(By.xpath("/html/body")).sendKeys(h.get("CField"));
		//u.typeEditBox("xpath", "/html/body", h.get("CField"));
		u.typeEditBox("xpath", "typeCompose_xpath_ComposeEditBox1", h.get("CField"));
		
		u.stepWiseScreenshot("Type on COMPOSE field  of  Rediff Login Page_"+h.get("Browser"));
		
		//Switch back to main page from Frame
		//driver.switchTo().defaultContent();
		u.switchMainPage();
		
		//Assert by the text "Send"
		//u.AssertText("Send", "xpath", "//a[text()='Send']", "for the text Send");
		u.AssertText("Send", "xpath", "assertText_xpath_SendLink1", "for the text Send");
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.PASS, MarkupHelper.createLabel("Assert for the text in SEND link - Send", ExtentColor.GREEN));
					
		
		//Click on SEND Link
		//driver.findElement(By.xpath("//*[@id=\"rd_compose_cmp2\"]/div[1]/a[1]")).click();
		u.clickLink("xpath", "clickSend_xpath_SendLink1");
		
		u.stepWiseScreenshot("Click  on Send button of  Rediff Login Page_"+h.get("Browser"));
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.INFO, MarkupHelper.createLabel("Click on SEND link", ExtentColor.BLUE));
					
		
		//Wait for the text "Your mail is sent"
		//w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"rdNotify\"]"), "Your mail has been sent"));
		//u.explicitWaitText("xpath", "//*[@id='rdNotify']", "Your mail has been sent");
		u.explicitWaitText("xpath", "explicitWait_YourMailIsSentNotification_xpath1", "Your mail has been sent");
		
		
		//Wait until the text LOGOUT is present
		//w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//a[text() = 'Logout']"), "Logout"));
		//u.explicitWaitText("xpath", "//a[text() = 'Logout']", "Logout");
		u.explicitWaitText("xpath", "explicitWait_LogoutText_xpath1", "Logout");
		
		
		//Assert by the text "Logout"
		//u.AssertText("Logout", "xpath", "//a[text() = 'Logout']", "for the text Logout");
		u.AssertText("Logout", "xpath", "assertText_xpath_LogoutLink1", "for the text Logout");
				
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.PASS, MarkupHelper.createLabel("Assert for the text in LOGOUT link - Send", ExtentColor.GREEN));
				
		
		//Click on Logout link
		//driver.findElement(By.xpath("//a[text() = 'Logout']")).click();
		u.clickLink("xpath", "clickLogout_xpath_LogoutLink1");
		
		u.stepWiseScreenshot("Click  on Logout link of  Rediff Login Page_"+h.get("Browser"));
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.INFO, MarkupHelper.createLabel("Click on Logout link", ExtentColor.BLUE));
				
		
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			try {
				String screenshotPath = u.FailScreenshot(result.getName()); //Screenshot file name will come with test annotation method name
				//Also put the failed screenshot in Extent report
				// 1) Adding screenshots to log of Extent Report
				logger.fail("Assertion failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				// Adding screenshots to test step
				logger.fail("Assertion failed").addScreenCaptureFromPath(screenshotPath);
				//Add the test annotation method name which has failed in the log file of Extent Report
				logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Rediffmail Account Creation Page Test Case", ExtentColor.RED));
				//Add the exception name on assertion failure to the log file of Extent Report
				//getThrowable() of ITestResul Interface will get the exception of error
				logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + "- Rediffmail Account Creation Page Test Case", ExtentColor.RED));
			
			
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		///Write the report in the report generated using the flush method
		extent.flush();

		//Close the App
		driver.quit();
	}
	
	
}
