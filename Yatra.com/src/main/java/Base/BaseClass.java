/**
 * 
 */
package Base;

/**
 * @author shriv
 *
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;



import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Shrivatsa
 *
 */
public class BaseClass {
	
	
	
	public static Properties prop;
	//public static WebDriver driver;
	ActionDriver.Action act=new ActionDriver.Action();
	
	public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<RemoteWebDriver>();
	
	
	@BeforeSuite
  public void beforeSuite() {
		
		DOMConfigurator.configure("log4j.xml");
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	@BeforeTest()
	public void loadConfig() throws FileNotFoundException {
		
		prop=new Properties();
		System.out.println("super constructor invoked");
		
		FileInputStream ip=new FileInputStream(("S:\\eclipse\\CucumberFramework\\Yatra.com\\Configuration\\Config.properties"));
		
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	public void launchApp() {
		
		WebDriverManager.chromedriver().setup();
		
		String BrowserName=prop.getProperty("browser");
	
	if(BrowserName.contains("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver());
		//driver=new ChromeDriver();
	}
		
		
		
		act.implicitWait(getDriver(),10);
		
		
		
		getDriver().get(prop.getProperty("url"));
		
		getDriver().manage().window().maximize();
		}

}
