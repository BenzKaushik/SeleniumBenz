package annotations;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class AnotherSKIPTechniqueTestAnnotation {
	
	//Login to Rediffmail - Test annotation
	//Write Email - Test annotation
	//Logout - Test annotation
	
	//Prioritize the test annotation method to run in the order in which we want.
	
	
	/*IF LoginRediffmail() fails because of Assertion error, how can SendMail()() pass. Strictly we cannot
	Send mail if login fails.
	
	1) The Logout() test annotation method is failing due to assertion error. BUt LOGOUT is inside the 
	inbox page of Rediffmail  and if login is failure, how can we send mail pass and how can 
	logout happen. 
	
	Thats means Logout() test annotation method and Sendmail() test annotation method depends on 
	LoginRediffmail() Test annotation method.We need to create this dependency.
	
	* IF LoginRediffmail() Test annotation method fails, Logout() test annotation method and Sendmail() 
	* test annotation method should SKIP.
	*/
	
	
	//HIERARCY: FAILURE>SKIP>PASS
	
	
	/*
	 * 1) SKIP  - If a dependency is there between test annotation methods, the dependent 
	 * test annotation methods will skip
	 * 
	 * 2) SKIP a test annotation method with SKIP EXCEPTION CLASS
	 */
	
	public Assertion a;
	public SoftAssert sa;
	
	
	@Test(priority = 1)
	public void LoginRediffmail() {
		System.out.println("Login to Rediffmail application");
		//Hard Assertion
		a = new Assertion();
		//Assert b = new Assert();
		a.assertEquals(true, true);
		System.out.println("Line after 1st assertion");
		a.assertEquals(2, 2);
		System.out.println("Line after 2nd assertion");
		//If the assertion fails, then only MESSAGE is thrown out
		a.assertEquals(true, true, "Expectation and actual did not match");
		System.out.println("Line after 3rd assertion");
		//assertFalse means , the expectations are false
		a.assertFalse(false);
		System.out.println("Line after 4th assertion");
		a.assertFalse(false, "Boolean results not matching");
		System.out.println("Line after 5th assertion");
		a.assertNotEquals(4, 5);
		System.out.println("Line after 6th assertion");
		a.assertNotEquals("Hi", "hi", "Actual is equal to expected");
		System.out.println("Line after 7th assertion");
		//assertTruemeans , the expectations are true
		a.assertTrue(true);
		System.out.println("Line after 8th assertion");
		//Messages are thrown when assertion fails
		a.assertTrue(true, "Actual is not equal to expected");
		System.out.println("Line after 9th assertion");
		
		
	}
	
	
	@Test(priority = 2, dependsOnMethods = {"LoginRediffmail"})
	public void SendMail() {
		//When we use a THROW clause , it should be the last line of code
		//throw new SkipException("Skipping the SendMail test annotation");
		
		  System.out.println("Sending mail after logging in"); 
		  //Hard Assertions
		  Assert.assertEquals(true, true); 
		  System.out.println("Line after 1st assertion - SendMail Test annotation method");
		  //Messages are thrown when assertion fails 
		  Assert.assertEquals(true, true,"Actual is not equal to expected"); 
		  System.out.println("Line after 2nd assertion - SendMail Test annotation method");
		 
		
		//When we use a THROW clause , it should be the last line of code
		throw new SkipException("Skipping the SendMail test annotation");
	}
	
	@Test(priority = 3, dependsOnMethods = {"LoginRediffmail","SendMail"})
	public void Logout() {
		System.out.println("Logging out of Rediffmail application");
		//Soft Assertion
		sa = new SoftAssert();
		sa.assertEquals('a', 'a');
		System.out.println("Line after 1st assertion - Logout Test annotation method");
		sa.assertNotEquals(true, false, "Actual is equal to expected - Logout Test annotation method");
		System.out.println("Line after 2nd assertion - Logout Test annotation method");
		/* 1) When we do not use the assertAll() method as the last line of code, assertion will fail at line 87
		 * but the test annotation method Logout() will show as pass. The line below the line where assertion
		 * has failed will be COMPILED.
		 * 
		 * 2) When we do use the assertAll() method as the last line of code, assertion will fail at line 87
		 * but the test annotation method Logout() will show as fail. The line below the line where assertion
		 * has failed will be COMPILED.
		 * 
		 */
		sa.assertAll();
	}
	
	
}
