package pages;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class CompareUIandServiceData {

	JsonPath jsonpath;
	
	
	
	
	
public double getTemepartureFromResponse(String response)
{
	jsonpath=new JsonPath(response);
	return jsonpath.getDouble("main.temp");
	
}

public double getHumidityFromResponse(String response)
{
	jsonpath=new JsonPath(response);
	return jsonpath.getDouble("main.humidity");
	
}


public double getWindSpeedFomResponse(String response)
{
	jsonpath=new JsonPath(response);
	return jsonpath.getDouble("wind.speed");
	
}

public String getWeatherConditionFromResponse(String response)
{
	jsonpath=new JsonPath(response);
	return jsonpath.getString("weather.main");
	
}


public void varianceLogic(double uitemp,double servicetemp,String variance)
{
	if(!(Integer.parseInt(variance) >Math.abs(servicetemp-uitemp)))
	{
		Assert.assertTrue(false, "Temperature variance between UI and Service more than "+Integer.parseInt(variance)+"  ");
		
	}

}


}
