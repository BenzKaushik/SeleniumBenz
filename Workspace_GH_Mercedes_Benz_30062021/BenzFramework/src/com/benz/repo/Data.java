package com.benz.repo;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import com.benz.utilities.TestUtils;
import com.benz.utilities.Xls_Reader;

public class Data {
	
	static Xls_Reader xls = new Xls_Reader("C:\\Users\\lenovo\\Desktop\\GitRep\\Workspace_GH_Mercedes_Benz_30062021\\BenzFramework\\src\\com\\benz\\repo\\TestData.xlsx");
	

	//Running the test annotation method in parallel not through TESTNG.XML but through DATA PROVIDER
	//Both the hashtable will work in parallel using the PARALLEL parameter in DATAPROVIDER
	@DataProvider (name = "formData")
	public static Object[][] FillForm(){
//		
//		Object [][] obj  = new Object[2][1];
//		
//		//Data for the first run
//		Hashtable<String, String> tab1 = new Hashtable<String, String>();
//		tab1.put("Browser", "Chrome");
//		tab1.put("FName", "Kaushik Mukherjee");
//		tab1.put("RID", "kaushikmukherjee2412");
//		tab1.put("Pwd", "test@1234");
//		tab1.put("Rpwd", "test@1234");
//		tab1.put("SQues", "Music");
//		tab1.put("MName", "Sukla");
//		tab1.put("PNumber", "12345");
//		
//		//Data for the Second run
//		Hashtable<String, String> tab2 = new Hashtable<String, String>();
//		tab2.put("Browser", "Edge");
//		tab2.put("FName", "Sam Mendes");
//		tab2.put("RID", "SamMendes2412");
//		tab2.put("Pwd", "test@5678");
//		tab2.put("Rpwd", "test@5678");
//		tab2.put("SQues", "Reading");
//		tab2.put("MName", "Jenny");
//		tab2.put("PNumber", "45678");
//		
//		obj[0][0] = tab1;
//		obj[1][0] = tab2;
//		
//		
//		
//		return obj;
		
		return TestUtils.getData("FillingFormRediffmail", xls);
		
	}
	
	
	
	@DataProvider(name = "sendMailData")
	public static Object[][] SendingEmailRediffData(){
		
//		Object[][]obj = new Object[2][1];
//		
//		//Data for the first run
//		Hashtable<String, String> tab1 = new Hashtable<String, String>();
//		tab1.put("Browser", "Chrome");
//		tab1.put("UName", "selenium.testmay2017");
//		tab1.put("Pwd", "test@1234");
//		tab1.put("TField", "kaushik.aryaan@gmail.com");
//		tab1.put("SField", "Test Mail");
//		tab1.put("CField", "Test Mail Sent");
//		
//		
//		//Data for the first run
//		Hashtable<String, String> tab2 = new Hashtable<String, String>();
//		tab2.put("Browser", "Edge");
//		tab2.put("UName", "selenium.testmay2017");
//		tab2.put("Pwd", "test@1234");
//		tab2.put("TField", "arundhoti.mukherjee@gmail.com");
//		tab2.put("SField", "Development Mail");
//		tab2.put("CField", "Development Mail Sent");	
//		
//		obj[0][0] = tab1;
//		obj[1][0] = tab2;
//		
//		return obj;
		
		return TestUtils.getData("SendingEmailRediff", xls);
	}



}
