package TestBankPkg;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import Utility.JSONReader;
import Utility.DriverStart;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import PageObjects_Mobile.*;
public class OTPGet {
	
	DriverStart drv;
	WebDriver driver;

	@BeforeMethod
	@BeforeClass
	public void setUp() throws FileNotFoundException, IOException, ParseException{
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		drv = new DriverStart();
		driver = drv.drvStart();
	}

	@Test
	public void testBankLoginMakePayment() throws Exception {
		JSONReader _JSONRead = new JSONReader();
		OTPRead otpRead = new OTPRead(driver);
		otpRead.clickTopSMS();
		
       System.out.println(otpRead.getSMSOTPContent());
		 
	}

	@AfterClass
	public void teardown(){
		//close the app
		driver.quit();
	}
}
