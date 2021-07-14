package BrowserOptions;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

//Selenium 3.141.59
public class FirefoxProfilingAndOptions {

	// set binary
	// notifications
	// maximize the browsers
	// certificate errors
	// work with proxy
	// page load stratergy
	
	
	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\geckodriver.exe");
		
		//LogFile of Firefox
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "firefox.log");
		
		FirefoxOptions options  = new FirefoxOptions();
		
		//Page Load Strategy
		//options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		//Set binary needs to be used when the firefox is installed not in default location
		//Default Location is C:\\Program Files\\Mozilla Firefox\\firefox.exe"
		//GEcko always tries to find Firefox.exe in default location
		//If firefox is not installed in default location then the setBinary() method needs to be used.
		//options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		
		//ProfileIni class is used to set Firefox profile and to get firefox profile
		//When we want to see or create profile  the firefocx browser should be closed
		//Command to open Firefox Profile Manager . Open run by right clicking on windows button > --> firefox.exe -P
		ProfilesIni allProf = new ProfilesIni(); // all the profiles
		//Opeining Firefox with KAUSHIK profile
		FirefoxProfile prof = allProf.getProfile("Kaushik");
		
		
		
		// notification
		prof.setPreference("dom.webnotifications.enabled", false);
		
		//accept or reject SSL certificates
		prof.setAcceptUntrustedCertificates(true);
		
		//Assumption of Untrusted Certificates Issuer
		prof.setAssumeUntrustedCertificateIssuer(false);
		
		// proxy Settings - if we use this will not go to internet
		//prof.setPreference("network.proxy.type", 1);
		//prof.setPreference("network.proxy.socks", "83.778.87.11");
		//prof.setPreference("network.proxy.socks_port", 1827);
		
		//USe the setPRofile method of FirefoxOptins class
		options.setProfile(prof);
		
		
		FirefoxDriver fd = new FirefoxDriver(options); // new profile
		//fd.get("http://pushengage.com/demo");
		fd.get("https://expired.badssl.com/");
		
	}
}
