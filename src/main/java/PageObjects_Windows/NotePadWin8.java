package PageObjects_Windows;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriver;

import io.appium.java_client.windows.WindowsDriver;

public class NotePadWin8 {
	  WiniumDriver driver;
	  
	  private static WebElement CalculatorResult = null;

	    public NotePadWin8(WiniumDriver driver_w){

	        this.driver = driver_w;

	    }
	    
	    public void typeText(String text){

	    	 driver.findElementByClassName("Edit").sendKeys(text);

	    }
}
