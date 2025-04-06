package testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class verifyAddingUserCrop extends BaseTest {
	@Test
	public void VerifyAddingUserCrop() throws InterruptedException {
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
		
//		maybe get the list of the crops, then random select one, 
//		click the add button, confirm the success symbol, then confirm in user profile
	}
}
