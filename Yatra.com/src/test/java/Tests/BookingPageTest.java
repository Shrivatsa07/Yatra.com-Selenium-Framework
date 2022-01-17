/**
 * 
 */
package Tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObjects.BookingRiviewPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.PayMentPage;
import PageObjects.SearchResultPage;

/**
 * @author shriv
 *
 */
public class BookingPageTest extends BaseClass{
	SearchResultPage searchpage;
	
	BookingRiviewPage bookingpage;
	
	HomePage homepage;
	LoginPage login;
	PayMentPage paymentPage;
	
	
	
	@BeforeMethod()
	public void setup() {
		
		launchApp();
		
	}
	
	@AfterMethod()
		
		public void tearDown() {
			
		getDriver().quit();
	
		}
	
	
	
	
	@Test
	public void bookingTest() {
		
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
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		

		try {
			bookingpage=searchpage.bookBus();
			
	      
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		paymentPage=bookingpage.bookingReview();
		
		boolean flag=paymentPage.verifyPayNowBtn();
		Assert.assertTrue(flag);

	}
}


