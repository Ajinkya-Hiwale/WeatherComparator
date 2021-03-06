package pages;

import io.cucumber.core.internal.gherkin.deps.com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import pojoClasses.Clouds;
import pojoClasses.Main;
import pojoClasses.Coord;
import pojoClasses.Sys;
import pojoClasses.Weather;
import pojoClasses.WeatherResponse;
import pojoClasses.Wind;
import stepDefinitions.Utility;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.io.StringReader;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import baseClass.TestBase;

public class ServiceWeatherPage {

	Utility utility = new Utility();
	
	
	/*
	*  GET Request
	*  This method will return service response base provided parameters
	*/

	public Response getWeatherDataResponse(String baseURI, String endpoint, String apiKey, String city)
			throws JsonMappingException, JsonProcessingException {

		RestAssured.reset();
		RestAssured.useRelaxedHTTPSValidation();

		Response res = RestAssured.given()
				 .baseUri(baseURI)
				.queryParam("appid", apiKey)
				.queryParam("q", city).when()
			    .get(endpoint).then().extract().response();
		return res;

		
	}
	
	public Response getWeatherDataResponseWithParas(String baseURI, String endpoint, String apiKey, String city)
			throws JsonMappingException, JsonProcessingException {

		
		RestAssured.reset();
		RestAssured.useRelaxedHTTPSValidation();
		
		Response res = RestAssured.given()
				 .baseUri(baseURI)
				.queryParam("appid", apiKey)
				.queryParam("q", city)
				.header("Key","Value")
				.header("Key","Value")
				.cookie("Key","Value")
				.when()
			    .get(endpoint).then().extract().response();
		return res;

		
	}
	
	public Response postWeatherDataResponseWithParas(String baseURI, String endpoint, String apiKey, String city)
			throws JsonMappingException, JsonProcessingException {

		
		RestAssured.reset();
		RestAssured.useRelaxedHTTPSValidation();
		
		Response res = RestAssured.given()
				 .baseUri(baseURI)
				.queryParam("appid", apiKey)
				.queryParam("q", city)
				.header("Key","Value")
				.header("Key","Value")
				.cookie("Key","Value")
				.body("body")
				.when()
			    .post(endpoint).then().extract().response();
		return res;

		
	}

	

}
