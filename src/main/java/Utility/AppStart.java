package Utility;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.windows.WindowsDriver;

public class AppStart {
	 private static WindowsDriver appSession = null;

	 public WindowsDriver windowsAppStart ()
	 {
		 try {
	          DesiredCapabilities capabilities = new DesiredCapabilities();
	          JSONReader JSONRead = new JSONReader();
	          capabilities.setCapability("app", JSONRead.ReadJSONFile("app", ".\\Data\\wsWindows.json"));
	          appSession = new WindowsDriver(new URL(JSONRead.ReadJSONFile("url", ".\\Data\\wsWindows.json")), capabilities);
	          appSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	        
	         

	      }catch(Exception e){
	          e.printStackTrace();
	      } finally {
	      }
		  return appSession;
	 }

}
