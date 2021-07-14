package annotations;

import org.testng.annotations.Test;

public class PriorityTestAnnotation {
	
	//Login to Rediffmail - Test annotation
	//Write Email - Test annotation
	//Logout - Test annotation
	
	//Prioritize the test annotation method to run in the order in which we want.
	
	
	@Test(priority = 1)
	public void LoginRediffmail() {
		System.out.println("Login to Rediffmail application");
	}
	
	
	@Test(priority = 2)
	public void SendMail() {
		System.out.println("Sending mail after logging in");
	}
	
	@Test(priority = 3)
	public void Logout() {
		System.out.println("Logging out of Rediffmail application");
	}
	
	
}
