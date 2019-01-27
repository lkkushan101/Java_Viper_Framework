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
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import Utility.*;
import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;

public class LoginTestTestingBotExample {
  WebDriver driver;
  Synthesizer syn; 
   @Test
   public void testLogin(Method method) throws IOException, EngineException, AudioException, EngineStateError, IllegalArgumentException, InterruptedException, ParseException {
	  

	    Login objLogin;

	    HomePage objHomePage;
	
	    ExtentReport extRpt = new ExtentReport();
	    ExcelRead excel = new ExcelRead();
	    SpeachReporting speachRpt = new SpeachReporting();
	    syn = speachRpt.setupSpeachReporting();
	    Logger log = Logger.getLogger("devpinoyLogger");
	    String testName = method.getName();
	    RunInTestingBot testBot = new RunInTestingBot();
	    WebDriver driver = testBot.runInTestingBot(testName);
	    
	    
	    
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
