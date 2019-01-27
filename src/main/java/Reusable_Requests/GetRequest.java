package Reusable_Requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetRequest {

	
	public String getRequest(String url)
	{
             
		RequestSpecification httpRequest = RestAssured.given();
		
        // Making GET request directly by RequestSpecification.get() method
		Response response = httpRequest.get(url);
		
		String body = response.getBody().asString();
		
		return body;
	
     }
}
