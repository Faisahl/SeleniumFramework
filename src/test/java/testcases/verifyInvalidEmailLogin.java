package testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class verifyInvalidEmailLogin extends BaseTest {
	@Test
	public void VerifyInvalidEmailLogin() throws InterruptedException {
		driverGet().get(navigateToUrl("api/auth/login"));
		logger.info("navigated to login page");
		
		LoginPage loginPage = new LoginPage(driverGet());
		WebDriverWait wait = new WebDriverWait(driverGet(), Duration.ofSeconds(3));
		
		loginPage.enteridentifier("test@tester.com");
		logger.info("incorrect email entered");
		
		loginPage.enterPassword("opal");
		logger.info("correct password entered");
		
		loginPage.submitLogin();
		logger.info("login button clicked");
		
		wait.until(ExpectedConditions.visibilityOf(loginPage.getErrorMsg()));
		Assert.assertEquals(loginPage.getErrorMsg().getText(), "Login failed: Invalid credentials");		
	}
}
