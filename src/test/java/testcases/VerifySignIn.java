package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class VerifySignIn extends BaseTest {
	public static Boolean ddIsPresent;
	
	@Test(dataProvider="testdata")
	public static void VerifySignIn(String username, String password) throws InterruptedException {
		LoginTest.Login(username,password);
		
		ddIsPresent = driver.findElements(By.id(loc.getProperty("dropdown"))).size() > 0;
		Assert.assertEquals(ddIsPresent, true);
	}
	
	@DataProvider(name="testdata")
	public Object[][] tData() {
		return new Object[][] {
			{"expatkat@aol.com","travelbug3"},
			{"expatkat@aol.com", "foodgrub2"},
			{"uhkot62@nilis.com", "chillysummer23"},
			{"likot63782@nickolis.com", "foodlover3"}
		};
	}
}
