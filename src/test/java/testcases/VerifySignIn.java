package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.xlsDataReader;

public class VerifySignIn extends BaseTest {
	public static Boolean ddIsPresent;
	
	@Test(dataProviderClass=xlsDataReader.class, dataProvider="xldata")
	public static void VerifySignIn(String username, String password) throws InterruptedException {
		LoginTest.Login(username,password);
		
		ddIsPresent = driver.findElements(By.id(loc.getProperty("dropdown"))).size() > 0;
		Assert.assertEquals(ddIsPresent, true);
	}
}
