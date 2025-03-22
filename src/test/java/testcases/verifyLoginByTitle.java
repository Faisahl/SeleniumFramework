package testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class verifyLoginByTitle extends BaseTest {
	@Test
	public static void VerifyLoginByTitle() throws InterruptedException {
		driver.get(navigateToUrl("api/auth/login"));
		LoginPage loginPage = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		
		loginPage.enterUsername("test@testy.com");
		loginPage.enterPassword("opal");
		loginPage.submitLogin();
		wait.until(ExpectedConditions.urlToBe(getBaseUrl()));
		Assert.assertEquals(driver.getTitle(), "Welcome - Kashti Agro", "Titles do not match");		
	}
}

//for later when using excel data
//@Test(dataProviderClass=xlsDataReader.class, dataProvider="xldata")
//String username, String password