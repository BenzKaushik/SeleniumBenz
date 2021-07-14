package phantomJS;

import java.io.File;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ExamplePhantomJS {
	
	public static WebDriver driver;

	public static void main(String[] args) {


		//CReate an object of File class in order to define the path of PHANTOM JS executable
		File f = new File("C:\\Program Files\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		
		String filePath = f.getAbsolutePath();
		System.out.println(filePath);
		
		//Create the environment variable for phantomjs.exe driver
		System.setProperty("phantomjs.binary.path", f.getAbsolutePath());
		
		//Desired capability is used to do setting for browser
		//USed Desired capability to set the logging level to OFF.
		DesiredCapabilities dcap = new DesiredCapabilities();
		String[] phantomArgs = new  String[] {"--webdriver-loglevel=NONE"};
		dcap.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
		
		//CReate an object of Phantomjs class
		driver = new PhantomJSDriver(dcap);
		
		//driver = new PhantomJSDriver();
		
		
		
		//Maximize the browser window
		driver.manage().window().maximize();
		
		//NAvigate to BBC website
		driver.get("https://www.bbc.com/");
		
		//Title of the landing page
		String titleLandingPage = driver.getTitle();
		System.out.println("Title of the landing page is "+titleLandingPage);
		
		//Get the text of China won't be bullied
		String text = driver.findElement(By.xpath("//*[@id='page']/section[3]/div/ul/li[1]/div/div[2]/h3/a")).getText();
		System.out.println("Text of the link is "+text);
		
		
		//Click on the news link - China won't be bullied
		driver.findElement(By.linkText("China won't be bullied, says Xi on 100th anniversary")).click();

		//Get the title of link page
		String titleLinkPage = driver.getTitle();
		System.out.println("Title of the Link page is "+titleLinkPage);
		
		//Close the browser
		driver.quit();
						

	}

}
