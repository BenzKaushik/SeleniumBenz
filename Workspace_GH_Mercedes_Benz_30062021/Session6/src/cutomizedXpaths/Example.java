package cutomizedXpaths;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Example extends BaseSettings{
	public static WebDriver driver;
	public static WebDriverWait w;

	public static void main(String[] args) {
		
		driver = Example.RunBrowser("Firefox");
	
		//Maximise the browser window
		driver.manage().window().maximize();
		
		//Navigate to the YAHOO website
		driver.get("https://www.google.com/");
		
		//StepWise Screenshot after navigation to googleto take the screenshot
		Example.stepWiseScreenshot("NavigateGoogle");
			
		//Define the page load timeout
		driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
			
		//Implicit wait - Dynamic wait 
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		//Explicit Wait 
		w = new WebDriverWait(driver, 30L);
		
		//Type on google edit box
		//Working
		//driver.findElement(By.xpath("//*[@class = 'gLFyf gsfi']")).sendKeys("Appium");
		//Working
		//driver.findElement(By.xpath("//input[@class = 'gLFyf gsfi']")).sendKeys("Appium");
		//Working
		//driver.findElement(By.xpath("//*[@name = 'q']")).sendKeys("Appium");
		//Working
		//driver.findElement(By.xpath("//input[@name = 'q']")).sendKeys("Appium");
		//Working
		//driver.findElement(By.xpath("//input[@title = 'Search']")).sendKeys("Appium");
		//Working
		//driver.findElement(By.xpath("//div[@class = 'a4bIc']/input[1]")).sendKeys("Appium");
		//Working
		//driver.findElement(By.xpath("//div[@jsname = 'gLFyf']/input[1]")).sendKeys("Appium");
		//Working
		//driver.findElement(By.xpath("//div[@class='SDkEP']/div[2]/input[1]")).sendKeys("Appium");
		//Working
		//driver.findElement(By.xpath("//div[@class = 'RNNXgb']/div/div[2]/input[1]")).sendKeys("Appium");
		//Working
		//driver.findElement(By.xpath("//div[@jsname = 'RNNXgb']/div/div[2]/input[1]")).sendKeys("Appium");
		//Working
		//driver.findElement(By.xpath("//div[@class = 'A8SBwf']/div[1]/div[1]/div[2]/input[1]")).sendKeys("Appium");
		//Working
		//driver.findElement(By.xpath("//div[@class = 'A8SBwf']/div[1]/div/div[2]/input[1]")).sendKeys("Appium");
		//Working
		//driver.findElement(By.xpath("//div[@jsmodel='vWNDde']/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys("Appium");
		//Working
		//driver.findElement(By.xpath("//form[@role = 'search']/div[1]/div[1]/div[1]/div/div[2]/input[1]")).sendKeys("Appium");
		//Working
		//driver.findElement(By.xpath("//div[@class = 'o3j99 ikrT4e om7nvf']/form[1]/div[1]/div[1]/div[1]/div/div[2]/input[1]")).sendKeys("Appium");
		//Working
		//driver.findElement(By.xpath(" //div[@class = 'L3eUgb']/div[3]/form[1]/div[1]/div[1]/div[1]/div/div[2]/input[1]")).sendKeys("Appium");
		//Not working in script but ranorex showing the element and highlighting it
		//driver.findElement(By.xpath("//body[@jsmodel = 'TvHxbe']/div[2]/div[3]/form[1]/div[1]/div[1]/div[1]/div/div[2]/input[1]")).sendKeys("Appium");
		//Not working in script but ranorex showing the element and highlighting it - customed full xpath
		//driver.findElement(By.xpath("/html/body[1]/div[2]/div[3]/form[1]/div[1]/div[1]/div[1]/div/div[2]/input[1]")).sendKeys("Appium");
		//Not working - full xpath from chrome.
		//driver.findElement(By.xpath("/html/body/div[2]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Appium");
		//Full xpath from Edge and working in CHrome.
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Appium");
		
		
	
		
		//Click on the Google Search button
		//Working - RANOREX SHOWING TwO ELEMENTS , but both elements are the same i.e the same element is highlighted.
		//driver.findElement(By.cssSelector("*[name = 'btnK']")).submit();
		//Working - RANOREX SHOWING TwO ELEMENTS , but both elements are the same i.e the same element is highlighted.
		//driver.findElement(By.cssSelector("input[name = 'btnK']")).submit();
		//Working - RANOREX SHOWING TwO ELEMENTS , but both elements are the same i.e the same element is highlighted.
		//driver.findElement(By.cssSelector("*[class = 'gNO89b']")).submit();
		//Working - RANOREX SHOWING TwO ELEMENTS , but both elements are the same i.e the same element is highlighted.
		//driver.findElement(By.cssSelector("input[class = 'gNO89b']")).submit();
		//Working - RANOREX SHOWING TwO ELEMENTS , but both elements are the same i.e the same element is highlighted.
		//driver.findElement(By.cssSelector("input.gNO89b")).submit();
		//Working - RANOREX SHOWING TwO ELEMENTS , but both elements are the same i.e the same element is highlighted.
		//driver.findElement(By.cssSelector("input[value = 'Google Search']")).submit();
		//Working - RANOREX SHOWING TwO ELEMENTS , but both elements are the same i.e the same element is highlighted.
		//driver.findElement(By.cssSelector("center input:nth-child(1)")).submit();
		//Working - RANOREX SHOWING TwO ELEMENTS , but both elements are the same i.e the same element is highlighted.
		//driver.findElement(By.cssSelector("center>input:nth-child(1)")).submit();
		//Working - RANOREX SHOWING TwO ELEMENTS , but both elements are the same i.e the same element is highlighted.
		//driver.findElement(By.cssSelector("center input.gNO89b")).submit();
		//Working - RANOREX SHOWING TwO ELEMENTS , but both elements are the same i.e the same element is highlighted
		//driver.findElement(By.cssSelector("center>input.gNO89b")).submit();
		//Working - RANOREX SHOWING TwO ELEMENTS , but both elements are the same i.e the same element is highlighted.
		//driver.findElement(By.cssSelector("center input[class = 'gNO89b']")).submit();
		//Working - RANOREX SHOWING TwO ELEMENTS , but both elements are the same i.e the same element is highlighted.
		//driver.findElement(By.cssSelector("center>input[class = 'gNO89b']")).submit();
		//Not Working - Compound class vales supported by Css Selector - With the below format , it shows NO SUCH ELEMENT EXCEPTION
		//driver.findElement(By.cssSelector("div.FPdoLc lJ9FBc>center:nth-child(1)>input:nth-child(1)")).submit();
		//Not Working - Compound class vales supported by Css Selector - With the below format , it shows NO SUCH ELEMENT EXCEPTION
		//driver.findElement(By.cssSelector("div.FPdoLc lJ9FBc center:nth-child(1) input:nth-child(1)")).submit();
		//Working - compound class value with the below format will work
		//driver.findElement(By.cssSelector("div[class = 'FPdoLc lJ9FBc']>center:nth-child(1)>input:nth-child(1)")).submit();
		//Working - compound class value with the below format will work
		//driver.findElement(By.cssSelector("div[class = 'FPdoLc lJ9FBc'] center:nth-child(1) input:nth-child(1)")).submit();
		//Working - compound class value with the below format will work where the first value in the compounded value is taken
		//driver.findElement(By.cssSelector("div.FPdoLc>center:nth-child(1)>input:nth-child(1)")).submit();
		//Working - compound class value with the below format will work where the second value in the compounded value is taken
		//driver.findElement(By.cssSelector("div.lJ9FBc>center:nth-child(1)>input:nth-child(1)")).submit();
		//Working
		//driver.findElement(By.cssSelector("div[class = 'A8SBwf']>div:nth-child(4)>center:nth-child(1)>input:nth-child(1)")).submit();
		//Working
		//driver.findElement(By.cssSelector("div[class = 'A8SBwf'] div:nth-child(4) center:nth-child(1) input:nth-child(1)")).submit();
		//Working
		//driver.findElement(By.cssSelector("div.A8SBwf>div:nth-child(4)>center:nth-child(1)>input:nth-child(1)")).submit();
		//Working
		//driver.findElement(By.cssSelector("div.A8SBwf div:nth-child(4) center:nth-child(1) input:nth-child(1)")).submit();
		//Working
		//driver.findElement(By.cssSelector("form[role = 'search']>div:nth-child(1)>div:nth-child(1)>div:nth-child(4)>center:nth-child(1)>input:nth-child(1)")).submit();
		//Not working - Ranorex selocity is showing single element but scipt shows NO SUCH ELEMENT exception
		//driver.findElement(By.cssSelector("div[class = 'o3j99 ikrT4e om7nvf']>form:nth-child(3)>div:nth-child(1)>div:nth-child(1)>div:nth-child(4)>center:nth-child(1)>input:nth-child(1)")).submit();
		//Not working - Ranorex selocity is showing single element but scipt shows NO SUCH ELEMENT exception
		//driver.findElement(By.cssSelector("div.o3j99>form:nth-child(3)>div:nth-child(1)>div:nth-child(1)>div:nth-child(4)>center:nth-child(1)>input:nth-child(1)")).submit();
		//Working - Created from inspect element used in browser opened by Selenium	 
		//driver.findElement(By.cssSelector("div.L3eUgb>div:nth-child(3)>form:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(3)>div:nth-child(3)>div:nth-child(7)>center:nth-child(2)>input:nth-child(1)")).submit();
		//Not Working - Created from inspect element used in desktop browser
		//driver.findElement(By.cssSelector("div.L3eUgb>div:nth-child(3)>form:nth-child(3)>div:nth-child(1)>div:nth-child(1)>div:nth-child(4)>center:nth-child(1)>input:nth-child(1)")).submit();
		//Working - Created from inspect element used in browser opened by Selenium	 
		driver.findElement(By.cssSelector("html>body:nth-child(2)>div:nth-child(2)>div:nth-child(3)>form:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(3)>div:nth-child(3)>div:nth-child(7)>center:nth-child(2)>input:nth-child(1)")).submit();
		
		
		
		
		
		
		
		
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//Close the browser
		//driver.quit();

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
