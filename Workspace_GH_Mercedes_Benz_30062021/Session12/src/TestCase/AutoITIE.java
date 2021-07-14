package TestCase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseSettings;
import Utilities.Utils;

public class AutoITIE extends BaseSettings{
	public static  WebDriver driver;
	public static  WebDriverWait w;
	public static WebElement wb;
	public static Actions act;
	public static Point p;
	public static JavascriptExecutor j;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		driver = AutoITIE.RunBrowser("IE");
		
		Utils u = new Utils(driver);
		
		//Navigate to upload.html
		driver.get("file:///C:/Users/lenovo/Desktop/Upload.html");
		
		//Click on the Choose File button
		//The below code shows exception --> org.openqa.selenium.InvalidArgumentException: invalid argument
		//driver.findElement(By.cssSelector("#fileToUpload")).submit();
		//USe the Actions class
		
		  act = new Actions(driver); 
		  wb = driver.findElement(By.xpath("//*[@id='fileToUpload']"));
		  act.moveToElement(wb).click(); 
		  act.build().perform();
		 
		
		//To sychronize the window opening on clicking CHHOOSE FILE button in the chrome browser
		Thread.sleep(3000L);
		
		
		//Integrate the AutoIT script with Selenium
		//Running the executable process 
		Runtime.getRuntime().exec("C:\\Users\\lenovo\\Desktop\\GH_Mercedes benz\\AutoITScript\\IEScript.exe");

		// TODO Auto-generated method stub

	}

}
