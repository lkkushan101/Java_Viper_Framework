package Test;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utility.*;
import com.github.seratch.jslack.*;
import com.github.seratch.jslack.api.webhook.*;

import Reusable_Requests.GetRequest;
import Reusable_Requests.PostRequest;
import Utility.JSONReader;
import java.lang.reflect.Method; 
public class SlackReporterTest {
	@Test
	public void test_slack(Method method)throws FileNotFoundException, IOException, ParseException
	{
		String response;
		JSONReader _JSONRead = new JSONReader();
		GetRequest _getReq = new GetRequest();
		String Req_URL = _JSONRead.ReadJSONFile("Request_Get2", ".\\Data\\wsData.json");
		response = _getReq.getRequest(Req_URL);
		
		SlackReporter slReporter = new SlackReporter();
		
		String testName = method.getName();
		if (response.toLowerCase().contains("mumbai"))
		{
		slReporter.slackReporter(testName+ " is Passing", "Viper Bot", "#random");
		}
		else 
		{
			slReporter.slackReporter(testName + " is failing", "Viper Bot", "#random");
				
		}
	}
}
