package testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class verifyContactNumberLoginByTitle extends BaseTest {
	@Test
	public void VerifyContactNumberLoginByTitle() throws InterruptedException {
		driver.get(navigateToUrl("api/auth/login"));
		logger.info("navigated to login page");
		
		LoginPage loginPage = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		
		loginPage.selectContactNumberMethod();
		logger.info("login method selected: contact number");
		
		loginPage.enteridentifier("3132021324");
		logger.info("correct contact number entered");
		
		loginPage.enterPassword("opal");
		logger.info("correct password entered");
		
		loginPage.submitLogin();
		logger.info("login button clicked");
		
		wait.until(ExpectedConditions.urlToBe(getBaseUrl()));
		Assert.assertEquals(driver.getTitle(), "Welcome - Kashti Agro");		
	}
}
