package PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	@FindBy(xpath="//*[@type='text' and @name='bus_leaving']")
	public WebElement fromButton;
	
	@FindBy(xpath="//*[@type='text' and @name='bus_dest']")
	public WebElement toButton;
	
	
//	@FindBy(id="BE_bus_depart_date")
//	WebElement departureButton;
	
	@FindBy(id="BE_bus_search_btn")
	public WebElement searchButton;
	
	
	@FindBy(xpath="//li[@id='userLoginBlock']")
	public WebElement myAccount;
	
	
	@FindBy(xpath="//*[@id='SignUpBtn']")
	WebElement signupbutton;
	
	
	@FindBy(xpath="//ul/div/div/div/li/span[contains(text(),'P')]")
	WebElement pune;
	
	@FindBy(xpath="//ul/div/div/div/li/span[contains(text(),'D')]")
	WebElement delhi;
	
	
	
	
	
	public HomePage() {
		
		PageFactory.initElements(getDriver(),this);
	}
//	
	
	//useraction Method
	public String ClickOnBus() throws Exception {
	

		act.click(getDriver(), buses);
		
		return getDriver().getCurrentUrl();	
	}
	
	//SearchBus Mehthod
	
	@SuppressWarnings("deprecation")
	public SearchResultPage searchBus() throws Exception {
		
		act.click(getDriver(), buses);
		
			act.click(getDriver(), fromButton);
			
			act.click(getDriver(),pune);
						
			getDriver().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			
			act.click(getDriver(), delhi);
		
			getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
			act.click(getDriver(),searchButton);
			
			Thread.sleep(2000);
			
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
