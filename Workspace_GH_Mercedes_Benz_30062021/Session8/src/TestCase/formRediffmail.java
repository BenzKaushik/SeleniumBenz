package TestCase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseSettings;
import Utilities.Utils;

public class formRediffmail extends BaseSettings{

		public static  WebDriver driver;
		public static  WebDriverWait w;
		public static WebElement wb;
		public static Select s;

	public static void main(String[] args) throws InterruptedException {
		
		driver = formRediffmail.RunBrowser("Chrome");
	
		Utils u = new Utils(driver);
		
		//Maximise the browser window
		driver.manage().window().maximize();
		
		//Navigate to the Rediffmail Form Creation website
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		//StepWise Screenshot after navigation to Rediffmail form cration page to take the screenshot
		u.stepWiseScreenshot("Navigate Redifmail");
			
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

		//Type on Full Name
		driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[3]/td[3]/input")).click();
		driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[3]/td[3]/input")).sendKeys("Kaushik Mukherjee");
	
		//StepWise Screenshot 
		u.stepWiseScreenshot("Type Full Name");
		
		//Type in the Rediffmail ID 
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).sendKeys("kaushikmukherjee2412");
		
		//StepWise Screenshot 
		u.stepWiseScreenshot("Type Rediffmail ID");
		
		//Click on check availability button - The below code is clicking on button but the text is not visible and so exception comin
		//driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[2]")).submit();
		//There is a class to simulate mouse movements and keystrokes
		//That class is called as ACTIONS class
		//Actions CLass doc --> https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/interactions/Actions.html
		//Need to use the build () and perform() method definately
		//When using Actions class do not tough the keypad or mose when script is running as it may destroy the simulation.
		//Actions class find the element by the middle mportion of it.
		Actions act = new Actions(driver);
		wb = driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[7]/td[3]/input[2]"));
		act.moveToElement(wb).click();
		act.build().perform();
		
		//StepWise Screenshot 
		u.stepWiseScreenshot("Text Appearing after button");
		
		
		//Wait until the text "Yippie! The ID you've chosen is available." is present
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#check_availability > font > b"), "Yippie! The ID you've chosen is available."));
	
		//To check if the text "Yippie! The ID you've chosen is available." is present . If not no further trnsaction
		String expectedText = "Yippie! The ID you've chosen is available.";
		String actualText = driver.findElement(By.xpath("//*[@id=\"check_availability\"]/font/b")).getText();
		if(actualText.equals(expectedText)) {
			//Type on Password
			driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[9]/td[3]/input")).click();
			driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[9]/td[3]/input")).sendKeys("test@1234");
		
			//StepWise Screenshot 
			u.stepWiseScreenshot("Type Password");
			
			//Type on Retype Password
			driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[11]/td[3]/input")).click();
			driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[11]/td[3]/input")).sendKeys("test@1234");
		
			//StepWise Screenshot 
			u.stepWiseScreenshot("Type Password Again");
			
			//To check if the check box for alternate Email ID is selected
			//isSelected method to check whetehr a radio button or checkbox is selected
			boolean sel = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[15]/td[2]/table/tbody/tr/td[1]/input")).isSelected();
			System.out.println("After Email ID checkbox is selected ? --> "+sel);
			
			//StepWise Screenshot 
			u.stepWiseScreenshot("Step - before Checkbox Clicked");
			
			//Now select the Checkbox
			driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[15]/td[2]/table/tbody/tr/td[1]/input")).click();
		
			//StepWise Screenshot 
			u.stepWiseScreenshot("Checkeckox chicked");
			
			//To check if the check box for alternate Email ID is selected
			boolean sel1 = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[15]/td[2]/table/tbody/tr/td[1]/input")).isSelected();
			System.out.println("After Email ID checkbox is selected ? --> "+sel1);
			
			//StepWise Screenshot 
			u.stepWiseScreenshot("Step - after Checkbox Clicked");
			
			//Drop option to be selected for "Select a security Question" created by SELECT tag
			wb = driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[2]/td[3]/select"));
			s = new Select(wb);
			s.selectByIndex(2);
			
			//StepWise Screenshot 
			u.stepWiseScreenshot("Secuity Question  - Drop down");
			
			//Type on ENTER AN ANSWER
			driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[4]/td[3]/input")).click();
			driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[4]/td[3]/input")).sendKeys("Music");
			
			//StepWise Screenshot 
			u.stepWiseScreenshot("Type Enter Answer to Security Question");
			
			//Type on Mother's Maiden name
			driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[6]/td[3]/input")).click();
			driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[6]/td[3]/input")).sendKeys("Music");
			
			//StepWise Screenshot 
			u.stepWiseScreenshot("Type Mother's name");
			
			//Select the option from ISD code drop down creatd by DIV tag
			//1. Click on the drop down to get the option
			driver.findElement(By.xpath("//*[@id=\"div_mob\"]/table/tbody/tr/td[3]/div[2]")).click();
			//2. The option of this drop down are created by UL - LI tag. GEt the options XPATH - USA
			driver.findElement(By.xpath("//*[@id=\"country_id\"]/ul/li[2]")).click();
			
			//StepWise Screenshot 
			u.stepWiseScreenshot("ISD Code  - Drop down");
			
			//Fill the edit box beside the ISD code drop down
			driver.findElement(By.xpath("//*[@id=\"mobno\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"mobno\"]")).sendKeys("12345");
			
			//StepWise Screenshot 
			u.stepWiseScreenshot("Type Phone Number");
			
			//Choose option from DAY drop down created by Select Tag
			wb = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[1]"));
			s = new Select(wb);
			s.selectByValue("04");
			
			//StepWise Screenshot 
			u.stepWiseScreenshot("Day  - Drop down");
			
			//Choose option from MONTH drop down created by Select Tag
			wb = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[2]"));
			s = new Select(wb);
			s.selectByVisibleText("FEB");
			
			//StepWise Screenshot 
			u.stepWiseScreenshot("Month  - Drop down");
			
			//Choose option from YEAR drop down created by Select Tag
			wb = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[3]"));
			s = new Select(wb);
			s.selectByIndex(6);
			
			//StepWise Screenshot 
			u.stepWiseScreenshot("Year  - Drop down");
			
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
			u.stepWiseScreenshot("Check Selected radio button - Male");
			
			//Select the FEMALE radio button
			driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[2]")).click();
			
			//StepWise Screenshot 
			u.stepWiseScreenshot("Radio button - Female Selected");

			
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
			u.stepWiseScreenshot("Check Selected radio button - Female");
			
			
			//Choose option from COUNTRY drop down created by Select Tag
			wb = driver.findElement(By.xpath("//*[@id=\"country\"]"));
			s = new Select(wb);
			s.selectByValue("99");
			
			//StepWise Screenshot 
			u.stepWiseScreenshot("Country  - Drop down");
			
			//Choose option from CITY drop down created by Select Tag
			wb = driver.findElement(By.xpath("//*[@id=\"div_city\"]/table/tbody/tr[1]/td[3]/select"));
			s = new Select(wb);
			s.selectByVisibleText("Bangalore");
			
			//StepWise Screenshot 
			u.stepWiseScreenshot("City  - Drop down");
			
		
		}
	
	
	}

}
