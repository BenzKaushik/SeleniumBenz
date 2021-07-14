package repo;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;

public class Data {
	
	//Data Provider for FillingFormRediffmail  Test annotation method present in formRediffmail class file
	//Convert the dataprovider method to static
	@DataProvider (name = "formData")
	public static Object[][] FillForm(){
		//Object is a super class in java.
		//All array can take on homogeneous data. For example a String array can take on String data
		//Since object is a super class in Java , it can take homogeneous as well as heterogeneous data
		//Like all arrays the size of an object array needs to be fixed.
		
		
		/*1) For the above test script there are eight points of parameterization , So the 
		 * COLUMN SIZE of the array is 8.
		 * 2) We want to run the test script two times; once with Chrome and the other time with EDGE.
		 * So the ROW SIZE of the object array should be 2
		 * 
		 * 
		 */
		
		//This data provider has to be connected with the test script i.e. test annotation
		
		//Object [][] obj  = new Object[2][8];
		
		//Define the data for the first run to happen in CHROME browser
		/*
		 * obj[0][0] = "Chrome";//Browser Name obj[0][1] = "Kaushik Mukherjee";//Full
		 * Name obj[0][2] = "kaushikmukherjee2412";//RediffMail ID obj[0][3] =
		 * "test@1234";//Password obj[0][4] = "test@1234";//Retype Password obj[0][5] =
		 * "Music"; //Enter the answer for Security Question obj[0][6] = "Sukla";
		 * //Mother's maiden name obj[0][7] = "12345";//Phone number beside ISD code
		 * drop Down
		 * 
		 * //Define the data for the second run to happen in EDGE browser obj[1][0] =
		 * "Edge";//Browser Name obj[1][1] = "Sam Mendes";//Full Name obj[1][2] =
		 * "SamMendes2412";//RediffMail ID obj[1][3] = "test@5678";//Password obj[1][4]
		 * = "test@5678";//Retype Password obj[1][5] = "Reading"; //Enter the answer for
		 * Security Question obj[1][6] = "Jenny"; //Mother's maiden name obj[1][7] =
		 * "45678";//Phone number beside ISD code drop Down
		 */		
		
		/*Since there are 8 data for parameterization, we are passing eight parameters in Test 
		 * annotation method.
		 * 
		 * So to reduce the number of  parameters in Test annotation method; we use the 
		 * HashTable class which implements the MAP interface
		 * 
		 * Since we want to run two times the test script , there has to be two HashTable class.
		 * Note: Hashtable takes KEY VALUE pair, KEy has to be unique and VALUE can be duplicated. KEy
		 * has to be in string format and the VALUE can be in any format
		 * 
		 * For hashtable concept "KEYS" name in all hashtable has to be same.
		 * 
		 * Note: Also the number of rows size will be variable . Column size is fixed at one
		 * 
		 */
		
		Object [][] obj  = new Object[2][1];
		
		//Data for the first run
		Hashtable<String, String> tab1 = new Hashtable<String, String>();
		tab1.put("Browser", "Chrome");
		tab1.put("FName", "Kaushik Mukherjee");
		tab1.put("RID", "kaushikmukherjee2412");
		tab1.put("Pwd", "test@1234");
		tab1.put("Rpwd", "test@1234");
		tab1.put("SQues", "Music");
		tab1.put("MName", "Sukla");
		tab1.put("PNumber", "12345");
		
		//Data for the Second run
		Hashtable<String, String> tab2 = new Hashtable<String, String>();
		tab2.put("Browser", "Edge");
		tab2.put("FName", "Sam Mendes");
		tab2.put("RID", "SamMendes2412");
		tab2.put("Pwd", "test@5678");
		tab2.put("Rpwd", "test@5678");
		tab2.put("SQues", "Reading");
		tab2.put("MName", "Jenny");
		tab2.put("PNumber", "45678");
		
		obj[0][0] = tab1;
		obj[1][0] = tab2;
		
		
		
		return obj;
	}
	
	
	//Data Provider for SendingEmailRediff  Test annotation method present in SendingMailRediff class file
	//Convert the dataprovider method to static
	//Give the name parameter
	@DataProvider(name = "sendMailData")
	public static Object[][] SendingEmailRediffData(){
		
		Object[][]obj = new Object[2][1];
		
		//Data for the first run
		Hashtable<String, String> tab1 = new Hashtable<String, String>();
		tab1.put("Browser", "Chrome");
		tab1.put("UName", "selenium.testmay2017");
		tab1.put("Pwd", "test@1234");
		tab1.put("TField", "kaushik.aryaan@gmail.com");
		tab1.put("SField", "Test Mail");
		tab1.put("CField", "Test Mail Sent");
		
		
		//Data for the first run
		Hashtable<String, String> tab2 = new Hashtable<String, String>();
		tab2.put("Browser", "Edge");
		tab2.put("UName", "selenium.testmay2017");
		tab2.put("Pwd", "test@1234");
		tab2.put("TField", "arundhoti.mukherjee@gmail.com");
		tab2.put("SField", "Development Mail");
		tab2.put("CField", "Development Mail Sent");	
		
		obj[0][0] = tab1;
		obj[1][0] = tab2;
		
		return obj;
	}



}
