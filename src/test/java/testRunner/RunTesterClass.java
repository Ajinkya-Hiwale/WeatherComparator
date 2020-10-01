package testRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		
		features = "C:\\Bench\\WeatherReportingComparator\\src\\test\\java\\features\\WeatherComparator.feature",
				glue = "stepDefinitions",
				
		
		plugin = {"pretty" ,"json:target//cucumber.json"}
		
		
		)
public class RunTesterClass extends AbstractTestNGCucumberTests {

}