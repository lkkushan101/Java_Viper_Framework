package Utility;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class WinniumRunner {
	 WiniumDriver driver = null;
	public WiniumDriver Setup (String appPath) throws InterruptedException
	 {
	  DesktopOptions desktop = new DesktopOptions();
	  desktop.setApplicationPath(appPath);
	  try {
		  desktop.setDebugConnectToRunningApp(false);
		  desktop.setLaunchDelay(2);
	   driver = new WiniumDriver(new URL ("http://localhost:9999"), desktop);
	   Thread.sleep(1000);
	  }catch (MalformedURLException e)
	  {
	   e.printStackTrace();
	  }
	  return driver;
	 }
}
