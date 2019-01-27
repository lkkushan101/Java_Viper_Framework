package Utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverStart {
 public WebDriver drvStart() throws FileNotFoundException, IOException, ParseException
 {
	 WebDriver driver;
	 JSONReader JSONRead = new JSONReader();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", JSONRead.ReadJSONFile("BROWSER_NAME", ".\\Data\\wsDataMobile.json"));

		capabilities.setCapability("deviceName",JSONRead.ReadJSONFile("deviceName", ".\\Data\\wsDataMobile.json"));
		capabilities.setCapability("platformName",JSONRead.ReadJSONFile("platformName", ".\\Data\\wsDataMobile.json"));
		capabilities.setCapability("appPackage", JSONRead.ReadJSONFile("appPackage", ".\\Data\\wsDataMobile.json"));
		capabilities.setCapability("appActivity", JSONRead.ReadJSONFile("appActivity", ".\\Data\\wsDataMobile.json"));
	   
	    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	    return driver;
 }
}
