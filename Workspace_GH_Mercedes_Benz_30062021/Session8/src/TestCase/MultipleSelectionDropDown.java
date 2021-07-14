package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseSettings;
import Utilities.Utils;

public class MultipleSelectionDropDown extends BaseSettings {
	public static  WebDriver driver;
	public static  WebDriverWait w;

	public static void main(String[] args) throws InterruptedException {
		
		driver = MultipleSelectionDropDown.RunBrowser("Chrome");
		
		Utils u = new Utils(driver);
		
		//Maximise the browser window
		driver.manage().window().maximize();
		
		//Navigate to the BBC website
		driver.get("https://semantic-ui.com/modules/dropdown.html#/definition");
		
		
		//Define the page load timeout
		driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
			
		//Implicit wait - Dynamic wait 
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		//Drop down with Multiple Selections - SKILLS
		//The below script is showing NO SUCH ELEMENT EXCEPTION as the element is not in the browser window
		//driver.findElement(By.xpath("//*[@id=\"example\"]/div[5]/div/div[2]/div[4]/div[1]/div[8]/div")).click();
		//First let us make the element visible by scrolling vertically
		//For scrolling we do not have any method in Selenium
		//But Selenium provides an interface called s JavascriptExecutor which helps in executing Javascript codes
		//Javascript is a powerful language and with this we can control browser.
		//1. Let us get the X and Y coordinate of the /Drop down with Multiple Selections - SKILLS --> use the getLocation() method
		//XPATH from Browser opened by Selenium
		Point p = driver.findElement(By.xpath("//*[@id=\"example\"]/div[4]/div/div[2]/div[4]/div[1]/div[8]/div")).getLocation();
		//Point class has two field --> X field and Y field which will give X and Y coordinate of the above address 
		int xCoords = p.x; //292
		int yCoords = p.y;//1570
		System.out.println("X Coordinate: "+xCoords+"--"+"Y Coordinate: "+yCoords);
		//2. USe the JavascriptExecutor to scroll vertically
		JavascriptExecutor j = (JavascriptExecutor)driver;
		//executeScript () method  - to execute javascript codes which are normal
		//executeAsyncScript () method  - to execute javascript codes in AJAX components
		j.executeScript("window.scrollTo(0, 1570);", "");
		//After scrolling to Multiple Selections - SKILLS, clikc on it
		driver.findElement(By.xpath("//*[@id=\"example\"]/div[4]/div/div[2]/div[4]/div[1]/div[8]/div")).click();
		
		//Choose Angular and css from Multi Selection drop down -SKILLS
		//Selecting Angular
		driver.findElement(By.xpath("//*[@id=\"example\"]/div[4]/div/div[2]/div[4]/div[1]/div[8]/div/div[2]/div[1]")).click();
		//Selecting CSS
		driver.findElement(By.xpath("//*[@id=\"example\"]/div[4]/div/div[2]/div[4]/div[1]/div[8]/div/div[2]/div[2]")).click();//
		
		Thread.sleep(3000L);
		
		//De-select Angular from Multi Selection drop down -SKILLS
		driver.findElement(By.xpath("//*[@id=\"example\"]/div[4]/div/div[2]/div[4]/div[1]/div[8]/div/a[1]/i")).click();
	
	
		//De-select CSS from Multi Selection drop down -SKILLS
		//The below does not work as the positon of CSS option changes after Angular option is de-selectd
		//driver.findElement(By.xpath("//*[@id=\"example\"]/div[4]/div/div[2]/div[4]/div[1]/div[8]/div/a[2]/i")).click();
		driver.findElement(By.xpath("//*[@id=\"example\"]/div[4]/div/div[2]/div[4]/div[1]/div[8]/div/a/i")).click();
			
	
	
	}

}
