package Group;

import org.testng.annotations.Test;

/*When we need to do grouping, ensure to run the class files from TESTNG SUITE level
by creating the textng.xml file.*/

//Usage of regular expression  - Where all Test cases run based on platform
//Run all test cases belonging to windows platform
public class Example2 {
	
	@Test(groups = {"windows.SmokeTest"})
	public void testMethod5(){
		
		System.out.println("Test Method 5");
	}
	
	@Test(groups = {"linux.SmokeTest"})
	public void testMethod6(){
		System.out.println("Test Method 6");
		
	}
	
	@Test(groups = {"windows.functionaltest"})
	public void testMethod7(){
		
		System.out.println("Test Method 7");
	}

}
