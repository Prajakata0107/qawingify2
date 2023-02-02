package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecondPage {
	WebDriver driver = null;
	By Amount = By.xpath("//table[@id=\"transactionsTable\"]/thead/tr/th[5]");

	public SecondPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAmountheader() {
    driver.findElement(Amount).click();
	}

}
