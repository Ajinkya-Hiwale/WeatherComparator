package pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import baseClass.TestBase;

import stepDefinitions.Utility;
import stepDefinitions.Hooks;

public class UIWeatherPage extends Utility {

	WebDriver driver;
	LinkedHashMap<String, String> data = new LinkedHashMap();
	Logger log=Hooks.logger;

	public UIWeatherPage() {
		this.driver = TestBase.driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id = "indiceslist-search")
	WebElement citysearch;

	@FindBy(xpath = "//a[text()='No Thanks']")
	WebElement alertclose;

	@FindBy(xpath = "//div[@id='norecord_india']//td[text()='No Record Found, Try again.']")
	WebElement norecordmsg;
	

	public void getUrl(String url) {
		driver.get(url);

	}
	
	/*
	*  Handling popup which as soon as you open NDTV weather website
	*  Once handle , entering city name
	*/

	public void handlePopupAndEnterCity(String cityname) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,60);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='No Thanks']")));
		Actions builder = new Actions(driver);
		 builder.click(element).build().perform();
		 citysearch.sendKeys(cityname);
		
	}
	
	/*
	*  Fetching Weather data from UI and storing it in one HashMap.
	*  As per our requirement we can fetch required value from the HashMap
	*/

	public LinkedHashMap<String, String> getWeatherData(String city) {

		
		WebElement weatherdata = driver.findElement(
				By.xpath("//*[@id='cities_list']//li//table//tbody//tr/td//b[text()='" + city + "']/parent::td"));
		
		
		log.info("Temperature: " + weatherdata.getText().split("[(]")[1].split("/")[0].trim());

		String weather = weatherdata.getText();
		log.info("City: "+weatherdata.getText().split(" ")[0].trim());
		data.put("City", weatherdata.getText().split(" ")[0].trim());
		
		data.put("Temperature", weatherdata.getText().split("[(]")[1].split("/")[0].trim());
		WebElement weathercondition = driver
				.findElement(By.xpath("//b[text()='" + city + "']/../preceding-sibling::td/div[@class='condition']"));
		log.info("Weather Condition is " + weathercondition.getText());
		data.put("WeatherCondition", weathercondition.getText().trim());
		log.info("Humidity: "+weather.substring(weather.indexOf("Humidity") + 10, weather.indexOf("%")));
		data.put("Humidity", weather.substring(weather.indexOf("Humidity") + 10, weather.indexOf("%")));
		log.info("Wind: "+weather.substring(weather.indexOf("Wind") + 5, weather.indexOf("KPH")));
		data.put("Wind", weather.substring(weather.indexOf("Wind") + 5, weather.indexOf("KPH")));
		return data;

	}
	
	/*
	* Verify each data whether it is blank 
	*/

	public void verifyWeatherData(LinkedHashMap<String, String> map) {
		for (Entry<String, String> map1 : map.entrySet()) {
			if (map1.getValue() == "") {
				Assert.assertTrue(false);
			}
		}
	}

	public void getNoRecordMessage(String errormsg) {
		log.info(norecordmsg.getText());
		Assert.assertEquals(norecordmsg.getText(), errormsg);
	}

}
