/**
 * 
 */
package PageObjects;

import Base.BaseClass;

/**
 * @author Shrivatsa
 *
 */
public class BusPage extends BaseClass{
	
	public String getUrl() {
		
		String currenturl=getDriver().getCurrentUrl();
		
		
		return currenturl;
		
	}
}
	
	
