/**
 * 
 */
package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.Action;
import Base.BaseClass;

/**
 * @author Shrivatsa
 *
 */
public class HomePage extends BaseClass{
	
	Action act=new Action();
	
	@FindBy(xpath="//*[@id='booking_engine_buses']")
	public WebElement buses;
	
	@FindBy(xpath="//input[@id='BE_bus_from_station']")
	public WebElement fromButton;
	
	@FindBy(id="BE_bus_to_station")
	public WebElement toButton;
	
	
//	@FindBy(id="BE_bus_depart_date")
//	WebElement departureButton;
	
	@FindBy(id="BE_bus_search_btn")
	public WebElement searchButton;
	
	
	@FindBy(xpath="//li[@id='userLoginBlock']")
	public WebElement myAccount;
	
	
	@FindBy(xpath="//*[@id='SignUpBtn']")
	WebElement signupbutton;
	
	@FindBy(xpath="//a[@title='Shrivatsa']")
	WebElement userNameDisplay;
	
	
	public HomePage() {
		
		PageFactory.initElements(getDriver(),this);
	}
//	
	
	//useraction Method
//	public String ClickOnBus() throws Exception {
//	
////		JavascriptExecutor executor =(JavascriptExecutor)getDriver();
////		executor.executeScript("arguments[0].click();", buses);
////		
////		
////		
//		act.click(getDriver(), buses);
//		
//		return getDriver().getCurrentUrl();
//		
//		
//	}
	
	@SuppressWarnings("deprecation")
	public SearchResultPage searchBus() throws Exception {
		
		act.click(getDriver(), buses);
			act.click(getDriver(), fromButton);
			
			act.type(fromButton,"Bengalore");
			
			getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			fromButton.sendKeys(Keys.ARROW_DOWN);
			fromButton.sendKeys(Keys.ENTER);

			
			//act.Click(getDriver(),toButton);
			
			Thread.sleep(2000);
			act.type(toButton,"Delhi");
			
			getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			toButton.sendKeys(Keys.ARROW_DOWN);
			toButton.sendKeys(Keys.ENTER);

			
			Thread.sleep(3000);
		//	act.Click(getDriver(), departureButton);
			act.Click(getDriver(),searchButton);
			
			
			return new SearchResultPage();
			
			
			
			
			
	}
	
	
	//login method
	
	public LoginPage clickOnLogin() throws InterruptedException {
		
		act.mouseOverElement(getDriver(), myAccount);
		act.implicitWait(getDriver(),5);
		Thread.sleep(4000);
		act.click(getDriver(),signupbutton);
		
		
		return new LoginPage();
		
	}
	
	public String geturl() {
		
		String HomePageurl= getDriver().getCurrentUrl();
		return HomePageurl;
	}

}
