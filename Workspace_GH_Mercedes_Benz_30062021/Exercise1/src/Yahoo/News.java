package Yahoo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class News extends BaseSettings{
	
	public static WebDriver driver;
	
	//WebDriverWait doc --> https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/WebDriverWait.html

	public static void main(String[] args) throws InterruptedException {


		//Functional Scenario --> To test the Yahoo page by clicking on the NEWS menu button. 
		
		/*Test case --> 
		 * 1. To check that the NEWS button present in Yahoo page is working fine where it opens up the NEWS page
		 * 
		 */
		/* Test Steps:
		 * 
		 * 1) Navigate to Yahoo page.
		 * 2) Verify that the title of the landing page is "Yahoo India | News, Finance, Cricket, Lifestyle and Entertainment".
		 * 3) Verify that the text "NEWS" is present in NEWS menu button.
		 * 4) Click on the NEWS menu button.
		 * 5) Verify the title in NEWS page is "Yahoo News India".
		 * 6) Verify that the text "News Home" is present in the NEWS HOME menu button
		 * 7) Close the browser
		 */
		
		driver = News.RunBrowser("Chrome");
		
		//Maximise the browser window
		driver.manage().window().maximize();

		
		//Navigate to the YAHOO website
		driver.get("https://in.yahoo.com/");
		
		//Define the page load timeout
		driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
		
		//Implicit wait - Dynamic wait ( can be applied for all elements in automation script)
		//Can be applied for all codes which uses the findElement() or findElements() method.
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		
		//Explicit wait - Dynamic Wait  and will use it for specific element
		//We open the NEW page on clicking the NEWS link n landing page
		//We will wait to check if the element NEW HOME is seen with the text NEW HOME
		WebDriverWait wait = new WebDriverWait(driver, 20L); //20 Second
		
		//Verify the title of the landing page
		String actialTitleLandingPage = driver.getTitle();
		String expectedTitleLandingPage = "Yahoo India | News, Finance, Cricket, Lifestyle and Entertainment";
		
		//Verify that the text "News" is present in NEWS menu button
		String actualTextNewsMenuButton = driver.findElement(By.linkText("News")).getText();
		String expectedTextNewsMenuButton = "News";
		
		if(expectedTitleLandingPage.equals(actialTitleLandingPage) && expectedTextNewsMenuButton.equals(actualTextNewsMenuButton)) {
			System.out.println("Vefication for the title and text in landing page successful");
			
			//Click on the news menu button
			driver.findElement(By.linkText("News")).click();
			
			//Static wait may be given when we navigate from one page to another
			//Not a good behavior to use Static wait
			/*Lets say the NEWS page open in 1000 milliseconds ( 1 second). The "main" Thread will 
			still wait for 2 second more thus talking computer resources. This is not good for the 
			memory management and other resources of the computer. So static wait is not good.
			
			And that is why we should use DYNAMIC wait given by WAIT interface of Selenium Webdriver*/
			//Thread.sleep(3000L);
			
			//Use Webdriver wait on the NEWS HOME ELEMENT with text NEWS HOME present in NEWS page
			//Wait for this element(NEWS HOME ELEMENT) until a condition is specified. Condition is defined by ExpectedConditions class
			//ExpectedConditions Class doc --> https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.linkText("News Home"), "News Home"));
			
			System.out.println("We are in News Link Page");
			
			
			//Verify the title of the NEWS page
			String actialTitleNewsPage = driver.getTitle();
			String expectedTitleNewsPage = "Yahoo News India";
			
			//Verify that the text NEWS HOME is present in NEWS HOME menu button
			String actualTextNewsHomeButton = driver.findElement(By.linkText("News Home")).getText();
			String expectedTextNewsHomeButton = "News Home";
			
			if(expectedTitleNewsPage.equals(actialTitleNewsPage) && expectedTextNewsHomeButton.equals(actualTextNewsHomeButton)) {
				System.out.println("Vefication for the title and text in News page successful");
			}else {
				System.out.println("Vefication for the title and text in News page is not successful");
			}
			
			
			
		}else {
			System.out.println("Vefication for the title and text in landing page is not successful");
		}
		
		//Close the browser
		driver.quit();
		
	}

}
