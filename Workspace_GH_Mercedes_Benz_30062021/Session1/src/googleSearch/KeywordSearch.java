package googleSearch;




import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeywordSearch extends  BaseSettings{
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		//Call the function of Basettings class which is now inherited in KeywordSearch class
		driver = KeywordSearch.RunBrowser("Edge");

		//Create an environment variable to tell system the location of chromedriver.exe
		//Use chromedriver.exe to find the executable of CHrome browser and invoke the Chrome browser
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\Workspace_GH_Mercedes_Benz_30062021\\Session1\\chromedriver.exe");
		
		//Create and object of ChromeDriver class
		//The Chromedriver class controls the Chrome browser
		/* Controlling the Chrome browser --> find elements (control/UI) of a web 
		 * application opened in chrome browser and performing action on the element
		 */
		//Performing action on the element --> Typing. clicking on element, choosing options
		// driver  = new ChromeDriver();
		//driver = new ChromeDriver();
		
		
		
		
		//Chrome opens in Minimize state i..e the browser window is in minimize state.
		/*Not good for a browser window to be in minimize state ad elements/control/UI may get hidden.
		 * If elements get hidden due to minimize state of the browser windows, Selenium script 
		 * may not be able to find the element and may throw NO SUCH ELEMENT EXCEPTION.
		 * 
		 * So Browser windows need to be in MAXIMIZE statre
		 * 
		 */
		//Point p = driver.manage().window().getPosition();
		//int xcoords = p.x;//Will give the X co-ordinate of windows
		//int ycoords = p.y;//Will give the Y co-ordinate of windows
		//System.out.println("X Coordinate: "+xcoords+"---- X Coordinate: "+ycoords);
		//driver.manage().window().fullscreen(); //Without menu buttons of browser
		//Dimension class as arguent of setSize() method
		//driver.manage().window().setSize(new Dimension(1322, 720)); //1322 - width, 720 - height
		//Point class as argument of setPosition() method
		//driver.manage().window().setPosition(new Point(200, 40)); //200 - x co-ordnate and 40 is y coordinate
		driver.manage().window().maximize();//With menu buttons of browser
	
	
		//Navigate to Google Website - get() and navigate()
		/*get() methods waits for the whole page to load in browser and then it allows to go to the next 
		line of the script. navigate( method does not wait for the whole page to load in browser*/
		//get() method cannot go to the history of browser which a navigate() method can.
		driver.get("https://www.google.com/");
		//driver.navigate().to("https://www.google.com/");
		
		//Verify that we are in Google Website by the TITLE of the landing page
		String expectedTitleLandingPage = "Google";
		String actualTitleLandingPage = driver.getTitle();
		
		//Verify that Google IMage has an attribute src whose value is "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png"  = 
		String expectedAttributeValueSrc = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png";
		String actualAttributeValueSrc = driver.findElement(By.className("lnXdpd")).getAttribute("src");
		
		if(actualTitleLandingPage.equals(expectedTitleLandingPage) && actualAttributeValueSrc.equals(expectedAttributeValueSrc)) {
			System.out.println("Title verification and attribute value of the \"src\" attribute has passed for the landing page");
			
			//Click on the Google Edit box
			driver.findElement(By.name("q")).click();
			
			//Type on the edit box
			driver.findElement(By.name("q")).sendKeys("Selenium Grid");
			
			//Click() method - when button is not a child or grand child of FORM HTML TAG
			//Submit() method - when button is a child or grand child of FORM HTML TAG
			//Click on Google Search button
			driver.findElement(By.name("btnK")).submit();
		}else {
			System.out.println("Title verification and attribute value of the \"src\" attribute has failed for the landing page");
		}
		
		//Close the browser
		driver.close();
		
	
	}

}
