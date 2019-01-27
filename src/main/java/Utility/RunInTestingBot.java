package Utility;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class RunInTestingBot {
	  
 public WebDriver runInTestingBot(String testName) throws FileNotFoundException, IOException, ParseException
 {
	 JSONReader readJSON = new JSONReader();
	 String KEY = readJSON.ReadJSONFile("KEY", ".\\Data\\TestingBotConfigure.json");
	 String SECRET = readJSON.ReadJSONFile("SECRET", ".\\Data\\TestingBotConfigure.json");
	 String URL = "http://" + KEY + ":" + SECRET + "@hub.testingbot.com/wd/hub";

	 
	    DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", readJSON.ReadJSONFile("browserName", ".\\Data\\TestingBotConfigure.json"));
		caps.setCapability("version", readJSON.ReadJSONFile("version", ".\\Data\\TestingBotConfigure.json"));
		caps.setCapability("platform", readJSON.ReadJSONFile("platform", ".\\Data\\TestingBotConfigure.json"));
		caps.setCapability("name", testName);

	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    return driver;
 }
}
