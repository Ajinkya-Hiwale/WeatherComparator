package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


	
	public class TestBase {
		
		public static WebDriver driver;
		public static String propertyfile="TestData.properties";
		public File src;
		public FileInputStream fis;
		public static Properties prop;
		
		public TestBase() throws IOException
		{
			 src=new File(propertyfile);
			 fis=new FileInputStream(src);
			 prop=new Properties();
			 
			 prop.load(fis);
			 
			 	 
		}
		
		public static void getDriver()
		{
			if(prop.getProperty("browser").equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\main\\java\\driver\\chromedriver.exe");
//				ChromeOptions options = new ChromeOptions();
//				options.setPageLoadStrategy(PageLoadStrategy.EAGER);
//				 driver=new ChromeDriver(options);
				
				driver = new ChromeDriver();
			}
			else
				if(prop.getProperty("browser").equals("firefox"))
				{
					System.setProperty("webdriver.gecko.driver",
							System.getProperty("user.dir") + "\\src\\main\\java\\driver\\geckodriver.exe");
					
					driver = new FirefoxDriver();
				}
			driver.manage().window().maximize();
			//driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
			
		}
		
		public static String getPropertyValue(String key)
		{
			return prop.getProperty(key);
		}

	}