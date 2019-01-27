package Test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Reusable_Requests.*;
import Utility.JSONReader;
public class test_get {
	@Test
	public void get_test_req_pune() throws FileNotFoundException, IOException, ParseException
	{
		String response;
		JSONReader _JSONRead = new JSONReader();
		GetRequest _getReq = new GetRequest();
		String Req_URL = _JSONRead.ReadJSONFile("Request_Get", ".\\Data\\wsData.json");
		response = _getReq.getRequest(Req_URL);

		  AssertJUnit.assertEquals(true,response.toLowerCase().contains("pune"));
	}
	@Test
	public void get_test_req_chennai() throws FileNotFoundException, IOException, ParseException
	{
		String response;
		JSONReader _JSONRead = new JSONReader();
		GetRequest _getReq = new GetRequest();
		String Req_URL = _JSONRead.ReadJSONFile("Request_Get2", ".\\Data\\wsData.json");
		response = _getReq.getRequest(Req_URL);

	  AssertJUnit.assertEquals(true,response.toLowerCase().contains("mumbai"));
	}
	@Test
	public void get_test_req_mumbai() throws FileNotFoundException, IOException, ParseException
	{
		String response;
		JSONReader _JSONRead = new JSONReader();
		GetRequest _getReq = new GetRequest();
		String Req_URL = _JSONRead.ReadJSONFile("Request_Get3", ".\\Data\\wsData.json");
		response = _getReq.getRequest(Req_URL);

	  AssertJUnit.assertEquals(true,response.toLowerCase().contains("chennai"));
	}
}
