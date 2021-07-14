package TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class MyListener extends AbstractWebDriverEventListener{
	
	public WebDriver driver;
	
	public void afterNavigateBack(WebDriver driver){
		
		this.driver = driver;
		//Print the title of rediffmail page
		String titleRediffPage = this.driver.getTitle();
		System.out.println("Listener - Title of the Rediff landing page after navigating forward is "+titleRediffPage);
			

	}
	
	public void beforeNavigateBack(WebDriver driver){
		
		this.driver = driver;
		//Print the title of rediffmail page
		String titleRediffmailPage = this.driver.getTitle();
		System.out.println("Listener - Title of the Rediffmail landing page after navigating forward is "+titleRediffmailPage);
		
	}
	
	
	public void beforeNavigateForward(WebDriver driver){
		
		this.driver = driver;
		//Print the title of rediffmail page
		String titleRediffPage = this.driver.getTitle();
		System.out.println("Listener - Title of the Rediff landing page after navigating forward is "+titleRediffPage);
			
	}
	
	public void afterNavigateForward(WebDriver driver){
		this.driver = driver;
		//Print the title of rediffmail page
		String titleRediffmailPage = this.driver.getTitle();
		System.out.println("Listener - Title of the Rediffmail landing page after navigating forward is "+titleRediffmailPage);
				
	}

}
