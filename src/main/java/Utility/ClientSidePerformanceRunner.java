package Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;

public class ClientSidePerformanceRunner {
	public WebDriver driver;
	public BrowserMobProxy proxy;
	public void clientSidePerformance(String url, String harfileURL, String harfilePath ) throws IOException
	{
		  BrowserMobProxy proxy = new BrowserMobProxyServer();
		    proxy.start(2020);

		    // get the Selenium proxy object
		    Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

		    // configure it as a desired capability
		    DesiredCapabilities capabilities = new DesiredCapabilities();
		    capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

		    
		    WebDriverManager.firefoxdriver().setup();

		   
		    
		    // start the browser up
		  
		    // enable more detailed HAR capture, if desired (see CaptureType for the complete list)
		    proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

		    // create a new HAR with the label "yahoo.com"
		    proxy.newHar(harfileURL);

		    // open yahoo.com
		    WebDriver driver = new FirefoxDriver(capabilities);
		    driver.get(url);

		    // get the HAR data
		    Har har = proxy.getHar();
		    har.writeTo(new File(harfilePath));
		    proxy.stop();
		    driver.close();
	}

}
