package testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class verifyEmailLoginByTitle extends BaseTest {
	@Test
	public void VerifyEmailLoginByTitle() throws InterruptedException {
		driverGet().get(navigateToUrl("api/auth/login"));
		logger.info("navigated to login page");
		
		LoginPage loginPage = new LoginPage(driverGet());
		WebDriverWait wait = new WebDriverWait(driverGet(), Duration.ofSeconds(3));
		
		loginPage.enteridentifier("test@testy.com");
		logger.info("correct email entered");
		
		loginPage.enterPassword("opal");
		logger.info("correct password entered");
		
		loginPage.submitLogin();
		logger.info("login button clicked");
		
		wait.until(ExpectedConditions.urlToBe(getBaseUrl()));
		Assert.assertEquals(driverGet().getTitle(), "Welcome - Kashti Agro");		
	}
}

//for later when using excel data
//@Test(dataProviderClass=xlsDataReader.class, dataProvider="xldata")
//String username, String password