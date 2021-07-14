package allAnnotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SaveMail {
	
	 @Test 
	  public void SaveMailRediff() {
		  
		  System.out.println("Saving mail to Rediff mail account");
	  }
	 

	  @BeforeMethod
	  public void NavigateLoginRediffmail() {
		  
		  System.out.println("Navigate to Rediffmail website and login to account -Save Mail");
	  }

	  @AfterMethod
	  public void Logout() {
		  
		  System.out.println("Logout from account of Rediffmail application-Save Mail");
	  }
	  
	  @BeforeClass
	  public void OpenBrowser() {
		  System.out.println("Open the chrome browser-Save Mail");
	  }

	  @AfterClass
	  public void CloseBrowser() {
		  System.out.println("Close the browser-Save Mail");
	  }
	  
	  @BeforeTest
	  public void ConnectDatabaseRediffmailApplication() {
		  
		 System.out.println("Connecting to database of Rediffmail application -Save Mail");
	  }

	  @AfterTest
	  public void DisConnectDatabaseRediffmailApplication() {
		  
		  System.out.println("Dis - Connecting from database of Rediffmail application-Save Mail");
	  }
	  
	  @BeforeSuite
	  public void InitialiseObjectRepositoryRediffmail() {
		  System.out.println("Initialise the object repository of Rediff mail application");
	  }

}
