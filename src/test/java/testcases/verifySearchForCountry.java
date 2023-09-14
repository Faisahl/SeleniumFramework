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
		searchBar.click();
		searchBar.sendKeys(location);
		
		places = driver.findElements(By.className("place"));
		place = places.get(0).getText();
		
		Assert.assertEquals(place, location);
		
	}
}
