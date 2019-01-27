package PageObjects_Mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OTPRead {
	 WebDriver driver;

	    By topSMS = By.id("com.android.dialer:id/subject");

	    By contentSMS = By.id("com.android.mms:id/text_view");

	   
	    public OTPRead(WebDriver driver){

	        this.driver = driver;

	    }

	    public void clickTopSMS(){

	        driver.findElement(topSMS).click();

	    }
	    public String getSMSOTPContent(){

	       return driver.findElement(contentSMS).getText();

	    }

}
