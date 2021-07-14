package ignoreAnnotation;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

//@Ignore
public class IgnoreTestAnnotation {
	
	//Login to Rediffmail - Test annotation
	//Write Email - Test annotation
	//Logout - Test annotation
	
	//@Ignoring annotation can be applied at class level and Test annotation method level
	//Ignoring annotation at class level > Ignoring annotation at Test annotation method level
	
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
		System.out.println("Sending mail after logging in");
		//Hard Assertions
		Assert.assertEquals(true, true);
		System.out.println("Line after 1st assertion - SendMail Test annotation method");
		//Messages are thrown when assertion fails
		Assert.assertEquals(true, true, "Actual is not equal to expected");
		System.out.println("Line after 2nd assertion - SendMail Test annotation method");
	}
	
	@Ignore
	@Test(priority = 3, dependsOnMethods = {"LoginRediffmail","SendMail"})
	public void Logout() {
		System.out.println("Logging out of Rediffmail application");
		//Soft Assertion
		sa = new SoftAssert();
		sa.assertEquals('a', 'a');
		System.out.println("Line after 1st assertion - Logout Test annotation method");
		sa.assertNotEquals(true, false, "Actual is equal to expected - Logout Test annotation method");
		System.out.println("Line after 2nd assertion - Logout Test annotation method");
		sa.assertAll();
	}
	
	
}
