package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features = "C:\\Bench\\WeatherReportingComparator\\src\\test\\java\\features", 
		glue = "stepDefinitions",
		monochrome = true,
		//tags="@SeriveTest",
		plugin = { "pretty", "html:target/cucumber" }

)
public class RunTesterClass extends AbstractTestNGCucumberTests {

}