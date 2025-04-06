package testcases;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CropGridPage;

public class verifyAddCropLoginPopUp extends BaseTest {
	@Test
	public void VerifyAddCropLoginPopUp() throws InterruptedException {
		driverGet().get(navigateToUrl("api/crop-types"));
		logger.info("navigated to crops grid page");
		
		CropGridPage cgp = new CropGridPage(driverGet());
		WebDriverWait wait = new WebDriverWait(driverGet(), Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(cgp.getCropCard()));
		
		List<WebElement> addBtns = cgp.getAddCropsBtns();
		logger.info("add buttons gathered " + addBtns.size());
		
		if (addBtns.isEmpty()) {
		    throw new NoSuchElementException("No crop links found!");
		}
		
		Random rand = new Random();
		WebElement selected = addBtns.get(rand.nextInt(addBtns.size()));
		logger.info("selected random crop to add " + selected.getLocation());
	
		
		JavascriptExecutor js = (JavascriptExecutor) driverGet();
		wait.until(ExpectedConditions.elementToBeClickable(selected));
		js.executeScript("arguments[0].click();", selected);
		logger.info("add button clicked");
		
		Boolean popped = cgp.getLoginPopUp().isDisplayed();
		Assert.assertEquals(popped, true);
		
	}
}
