package Test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import ReadExcel.ExcelRead;
import Utility.BrowserStart;
public class BarcodeVerification {
	  WebDriver driver;
	@Test 
	public void verifyBarCode() throws IOException, NotFoundException, ChecksumException, FormatException
	{
		ExcelRead excel = new ExcelRead();
		URL url = new URL("https://cdn.barcodesinc.com/themes/barcodesinc/images/upc.gif");
		BufferedImage barCodeBufferedImage = ImageIO.read(url);
		BrowserStart bwStart = new BrowserStart();
		
		 String browserMode = excel.readExcel(1,4, ".\\Data\\data.xlsx","Sheet1");
		    if (browserMode.equals("Chrome-Headless"))
		    {
		    	String gridStatus = excel.readExcel(1,5, ".\\Data\\data.xlsx","Sheet1");
		    	
		    	if (gridStatus.equals("Yes"))
		    	{
		    		driver = bwStart.startGridChormeHeadless(driver);
		    	   
		    	}
		    	else
		    	{
				    driver = bwStart.startChromeHeadless(driver);
		    	}
		    }
		    else if (browserMode.equals("Chrome"))
		    {
		    	String gridStatus = excel.readExcel(1,5, ".\\Data\\data.xlsx","Sheet1");
		    	
		    	if (gridStatus.equals("Yes"))
		    	{
		    	     driver = bwStart.startGridChorme(driver);
		    	   
		    	}
		    	else
		    	{
		    	   driver = bwStart.startChrome(driver);
		    	}
		    }
		    else if (browserMode.equals("Firefox"))
		    {
		    	String gridStatus = excel.readExcel(1,5, ".\\Data\\data.xlsx","Sheet1");
		    	
		    	if (gridStatus.equals("Yes"))
		    	{
		    	    driver = bwStart.startGridFireFox(driver);
		    	   
		    	}
		    	else
		    	{
		    	  driver = bwStart.startFireFox(driver);
		    	}
		    }
		    else if (browserMode.equals("Firefox-Headless"))
		    {
		    
			   String gridStatus = excel.readExcel(1,5, ".\\Data\\data.xlsx","Sheet1");
		    	
		    	if (gridStatus.equals("Yes"))
		    	{
		    	      driver = bwStart.startGridFireFoxHeadless(driver);
		    	   
		    	}
		    	else
		    	{
			         driver = bwStart.startFireFoxHeadless(driver);
		    	}
		    }
		    
		
		LuminanceSource source = new BufferedImageLuminanceSource(barCodeBufferedImage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		Reader reader = new MultiFormatReader();
		Result result = reader.decode(bitmap);

		System.out.println("Barcode text is " + result.getText());
		
		AssertJUnit.assertEquals(result.getText(), "671860013624");
	
		driver.close();
		driver.quit();
	}
}
