package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver = null;
	By UserName = By.xpath("//input[@id='username']");
	By Password = By.xpath("//input[@id=\"password\"]");
	By LoginButton = By.xpath("//div[@class=\"buttons-w\"]/button[@id=\"log-in\"]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setUsername(String text) {

		driver.findElement(UserName).sendKeys(text);
	}

	public void SetPassword(String text2) {
		driver.findElement(Password).sendKeys(text2);
	}

	public void clickOnLoginButton() {
	driver.findElement(LoginButton).click();
	}

}
