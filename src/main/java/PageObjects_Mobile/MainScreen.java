package PageObjects_Mobile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainScreen {
	    WebDriver driver;

	    By makePaymentBtn  = By.id("com.experitest.ExperiBank:id/makePaymentButton");
	    public MainScreen(WebDriver driver){

	        this.driver = driver;

	    }

	    public void clickPaymentButton(){

	        driver.findElement(makePaymentBtn).click();

	    }


}
