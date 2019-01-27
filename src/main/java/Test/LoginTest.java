package Test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.speech.AudioException;
import javax.speech.EngineException;
import javax.speech.EngineStateError;
import javax.speech.synthesis.Synthesizer;
import io.github.bonigarcia.wdm.WebDriverManager;
import ExtentReport.ExtentReport;
import PageFactory.*;
import ReadExcel.ExcelRead;
import Utility.BrowserStart;
import Utility.SpeachReporting;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import org.apache.log4j.Logger;

public class LoginTest {
  WebDriver driver;
  Synthesizer syn; 
   @Test
   public void testLogin() throws IOException, EngineException, AudioException, EngineStateError, IllegalArgumentException, InterruptedException {
	  

	    Login objLogin;

	    HomePage objHomePage;
	
	    ExtentReport extRpt = new ExtentReport();
	    ExcelRead excel = new ExcelRead();
	    SpeachReporting speachRpt = new SpeachReporting();
	    syn = speachRpt.setupSpeachReporting();
	    Logger log = Logger.getLogger("devpinoyLogger");
	   
	    BrowserStart bwStart = new BrowserStart();
	    String browserMode = excel.readExcel(1,4, ".\\Data\\data.xlsx","Sheet1");
	    if (browserMode.equals("Chrome-Headless"))
	    {
	    	String gridStatus = excel.readExcel(1,5, ".\\Data\\data.xlsx","Sheet1");
	    	
	    	if (gridStatus.equals("Yes"))
	    	{
	    		driver = bwStart.startGridChormeHeadless(driver);
	    	   
	    	}
	    	else
	    	{
			    driver = bwStart.startChromeHeadless(driver);
	    	}
	    }
	    else if (browserMode.equals("Chrome"))
	    {
	    	String gridStatus = excel.readExcel(1,5, ".\\Data\\data.xlsx","Sheet1");
	    	
	    	if (gridStatus.equals("Yes"))
	    	{
	    	     driver = bwStart.startGridChorme(driver);
	    	   
	    	}
	    	else
	    	{
	    	   driver = bwStart.startChrome(driver);
	    	}
	    }
	    else if (browserMode.equals("Firefox"))
	    {
	    	String gridStatus = excel.readExcel(1,5, ".\\Data\\data.xlsx","Sheet1");
	    	
	    	if (gridStatus.equals("Yes"))
	    	{
	    	    driver = bwStart.startGridFireFox(driver);
	    	   
	    	}
	    	else
	    	{
	    	  driver = bwStart.startFireFox(driver);
	    	}
	    }
	    else if (browserMode.equals("Firefox-Headless"))
	    {
	    
		   String gridStatus = excel.readExcel(1,5, ".\\Data\\data.xlsx","Sheet1");
	    	
	    	if (gridStatus.equals("Yes"))
	    	{
	    	      driver = bwStart.startGridFireFoxHeadless(driver);
	    	   
	    	}
	    	else
	    	{
		         driver = bwStart.startFireFoxHeadless(driver);
	    	}
	    }
	    
	    
	    
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(excel.readExcel(1,0, ".\\Data\\data.xlsx","Sheet1"));
        speachRpt.speachReport("Navigated to" + excel.readExcel(1,0, ".\\Data\\data.xlsx","Sheet1"),syn);
        log.debug("Navigating to Login Page");
        extRpt.setUpReport();
        
        extRpt.startTestCase("User Login");
    	
	    objLogin = new Login(driver);

	    //Verify login page title

	   
	    
	    String loginPageTitle = objLogin.getLoginTitle();

	    AssertJUnit.assertTrue(loginPageTitle.toLowerCase().contains(excel.readExcel(1,3, ".\\Data\\data.xlsx","Sheet1")));

	    //login to application

	    objLogin.loginToGuru99(excel.readExcel(1,1, ".\\Data\\data.xlsx","Sheet1"), excel.readExcel(1,2, ".\\Data\\data.xlsx","Sheet1"));
	    log.debug("Entered the user name and password");
	    extRpt.logEvents("Logged Successfully");
	    Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).save(".\\Screenshots\\");
	    
	    driver.close();
   }
}
