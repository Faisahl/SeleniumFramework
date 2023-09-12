package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties props = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader fr2;
	
	@BeforeMethod
	public void setUp() throws IOException {
		if(driver == null) {
			FileReader fr = new FileReader(System.getProperty("user.dir")+"/src/test/resources/configFiles/config.properties");
			FileReader fr2 = new FileReader(System.getProperty("user.dir")+"/src/test/resources/configFiles/locators.properties");
			props.load(fr);
			loc.load(fr2);
		}
		
		switch(props.getProperty("browser")) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get(props.getProperty("testurl"));
				break;
			
			case "firefox":
				WebDriverManager.firefoxdriver().setup();				
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
				driver.get(props.getProperty("testurl"));
				break;
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		System.out.println("Browser Closed");
	}

}
