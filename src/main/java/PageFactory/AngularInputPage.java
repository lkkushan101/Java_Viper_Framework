package PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class AngularInputPage {
	
	static WebDriver driver;
	static NgWebDriver ngdriver;
	
	  ByAngular name;
	  ByAngular employees;
	  ByAngular headoffice;
	
	   public AngularInputPage(WebDriver driver){

	         this.driver = driver;
          
	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);

	    }
	   
	   public void setName (String name)
	   {
		  this.driver.findElement(ByAngular.model("name")).sendKeys(name);
	   }
	   
	   public void setEmployeeCount (String count)
	   {
		  this.driver.findElement(ByAngular.model("employees")).sendKeys(count);
	   }
	   
	   public void setHeadOffice (String headoffice)
	   {
		  this.driver.findElement(ByAngular.model("headoffice")).sendKeys(headoffice);
	   }
}
