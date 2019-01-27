package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import Utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFileOpen {
 @Test 
  public void test() throws InterruptedException
  {
	   WebDriver driver;
		
	   WebDriverManager.chromedriver().setup();

	    driver = new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		driver.findElement(By.xpath("/html/body/form/input[1]")).click();
		FileOpenDialog fp = new FileOpenDialog();
		fp.openDlg("Open", "E:\\kushan.txt", "Button1");
  }
}
