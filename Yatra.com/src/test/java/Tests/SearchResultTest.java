/**
 * 
 */
package Tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObjects.BookingRiviewPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.SearchResultPage;

/**
 * @author shriv
 *
 */
public class SearchResultTest extends BaseClass {
	
	SearchResultPage searchpage;
	
	BookingRiviewPage bookingpage;
	
	HomePage homepage;
	LoginPage login;
	
	@BeforeMethod()
	public void setup() {
		
		launchApp();
		
	}
	
	@AfterMethod()
		
		public void tearDown() {
			
		getDriver().quit();
		
		
		}
	
	@Test
	
	public void SearchBusTest()  {
		
		homepage=new HomePage();
		try {
			login=homepage.clickOnLogin();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//login=new LoginPage();
		try {
			homepage=login.Login(prop.getProperty("username"),prop.getProperty("password"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			searchpage=homepage.searchBus();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
	//	Thread.sleep(2000);
		
		try {
			bookingpage=searchpage.bookBus();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag=bookingpage.verifyText();
		Assert.assertTrue(flag);
	}


}
