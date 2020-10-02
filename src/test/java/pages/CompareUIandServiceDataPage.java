package pages;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import stepDefinitions.Hooks;

public class CompareUIandServiceDataPage {

	JsonPath jsonpath;
	Logger log = Hooks.logger;

	/*
	 * Variance Logic : If comparison is greator than difference between Ui Value
	 * and Service Value then it return false else true
	 */

	public void varianceLogic(double uitemp, double servicetemp, String variance) {
		if (!(Integer.parseInt(variance) > Math.abs(servicetemp - uitemp))) {
			log.info("Temperature variance between UI and Service more than " + Integer.parseInt(variance) + "  ");
			Assert.assertTrue(false);

		}

	}

	/*
	 * Below methods will be used to fetch the valued from the service response
	 */

	public double getTemepartureFromResponse(String response) {
		jsonpath = new JsonPath(response);
		return jsonpath.getDouble("main.temp");

	}

	public double getHumidityFromResponse(String response) {
		jsonpath = new JsonPath(response);
		return jsonpath.getDouble("main.humidity");

	}

	public double getWindSpeedFomResponse(String response) {
		jsonpath = new JsonPath(response);
		return jsonpath.getDouble("wind.speed");

	}

	public String getWeatherConditionFromResponse(String response) {
		jsonpath = new JsonPath(response);
		return jsonpath.getString("weather.main");

	}

}
