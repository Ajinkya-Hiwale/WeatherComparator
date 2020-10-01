package stepDefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
/*  @Webdriver used to perform operation on browser
 * 
 *  @setup method will get executed before each test case 
 *  it will set the driver,maximize the windows browser and set implicit wait
 * 
 * @After execute after end of of each test case
 * 
 */

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import baseClass.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks extends TestBase{

	
	
	
	public Hooks() throws IOException {
		super();
		
	}

	Scenario scenario;
	public TestBase testbase;

	@Before("@UITest")
	public void setUP(Scenario scenario) throws Throwable {

		getDriver();
		
		this.scenario=scenario;
		System.out.println("Scenario name is "+scenario.getName());
		

	}

	@After("@UITest")
	public void tearDown() {
//		scenario.write("End of the test");
//		//if (Scenario.isFailed())
//		{
//			scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
//		}
		
		//driver.close();
		driver.quit();
	}

}
