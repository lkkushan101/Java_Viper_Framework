package PageObjects_Mobile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.TouchAction;
public class MakePaymentScreen {
	 WebDriver driver;
     By inputTel  = By.id("com.experitest.ExperiBank:id/phoneTextField");
	 By inputName = By.id("com.experitest.ExperiBank:id/nameTextField");
	 By amountTracker = By.id("com.experitest.ExperiBank:id/amount");
     By inputCountry = By.id("com.experitest.ExperiBank:id/countryTextField");
     By sendPaymentButton = By.id("com.experitest.ExperiBank:id/sendPaymentButton");
    
     public MakePaymentScreen(WebDriver driver){

	        this.driver = driver;

	    }

     
    
	public void makePayment (String teleNo, String name, String country)
     {
    	  driver.findElement(inputTel).sendKeys(teleNo);
    	  driver.findElement(inputName).sendKeys(name);
    	  driver.findElement(inputCountry).sendKeys(country);
    	  driver.findElement(amountTracker).sendKeys("0.5");
    	  driver.findElement(sendPaymentButton).click();
     	 
        	
     }

}
