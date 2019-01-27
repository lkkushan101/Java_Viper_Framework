package Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import io.appium.java_client.windows.WindowsDriver;
import org.testng.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects_Windows.*;
import Utility.*;

public class CalculatorClass {
	    private static WindowsDriver CalculatorSession = null;
	    private static WebElement CalculatorResult = null;
	  
	@BeforeClass
    public static void setup() {
        AppStart appStart = new AppStart();
        CalculatorSession =  appStart.windowsAppStart();
    }


    protected String _GetCalculatorResultText()
    {
        // trim extra text and whitespace off of the display value
        return CalculatorResult.getText().replace("Display is", "").trim();
    }
	
@Test
public void testCalc()
{
	  Calculator_Screen calcPage = new Calculator_Screen(CalculatorSession) ;
	  calcPage.clickButton("Two");
	  calcPage.clickButton("Plus");
	  calcPage.clickButton("Three");
	  calcPage.clickButton("Equals");
      AssertJUnit.assertEquals("Display is 5", calcPage. getContents().getText());
	
}
	
}
