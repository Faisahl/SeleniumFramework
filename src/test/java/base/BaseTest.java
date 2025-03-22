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
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Log;

public class BaseTest {
	
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static Properties props = new Properties();
	public static FileReader fr;
	public static Logger logger;
	
	@BeforeMethod
	public void setUp() throws IOException {
		FileReader fr = new FileReader(System.getProperty("user.dir")+"/src/test/resources/configFiles/config.properties");
		props.load(fr);
		logger = LogManager.getLogger();
		
		WebDriver localDriver = null;
		switch(props.getProperty("browser")) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				localDriver = new ChromeDriver();
				break;
			
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions firefoxOptions = new FirefoxOptions();
	            firefoxOptions.addArguments("--headless"); // Enable headless mode
				localDriver = new FirefoxDriver(firefoxOptions);
				break;
		}
		
		if (localDriver != null) {
            localDriver.get(props.getProperty("testurl"));
            logger.info("Browser instantiated and navigated to: " + props.getProperty("testurl"));
            driver.set(localDriver);
        }
	}
	
	@AfterMethod
	public void tearDown() {
		if (driver.get() != null) {
            driver.get().quit();  // Ensures the WebDriver session is fully closed
            driver.remove();
            logger.info("Browser closed successfully");
        }
	}
	
	public WebDriver driverGet() {
		return driver.get();
	}
	
	public static String navigateToUrl(String path) {
		return props.getProperty("testurl") + path;
	}
	
	public static String getBaseUrl() {
		return props.getProperty("testurl");
	}

}
