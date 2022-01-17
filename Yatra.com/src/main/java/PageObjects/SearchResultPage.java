/**
 * 
 */
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ActionDriver.Action;
import Base.BaseClass;

/**
 * @author shriv
 *
// */
public class SearchResultPage extends BaseClass {
	HomePage homepage;
	LoginPage login;
	SearchResultPage searchpage;
	
	Action act=new Action();
	
	
	@FindBy(xpath="//*[@class='btn-red mr0 v-btn theme--light']")
	WebElement searchBusButton;
	
	
	@FindBy(xpath="//option[@value='brdingSelect']/ancestor::select")
	WebElement selectOnboarding;
	
	@FindBy(xpath="//li[@snum='A']/child::i")
	WebElement seat;
	
	@FindBy(xpath="//option[@value='dropingSelect']/ancestor::select")
	WebElement selectDropping;
	
	
	@FindBy(xpath="//div[text()='Confirm Seats']")
	WebElement confirmSeat;
	
	
	
 public SearchResultPage() {
	// TODO Auto-generated constructor stub
 
		
		PageFactory.initElements(getDriver(),this);
	}
	
	
	public String getUrl() {
		
		return getDriver().getCurrentUrl();
	}
	
	
	public BookingRiviewPage bookBus() {
		
		//login=homepage.clickOnLogin();
		
		//homepage=login.Login(prop.getProperty("username"),prop.getProperty("password"));
		
		
		
		//homepage.searchBus();
		
		
		//searchpage=homepage.searchBus();
		
		
		try {
			act.JSClick(getDriver(),searchBusButton);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//searchBusButton.click();
		
		act.implicitWait(getDriver(), 5);
		
		try {
			act.JSClick(getDriver(),seat);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		act.implicitWait(getDriver(),5);

		
		Select select=new Select(selectOnboarding);
		select.selectByIndex(2);
		
	//	act.click(getDriver(),selectOnboarding);
		
		act.implicitWait(getDriver(),5);

		
		Select select1=new Select(selectDropping);
		select1.selectByIndex(1);
		
		
		act.implicitWait(getDriver(),5);
		
		
		act.click(getDriver(),confirmSeat );
		
		
		
		return new BookingRiviewPage();
		
	  	
	}
}

