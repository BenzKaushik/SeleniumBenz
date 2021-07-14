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

public class SingleScript extends BaseSettings{

	public static  WebDriver driver;
	public static  WebDriverWait w;
	public static WebElement wb;
	public static Actions act;
	public static Point p;
	public static JavascriptExecutor j;
	
	//EDGE/FIREFOX/CHROME
	public static void main(String[] args) throws InterruptedException, IOException {
	    
		/*Rule : The RunBrowser function take the argument of the browser on which we need to run the 
		 * script.Thevcvalue are TE, Chrome, Firefox, Edge.
		 * 
		 * When we use the AutoItRunner() function, use the same browser name  in argument as used in 
		 * RunBrowser function
		 * 
		 * 
		 */
		
		
		driver = SingleScript.RunBrowser("Chrome");
		
		Utils u = new Utils(driver);
		
		//Navigate to upload.html
		driver.get("file:///"+System.getProperty("user.dir")+"/Upload.html");
		
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
		
		//Calling the AutoItRunner function
		SingleScript.AutoItRunner("Chrome");
		

	}
	
	public static void AutoItRunner(String BrowserName) {
		//Integrate the AutoIT script with Selenium
		//Running the executable process 
		try {
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\AutoITScript\\"+BrowserName+"Script.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
