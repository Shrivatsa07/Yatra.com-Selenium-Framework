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
import PageObjects.SearchResultPage;
import junit.framework.Assert;
import utilities.Log;

/**
 * @author Shrivatsa
 *
 */
public class LoginPageTest extends BaseClass{
	HomePage homepage;
	LoginPage loginpage;
	SearchResultPage searchpage=new SearchResultPage();
	
	@BeforeMethod()
	public void setup() {
		
		launchApp();
		
	}
	
	@AfterMethod()
		
		public void tearDown() {
			
		getDriver().quit();
		
		
		}

	
	@Test
	public void LoginTest(){
		
		Log.startTestCase("LoginTest");
		homepage=new HomePage();
		
		Log.info("User is going to click on Signup button");
		try {
			loginpage=homepage.clickOnLogin();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Log.info("entering username and password");
		try {
			homepage=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actualurl=homepage.geturl();
		System.out.println(actualurl);
		String expected="https://www.yatra.com/";
		
		Assert.assertEquals(expected, actualurl);
		
		Log.info("Success");
		Log.endTestCase("Login test");
		
		
	
	
	
	//public void searchTest() throws Exception {
	//	homepage=new HomePage();
		
		//SearchResultPage searchreslt=new SearchResultPage();
		 try {
			searchpage=homepage.searchBus();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 String expectedurl="https://ebus.yatra.com/busview/busdesktop/search";
		 String actual=searchpage.getUrl();
		 Assert.assertEquals(actual, expectedurl);
		 
		 
		//Assert.assertEquals(searchpage, new SearchResultPage() );
		
	}
	}


