package Utilities;

import java.io.IOException;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	/*METHOD's Job - getInstanceSparkReporter()
	 * 1) This method will see if objects of ExtentSparkReporter class is created or not.
	 * 2) If the object of ExtentSparkReporter class is not created , create it.
	 * 3) The same object of ExtentSparkReporter class along with getInstanceSparkReporter()
	 *  method needs to be used in all class files defined in "TestCase" package.
	 * 4) This method also load the XML configuration file.
	 */
	
	
	
	/*METHOD's Job - getInstanceReporter()
	 * 1) This method will see if objects of ExtentReports class is created or not.
	 * 2) If the object of ExtentReports class is not created , create it.
	 * 3) The same object of ExtentReports class along with getInstanceReporter()
	 *  method needs to be used in all class files defined in "TestCase" package.
	 * 4) This method also attached the report crested by ExtentSparkReporter class
	 * 5) This method also attached the XML configuration file defined in 
	 * ExtentSparkReporter class's getInstanceReporter()method.
	 * 6) We can also create system information 
	 */
	
	
	/*ExtentSparkReporter class - A class inside the Extent reports API responsible for 
	defining the path and name of the report. Report will have an extension'of
	html. 
	
	This class can also also be used to set the theme of the report, placeholder
	for pie chart, define the title of the report, to define the name of the 
	report - comes from XML Configuration file*/
	
	
	/*ExtentReports - A class inside the Extent reports API responsible for creating the test case,
	creating logs, creating test category, defining system information for the report
	generated and for writing the report in the report generated*/
	
	//Global Variables
	private static ExtentSparkReporter  report;
	private static ExtentReports extent;
	
	
	
	//Method
	public static ExtentSparkReporter getInstanceSparkReporter()  {
		
		try {
			if(report == null) {
				//Will  create the report name by the date stamp - will use the Date class
				Date d = new Date();
				String dateStamp  = d.toString().replace(" ", "_").replace(":", "_");
				
				//Object of ExtentSparkReporter class is created if object is NULL
				report = new ExtentSparkReporter(System.getProperty("user.dir")+"\\ExtentReport\\RediffmailReport_"+dateStamp+".html");
			
				//Loading the configuration which is in XML file using loadXMLConfig of ExtentSparkReporter class
				report.loadXMLConfig(System.getProperty("user.dir")+"\\src\\Repo\\Report-config.xml");
			}				
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return report;
	}
	
	public static ExtentReports getInstanceReporter() {
		if(extent == null) {
			//Create the object of ExtentReports class if the object is NULL
			extent = new ExtentReports();
			
			//Attach the Extent report created in ExtentSparkReporter and also the configuration file i.e.XML
			//Use attachReporter() of ExtentReports class
			extent.attachReporter(report);
			
			//Assign the system information
			//Use setSystemInfo() method of ExtentReports class
			extent.setSystemInfo("OS", "Windows 8.1");
			extent.setSystemInfo("Testing Env", "Rediffmail SIT");
			extent.setSystemInfo("User", "Lenovo");
			extent.setSystemInfo("Author", "Kaushik");
			extent.setSystemInfo("Extent Report", "5.0.6");
			
		}
		
		return extent;
	}
	
	
	
}
