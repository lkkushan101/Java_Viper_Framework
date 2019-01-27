package stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import ExtentReport.ExtentReport;
import PageFactory.*;
import ReadExcel.ExcelRead;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
public class LoginScenario {
	     WebDriver driver;

	    Login objLogin;

	    HomePage objHomePage;
	
	    ExtentReport extRpt = new ExtentReport();
	    ExcelRead excel = new ExcelRead();
	    Logger log = Logger.getLogger("devpinoyLogger");
	@Given("^I have user name and password$")
	public void i_have_user_name_and_password() throws Throwable {
		    WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();

	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        driver.get(excel.readExcel(1,0, ".\\Data\\data.xlsx","Sheet1"));
	        log.debug("Navigating to Login Page");
	        extRpt.setUpReport();
	        
	  
	}
	@When("^I successfully login$")
	public void i_successfully_login() throws Throwable {
	  
		   extRpt.startTestCase("User Login");
	
		    objLogin = new Login(driver);

		    //Verify login page title

		   
		    
		    String loginPageTitle = objLogin.getLoginTitle();

		    Assert.assertTrue(loginPageTitle.toLowerCase().contains(excel.readExcel(1,3, ".\\Data\\data.xlsx","Sheet1")));

		    //login to application

		    objLogin.loginToGuru99(excel.readExcel(1,1, ".\\Data\\data.xlsx","Sheet1"), excel.readExcel(1,2, ".\\Data\\data.xlsx","Sheet1"));
		    log.debug("Entered the user name and password");
		    extRpt.logEvents("Logged Successfully");

	   
	}
	
	@Then("^I should navigate to the home page$")
	public void i_should_navigate_to_the_home_page() throws Throwable {
		 

		    //Verify home page

		    objHomePage = new HomePage(driver);

		    //Verify home page

		    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
		    driver.close();
		    extRpt.createFinalReport();
		    log.debug("Creating final report");
		   

	
	}

}
