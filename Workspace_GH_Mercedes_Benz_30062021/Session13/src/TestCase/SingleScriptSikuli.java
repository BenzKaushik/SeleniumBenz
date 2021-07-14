package TestCase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import Base.BaseSettings;
import Utilities.Utils;

public class SingleScriptSikuli extends BaseSettings{

	public static  WebDriver driver;
	public static  WebDriverWait w;
	public static WebElement wb;
	public static Actions act;
	public static Point p;
	public static JavascriptExecutor j;
	public static Pattern p1;
	public static Screen scr;
	
	
	public static void main(String[] args) throws InterruptedException, IOException, FindFailed {
	    
		
		
		//EDGE/FIREFOX/CHROME
		driver = SingleScriptSikuli.RunBrowser("Edge");
		
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
		
		//Class to keep the image - File Name Edit box
		p1 = new Pattern(System.getProperty("user.dir")+"\\SikuliImages\\file.png");
		//Screen class to perform action on the images
		scr = new Screen();
		scr.type(p1, "C:\\Users\\lenovo\\Desktop\\AutiIT_Screenshots.docx");
		
		Thread.sleep(3000L);
		
		//Class to keep the image - Open button
		p1 = new Pattern(System.getProperty("user.dir")+"\\SikuliImages\\open.png");
		//Screen class to perform action on the images
		scr = new Screen();
		scr.click(p1);
				
	}
	
	

}
