package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Log;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties props = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader fr2;
	public static Logger logger;
	
	@BeforeMethod
	public void setUp() throws IOException {
		if(driver == null) {
			FileReader fr = new FileReader(System.getProperty("user.dir")+"/src/test/resources/configFiles/config.properties");
			FileReader fr2 = new FileReader(System.getProperty("user.dir")+"/src/test/resources/configFiles/locators.properties");
			props.load(fr);
			loc.load(fr2);
			logger = LogManager.getLogger();
		}
		
		switch(props.getProperty("browser")) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get(props.getProperty("testurl"));
				logger.info("browser has been instantiated");
				break;
			
			case "firefox":
				WebDriverManager.firefoxdriver().setup();				
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
				driver.get(props.getProperty("testurl"));
				logger.info("browser has been instantiated");
				break;
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		logger.info("browser closed successfully");
	}

}
