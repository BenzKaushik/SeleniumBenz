package rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class example {

	public static void main(String[] args) {

		try {
			Properties p = new Properties();
			//Get the data from browser .properties file
			//Stream the data from the location in BYTE format
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\rough\\browser.properties");
			//Load the inputstream using the load method of Properties class
			p.load(fis);
			
			//Read the value of the Keys
			String browserName = p.getProperty("browser2");
			System.out.println(browserName);
			
			//Write down to properties file - need to write down in Browser.properties file
			//Stream the data in the location in BYTE format
			FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"\\src\\rough\\browser.properties");
			//Set the KEy value pairs
			p.setProperty("browser3", "IE");
			//Store it in same location where the earlier comments is replace by these below comment
			p.store(fos, "Storing third Key");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
