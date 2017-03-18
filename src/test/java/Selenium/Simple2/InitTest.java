package Selenium.Simple2;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.remote.*;
import org.openqa.*;

/**
 * Unit test for simple App.
 */
// public class AppTest extends TestCase {
public class InitTest {

	public static WebDriver driver;
	WebElement element;

	@Before
	public void setup() {
		
		System.out.println("--------- wewnatrz setup AT Before");

		//System.setProperty("webdriver.gecko.driver", "C:\\work\\geckodriver.exe");


		final FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("xpinstall.signatures.required", false);
		//firefoxProfile.setPreference("--log", "error");
		//firefoxProfile.setPreference("marionette.logging", false);
		
		
		// ----------
		LoggingPreferences pref = new LoggingPreferences();
	    pref.enable(LogType.BROWSER, Level.OFF);
	    pref.enable(LogType.CLIENT, Level.OFF);
	    pref.enable(LogType.DRIVER, Level.OFF);
	    pref.enable(LogType.PERFORMANCE, Level.OFF);
	    pref.enable(LogType.PROFILER, Level.OFF);
	    pref.enable(LogType.SERVER, Level.OFF);


	    DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
	    desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, pref);

	    
		// ----------
		
		driver = new FirefoxDriver(firefoxProfile);
		//driver = new FirefoxDriver();
		//driver = new FirefoxDriver(desiredCapabilities);
		// driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// driver.get("https://www.google.pl");
		//driver.get("http://www.store.demoqa.com");
		
	}
	
	public static WebDriver getDriver(){
		
		System.out.println("wewnatrz getDriver");
		
		//System.setProperty("webdriver.gecko.driver", "C:\\work\\geckodriver.exe");

		//final FirefoxProfile firefoxProfile = new FirefoxProfile();
		//firefoxProfile.setPreference("xpinstall.signatures.required", false);
		//driver = new FirefoxDriver(firefoxProfile);
		
		if(driver == null){
			System.out.println("wewnatrz getDriver - driver był null więc uruchamiam SETUP");
			final FirefoxProfile firefoxProfile = new FirefoxProfile();
			firefoxProfile.setPreference("xpinstall.signatures.required", false);
			driver = new FirefoxDriver(firefoxProfile);
			return driver;
		}else{
			System.out.println("wewnatrz getDriver - driver nie był null, jest stary więc zwracam");
			return driver;
		}
		
		
		
		//return driver;
	}

	/*
	 * @Test public void test(){ driver.get("https://www.google.pl"); }
	 */

	@After
	public void cleanUp() {
		System.out.println("wewnatrz AfterClass");
		
		if (driver != null) {
			System.out.println("wewnatrz AfterClass -- driver not null więc CLOSE QUIT");
			driver.close();
			driver.quit();
		}else
		{
			System.out.println("wewnatrz AfterClass -- driver null --BEZ CLOSE QUIT");
		}
	}

}

