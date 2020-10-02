package stepDefinitions;

import java.util.LinkedHashMap;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import baseClass.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pages.CompareUIandServiceData;
import pages.ServiceWeatherPage;
import pages.UiComparator;
import pojoClasses.WeatherResponse;

public class ComparatorUIandServiceStepDef {
	
	ServiceWeatherPage service = new ServiceWeatherPage();
	Utility utility=new Utility();
	UiComparator ui = new UiComparator();
	CompareUIandServiceData compare=new CompareUIandServiceData();
	LinkedHashMap<String, String> weathermap;
	Response response;
	String baseURI;
	String endpoint;
	String apikey;
	String city;
	String city1;	
	
	@Given("Launch NDTV weather website {string} and enter city {string}")
	public void launch_NDTV_weather_website_and_enter_city(String url, String city) {
		ui.getUrl(TestBase.getPropertyValue(url));
		city1 = city;
		ui.enterCity(TestBase.getPropertyValue(city));
	}

	@When("Retrive the weather data from the UI")
	public void retrive_the_weather_data_from_the_UI() {
		weathermap = ui.getWeatherData(TestBase.getPropertyValue(city1));
		ui.verifyWeatherData(weathermap);    	
	}

	@When("Call Weather API and fetch all the weather details {string},{string},{string},{string}")
	public void call_Weather_API_and_fetch_all_the_weather_details(String baseuri, String endPoint, String apikeyy, String cityy) throws JsonMappingException, JsonProcessingException {
	   
		baseURI = TestBase.getPropertyValue(baseuri);
		endpoint = TestBase.getPropertyValue(endPoint);
		apikey = TestBase.getPropertyValue(apikeyy);
		city = TestBase.getPropertyValue(cityy);
		response = service.getWeatherDataResponse(baseURI, endpoint, apikey, city);
		System.out.println(response.getBody().asString());
	}
	@Then("verify if the Temperature retrived from UI and Service is matching with Variance {string}")
	public void verify_if_the_Temperature_retrived_from_UI_and_Service_is_matching_with_Variance(String variance) {
		int temperaturefromui=Integer.parseInt(weathermap.get("Temperature").substring(0, 2));
		double temperaturefromresponse=compare.getTemepartureFromResponse(response.asString());
		double celciustokelvin=utility.celciusToKelvin(temperaturefromui);
		
		
		compare.varianceLogic(temperaturefromresponse, celciustokelvin,TestBase.getPropertyValue(variance));
	}
	
	@Then("verify if the City retrived from UI and Service is matching")
	public void verify_if_the_City_retrived_from_UI_and_Service_is_matching() throws JsonMappingException, JsonProcessingException {
	    
		String cityname=weathermap.get("City");
		WeatherResponse we=utility.unmarshallingResponse(response.asString(),WeatherResponse.class);
	    System.out.println("City Name: "+we.getName());
	    Assert.assertEquals(cityname, we.getName());
	}







}
