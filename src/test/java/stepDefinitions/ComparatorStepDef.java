package stepDefinitions;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.junit.Assert;

import baseClass.TestBase;
//import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UiComparator;

public class ComparatorStepDef {

	String city1;

	UiComparator ui = new UiComparator();
	

	@Given("Launch website {string}")
	public void launch_website(String url) throws InterruptedException {

		ui.getUrl(TestBase.getPropertyValue(url));
		
	}

	@When("Enter city name {string}")
	public void enter_city_name(String city) throws InterruptedException {
		city1 = city;
		ui.enterCity(TestBase.getPropertyValue(city));

	}

	@Then("verify if weather data is displayed")
	public void verify_if_weather_data_is_displayed() throws InterruptedException {
		LinkedHashMap<String, String> weathermap = ui.getWeatherData(TestBase.getPropertyValue(city1));
		ui.verifyWeatherData(weathermap);

	}

	@Then("verify error message when city is not valid {string}")
	public void verify_error_message_when_city_is_not_valid(String errormsg) {
		ui.getNoRecordMessage(TestBase.getPropertyValue(errormsg));
	}

}
