package stepDefinitions;

import java.io.StringReader;
import java.util.UUID;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.core.internal.gherkin.deps.com.google.gson.Gson;

public class Utility {

	public <T> T unmarshallingResponse(String response, Class name)
			throws JsonMappingException, JsonProcessingException {
		ObjectMapper jsonmapper = new ObjectMapper();

		jsonmapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		jsonmapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

		T pojo = (T) jsonmapper.readValue(response, name);

		return pojo;

	}

	public <T> T gsonParser(String response, Class name) throws JsonMappingException, JsonProcessingException {
		StringReader reader = new StringReader(response);
		Gson gson = new Gson();
		T res = (T) gson.fromJson(response, name);

		return res;

	}

	public boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	}

	public double celciusToKelvin(int a) {
		return a + 273.15;
	}

	public double meterPerSecondToKPH(int a) {
		return a * 3.6;
	}

	public void javaScriptExecutorClick(WebDriver driver, WebElement ele) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
	}

}
