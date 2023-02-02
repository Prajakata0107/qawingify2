package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MySetup {
	public static RemoteWebDriver driver = null;

	@BeforeMethod

	public static void launchBrowser() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//Thread.sleep(30000);
		driver.get("https://sakshingp.github.io/assignment/login.html");
		Thread.sleep(4000);
		driver.manage().window().maximize();
		System.out.println("window maximize");
	}
     @AfterMethod
	public static void closeBrowser() {
		driver.close();
	}

}
