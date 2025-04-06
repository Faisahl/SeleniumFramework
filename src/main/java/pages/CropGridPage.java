package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CropGridPage {
	private WebDriver driver;
	
	private By cropNameLink = By.id("crop-name-link");
	private By cropName = By.id("crop-name");
	private By cropCard = By.id("crop-card");
	private By addSuccessIcon = By.id("crop-add-success");
	private By addCropBtn = By.id("add-user-crop");
	private By loginPopUp = By.id("login-popup");
//	private By errorMsg = By.id("login-error");
//	private By contactRadio = By.id("contact");
	
	public CropGridPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addToUserCrops() {
		driver.findElement(addCropBtn).click();
	}
	
	public List<WebElement> getAddCropsBtns() {
		return driver.findElements(addCropBtn);
	}
	
	public WebElement getSuccessIcon() {
		return driver.findElement(addSuccessIcon);
	}
	
	public void getCropNameLink() {
		driver.findElement(cropNameLink);
	}
	
	public List<WebElement> getCropNameLinks() {
		return driver.findElements(cropNameLink);
	}
	
	public WebElement getCropName() {
		return driver.findElement(cropName);
	}
	
	public List<WebElement> getCropNames() {
		return driver.findElements(cropName);
	}

	public By getCropCard() {
		return cropCard;
	}
	
	public List<WebElement> getCropCards() {
		return driver.findElements(cropCard);
	}
	
	
	public WebElement getLoginPopUp() {
		return driver.findElement(loginPopUp);
	}
	
}
