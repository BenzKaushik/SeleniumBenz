package Group;

import org.testng.annotations.Test;

//Note --> When running group based test cases , run it as TestNG Suite.
/*Note - exclusion has a higher hierarchy than inclusion.That means 
test cases which are belonging to the multiple group and a particular
group is excluded, that test case will not run.*/
//We need to include the groups tag in testng.xml file between the TEST tag and CLASSES tag

public class Example1 {
	
	 @Test(groups = {"functest", "SmokeTest", "Regression" })
	 public void testMethod1(){
		 System.out.println("Test Method 1");
	 }
	 
	  @Test(groups = {"functest", "SmokeTest"} )
	  public void testMethod2() {
		  System.out.println("Test Method 2");
	  }
	 
	  @Test(groups = {"Regression" })
	  public void testMethod3() {
		  System.out.println("Test Method 3");
	  }
	  
	  @Test(groups = {"functest", "Regression" })
	  public void testMethod4() {
		  System.out.println("Test Method 4");
	  }



}
