package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class LoginTest extends BaseTest {
	@Test
	public static void Login() throws InterruptedException {
		driver.findElement(By.className("log-in")).click();
		driver.findElement(By.name("email")).sendKeys("likot63782@nickolis.com");
		driver.findElement(By.name("password")).sendKeys("foodlover3");
		driver.findElement(By.xpath("//div[@type='submit']")).click();
	}
	
}
