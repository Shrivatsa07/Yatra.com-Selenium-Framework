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

//	@Test
//	public void ClickOnBusTest() throws Exception {
//	
//	homepage=new HomePage();
//		buspage=new BusPage();
//	String actual=homepage.ClickOnBus();
//	String expected=buspage.getUrl();
//		Assert.assertEquals(expected,actual);	
//	}
	
	
	
	
	@Test
	public void searchTest() throws Exception {
		homepage=new HomePage();
		
		//SearchResultPage searchreslt=new SearchResultPage();
		 searchpage=homepage.searchBus();
		//Assert.assertEquals(searchpage, new SearchResultPage() );
		
	}
	
	@Test
	public void LoginTest() throws InterruptedException {
		
	//	String expected=loginpage.Url();
		homepage=new HomePage();
		loginpage=homepage.clickOnLogin();
		String expected=loginpage.verifyLoginUrl();
		String actual="https://secure.yatra.com/social/common/yatra/register";
		
		
		Assert.assertEquals(actual, expected);
		
		
	}
	
	

}
