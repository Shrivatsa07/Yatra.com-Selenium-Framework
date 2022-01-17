/**
 * 
 */
package PageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.Action;
import Base.BaseClass;

/**
 * @author shriv
 *
 */
public class PayMentPage extends BaseClass {
	Action act=new Action();
	
	@FindBy(xpath="//div[text()=' Book your Bus in 3 simple steps ']")
	WebElement bookYourbustxt;
	
	
	public PayMentPage() {
		
		PageFactory.initElements(getDriver(),this);
	}
	
	public boolean verifyPayNowBtn() {
		
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	//	JavascriptExecutor js=(JavascriptExecutor) getDriver();
		
	//	js.executeScript("arguments[0].scrollIntoView();", payNow_btn);
		
		return act.isDisplayed(getDriver(),bookYourbustxt);
	}

}
