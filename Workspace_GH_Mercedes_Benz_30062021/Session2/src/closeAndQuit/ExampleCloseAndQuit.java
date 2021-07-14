package closeAndQuit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExampleCloseAndQuit extends BaseSettings{
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver =  ExampleCloseAndQuit.RunBrowser("Chrome");
		
		//Maximize the browser window
		driver.manage().window().maximize();
		
		//Navigate to Google News
		driver.get("https://news.google.com/");
		
		//Page Load Timeout
		//By default the time to load a web page is infinite in Selenium Webdriver
		//Implement a time period to load the web page in browser. So we use page  load timeout
		//If the page does not load in the time specified, it will show TIMEOUT EXCEPTION
		driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
		
		//Click on first news
		driver.findElement(By.xpath("//*[@id='yDmH0d']/c-wiz/div/div[2]/div[2]/div/main/c-wiz/div[1]/div[3]/div/div/article/a")).click();

		//Static wait
		Thread.sleep(3000L);
		
		//Close the browser - close the current window, the window on which it had focus i.e. for this instance the landing page
		//driver.close();
		
		//Close the browser and kill the object of Chromedriver class  - close all browser windows associated with the application
		driver.quit();
	}

}
