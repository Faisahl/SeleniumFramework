package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.Log;

public class LoginTest extends BaseTest {
	public static float cnt = 0;
	@Test
	public static void Login(String username, String password) throws InterruptedException {
		driver.findElement(By.className(loc.getProperty("login_link"))).click();
//		Log.info("Login button clicked");
		driver.findElement(By.name(loc.getProperty("email_field"))).sendKeys(username);
//		Log.info("Email field found and info entered");
		driver.findElement(By.name(loc.getProperty("pwd_field"))).sendKeys(password);
//		Log.info("Password field found and password entered");
		driver.findElement(By.xpath(loc.getProperty("submit_btn"))).click();
//		Log.info("Sign in button clicked");
	}
//	@DataProvider(name="testdata")
//	public Object[][] tData() {
//		return new Object[][] {
//			{"expatkat@aol.com","travelbug3"},
//			{"travbud@travss.com", "foodgrub2"},
//			{"uhkot62@nilis.com", "chillysummer23"},
//			{"likot63782@nickolis.com", "foodlover3"}
//		};
//	}
	
}
