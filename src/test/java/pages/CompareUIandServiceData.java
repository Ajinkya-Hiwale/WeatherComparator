package pages;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class CompareUIandServiceData {

	JsonPath jsonpath;
	
	
	
	/*int count=jsonpath.getInt("courses.size()")
			for(int i=0;i<count;i++)
			{
			 jsonpath.get("courses["+i+"].title") 
			 jsonpath.get("courses["+i+"].prize")
			}*/
	
public double getTemepartureFromResponse(String response)
{
	jsonpath=new JsonPath(response);
	return jsonpath.getDouble("main.temp");
	
}


public void varianceLogic(double uitemp,double servicetemp,String variance)
{
	if(!(Integer.parseInt(variance) >(servicetemp-uitemp)))
	{
		Assert.assertTrue(false, "Temperature variance between UI and Service more than "+Integer.parseInt(variance)+"  ");
	}

}


}
