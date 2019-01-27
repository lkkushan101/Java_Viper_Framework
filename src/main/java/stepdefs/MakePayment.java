package stepdefs;

import org.openqa.selenium.WebDriver;

import PageObjects_Mobile.LoginScreen;
import PageObjects_Mobile.MainScreen;
import PageObjects_Mobile.MakePaymentScreen;
import Utility.DriverStart;
import Utility.JSONReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MakePayment {
	DriverStart drv;
	WebDriver driver;
	@Given("^I logged into the bank Application$")
	public void i_logged_into_the_bank_Application() throws Throwable {
		drv = new DriverStart();
		driver = drv.drvStart();
		JSONReader _JSONRead = new JSONReader();
		LoginScreen logSc = new LoginScreen(driver);
		logSc.setUserName(_JSONRead.ReadJSONFile("User", ".\\Data\\wsDataMobile.json"));
		logSc.setPassword(_JSONRead.ReadJSONFile("User", ".\\Data\\wsDataMobile.json"));
		logSc.clickLogin();
	}

	@When("^I make payment with the app$")
	public void i_make_payment_with_the_app() throws Throwable {
		MainScreen mainPage = new MainScreen(driver);
		mainPage.clickPaymentButton();
		JSONReader _JSONRead = new JSONReader();
		MakePaymentScreen mkPayment = new MakePaymentScreen(driver);
		mkPayment.makePayment(_JSONRead.ReadJSONFile("tele", ".\\Data\\wsDataMobile.json"), _JSONRead.ReadJSONFile("name", ".\\Data\\wsDataMobile.json"), _JSONRead.ReadJSONFile("country", ".\\Data\\wsDataMobile.json")); 
	}

	@Then("^App should accept the payment$")
	public void app_should_accept_the_payment() throws Throwable {
	  driver.close();
	}
}
