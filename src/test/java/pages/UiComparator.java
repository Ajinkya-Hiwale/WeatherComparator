package pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseClass.TestBase;

import stepDefinitions.Utility;
import stepDefinitions.Hooks;

public class UiComparator extends Utility {

	WebDriver driver;
	LinkedHashMap<String, String> data = new LinkedHashMap();

	public UiComparator() {
		this.driver = TestBase.driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "indiceslist-search")
	WebElement citysearch;



	@FindBy(xpath = "//a[text()='No Thanks']")
	WebElement alertclose;
	
	@FindBy(xpath="//div[@id='norecord_india']//td[text()='No Record Found, Try again.']")
	WebElement norecordmsg;

	public void getUrl(String url) {
		driver.get(url);

	}

	public void enterCity(String cityname) {
		citysearch.sendKeys(cityname);
	}

	public LinkedHashMap<String, String> getWeatherData(String city) {

		 //javaScriptExecutorClick(driver,alertclose);
		WebElement weatherdata=driver.findElement(By.xpath("//*[@id='cities_list']//li//table//tbody//tr/td//b[text()='" + city + "']/parent::td"));
		 System.out.println("Text is"+weatherdata.getText().trim());
		 System.out.println("Temperature"+weatherdata.getText().split("[(]")[1].split("/")[0].trim());
		

		String weather = weatherdata.getText();
		data.put("City", weatherdata.getText().split(" ")[0].trim());
		data.put("Temperature", weatherdata.getText().split("[(]")[1].split("/")[0].trim());
		WebElement weathercondition = driver
				.findElement(By.xpath("//b[text()='" + city + "']/../preceding-sibling::td/div[@class='condition']"));
		System.out.println("Constion is " + weathercondition.getText());
		data.put("WeatherCondition", weathercondition.getText().trim());
		data.put("Humidity", weather.substring(weather.indexOf("Humidity") + 10, weather.indexOf("%")));
		data.put("Wind", weather.substring(weather.indexOf("Wind") + 5, weather.indexOf("KPH")));

		return data;

	}
	
	public void verifyWeatherData(LinkedHashMap<String, String> map)
	{
		for(Entry<String, String> map1:map.entrySet())
		{
			if(map1.getValue()=="")
			{
				Assert.assertTrue(false);
			}
		}
	}
	
	public void getNoRecordMessage(String errormsg)
	{
		System.out.println(norecordmsg.getText());
		Assert.assertEquals(norecordmsg.getText(),errormsg);
	}

}
