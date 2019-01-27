package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Reusable_Requests.*;
import Utility.JSONReader;
public class Get_Test {
	String response;
	GetRequest _getReq;
	String Req_URL ;
	@Given("^I have url to get weather for Pune$")
	public void i_have_url_to_get_weather_for_Pune() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		JSONReader _JSONRead = new JSONReader();
		 _getReq = new GetRequest();
		 Req_URL = _JSONRead.ReadJSONFile("Request_Get", ".\\Data\\wsData.json");
		

	 
	}

	@When("^I successfully sent the request$")
	public void i_successfully_sent_the_request() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		response = _getReq.getRequest(Req_URL);
	
	}

	@Then("^I should get weather details$")
	public void i_should_get_weather_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 Assert.assertEquals(response.toLowerCase().contains("pune") , true , "Response body contains Pune");
		  
	  
	}
}
