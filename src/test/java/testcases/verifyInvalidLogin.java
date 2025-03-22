package testcases;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class verifyInvalidLogin extends BaseTest {
	@Test
	public static void VerifyInvalidLogin() throws InterruptedException {
		driver.get(navigateToUrl("api/auth/login"));
		LoginPage loginPage = new LoginPage(driver);
		WebElement errorMsg = driver.findElement(loginPage.getErrorMsg());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		
		loginPage.enterUsername("test@testy.com");
		loginPage.enterPassword("ropal");
		loginPage.submitLogin();
		wait.until(ExpectedConditions.visibilityOf(errorMsg));
		Assert.assertEquals(errorMsg.getText(), "Login failed: Invalid credentials");		
	}
}
