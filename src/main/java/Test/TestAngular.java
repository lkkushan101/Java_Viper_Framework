package Test;

import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.NgWebDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import PageFactory.*;
public class TestAngular {
	static WebDriver driver;
	static NgWebDriver ngdriver;
	@Test
	public void testAngular()
	{
		System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://hello-angularjs.appspot.com/sorttablecolumn");
		
		ngdriver = new NgWebDriver((JavascriptExecutor) driver);
		
		AngularInputPage anPage = new AngularInputPage(driver);
		anPage.setName("Kushan");
		anPage.setEmployeeCount("20");
		anPage.setHeadOffice("Test");
		
		driver.close();
		driver.quit();
		
		
	}

}
