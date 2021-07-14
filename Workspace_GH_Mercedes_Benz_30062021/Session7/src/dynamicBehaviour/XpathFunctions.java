package dynamicBehaviour;

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



public class XpathFunctions extends BaseSettings{
	public static WebDriver driver;
	public static WebDriverWait w;

	public static void main(String[] args) {
		
		driver = XpathFunctions.RunBrowser("Firefox");
	
		//Maximise the browser window
		driver.manage().window().maximize();
		
		//Navigate to the YAHOO website
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		//StepWise Screenshot after navigation to googleto take the screenshot
		XpathFunctions.stepWiseScreenshot("NavigateGoogle");
			
		//Define the page load timeout
		driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
			
		//Implicit wait - Dynamic wait 
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		//Explicit Wait 
		w = new WebDriverWait(driver, 30L);
		
		//Wait until the FULL NAME text is present
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[1]"), "Full Name"));
		
		//Type on the FULL NAME field
		//Shows no such element exception
		//From Browser in desktop
		//driver.findElement(By.xpath("//input[name = 'name2539f692']")).click();//name8f25c854,namebed98831
		//driver.findElement(By.xpath("//input[name = 'name2539f692']")).sendKeys("Kaushik Mukherjee");
		//From Browser opened by Selenium
		//driver.findElement(By.xpath("//input[name = 'name739069a7']")).click();
		//driver.findElement(By.xpath("//input[name = 'name739069a7']")).sendKeys("Kaushik Mukherjee");
		//A scenario where the name attribute value is continuously changing; this can happen with ID attribute
		//When we refresh the app, the name or ID attribute can change.
		/*NOTE: If the name attribute or the ID attribute has number (at beginning, in middle or at the end),
		be careful.ID or name attribute value will change at runtime and will show NO SUCH ELEMENT EXCEPTION.*/
		//Handle this scenario either with functions of XPATh or regular expression of Css Selector
		
		//Function of xpath to handle dynamic value of ID attribute or name attribute- Typing on Full Name edit box
		driver.findElement(By.xpath("//input[starts-with(@name, 'name')]")).click();
		driver.findElement(By.xpath("//input[starts-with(@name, 'name')]")).sendKeys("Kaushik Mukherjee");
		
		//Function of xpath to handle dynamic value of ID attribute or name attribute - typing on rediffmail ID edit box
		//driver.findElement(By.xpath("//input[@name = 'logina9260a89']")).click(); //login5918e16d - runtime
		//driver.findElement(By.xpath("//input[@name = 'logina9260a89']")).sendKeys("test.benz2412");
		driver.findElement(By.xpath("//input[contains(@name, 'login')]")).click();
		driver.findElement(By.xpath("//input[contains(@name, 'login')]")).sendKeys("test.benz2412");
		
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
