package Test;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Reusable_Requests.GetRequest;
import Utility.*;
import java.lang.reflect.Method; 
public class TelegramTest {
@Test
public void testTelegram (Method method) throws FileNotFoundException, IOException, ParseException

{
	TelegramReporter tr = new TelegramReporter();
	String response;
	JSONReader _JSONRead = new JSONReader();
	GetRequest _getReq = new GetRequest();
	String Req_URL = _JSONRead.ReadJSONFile("Request_Get2", ".\\Data\\wsData.json");
	response = _getReq.getRequest(Req_URL);
	System.out.println(response);
	String testName = method.getName();
	if (response.toLowerCase().contains("mumbai"))
	{
		tr.TelegramReporter(testName+ " is Passing");

	}
	else 
	{
		tr.TelegramReporter(testName+ " is Failing");
			
	}
 }

}
