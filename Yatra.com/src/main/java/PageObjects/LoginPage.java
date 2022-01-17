package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.Action;
import Base.BaseClass;

/**
 * @author Shrivatsa
 *
 */
public class LoginPage extends BaseClass{
	HomePage home;
	
	Action act=new Action();
	
	@FindBy(xpath="//*[@id='sub-title']")
	WebElement message;
	
	@FindBy(id="login-input")
	WebElement email;
	
	@FindBy(id="login-password")
	WebElement passwordbox;
	
	
	@FindBy(id="login-submit-btn")
	WebElement loginButton;
	
	
	@FindBy(id="login-continue-btn")
	WebElement continuebtn;
	
	public LoginPage() {
		
		PageFactory.initElements(getDriver(), this);
	
	}
	
	public HomePage Login(String userName,String password) throws InterruptedException {
		
		
		
		
		act.type(email,userName);
		
		act.click(getDriver(), continuebtn);
		act.type(passwordbox,password);
		act.click(getDriver(),loginButton);
		Thread.sleep(2000);
		return new HomePage();
		
	}
	
	
	public String  verifyLoginUrl() {
		
		return getDriver().getCurrentUrl();
		
	}
	
	
	

}
