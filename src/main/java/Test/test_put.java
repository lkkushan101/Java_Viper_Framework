package Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Reusable_Requests.PutRequest;
import Utility.JSONReader;;

public class test_put {
	@Test
	public void put_test_req() throws FileNotFoundException, IOException, ParseException
	{
		String response;
		JSONReader _JSONRead = new JSONReader();
		PutRequest _pustReq = new PutRequest();
		String Req_URL = _JSONRead.ReadJSONFile("Request_Put", ".\\Data\\wsData.json");
		String name = _JSONRead.ReadJSONFile("name", ".\\Data\\wsData.json");
		String job = _JSONRead.ReadJSONFile("job", ".\\Data\\wsData.json");
		  
		response = _pustReq.putRequest(Req_URL, "{\"name\":\"+name+\",\"job\":\"+job+\"}");
	
	   AssertJUnit.assertEquals(true,response.contains("200"));
	}

}
