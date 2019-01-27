package Utility;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import ReadExcel.ExcelRead;

public class BrowserStart {
	  String gridIP;
	   ExcelRead excel = new ExcelRead();
	
	   public WebDriver startGridChormeHeadless(WebDriver driver) throws IOException {
		   gridIP = excel.readExcel(1,6, ".\\Data\\data.xlsx","Sheet1");
		 	ChromeOptions options = new ChromeOptions();
		    options.addArguments("--headless");
		    driver = new RemoteWebDriver(new URL(gridIP), options);
		    return driver;
	}
	   
    public WebDriver startGridChorme(WebDriver driver) throws IOException {
		   gridIP = excel.readExcel(1,6, ".\\Data\\data.xlsx","Sheet1");
		 	ChromeOptions options = new ChromeOptions();
		    driver = new RemoteWebDriver(new URL(gridIP), options);
		    return driver;
	}
	   
	   public WebDriver startChrome(WebDriver driver) throws IOException {
		 
		   WebDriverManager.chromedriver().setup();
	
		   driver = new ChromeDriver();
		   return driver;
	}
	   
	   public WebDriver startChromeHeadless(WebDriver driver) throws IOException {
		   ChromeOptions options = new ChromeOptions();
		   options.addArguments("--headless");
		   WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver(options);
		   return driver;
	}
	 public WebDriver startFireFoxHeadless(WebDriver driver) throws IOException {
		   FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			WebDriverManager.firefoxdriver().setup();
			driver  = new FirefoxDriver(options);
		   return driver;
	}
	 
	 public WebDriver startGridFireFoxHeadless(WebDriver driver) throws IOException {
		   FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			driver = new RemoteWebDriver(new URL(gridIP), options);
		    return driver;
	}
	 public WebDriver startGridFireFox(WebDriver driver) throws IOException {
		   FirefoxOptions options = new FirefoxOptions();
			driver = new RemoteWebDriver(new URL(gridIP), options);
		    return driver;
	}
   	
	 public WebDriver startFireFox(WebDriver driver) throws IOException {
		    FirefoxOptions options = new FirefoxOptions();
		    WebDriverManager.firefoxdriver().setup();
		    driver  = new FirefoxDriver(options);
		    return driver;
	}
}
