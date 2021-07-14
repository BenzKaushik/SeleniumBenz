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
	
	/*
	 * 1)Data Provider is used to parameterize.
	 * 2)Parameterize is a process to check the same functionality but with different data sets.
	 * 3) All annotations of TestNG takes PUBLIC NON-STATIC VOID RETURN TYPE methods. Dataprovider 
	 * annotation takes the return type as two dimensional object array
	 * 4) For the sake of smooth running, try to have one TEST annotation in a class file which has
	 * DATAPROVIDER annotation.
	 * 5) Parameterization is possible with edit box, drop down
	 * 
	 */
	
	
	//Connecting the dataprovider annotation  name parameter value called as  "formData" with the test annotation
	//Give the class in which "formData" is present
	@Test(dataProvider = "formData", dataProviderClass = Data.class )
	//public  void FillingFormRediffmail(String browser, String fName,String rediffID, String pwd, String rPwd, String sQuestion, String momName, String phone ) throws InterruptedException {
	public  void FillingFormRediffmail(Hashtable <String, String> h) throws InterruptedException {	
		//driver = formRediffmail.RunBrowser(browser); //Chrome and Edge - parameterization point 1
		String browserVal = h.get("Browser");
		System.out.println(browserVal);
		driver = formRediffmail.RunBrowser(h.get("Browser")); //Chrome and Edge - parameterization point 1
		
		
		Utils u = new Utils(driver);
		
		//Maximise the browser window
		driver.manage().window().maximize();
		
		//Navigate to the Rediffmail Form Creation website
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		//StepWise Screenshot after navigation to Rediffmail form cration page to take the screenshot
		//u.stepWiseScreenshot("Navigate Redifmail_"+browser);
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

		//Type on Full Name - parameterization point 2
		driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[3]/td[3]/input")).click();
		//driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[3]/td[3]/input")).sendKeys(fName);
		driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[3]/td[3]/input")).sendKeys(h.get("FName"));
	
		//StepWise Screenshot 
		//u.stepWiseScreenshot("Type Full Name_"+browser);
		u.stepWiseScreenshot("Type Full Name_"+h.get("Browser"));
		
		//Type in the Rediffmail ID  - parameterization point 3
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).click();
		//driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).sendKeys(rediffID);
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).sendKeys(h.get("RID"));
		
		//StepWise Screenshot 
		//u.stepWiseScreenshot("Type Rediffmail ID_"+browser);
		u.stepWiseScreenshot("Type Rediffmail ID_"+h.get("Browser"));
		
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
			//Type on Password - parameterization point 4
			driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[9]/td[3]/input")).click();
			//driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[9]/td[3]/input")).sendKeys(pwd);
			driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[9]/td[3]/input")).sendKeys(h.get("Pwd"));
		
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Type Password_"+browser);
			u.stepWiseScreenshot("Type Password_"+h.get("Browser"));
			
			//Type on Retype Password - parameterization point 5
			driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[11]/td[3]/input")).click();
			//driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[11]/td[3]/input")).sendKeys(rPwd);
			driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[11]/td[3]/input")).sendKeys(h.get("Rpwd"));
		
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Type Password Again_"+browser);
			u.stepWiseScreenshot("Type Password Again_"+h.get("Browser"));
			
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
			
			//Drop option to be selected for "Select a security Question" created by SELECT tag
			wb = driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[2]/td[3]/select"));
			s = new Select(wb);
			s.selectByIndex(2);
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Secuity Question  - Drop down_"+browser);
			u.stepWiseScreenshot("Secuity Question  - Drop down_"+h.get("Browser"));
			
			//Type on ENTER AN ANSWER - parameterization point 6
			driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[4]/td[3]/input")).click();
			//driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[4]/td[3]/input")).sendKeys(sQuestion);
			driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[4]/td[3]/input")).sendKeys(h.get("SQues"));
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Type Enter Answer to Security Question_"+browser);
			u.stepWiseScreenshot("Type Enter Answer to Security Question_"+h.get("Browser"));
			
			//Type on Mother's Maiden name - parameterization point 7
			driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[6]/td[3]/input")).click();
			//driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[6]/td[3]/input")).sendKeys(momName);
			driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[6]/td[3]/input")).sendKeys(h.get("MName"));
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Type Mother's name_"+browser);
			u.stepWiseScreenshot("Type Mother's name_"+h.get("Browser"));
			
			//Select the option from ISD code drop down creatd by DIV tag
			//1. Click on the drop down to get the option
			driver.findElement(By.xpath("//*[@id=\"div_mob\"]/table/tbody/tr/td[3]/div[2]")).click();
			//2. The option of this drop down are created by UL - LI tag. GEt the options XPATH - USA
			driver.findElement(By.xpath("//*[@id=\"country_id\"]/ul/li[2]")).click();
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("ISD Code  - Drop down_"+browser);
			u.stepWiseScreenshot("ISD Code  - Drop down_"+h.get("Browser"));
			
			//Fill the edit box beside the ISD code drop down - parameterization point 8
			driver.findElement(By.xpath("//*[@id=\"mobno\"]")).click();
			//driver.findElement(By.xpath("//*[@id=\"mobno\"]")).sendKeys(phone);
			driver.findElement(By.xpath("//*[@id=\"mobno\"]")).sendKeys(h.get("PNumber"));
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Type Phone Number_"+browser);
			u.stepWiseScreenshot("Type Phone Number_"+h.get("Browser"));
			
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
			
			//From the area containing both radio button i.e. male and female, check whicb radio button is selected by default?
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
			
			
			//Choose option from COUNTRY drop down created by Select Tag
			wb = driver.findElement(By.xpath("//*[@id=\"country\"]"));
			s = new Select(wb);
			s.selectByValue("99");
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("Country  - Drop down_"+browser);
			u.stepWiseScreenshot("Country  - Drop down_"+h.get("Browser"));
			
			//Choose option from CITY drop down created by Select Tag
			wb = driver.findElement(By.xpath("//*[@id=\"div_city\"]/table/tbody/tr[1]/td[3]/select"));
			s = new Select(wb);
			s.selectByVisibleText("Bangalore");
			
			//StepWise Screenshot 
			//u.stepWiseScreenshot("City  - Drop down_"+browser);
			u.stepWiseScreenshot("City  - Drop down_"+h.get("Browser"));
			
			//Close the browser
			driver.quit();
			
		
		}
		
		//Close the App
		driver.quit();
	
	}
	
	

}
