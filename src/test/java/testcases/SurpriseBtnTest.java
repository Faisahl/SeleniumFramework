package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class SurpriseBtnTest extends BaseTest{
	
	public static Boolean dishName;
	public static WebElement sps;
	@Test
	public static void SurpriseBtnTest() throws InterruptedException{
		driver.findElement(By.linkText(loc.getProperty("surprise_btn"))).click();
		logger.info("surprise btn found");
		dishName = driver.findElements(By.xpath(loc.getProperty("dish_title"))).size() > 0;
		logger.info("dish title located");
		Assert.assertEquals(dishName, true);
		logger.info("test completed");
	}
}
