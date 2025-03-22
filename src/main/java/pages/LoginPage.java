package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;
	
	private By usernameField = By.id("username");
	private By passwordField = By.id("password");
	private By submitBtn = By.id("submitBtn");
	private By errorMsg = By.id("login-error");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getErrorMsg() {
		return driver.findElement(errorMsg);
	}
	
	public void enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void submitLogin() {
		driver.findElement(submitBtn).click();
	}
}
