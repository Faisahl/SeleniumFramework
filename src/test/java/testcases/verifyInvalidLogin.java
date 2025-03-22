package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class verifyInvalidLogin extends BaseTest {
	@Test
	public void VerifyInvalidLogin() throws InterruptedException {
		driverGet().get(navigateToUrl("api/auth/login"));
		logger.info("navigated to login page");
		
		LoginPage loginPage = new LoginPage(driverGet());
		WebDriverWait wait = new WebDriverWait(driverGet(), Duration.ofSeconds(3));
		
		loginPage.enteridentifier("test@testy.com");
		logger.info("email entered");
		
		loginPage.enterPassword("ropal");
		logger.info("incorrect password entered");
		
		loginPage.submitLogin();
		logger.info("login button clicked");
		
		wait.until(ExpectedConditions.visibilityOf(loginPage.getErrorMsg()));
		Assert.assertEquals(loginPage.getErrorMsg().getText(), "Login failed: Invalid credentials");		
	}
}
