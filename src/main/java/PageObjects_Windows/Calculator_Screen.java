package PageObjects_Windows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import io.appium.java_client.windows.WindowsDriver;
import org.testng.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Calculator_Screen {

	      WindowsDriver driver;

	      private static WebElement CalculatorResult = null;

		    public Calculator_Screen(WindowsDriver driver){

		        this.driver = driver;

		    }

		  	    

		    //ClickButton

		    public void clickButton(String buttonCaption){

		         driver.findElementByName(buttonCaption).click();

		    }

		    

		    //Click on login button

		    public WebElement getContents(){

		    	return CalculatorResult = driver.findElementByAccessibilityId("CalculatorResults");

		    }

		    


}
