package Utility;

import static org.testng.AssertJUnit.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.deque.axe.AXE;

import ReadExcel.ExcelRead;
import Test.Test_Accessibility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AccessibilityRunner {
	@Rule
	public TestName testName = new TestName();
	//WebDriver driver;
	private static final URL scriptUrl = Test_Accessibility.class.getResource("/axe.min.js");

	public void accessibilityTest(String url) throws IOException
	{
		   WebDriver driver;
			
		   WebDriverManager.chromedriver().setup();

		    driver = new ChromeDriver();
			driver.get(url);
			
			JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).analyze();

			JSONArray violations = responseJSON.getJSONArray("violations");

			if (violations.length() == 0) {
				assertTrue("No violations found", true);
			} else {
				AXE.writeResults(testName.getMethodName(), responseJSON);
				assertTrue(AXE.report(violations), true);
				System.out.println("Accessibility Violiations for " + url);
				System.out.println(AXE.report(violations));
				String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
				File file=new File(".\\Accessibility_Reports\\"+timeStamp+".txt");  
				
	            file.createNewFile();  
	            FileWriter fileWriter = new FileWriter(file);  
	            fileWriter.write("Accessibility Violiations for " + url +" ");
	            fileWriter.write(AXE.report(violations));  
	            fileWriter.flush();  
	            fileWriter.close();  
			}
			driver.close();
	}
	

}
