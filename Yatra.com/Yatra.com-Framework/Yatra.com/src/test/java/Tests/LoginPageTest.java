/**
 * 
 */
package Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import junit.framework.Assert;
import utilities.Log;

/**
 * @author Shrivatsa
 *
 */
public class LoginPageTest extends BaseClass{
	HomePage homepage;
	LoginPage loginpage;
	
	@BeforeMethod()
	public void setup() {
		
		launchApp();
		
	}
	
	@AfterMethod()
		
		public void tearDown() {
			
		getDriver().quit();
		
		
		}

	
	@Test
	public void LoginTest() throws InterruptedException {
		
		Log.startTestCase("LoginTest");
		homepage=new HomePage();
		
		Log.info("User is going to click on Signup button");
		loginpage=homepage.clickOnLogin();
		
		Log.info("entering username and password");
		homepage=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		String actualurl=homepage.geturl();
		System.out.println(actualurl);
		String expected="https://www.yatra.com/";
		
		Assert.assertEquals(expected, actualurl);
		
		Log.info("Success");
		Log.endTestCase("Login test");
	}

}
