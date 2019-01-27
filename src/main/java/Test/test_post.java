package Test;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utility.*;

import Reusable_Requests.*;
public class test_post {
	@Test
	public void post_test_req() throws FileNotFoundException, IOException, ParseException
	{
		
		String response;
		JSONReader _JSONRead = new JSONReader();
		PostRequest _postReq = new PostRequest();
	    String Req_URL = _JSONRead.ReadJSONFile("Request_Post", ".\\Data\\wsData.json");
	    String email = _JSONRead.ReadJSONFile("email", ".\\Data\\wsData.json");
	    String password = _JSONRead.ReadJSONFile("password", ".\\Data\\wsData.json");
	   System.out.println(Req_URL);
	    response = _postReq.postRequest(Req_URL, "{\"email\":\"+email+\",\"password\":\"+password+\"}");

	 // Assert.assertEquals(response.contains("201") , true , "Request is successful");
	}

}
