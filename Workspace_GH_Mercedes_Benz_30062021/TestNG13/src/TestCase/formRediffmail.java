package TestCase;

import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

import Base.BaseSettings;
import Repo.Data;
import Utilities.ExtentManager;
import Utilities.Utils;

public class formRediffmail extends BaseSettings{

	public   WebDriver driver;
	public   WebDriverWait w;
	public  WebElement wb;
	public  Select s;
	public Utils u;
	public ExtentTest logger;
	
	
	//Use the getInstanceSparkReporter() method which returns  ExtentSparkReporter class
	ExtentSparkReporter report = ExtentManager.getInstanceSparkReporter();
	
	//Use the getInstanceReporter() method which returns  ExtentReports class
	ExtentReports extent = ExtentManager.getInstanceReporter();
	
	
	
	@Test(dataProvider = "formData", dataProviderClass = Data.class )
	public  void FillingFormRediffmail(Hashtable <String, String> h) throws InterruptedException {
		
		//Create the test case required for Extent report
		logger = extent.createTest("Rediffmail Account Creation Page Test Case  - "+h.get("Browser"));
		
		//Create the category for testing - using the assign category method of ExtentTest class
		logger.assignCategory("Test Category Preference  - Functional");

		
		driver = formRediffmail.RunBrowser(h.get("Browser")); //Chrome and Edge - parameterization point 1
		
		u = new Utils(driver);
		
		//Maximise the browser window
		driver.manage().window().maximize();
		
		//Navigate to the Rediffmail Form Creation website
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		
		//StepWise Screenshot after navigation to Rediffmail form creation page to take the screenshot
		u.stepWiseScreenshot("Navigate Redifmail_"+h.get("Browser"));  //Will give the value of key
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.INFO, MarkupHelper.createLabel("Navigating to Rediffmal Account creation page", ExtentColor.BLUE));
			
		//Define the page load timeout
		driver.manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
			
		//Implicit wait - Dynamic wait 
		driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
		
		//Explicit Wait 
		w = new WebDriverWait(driver, 30L);
		
		//Wait until the text "Create a Rediffmail account" is seen
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.className("f22"), "Create a Rediffmail account"));
		
		//Verify the title
		u.VerifyTitle("Rediffmail Free Unlimited Storage", "Rediffmail landing page");
		
		//Verify the text  - Create a Rediffmail account
		u.VerifyText("Create a Rediffmail account", "className", "f22", "the text \"Create a Rediffmail account\"");

		//Assert on title 
		u.AssertTitle("Rediffmail Free Unlimited Storage", "Landing Page");
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.PASS, MarkupHelper.createLabel("Assertion for title in landing page - Rediffmail Free Unlimited Storage", ExtentColor.GREEN));
					
				
		//Assert on text "Create a Rediffmail account" in landing page
		u.AssertText("Create a Rediffmail account", "xpath", "//*[@id=\"tblcrtac\"]/tbody/tr[1]/td", "for the text Create a Rediffmail account");
			
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.PASS, MarkupHelper.createLabel("Assertion for text in landing page - Create a Rediffmail account", ExtentColor.GREEN));
				
		
		//Assert for FULL name text to be present
		u.AssertText("Full Name", "xpath", "//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[1]", "for the text Full Name");
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.PASS, MarkupHelper.createLabel("Assertion for text in Full Name edit box - Full Name", ExtentColor.GREEN));
				
		
		//Type on Full Name - parameterization point 2
		driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[3]/td[3]/input")).click();
		//driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[3]/td[3]/input")).sendKeys(fName);
		driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[3]/td[3]/input")).sendKeys(h.get("FName"));
	
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.INFO, MarkupHelper.createLabel("Type in Full Name edit box", ExtentColor.BLUE));
				
		
		//StepWise Screenshot 
		//u.stepWiseScreenshot("Type Full Name_"+browser);
		u.stepWiseScreenshot("Type Full Name_"+h.get("Browser"));
		
		//Assert by the text "Choose a Rediffmail ID'
		u.AssertText("Choose a Rediffmail ID", "xpath", "//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[1]", "for the text Choose a Rediffmail ID");
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.PASS, MarkupHelper.createLabel("Assertion for text in Rediffmail ID edit box - Choose a Rediffmail ID", ExtentColor.GREEN));
				
		
		//Type in the Rediffmail ID  - parameterization point 3
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).click();
		//driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).sendKeys(rediffID);
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).sendKeys(h.get("RID"));
		
		
		//StepWise Screenshot 
		//u.stepWiseScreenshot("Type Rediffmail ID_"+browser);
		u.stepWiseScreenshot("Type Rediffmail ID_"+h.get("Browser"));
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.INFO, MarkupHelper.createLabel("Type in Rediffmail ID edit box", ExtentColor.BLUE));
				
		
		//Assert by attribute value of the "value" attribute
		u.AssertAttributeValue("Check availability", "xpath", "//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[2]", "value attribute for check availability button", "value");
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.PASS, MarkupHelper.createLabel("Assertion for attribute: \"value\" in html script of Check Availability button.", ExtentColor.GREEN));
				
		
		
		//Click on check availability button 
		Actions act = new Actions(driver);
		wb = driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[7]/td[3]/input[2]"));
		act.moveToElement(wb).click();
		act.build().perform();
		
		//StepWise Screenshot 
		//u.stepWiseScreenshot("Text Appearing after button_"+browser);
		u.stepWiseScreenshot("Text Appearing after button_"+h.get("Browser"));
		
		//Logging for Extent Report - Which is a test step in Extent report
		logger.log(Status.INFO, MarkupHelper.createLabel("Click on CHeck Availability button", ExtentColor.BLUE));
						
				
		
		
		//Wait until the text "Yippie! The ID you've chosen is available." is present
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#check_availability > font > b"), "Yippie! The ID you've chosen is available."));
	
		
		//To check if the text "Yippie! The ID you've chosen is available." is present . If not no further trnsaction
		String expectedText = "Yippie! The ID you've chosen is available.";
		String actualText = driver.findElement(By.xpath("//*[@id=\"check_availability\"]/font/b")).getText();
		if(actualText.equals(expectedText)) {
			
			//Assert by the text "Yippie! The ID you've chosen is available."
			u.AssertText("Yippie! The ID you've chosen is available.", "cssSelector", "#check_availability > font > b", "for the text Yippie! The ID you've chosen is available.");
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.PASS, MarkupHelper.createLabel("Assertion for text which is shown after clicking on Check Availability button - Yippie! The ID you've chosen is available.", ExtentColor.GREEN));
			
			
			//Assert on the text "Password"
			u.AssertText("Password", "xpath", "//*[@id='tblcrtac']/tbody/tr[9]/td[1]", "for the text Password");
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.PASS, MarkupHelper.createLabel("Assertion for text in Password edit box - Password", ExtentColor.GREEN));
			
			
			//Type on Password - parameterization point 4
			driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[9]/td[3]/input")).click();
			//driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[9]/td[3]/input")).sendKeys(pwd);
			driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[9]/td[3]/input")).sendKeys(h.get("Pwd"));
		
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Type Password_"+browser);
			u.stepWiseScreenshot("Type Password_"+h.get("Browser"));
			
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.INFO, MarkupHelper.createLabel("Type on Password edit box", ExtentColor.BLUE));
				
			
			//Assert by the text "Retype password'
			u.AssertText("Retype password", "xpath", "//*[@id=\"tblcrtac\"]/tbody/tr[11]/td[1]", "for the text Retype password");
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.PASS, MarkupHelper.createLabel("Assertion for text in Retypr Password edit box - Retype password", ExtentColor.GREEN));
			
			
			//Type on Retype Password - parameterization point 5
			driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[11]/td[3]/input")).click();
			//driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[11]/td[3]/input")).sendKeys(rPwd);
			driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[11]/td[3]/input")).sendKeys(h.get("Rpwd"));
		
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Type Password Again_"+browser);
			u.stepWiseScreenshot("Type Password Again_"+h.get("Browser"));
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.INFO, MarkupHelper.createLabel("Type on Retype Password edit box", ExtentColor.BLUE));
				
			
			//Assert by the text " Click if you don't have an alternate ID"
			u.AssertText(" Click if you don't have an alternate ID", "xpath", "//*[@id=\"altid_msg\"]/span", " for the text Click if you don't have an alternate ID");
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.PASS, MarkupHelper.createLabel("Assertion for text in Alternate ID check box -  Click if you don't have an alternate ID", ExtentColor.GREEN));
			
			
			//To check if the check box for alternate Email ID is selected
			//isSelected method to check whether a radio button or checkbox is selected
			boolean sel = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[15]/td[2]/table/tbody/tr/td[1]/input")).isSelected();
			System.out.println("After Email ID checkbox is selected ? --> "+sel);
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Step - before Checkbox Clicked_"+browser);
			u.stepWiseScreenshot("Step - before Checkbox Clicked_"+h.get("Browser"));
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.INFO, MarkupHelper.createLabel("To check id checkbox is SELECTED: "+sel, ExtentColor.BLUE));
				
			
			//Now select the Checkbox
			driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[15]/td[2]/table/tbody/tr/td[1]/input")).click();
		
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Checkeckox chicked_"+browser);
			u.stepWiseScreenshot("Checkeckox chicked_"+h.get("Browser"));
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.INFO, MarkupHelper.createLabel("Alternate Email ID check box is selected", ExtentColor.BLUE));
			
			
			
			//To check if the check box for alternate Email ID is selected
			boolean sel1 = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[15]/td[2]/table/tbody/tr/td[1]/input")).isSelected();
			System.out.println("After Email ID checkbox is selected ? --> "+sel1);
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Step - after Checkbox Clicked_"+browser);
			u.stepWiseScreenshot("Step - after Checkbox Clicked_"+h.get("Browser"));
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.INFO, MarkupHelper.createLabel("To check id checkbox is SELECTED: "+sel1, ExtentColor.BLUE));
				
			
			//Assert by the text "Select a Security Question"
			u.AssertText("Select a Security Question", "xpath", "//*[@id=\"div_hintQS\"]/table/tbody/tr[2]/td[1]", " for the text Select a Security Question");
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.PASS, MarkupHelper.createLabel("Assertion for text in Select a Security Question drop down - Select a Security Question", ExtentColor.GREEN));
			
			
			//Drop option to be selected for "Select a security Question" created by SELECT tag
			wb = driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[2]/td[3]/select"));
			s = new Select(wb);
			s.selectByIndex(2);
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Secuity Question  - Drop down_"+browser);
			u.stepWiseScreenshot("Secuity Question  - Drop down_"+h.get("Browser"));
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.INFO, MarkupHelper.createLabel("Select a Security Question Drop Down option selected - What is your favourite pass time?  ", ExtentColor.BLUE));
			
			
			//Assert by the text "Enter an Answer'
			u.AssertText("Enter an Answer", "xpath", "//*[@id=\"div_hintQS\"]/table/tbody/tr[4]/td[1]", " for the text Enter an Answer");
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.PASS, MarkupHelper.createLabel("Assertion for text in Enter an Answer edit box - Enter an Answer", ExtentColor.GREEN));
			
			
			//Type on ENTER AN ANSWER - parameterization point 6
			driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[4]/td[3]/input")).click();
			//driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[4]/td[3]/input")).sendKeys(sQuestion);
			driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[4]/td[3]/input")).sendKeys(h.get("SQues"));
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Type Enter Answer to Security Question_"+browser);
			u.stepWiseScreenshot("Type Enter Answer to Security Question_"+h.get("Browser"));
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.INFO, MarkupHelper.createLabel("Type on the edit box  - Enter An Answer", ExtentColor.BLUE));
			
			
			//Assert by the text "Mother's Maiden Name"
			u.AssertText("Mother's Maiden Name", "xpath", "//*[@id=\"div_hintQS\"]/table/tbody/tr[6]/td[1]", " for the text Mother's Maiden Name");
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.PASS, MarkupHelper.createLabel("Assertion for text in Mother's Maiden Name edit box -Mother's Maiden Name", ExtentColor.GREEN));
			
			
			//Type on Mother's Maiden name - parameterization point 7
			driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[6]/td[3]/input")).click();
			//driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[6]/td[3]/input")).sendKeys(momName);
			driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[6]/td[3]/input")).sendKeys(h.get("MName"));
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Type Mother's name_"+browser);
			u.stepWiseScreenshot("Type Mother's name_"+h.get("Browser"));
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.INFO, MarkupHelper.createLabel("Type on the edit box  - EMother's Maiden name", ExtentColor.BLUE));
			
			
			//Assert by the text "Mobile No."
			u.AssertText("Mobile No.", "xpath", "//*[@id=\"mob_txt\"]", " for the text Mobile No.");
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.PASS, MarkupHelper.createLabel("Assertion for text in Mobile No. drop down - Mobile No.", ExtentColor.GREEN));
			
			
			//Select the option from ISD code drop down created by DIV tag
			//1. Click on the drop down to get the option
			driver.findElement(By.xpath("//*[@id=\"div_mob\"]/table/tbody/tr/td[3]/div[2]")).click();
			//2. The option of this drop down are created by UL - LI tag. GEt the options XPATH - USA
			driver.findElement(By.xpath("//*[@id=\"country_id\"]/ul/li[2]")).click();
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("ISD Code  - Drop down_"+browser);
			u.stepWiseScreenshot("ISD Code  - Drop down_"+h.get("Browser"));
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.INFO, MarkupHelper.createLabel("Choose option from ISD drop Down - USA/CANADA", ExtentColor.BLUE));
			
			
			//Assert  by the attribute value "id" in edit box beside Mobile No. drop down
			u.AssertAttributeValue("mobno", "xpath", "//*[@id=\"mobno\"]", "for the attribute ID", "id");
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.PASS, MarkupHelper.createLabel("Assertion for the attribute: \"id\" - mobno", ExtentColor.GREEN));
			
			
			
			//Fill the edit box beside the ISD code drop down - parameterization point 8
			driver.findElement(By.xpath("//*[@id=\"mobno\"]")).click();
			//driver.findElement(By.xpath("//*[@id=\"mobno\"]")).sendKeys(phone);
			driver.findElement(By.xpath("//*[@id=\"mobno\"]")).sendKeys(h.get("PNumber"));
			
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Type Phone Number_"+browser);
			u.stepWiseScreenshot("Type Phone Number_"+h.get("Browser"));
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.INFO, MarkupHelper.createLabel("Typed on the edit box bedie the Mobile No. drop down", ExtentColor.BLUE));
			
			
			
			//Assert by the text "Date of Birth"
			u.AssertText("Date of Birth", "xpath", "//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[1]", " for the text Date of Birth");
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.PASS, MarkupHelper.createLabel("Assertion for the text present beside DAY drop down - Date of Birth ", ExtentColor.GREEN));
			
			
			//Choose option from DAY drop down created by Select Tag
			wb = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[1]"));
			s = new Select(wb);
			s.selectByValue("04");
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Day  - Drop down_"+browser);
			u.stepWiseScreenshot("Day  - Drop down_"+h.get("Browser"));
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.INFO, MarkupHelper.createLabel("Choose the option from DAY drop down - 04 ", ExtentColor.BLUE));
			
			
			//Choose option from MONTH drop down created by Select Tag
			wb = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[2]"));
			s = new Select(wb);
			s.selectByVisibleText("FEB");
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Month  - Drop down_"+browser);
			u.stepWiseScreenshot("Month  - Drop down_"+h.get("Browser"));
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.INFO, MarkupHelper.createLabel("Choose the option from MONTH drop down - FEB ", ExtentColor.BLUE));
			
			
			
			//Choose option from YEAR drop down created by Select Tag
			wb = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[3]"));
			s = new Select(wb);
			s.selectByIndex(6);
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Year  - Drop down_"+browser);
			u.stepWiseScreenshot("Year  - Drop down_"+h.get("Browser"));
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.INFO, MarkupHelper.createLabel("Choose the option from YEAR drop down - 2017 ", ExtentColor.BLUE));
			
			
			
			
			//From the area containing both radio button i.e. male and female, check which radio button is selected by default?
			wb = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]"));
			List<WebElement> allradioButtons = wb.findElements(By.tagName("input"));
			int numOfRadioButtons = allradioButtons.size();
			System.out.println("Number of radio buttons in the area are "+numOfRadioButtons);
			String valAttr;
			boolean valIsSelected;
			for(int x = 0; x<numOfRadioButtons; x++) {
				valIsSelected = allradioButtons.get(x).isSelected();
				valAttr = allradioButtons.get(x).getAttribute("value");
				System.out.println(valAttr+"--"+valIsSelected);
				//Logging for Extent Report - Which is a test step in Extent report
				logger.log(Status.INFO, MarkupHelper.createLabel("Check whether MALE or FEMALE radio button selected: "+valAttr+"--"+valIsSelected , ExtentColor.BLUE));
				
				
			}
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Check Selected radio button - Male_"+browser);
			u.stepWiseScreenshot("Check Selected radio button - Male_"+h.get("Browser"));
			
			
			
			//Assert by the attribute "value" whose value is "f"
			u.AssertAttributeValue("f", "xpath", "//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[2]", "for the value attribute", "value");
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.PASS, MarkupHelper.createLabel("Assertion for the attribute: \"value\" for Female radio button - f", ExtentColor.GREEN));
			
			
			
			//Select the FEMALE radio button
			driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[2]")).click();
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Radio button - Female Selected_"+browser);
			u.stepWiseScreenshot("Radio button - Female Selected_"+h.get("Browser"));
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.INFO, MarkupHelper.createLabel("Selected the Female radio button" , ExtentColor.BLUE));
			

			
			//From the area containing both radio button i.e. male and female, check which radio button is selected by default?
			wb = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]"));
			allradioButtons = wb.findElements(By.tagName("input"));
			numOfRadioButtons = allradioButtons.size();
			System.out.println("Number of radio buttons in the area are "+numOfRadioButtons);
			boolean valIsSelected1;
			String valAttr1;
			for(int x = 0; x<numOfRadioButtons; x++) {
				valIsSelected1 = allradioButtons.get(x).isSelected();
				valAttr1 = allradioButtons.get(x).getAttribute("value");
				System.out.println(valAttr1+"--"+valIsSelected1);
				//Logging for Extent Report - Which is a test step in Extent report
				logger.log(Status.INFO, MarkupHelper.createLabel("Check whether MALE or FEMALE radio button selected: "+valAttr1+"--"+valIsSelected1 , ExtentColor.BLUE));
				
				
			}
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Check Selected radio button - Female_"+browser);
			u.stepWiseScreenshot("Check Selected radio button - Female_"+h.get("Browser"));
			
			
			//Assert by the attribute "class" with value as "country"
			u.AssertAttributeValue("country", "xpath", "//*[@id=\"tblcrtac\"]/tbody/tr[26]/td[1]/span", "for the attribute called class", "class");
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.PASS, MarkupHelper.createLabel("Assertion for the attribute: \"class\" for Country drop down - country", ExtentColor.GREEN));
			
			
			//Choose option from COUNTRY drop down created by Select Tag
			wb = driver.findElement(By.xpath("//*[@id=\"country\"]"));
			s = new Select(wb);
			s.selectByValue("99");
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Country  - Drop down_"+browser);
			u.stepWiseScreenshot("Country  - Drop down_"+h.get("Browser"));
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.INFO, MarkupHelper.createLabel("Choose the option from Country drop down - India" , ExtentColor.BLUE));
			
			
			//Assert  by the text "City"
			u.AssertText("City  ", "xpath", "//*[@id=\"div_city\"]/table/tbody/tr[1]/td[1]", " for the text City");
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.PASS, MarkupHelper.createLabel("Assertion for the text in City drop down - City", ExtentColor.GREEN));
			
			
			
			//Choose option from CITY drop down created by Select Tag
			wb = driver.findElement(By.xpath("//*[@id=\"div_city\"]/table/tbody/tr[1]/td[3]/select"));
			s = new Select(wb);
			s.selectByVisibleText("Bangalore");
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("City  - Drop down_"+browser);
			u.stepWiseScreenshot("City  - Drop down_"+h.get("Browser"));
			
			//Logging for Extent Report - Which is a test step in Extent report
			logger.log(Status.INFO, MarkupHelper.createLabel("Choose the option from City drop down - Bangalore" , ExtentColor.BLUE));
			
		
		}
		
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
