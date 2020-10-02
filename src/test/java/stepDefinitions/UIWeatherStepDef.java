package stepDefinitions;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.log4j.Logger;
import org.junit.Assert;

import baseClass.TestBase;
//import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UIWeatherPage;

public class UIWeatherStepDef {

	String city1;
	Logger log=Hooks.logger;
	UIWeatherPage uiweatherpage = new UIWeatherPage();
	

	@Given("Launch NDTV weather website {string}")
	public void launch_NDTV_weather_website(String url) throws InterruptedException {
		log.info("Launching Website...");
		uiweatherpage.getUrl(TestBase.getPropertyValue(url));
		
	}

	@When("Enter city name {string}")
	public void enter_city_name(String city) throws InterruptedException {
		city1 = city;
		uiweatherpage.handlePopupAndEnterCity(TestBase.getPropertyValue(city));

	}

	@Then("verify if weather data is displayed")
	public void verify_if_weather_data_is_displayed() throws InterruptedException {
		LinkedHashMap<String, String> weathermap = uiweatherpage.getWeatherData(TestBase.getPropertyValue(city1));
		uiweatherpage.verifyWeatherData(weathermap);

	}

	@Then("verify error message when city is not valid {string}")
	public void verify_error_message_when_city_is_not_valid(String errormsg) {
		uiweatherpage.getNoRecordMessage(TestBase.getPropertyValue(errormsg));
	}

}
