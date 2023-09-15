package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.xlsDataReader;

public class verifySearchForCountry extends BaseTest {
	public static WebElement searchBar;

	@Test(dataProviderClass=xlsDataReader.class, dataProvider="xldata")
	public static void verifySearchForCountry(String location) throws InterruptedException {
		List<WebElement> places;
		String place;
		
		searchBar = driver.findElement(By.xpath(loc.getProperty("search_bar")));
		logger.info("searchbar located");
		searchBar.click();
		logger.info("searchbar clicked");
		searchBar.sendKeys(location);
		logger.info("location entered into searchbar");
		places = driver.findElements(By.className("place"));
		logger.info("countries populated");
		place = places.get(0).getText();
		logger.info(place + "=" + location);
		Assert.assertEquals(place, location);
		
	}
}
