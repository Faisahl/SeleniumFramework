package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;
	
	private By identifierField = By.id("identifier");
	private By passwordField = By.id("password");
	private By submitBtn = By.id("submitBtn");
	private By errorMsg = By.id("login-error");
	private By contactRadio = By.id("contact");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getErrorMsg() {
		return driver.findElement(errorMsg);
	}
	
	public void enteridentifier(String identity) {
		driver.findElement(identifierField).sendKeys(identity);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void submitLogin() {
		driver.findElement(submitBtn).click();
	}
	
	public void selectContactNumberMethod() {
		driver.findElement(contactRadio).click();
	}
}
