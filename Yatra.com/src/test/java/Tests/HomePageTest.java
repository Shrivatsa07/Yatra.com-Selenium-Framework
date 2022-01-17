/**
 * 
 */
package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObjects.BusPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.SearchResultPage;
import io.netty.util.AsciiString;

/**
 * @author Shrivatsa
 *
 */
public class HomePageTest extends BaseClass {
	
	HomePage homepage;
	BusPage buspage;
	SearchResultPage searchpage;
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
	public void ClickOnBusTest()   {
	String actual="";
	homepage=new HomePage();
		buspage=new BusPage();
	
	try {
		actual = homepage.ClickOnBus();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String expected=buspage.getUrl();
		Assert.assertEquals(expected,actual);	
	}
	
	
	
	
	@Test
	public void searchTest()  {
		homepage=new HomePage();
		
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
	
	@Test
	public void LoginTest()   {
		
	
		homepage=new HomePage();
		try {
			loginpage=homepage.clickOnLogin();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expected=loginpage.verifyLoginUrl();
		String actual="https://secure.yatra.com/social/common/yatra/register";
		
		
		Assert.assertEquals(actual, expected);
		
		
	}
	
	

}

