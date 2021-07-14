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

import Base.BaseSettings;
import Utilities.Utils;
import repo.Data;

public class formRediffmail extends BaseSettings{

	public   WebDriver driver;
	public   WebDriverWait w;
	public  WebElement wb;
	public  Select s;
	public Utils u;
	
	
	@Test(dataProvider = "formData", dataProviderClass = Data.class )
	public  void FillingFormRediffmail(Hashtable <String, String> h) throws InterruptedException {	

		
		driver = formRediffmail.RunBrowser(h.get("Browser")); //Chrome and Edge - parameterization point 1
		
		u = new Utils(driver);
		
		//Maximise the browser window
		driver.manage().window().maximize();
		
		//Navigate to the Rediffmail Form Creation website
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		
		//StepWise Screenshot after navigation to Rediffmail form creation page to take the screenshot
		u.stepWiseScreenshot("Navigate Redifmail_"+h.get("Browser"));  //Will give the value of key
			
		//Define the page load timeout
		driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
			
		//Implicit wait - Dynamic wait 
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		//Explicit Wait 
		w = new WebDriverWait(driver, 20L);
		
		//Wait until the text "Create a Rediffmail account" is seen
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.className("f22"), "Create a Rediffmail account"));
		
		//Verify the title
		u.VerifyTitle("Rediffmail Free Unlimited Storage", "Rediffmail landing page");
		
		//Verify the text  - Create a Rediffmail account
		u.VerifyText("Create a Rediffmail account", "className", "f22", "the text \"Create a Rediffmail account\"");

		//Assert on title 
		u.AssertTitle("Rediffmail Free Unlimited Storage", "Landing Page");
				
		//Assert on text "Create a Rediffmail account" in landing page
		u.AssertText("Create a Rediffmail account", "xpath", "//*[@id=\"tblcrtac\"]/tbody/tr[1]/td", "for the text Create a Rediffmail account");
				
		
		//Assert for FULL name text to be present
		u.AssertText("Full Name", "xpath", "//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[1]", "for the text Full Name");
		
		//Type on Full Name - parameterization point 2
		driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[3]/td[3]/input")).click();
		//driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[3]/td[3]/input")).sendKeys(fName);
		driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[3]/td[3]/input")).sendKeys(h.get("FName"));
	
		//StepWise Screenshot 
		//u.stepWiseScreenshot("Type Full Name_"+browser);
		u.stepWiseScreenshot("Type Full Name_"+h.get("Browser"));
		
		//Assert by the text "Choose a Rediffmail ID'
		u.AssertText("Choose a Rediffmail ID", "xpath", "//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[1]", "for the text Choose a Rediffmail ID");
		
		//Type in the Rediffmail ID  - parameterization point 3
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).click();
		//driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).sendKeys(rediffID);
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).sendKeys(h.get("RID"));
		
		//StepWise Screenshot 
		//u.stepWiseScreenshot("Type Rediffmail ID_"+browser);
		u.stepWiseScreenshot("Type Rediffmail ID_"+h.get("Browser"));
		
		//Assert by attribute value of the "value" attribute
		u.AssertAttributeValue("Check availability", "xpath", "//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[2]", "value attribute for check availability button", "value");
		
		//Click on check availability button 
		Actions act = new Actions(driver);
		wb = driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[7]/td[3]/input[2]"));
		act.moveToElement(wb).click();
		act.build().perform();
		
		//StepWise Screenshot 
		//u.stepWiseScreenshot("Text Appearing after button_"+browser);
		u.stepWiseScreenshot("Text Appearing after button_"+h.get("Browser"));
		
		
		//Wait until the text "Yippie! The ID you've chosen is available." is present
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#check_availability > font > b"), "Yippie! The ID you've chosen is available."));
	
		
		//To check if the text "Yippie! The ID you've chosen is available." is present . If not no further trnsaction
		String expectedText = "Yippie! The ID you've chosen is available.";
		String actualText = driver.findElement(By.xpath("//*[@id=\"check_availability\"]/font/b")).getText();
		if(actualText.equals(expectedText)) {
			
			//Assert by the text "Yippie! The ID you've chosen is available."
			u.AssertText("Yippie! The ID you've chosen is available.", "cssSelector", "#check_availability > font > b", "for the text Yippie! The ID you've chosen is available.");
			
			//Assert on the text "Password"
			u.AssertText("Password", "xpath", "//*[@id='tblcrtac']/tbody/tr[9]/td[1]", "for the text Password");
			
			//Type on Password - parameterization point 4
			driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[9]/td[3]/input")).click();
			//driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[9]/td[3]/input")).sendKeys(pwd);
			driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[9]/td[3]/input")).sendKeys(h.get("Pwd"));
		
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Type Password_"+browser);
			u.stepWiseScreenshot("Type Password_"+h.get("Browser"));
			
			//Assert by the text "Retype password'
			u.AssertText("Retype password", "xpath", "//*[@id=\"tblcrtac\"]/tbody/tr[11]/td[1]", "for the text Retype password");
			
			
			//Type on Retype Password - parameterization point 5
			driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[11]/td[3]/input")).click();
			//driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[11]/td[3]/input")).sendKeys(rPwd);
			driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[11]/td[3]/input")).sendKeys(h.get("Rpwd"));
		
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Type Password Again_"+browser);
			u.stepWiseScreenshot("Type Password Again_"+h.get("Browser"));
			
			//Assert by the text " Click if you don't have an alternate ID"
			u.AssertText(" Click if you don't have an alternate ID", "xpath", "//*[@id=\"altid_msg\"]/span", " for the text Click if you don't have an alternate ID");
			
			//To check if the check box for alternate Email ID is selected
			//isSelected method to check whether a radio button or checkbox is selected
			boolean sel = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[15]/td[2]/table/tbody/tr/td[1]/input")).isSelected();
			System.out.println("After Email ID checkbox is selected ? --> "+sel);
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Step - before Checkbox Clicked_"+browser);
			u.stepWiseScreenshot("Step - before Checkbox Clicked_"+h.get("Browser"));
			
			//Now select the Checkbox
			driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[15]/td[2]/table/tbody/tr/td[1]/input")).click();
		
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Checkeckox chicked_"+browser);
			u.stepWiseScreenshot("Checkeckox chicked_"+h.get("Browser"));
			
			//To check if the check box for alternate Email ID is selected
			boolean sel1 = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[15]/td[2]/table/tbody/tr/td[1]/input")).isSelected();
			System.out.println("After Email ID checkbox is selected ? --> "+sel1);
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Step - after Checkbox Clicked_"+browser);
			u.stepWiseScreenshot("Step - after Checkbox Clicked_"+h.get("Browser"));
			
			//Assert by the text "Select a Security Question"
			u.AssertText("Select a Security Question", "xpath", "//*[@id=\"div_hintQS\"]/table/tbody/tr[2]/td[1]", " for the text Select a Security Question");
			
			
			//Drop option to be selected for "Select a security Question" created by SELECT tag
			wb = driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[2]/td[3]/select"));
			s = new Select(wb);
			s.selectByIndex(2);
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Secuity Question  - Drop down_"+browser);
			u.stepWiseScreenshot("Secuity Question  - Drop down_"+h.get("Browser"));
			
			//Assert by the text "Enter an Answer'
			u.AssertText("Enter an Answer", "xpath", "//*[@id=\"div_hintQS\"]/table/tbody/tr[4]/td[1]", " for the text Enter an Answer");
			
			
			
			//Type on ENTER AN ANSWER - parameterization point 6
			driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[4]/td[3]/input")).click();
			//driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[4]/td[3]/input")).sendKeys(sQuestion);
			driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[4]/td[3]/input")).sendKeys(h.get("SQues"));
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Type Enter Answer to Security Question_"+browser);
			u.stepWiseScreenshot("Type Enter Answer to Security Question_"+h.get("Browser"));
			
			//Assert by the text "Mother's Maiden Name"
			u.AssertText("Mother's Maiden Name", "xpath", "//*[@id=\"div_hintQS\"]/table/tbody/tr[6]/td[1]", " for the text Mother's Maiden Name");
			
			
			//Type on Mother's Maiden name - parameterization point 7
			driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[6]/td[3]/input")).click();
			//driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[6]/td[3]/input")).sendKeys(momName);
			driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[6]/td[3]/input")).sendKeys(h.get("MName"));
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Type Mother's name_"+browser);
			u.stepWiseScreenshot("Type Mother's name_"+h.get("Browser"));
			
			//Assert by the text "Mobile No."
			u.AssertText("Mobile No.", "xpath", "//*[@id=\"mob_txt\"]", " for the text Mobile No.");
			
			
			//Select the option from ISD code drop down creatd by DIV tag
			//1. Click on the drop down to get the option
			driver.findElement(By.xpath("//*[@id=\"div_mob\"]/table/tbody/tr/td[3]/div[2]")).click();
			//2. The option of this drop down are created by UL - LI tag. GEt the options XPATH - USA
			driver.findElement(By.xpath("//*[@id=\"country_id\"]/ul/li[2]")).click();
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("ISD Code  - Drop down_"+browser);
			u.stepWiseScreenshot("ISD Code  - Drop down_"+h.get("Browser"));
			
			//Assert  by the attribute value "id" 
			u.AssertAttributeValue("mobno", "xpath", "//*[@id=\"mobno\"]", "for the attribute ID", "id");
			
			//Fill the edit box beside the ISD code drop down - parameterization point 8
			driver.findElement(By.xpath("//*[@id=\"mobno\"]")).click();
			//driver.findElement(By.xpath("//*[@id=\"mobno\"]")).sendKeys(phone);
			driver.findElement(By.xpath("//*[@id=\"mobno\"]")).sendKeys(h.get("PNumber"));
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Type Phone Number_"+browser);
			u.stepWiseScreenshot("Type Phone Number_"+h.get("Browser"));
			
			
			//Assert by the text "Date of Birth"
			u.AssertText("Date of Birth", "xpath", "//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[1]", " for the text Date of Birth");
			
			
			//Choose option from DAY drop down created by Select Tag
			wb = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[1]"));
			s = new Select(wb);
			s.selectByValue("04");
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Day  - Drop down_"+browser);
			u.stepWiseScreenshot("Day  - Drop down_"+h.get("Browser"));
			
			//Choose option from MONTH drop down created by Select Tag
			wb = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[2]"));
			s = new Select(wb);
			s.selectByVisibleText("FEB");
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Month  - Drop down_"+browser);
			u.stepWiseScreenshot("Month  - Drop down_"+h.get("Browser"));
			
			//Choose option from YEAR drop down created by Select Tag
			wb = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[3]"));
			s = new Select(wb);
			s.selectByIndex(6);
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Year  - Drop down_"+browser);
			u.stepWiseScreenshot("Year  - Drop down_"+h.get("Browser"));
			
			
			//From the area containing both radio button i.e. male and female, check which radio button is selected by default?
			wb = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]"));
			List<WebElement> allradioButtons = wb.findElements(By.tagName("input"));
			int numOfRadioButtons = allradioButtons.size();
			System.out.println("Number of radio buttons in the area are "+numOfRadioButtons);
			for(int x = 0; x<numOfRadioButtons; x++) {
				boolean valIsSelected = allradioButtons.get(x).isSelected();
				String valAttr = allradioButtons.get(x).getAttribute("value");
				System.out.println(valAttr+"--"+valIsSelected);
			}
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Check Selected radio button - Male_"+browser);
			u.stepWiseScreenshot("Check Selected radio button - Male_"+h.get("Browser"));
			
			//Assert by the attribute "value" whose value is "f"
			u.AssertAttributeValue("f", "xpath", "//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[2]", "for the value attribute", "value");
			
			//Select the FEMALE radio button
			driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[2]")).click();
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Radio button - Female Selected_"+browser);
			u.stepWiseScreenshot("Radio button - Female Selected_"+h.get("Browser"));

			
			//From the area containing both radio button i.e. male and female, check whicb radio button is selected by default?
			wb = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]"));
			allradioButtons = wb.findElements(By.tagName("input"));
			numOfRadioButtons = allradioButtons.size();
			System.out.println("Number of radio buttons in the area are "+numOfRadioButtons);
			for(int x = 0; x<numOfRadioButtons; x++) {
				boolean valIsSelected = allradioButtons.get(x).isSelected();
				String valAttr = allradioButtons.get(x).getAttribute("value");
				System.out.println(valAttr+"--"+valIsSelected);
			}
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Check Selected radio button - Female_"+browser);
			u.stepWiseScreenshot("Check Selected radio button - Female_"+h.get("Browser"));
			
			//Assert by the attribute "class" with value "country"
			u.AssertAttributeValue("countr", "xpath", "//*[@id=\"tblcrtac\"]/tbody/tr[26]/td[1]/span", "for the attribute called class", "class");
			
			//Choose option from COUNTRY drop down created by Select Tag
			wb = driver.findElement(By.xpath("//*[@id=\"country\"]"));
			s = new Select(wb);
			s.selectByValue("99");
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Country  - Drop down_"+browser);
			u.stepWiseScreenshot("Country  - Drop down_"+h.get("Browser"));
			
			//Assert  by the text "City"
			u.AssertText("City  ", "xpath", "//*[@id=\"div_city\"]/table/tbody/tr[1]/td[1]", " for the text City");
			
			
			//Choose option from CITY drop down created by Select Tag
			wb = driver.findElement(By.xpath("//*[@id=\"div_city\"]/table/tbody/tr[1]/td[3]/select"));
			s = new Select(wb);
			s.selectByVisibleText("Bangalore");
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("City  - Drop down_"+browser);
			u.stepWiseScreenshot("City  - Drop down_"+h.get("Browser"));
		
		}
		
	}
	
	
	/*1) After method runs after each test annotation method. 
	 * 
	 * For example there are 2 test annotation method :
	 * @Test (priority = 1)
	 * public void testMethodA(){
	 * 
	 * }
	 * 
	 * @Test(priority = 2)
	 * public void testMethodB(){
	 * 
	 * }
	 * 
	 * @ AfterMethod
	 * public void tearDown(){
	 * 
	 * }
	 * 
	 * Run Procedure:
	 * testMethodA()
	 * tearDown()
	 * testMethodB()
	 * tearDown()
	 * 
	 * 2) As the number of times the test annotation methods are present, AfterMethod annotation will
	 * run those number of times.
	 * 
	 * 3) Whether the test annotation method passes or fails ,  the AfterMethod annotation
	 * will run.
	 * 
	 * 4) AfterMethod annotation can be used once in a class file
	 * 
	 * 
	 * 5)  Before method runs before each test annotation method. 
	 * 
	 * For example there are 2 test annotation method :
	 * @Test (priority = 1)
	 * public void testMethodA(){
	 * 
	 * }
	 * 
	 * @Test(priority = 2)
	 * public void testMethodB(){
	 * 
	 * }
	 * 
	 * @ BeforeMethod
	 * public void SetUp(){
	 * 
	 * }
	 * 
	 * Run Procedure:
	 * SetUp()
	 * testMethodA()
	 * SetUp()
	 * testMethodB()
	 * 
	 * 6) As the number of times the test annotation methods are present, BeforeMethod annotation will
	 * run those number of times.
	 * 
	 * 7) Whether the test annotation method passes or fails ,  the BeforeMethod annotation
	 * will run.
	 * 
	 * 8)BeforeMethod annotation can be used once in a class file.
	 * 
	 * NOTE: It is not compulsory to have both AfterMethod or BeforeMethod annotation.
	 * 
	 */
	@AfterMethod
	public void tearDown(ITestResult result) {
		//Screenshot on failure of Assertion
		//For taking screen shot on failure we need to use ITestResult interface of TestNG
		//Java doc --> https://javadoc.jitpack.io/com/github/cbeust/testng/master/javadoc/
		/*Static and final fields of ITestResult interface. Static and final field have fixed values.
		 * 
		 * https://javadoc.jitpack.io/com/github/cbeust/testng/master/javadoc/
		 * 
		 * FAIILURE = 2
		 * SKIP = 3
		 * SUCCESS = 1
		 */
		
		/*getStatus()  - return a integer value . This methods gives whther the test annotation method 
		 * has passed, failed or skipped dynamically
		 * 
		 * getStatus()  = 1 --> SUCCESS of test annotation method
		 * getStatus()  = 2 --> FAILED of test annotation method
		 * getStatus()  = 3--> Skipping of test annotation method
		 */
		
		/*getName()  - Will give the name of TEST ANNOTATIONMETHOD */
		
		int x = result.getStatus();
		System.out.println(x);
		if(x == ITestResult.FAILURE) {
			//u = new Utils(driver);
			u.FailScreenshot(result.getName()); //Screenshot file name will come with test annotation method name
		}
		

		//Close the App
		driver.quit();
	
		
	}
	
	

}
