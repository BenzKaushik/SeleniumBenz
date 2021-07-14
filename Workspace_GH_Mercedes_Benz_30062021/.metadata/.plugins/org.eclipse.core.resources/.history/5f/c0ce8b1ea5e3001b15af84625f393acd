package allAnnotations;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Example {
	/* 1)Test annotation can be used more than once in a class file.
	 * 2) All other annotations can be used ONECE in a class file
	 * 3) Before Method annotation will run before the TEST annotation. If there are two test annotation 
	 * BeforeMethod will run twice, before each annotation.
	 * 3) After Method annotation will run after the TEST annotation. If there are two test annotation 
	 * AfterMethod will run twice, after each annotation.
	 * 4) Before Class annotation will run before the CLASS TAG of TESTNG.xml file or before the class file.
	 * 5) After Class annotation will run after the CLASS TAG of TESTNG.xml file or after the class file
	 * 6) Before Test will run before the TEST tag in TESTNG.xml file.
	 * 7) After Test will run after the TEST tag in TESTNG.xml file.
	 * 8) Before Suite will run before the SUITA tag of TESTNG.XML file.
	 * 9) After Suite will run after the SUITA tag of TESTNG.XML file.
	 * 
	 */
	
	/* Run Behaviour:
	 * 
	 * Before Suite - InitialiseObjectRepositoryRediffmail() - Initialise the object repository of Rediff mail application
	 * Before Test - isConnectDatabaseRediffmailApplication() - Connecting to database of Rediffmail application
	 * Before Class - OpenBrowser() - Open the chrome browser
	 * Before Method - NavigateLoginRediffmail() - Navigate to Rediffmail website and login to account
	 * Test P1- SendMailRediff() - Sending mail from Rediff mail account
	 * After Method - Logout() - Logout from account of Rediffmail application
	 * Before Method - NavigateLoginRediffmail() - Navigate to Rediffmail website and login to account
	 * Test P2 - SaveMailRediff() - Saving mail to Rediff mail account
	 * After Method - Logout() - Logout from account of Rediffmail application
	 * After Class - CloseBrowser()  - Close the browser
	 * After Test - DisConnectDatabaseRediffmailApplication() - Dis - Connecting from database of Rediffmail application
	 * After Suite - DeInitialiseObjectRepositoryRediffmail() - De - Initialise the object repository of Rediff mail application
	 */
	
  @Test (priority = 1)
  public void SendMailRediff() {
	  
	  System.out.println("Sending mail from Rediff mail account");
  }
  
  @Test (priority = 2)
  public void SaveMailRediff() {
	  
	  System.out.println("Saving mail to Rediff mail account");
  }
  
  @BeforeMethod
  public void NavigateLoginRediffmail() {
	  
	  System.out.println("Navigate to Rediffmail website and login to account");
  }

  @AfterMethod
  public void Logout() {
	  
	  System.out.println("Logout from account of Rediffmail application");
  }

  @BeforeClass
  public void OpenBrowser() {
	  System.out.println("Open the chrome browser");
  }

  @AfterClass
  public void CloseBrowser() {
	  System.out.println("Close the browser");
  }

  @BeforeTest
  public void ConnectDatabaseRediffmailApplication() {
	  
	 System.out.println("Connecting to database of Rediffmail application");
  }

  @AfterTest
  public void DisConnectDatabaseRediffmailApplication() {
	  
	  System.out.println("Dis - Connecting from database of Rediffmail application");
  }

  @BeforeSuite
  public void InitialiseObjectRepositoryRediffmail() {
	  System.out.println("Initialise the object repository of Rediff mail application");
  }

  @AfterSuite
  public void DeInitialiseObjectRepositoryRediffmail() {
	  System.out.println("De - Initialise the object repository of Rediff mail application");
  }

}
