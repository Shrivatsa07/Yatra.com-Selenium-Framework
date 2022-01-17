/**
 * 
 */
package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ActionDriver.Action;
import Base.BaseClass;

/**
 * @author shriv
 *
 */
public class BookingRiviewPage extends BaseClass {
	
	Action act=new Action();
	
	@FindBy(xpath="//i[@class='fi-review']")
	WebElement bookingreviewtxt;
	
	
	@FindBy(xpath="//select[@class='gender-wdth']")
	WebElement genderSelect;
	
	@FindBy(xpath="//select[@class='age-width']")
	WebElement ageSelect;
	
	@FindBy(xpath="//div[text()='Proceed To Payment']/ancestor::button")
	WebElement proceedtobtn;
	
	@FindBy(xpath="//input[@placeholder='Traveller Name']")
	WebElement travellernm;
	
	
	
	public BookingRiviewPage() {
		
		PageFactory.initElements(getDriver(),this);
	}
	
	public boolean verifyText() {
		
		return act.isDisplayed(getDriver(),bookingreviewtxt);
	}
	
	
	public PayMentPage bookingReview() {
		
		act.type(travellernm, prop.getProperty("TravellerName"));
		
		Select select=new Select(genderSelect);
		
		act.implicitWait(getDriver(), 5);
		
		select.selectByValue("Male");
		
		act.implicitWait(getDriver(), 5);
		
		Select select1=new Select(ageSelect);
		
		act.implicitWait(getDriver(), 5);
		
		select1.selectByValue("23");
		
		act.implicitWait(getDriver(), 5);
		
		
		act.click(getDriver(), proceedtobtn);
		
		
		
		
		act.implicitWait(getDriver(),15);
		
		
		
		return new PayMentPage();
		
		
		
		
		
		
	}
	
	

}
