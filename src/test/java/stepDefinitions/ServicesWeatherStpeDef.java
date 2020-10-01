package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import baseClass.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pages.ServiceWeatherPage;

public class ServicesWeatherStpeDef extends TestBase {
	
	ServiceWeatherPage service=new ServiceWeatherPage();
	public ServicesWeatherStpeDef() throws IOException {
		super();
		ServiceWeatherPage service=new ServiceWeatherPage();
	}

	
	Response response;
	String baseURI;
	String endpoint;
	String apikey;
	String city;
	@Given("Calling Weather API to get weather details {string},{string},{string},{string}")
	public void calling_Weather_API_to_get_weather_details(String baseuri, String endPoint, String apikeyy, String cityy) throws JsonMappingException, JsonProcessingException {
	  
		 baseURI=TestBase.getPropertyValue(baseuri);
		 endpoint=TestBase.getPropertyValue(endPoint);
		 apikey=TestBase.getPropertyValue(apikeyy);
		 city=cityy;
		 response=service.getWeatherDataResponse(baseURI, endpoint, apikey, city);
		
	}

	@Then("Verify if weather data is getting fetched from the API")
	public void verify_if_weather_data_is_getting_fetched_from_the_API() throws JsonMappingException, JsonProcessingException {
	    
		System.out.println("Response is "+response.getBody().asString());
		if(response.getBody().asString().equals(" "))
		{
			Assert.assertTrue(false, "No Data in Response");
		}
	}
	
	@Then("Verify status code should be {string}")
	public void verify_status_code_should_be(String statuscode) {
	   
		Assert.assertEquals(String.valueOf(response.getStatusCode()), statuscode);
	}

	
}
