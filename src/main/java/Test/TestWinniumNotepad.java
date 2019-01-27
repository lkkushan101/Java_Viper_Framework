package Test;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.Test;

import PageObjects_Windows.NotePadWin8;
import  Utility.*;
public class TestWinniumNotepad {
   WiniumDriver driver;
@Test 
public void winniumTest() throws InterruptedException{
	WinniumRunner wr = new WinniumRunner();
	driver = wr.Setup("C:\\Windows\\System32\\notepad.exe");
	NotePadWin8 np = new NotePadWin8(driver);
	np.typeText("Welcome to Viper");
	driver.close();
  }
}
