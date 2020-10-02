package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import baseClass.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pages.ServiceWeatherPage;

public class ServicesWeatherStpeDef extends TestBase {

	ServiceWeatherPage service = new ServiceWeatherPage();

	public ServicesWeatherStpeDef() throws IOException {
		super();
		ServiceWeatherPage service = new ServiceWeatherPage();
	}

	Response response;
	String baseURI;
	String endpoint;
	String apikey;
	String city;

	@Given("Setting up Rest APi ELements like {string},{string},{string},{string}")
	public void setting_up_Rest_APi_ELements_like(String baseuri, String endPoint, String apikeyy, String cityy) {

		baseURI = TestBase.getPropertyValue(baseuri);
		endpoint = TestBase.getPropertyValue(endPoint);
		apikey = TestBase.getPropertyValue(apikeyy);
		city = TestBase.getPropertyValue(cityy);
	}

	@When("Calling Weather API to get weather details")
	public void calling_Weather_API_to_get_weather_details() throws JsonMappingException, JsonProcessingException {
		response = service.getWeatherDataResponse(baseURI, endpoint, apikey, city);
	}

	@Then("Verify if weather data is getting fetched from the API")
	public void verify_if_weather_data_is_getting_fetched_from_the_API()
			throws JsonMappingException, JsonProcessingException {

		System.out.println("Response is " + response.getBody().asString());
		if (response.getBody().asString().equals(" ")) {
			Assert.assertTrue(false, "No Data in Response");
		}
	}

	@Then("Verify status code should be {string}")
	public void verify_status_code_should_be(String statuscode) {

		Assert.assertEquals(String.valueOf(response.getStatusCode()), statuscode);
		
	}
	
	@Then("Verify content type of the response {string}")
	public void verify_content_type_of_the_response(String content_type) {
		System.out.println(response.getContentType());
		Assert.assertTrue(response.getContentType().contains(TestBase.getPropertyValue(content_type)));
	}

}
