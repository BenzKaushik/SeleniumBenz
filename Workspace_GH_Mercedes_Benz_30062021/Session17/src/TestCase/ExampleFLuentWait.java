package TestCase;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import Base.BaseSettings;
import Utilities.Utils;

public class ExampleFLuentWait extends BaseSettings{
	
	public static  WebDriver driver;
	public static  WebDriverWait w;
	public static WebElement wb;
	public static Actions act;
	public static Point p;
	public static JavascriptExecutor j;
	public static Pattern p1;
	public static Screen scr;
	public static Wait<WebDriver> wait;
	

	public static void main(String[] args) throws InterruptedException {

		driver = ExampleFLuentWait.RunBrowser("Chrome");
		
		Utils u = new Utils(driver);
		
		//Navigate to Yatra Website
		driver.get("https://www.yatra.com/");
		
		//Define the page load timeout
		driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
					
		//Implicit wait - Dynamic wait 
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		//Fluent Wait
		wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20L))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
			      
		
		//Handle cookie pop is present
		u.IsPopUpHTMLPresent("//*[@id='themeSnipe']/div/div/div[1]/button");
		//--> //button[@text() = 'Ok,I Agree']
		
		//Click on ONE WAY link
		driver.findElement(By.xpath("//*[@id=\"BE_flight_form_wrapper\"]/div[1]/div[1]/ul[1]/li[1]/a")).click();

		//Click on DEPART FROM Edit Box - Bangalore
		driver.findElement(By.xpath("//*[@id=\"BE_flight_origin_city\"]")).click();
		
		//Wait Explicitly For text - Select Departure City
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"booking_engine_modues\"]/div/div[2]/div/p"), "Select Depart City"));
		
		//Type on DEPART FROM edit box
		//driver.findElement(By.xpath("//*[@id=\"BE_flight_origin_city\"]")).sendKeys("Bang");
		
		//Working on Auto-Suggest to choose Bangalore from Drop Down
		String part1 = "//*[@id='BE_flight_form_wrapper']/div[1]/div[2]/ul/li[1]/ul/li[1]/div/div/ul/div/div/div/li[";
		String part2 = "]/div[1]/p[1]";
		int x = 1;
		while(u.isElementPresent(part1+x+part2)) {
			//Expected TExt
			String expectedText = "Bangalore";
			//Actual Text
			String actualText = driver.findElement(By.xpath(part1+x+part2)).getText();
			System.out.println(actualText);
			if(actualText.contains(expectedText)){
				driver.findElement(By.xpath(part1+x+part2)).click();
			}
			
			x = x+1;
		}
		
		Thread.sleep(5000L);
		
		//Click on GOING TO Edit Box - New Delhi
        //driver.findElement(By.xpath("//*[@id='BE_flight_arrival_city']")).click();
		
		//Wait Explicitly For text - Select Arrival City
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"booking_engine_modues\"]/div/div[2]/div/p"), "Select Arrival City"));
		
		
		//Type on DEPART FROM edit box
		//driver.findElement(By.xpath("//*[@id=\"BE_flight_origin_city\"]")).sendKeys("Del");
		
		//Working on Auto-Suggest to choose New Delhi from Drop Down
		String part3 = "//*[@id='BE_flight_form_wrapper']/div[1]/div[2]/ul/li[1]/ul/li[3]/div/div/ul/div/div/div/li[";
		String part4 = "]/div[1]/p[1]";
		int y = 1;
		while(u.isElementPresent(part3+x+part4)) {
			//Expected TExt
			String expectedText = "New Delhi";
			//Actual Text
			String actualText = driver.findElement(By.xpath(part3+y+part4)).getText();
			System.out.println(actualText);
			if(actualText.contains(expectedText)){
				driver.findElement(By.xpath(part3+y+part4)).click();
			}
			
			y = y+1;
		}
		
		//Click on DEPARTURE DATE edit box
		driver.findElement(By.xpath("//*[@id=\"BE_flight_origin_date\"]")).click();
		
		//Wait for the text 13 to be present and enabled
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"13/07/2021\"]"), "13"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"13/07/2021\"]")));
		
		//Choose 13 by clicking 13 July
		driver.findElement(By.xpath("//*[@id=\"13/07/2021\"]")).click();
		
		//Click on Drop Down for travellers
		driver.findElement(By.xpath("//*[@id=\"BE_flight_paxInfoBox\"]/i")).click();
		
		//Wait for the text  - Adult
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"adultPax\"]"), "Adult"));
		
		//Click on the PLUS SIGN of Adult to increase the passerger from 1 to 2
		driver.findElement(By.xpath("//*[@id=\"BE_flight_passengerBox\"]/div[1]/div[1]/div/div/span[2]")).click();
	
		//Wait for the number to be 2 - validation
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"BE_flight_passengerBox\"]/div[1]/div[1]/span/span[1]"), "2"));
		
		//Wait for the text PREMIUM ECONOMY to be present
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"flight_class_select_child\"]/ul/li[2]/span"), "Premium Economy"));
		
		//Click on PRemium Economy radio button
		driver.findElement(By.xpath("//*[@id=\"flight_class_select_child\"]/ul/li[2]")).click();
		
		//Click on Search Flight button
		driver.findElement(By.xpath("//*[@id=\"BE_flight_flsearch_btn\"]")).click();
		
		driver.quit();
	
	}

}
