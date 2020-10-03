package stepDefinitions;

import java.util.LinkedHashMap;

import org.testng.Assert;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


import baseClass.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pages.CompareUIandServiceDataPage;
import pages.ServiceWeatherPage;
import pages.UIWeatherPage;
import pojoClasses.WeatherResponse;

public class ComparatorUIandServiceStepDef {

	ServiceWeatherPage service = new ServiceWeatherPage();
	Utility utility = new Utility();
	UIWeatherPage uiweatherpage = new UIWeatherPage();
	CompareUIandServiceDataPage compare = new CompareUIandServiceDataPage();
	LinkedHashMap<String, String> weathermap;
	Logger log=Hooks.logger;
	Response response;
	String baseURI;
	String endpoint;
	String apikey;
	String city;
	String city1;

	@Given("Launch NDTV weather website {string} and enter city {string}")
	public void launch_NDTV_weather_website_and_enter_city(String url, String city) throws InterruptedException {
		log.info("Launching Website...");
		uiweatherpage.getUrl(TestBase.getPropertyValue(url));
		city1 = city;
		uiweatherpage.handlePopupAndEnterCity(TestBase.getPropertyValue(city));
	}

	@When("Retrive the weather data from the UI")
	public void retrive_the_weather_data_from_the_UI() {
		weathermap = uiweatherpage.getWeatherData(TestBase.getPropertyValue(city1));
		uiweatherpage.verifyWeatherData(weathermap);
	}

	@When("Call Weather API and fetch all the weather details {string},{string},{string},{string}")
	public void call_Weather_API_and_fetch_all_the_weather_details(String baseuri, String endPoint, String apikeyy,
			String cityy) throws JsonMappingException, JsonProcessingException {
		log.info("Setting up data to hit weather web service");
		baseURI = TestBase.getPropertyValue(baseuri);
		endpoint = TestBase.getPropertyValue(endPoint);
		apikey = TestBase.getPropertyValue(apikeyy);
		city = TestBase.getPropertyValue(cityy);
		response = service.getWeatherDataResponse(baseURI, endpoint, apikey, city);
		//log.info("Response is "+response.getBody().asString());
		
	}

	@Then("verify if the Temperature retrived from UI and Service is matching with Variance {string}")
	public void verify_if_the_Temperature_retrived_from_UI_and_Service_is_matching_with_Variance(String variance) {
		int temperaturefromui = Integer.parseInt(weathermap.get("Temperature").substring(0, 2));
		double temperaturefromresponse = compare.getTemepartureFromResponse(response.asString());
		double celciustokelvin = utility.celciusToKelvin(temperaturefromui);

		compare.varianceLogic(temperaturefromresponse, celciustokelvin, TestBase.getPropertyValue(variance));
	}

	@Then("verify if the City retrived from UI and Service is matching")
	public void verify_if_the_City_retrived_from_UI_and_Service_is_matching()
			throws JsonMappingException, JsonProcessingException {

		String cityname = weathermap.get("City");
		WeatherResponse wr = utility.unmarshallingResponse(response.asString(), WeatherResponse.class);
		log.info("City Name: " + wr.getName());
		Assert.assertEquals(cityname, wr.getName(), "City Name is not matching  ");
	}

	@Then("verify if the Humidity retrived from UI and Service is matching with Variance {string}")
	public void verify_if_the_Humidity_retrived_from_UI_and_Service_is_matching_with_Variance(String variance) {
		int humidityfromui = Integer.parseInt(weathermap.get("Humidity").substring(0, 2));
		double humidityfromresponse = compare.getHumidityFromResponse(response.asString());
		compare.varianceLogic(humidityfromui, humidityfromresponse, TestBase.getPropertyValue(variance));
	}

	@Then("verify if the weather condition retrived from UI and Service is matching")
	public void verify_if_the_weather_condition_retrived_from_UI_and_Service_is_matching()
			throws JsonMappingException, JsonProcessingException {

		String weatherconditionui = weathermap.get("WeatherCondition");

		String weatherconditionservice = compare.getWeatherConditionFromResponse(response.asString());
		if(!(weatherconditionservice.toUpperCase().contains(weatherconditionui.toUpperCase())||(
				(weatherconditionui.toUpperCase().contains(weatherconditionservice.toUpperCase())))))
				{
			log.info("Weather condition is not matching "+"Expected is "+weatherconditionservice.toUpperCase()+"  Actual is "+
					weatherconditionui+" ");
					Assert.assertTrue(false);
				}
		
		
	}

	
	@Then("verify if the Wind Speed retrived from UI and Service is matching with Variance {string}")
	public void verify_if_the_Wind_Speed_retrived_from_UI_and_Service_is_matching_with_Variance(String variance) {
		double windspeedfromui = Double.parseDouble(weathermap.get("Wind"));
		double windspeedfromresponse = compare.getWindSpeedFomResponse((response.asString()));
		compare.varianceLogic(windspeedfromui, windspeedfromresponse, TestBase.getPropertyValue(variance));
	}
	
}
