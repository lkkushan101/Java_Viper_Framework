package PageObjects_Mobile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginScreen {
	 WebDriver driver;

	    By userName = By.id("com.experitest.ExperiBank:id/usernameTextField");

	    By password = By.id("com.experitest.ExperiBank:id/passwordTextField");

	    By loginButton =By.id("com.experitest.ExperiBank:id/loginButton");

	    public LoginScreen(WebDriver driver){

	        this.driver = driver;

	    }

	    public void setUserName(String strUserName){

	        driver.findElement(userName).sendKeys(strUserName);

	    }

	    

	    //Set password in password textbox

	    public void setPassword(String strPassword){

	         driver.findElement(password).sendKeys(strPassword);

	    }

	    

	    //Click on login button

	    public void clickLogin(){

	            driver.findElement(loginButton).click();

	    }

	    
}
