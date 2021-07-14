package rediffmailPac;

public class rough {

	public static void main(String[] args) {


		//C:\Users\lenovo\Desktop\Workspace_GH_Mercedes_Benz_30062021\ConverScriptIDE\chromedriver.exe
		
		String path = System.getProperty("user.dir");
		System.out.println(path);
		
		System.setProperty("webdriver.chrome.driver", path+"\\chromedriver.exe") ;

	}

}
