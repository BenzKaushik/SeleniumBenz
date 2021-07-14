package annotations;

import org.testng.annotations.Test;

public class ExampleTestAnnotation {
	
	//Test Annotation - meant for creating test scripts
	//We can have "n" number of test annotation in a class file.
	//Every Test annotation will have a public non-static  void return type method
	//Test Annotation run alphabetically
	//TEst annotation is depicted by --> @Test
	
	@Test
	public void methodA() {
		System.out.println("Running test annotation method  - methodA");
	}
	
	
	@Test
	public void methodC() {
		System.out.println("Running test annotation method  - methodC");
	}
	
	@Test
	public void methodD() {
		System.out.println("Running test annotation method  - methodD");
	}
	
	@Test
	public void methodB() {
		System.out.println("Running test annotation method  - methodB");
	}
	

}
