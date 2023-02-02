package base;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.xml.xpath.XPath;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyword {

	public static RemoteWebDriver driver = null;
	// private static final Logger log = Logger.getLogger(UIKeywords.class);

	public static void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("-disable-notifications ", "start-maximized");
			// option.addArguments(" ");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("InternetExplorerDriver")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
	}

	public static void SwitchToWindow(String byTitle) {
		String windowa = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		String title = driver.getTitle();
		for (String window : windows) {
			if (driver.switchTo().window(window).getTitle().equals(byTitle)) {
				System.out.println("Switch on window:" + byTitle);
				break;
			}
		}
	}

	public static void enterText(By element, String text) {
		driver.findElement(element).sendKeys(text);
	}

	public static void hitButton(int Keycode) {
		Robot robo = null;
		try {
			robo = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robo.keyPress(Keycode);
		robo.keyRelease(Keycode);
	}

	public static List<String> getTexts(By element) {
		List<WebElement> elements = driver.findElements(element);
		List<String> texts = new ArrayList<String>();
		for (WebElement ele : elements) {
			texts.add(ele.getText());
		}
		return texts;
	}

	public static void mouseMove(By xpath) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(xpath)).build().perform();
	}

	public static void click(By xpath) {
		driver.findElement(xpath).click();
	}

	// Overloded
	public static void click(String locatorType, String locatoraValue) {
		getWebElement(locatorType, locatoraValue).click();
	}

	public static WebElement getWebElement(String locatorType, String locatoraValue) {
		WebElement element = null;
		if (locatorType.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(locatoraValue));
		} else if (locatorType.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(locatoraValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(locatoraValue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(locatoraValue));
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			element = driver.findElement(By.linkText(locatoraValue));
		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			element = driver.findElement(By.partialLinkText(locatoraValue));
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			element = driver.findElement(By.tagName(locatoraValue));
		} else if (locatorType.equalsIgnoreCase("class")) {
			element = driver.findElement(By.className(locatoraValue));

		} else {
			System.out.println("Invalid Selector:" + locatorType);
		}
		return element;
	}

	public static List<WebElement> getWebElements(String locatorType, String locatoraValue) {
		List<WebElement> elements = null;
		if (locatorType.equalsIgnoreCase("xpath")) {
			elements = driver.findElements(By.xpath(locatoraValue));
		} else if (locatorType.equalsIgnoreCase("id")) {
			elements = driver.findElements(By.id(locatoraValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			elements = driver.findElements(By.cssSelector(locatoraValue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			elements = driver.findElements(By.name(locatoraValue));
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			elements = driver.findElements(By.linkText(locatoraValue));
		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			elements = driver.findElements(By.partialLinkText(locatoraValue));
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			elements = driver.findElements(By.tagName(locatoraValue));
		} else if (locatorType.equalsIgnoreCase("class")) {
			elements = driver.findElements(By.className(locatoraValue));

		} else {
			System.out.println("Invalid Selector:" + locatorType);
		}
		return elements;
	}

	public static void mouseMove(String locatorType, String locatoraValue) {
		Actions act = new Actions(Keyword.driver);
		act.moveToElement(getWebElement(locatorType, locatoraValue)).perform();
	}

	public static void mouseMove(WebElement elem) {
		Actions act = new Actions(Keyword.driver);
		act.moveToElement(elem).perform();
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void sendk(String locatorType, String locatoraValue) {
		getWebElement(locatorType, locatoraValue).sendKeys();
	}

	public static void alertDemo() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.dismiss();
		System.out.println(text);
	}

	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static Set<String> getWindowHandles() {
		return null;
	}

	public static Object switchTo() {
		Set<String> windows = driver.getWindowHandles();
		String title = driver.getTitle();
		for (String window : windows) {
			if (driver.switchTo().window(window).getTitle().equals(title)) {
				System.out.println("Switch on window:" + title);
				break;
			}
			return null;
		}
		return title;
	}

	public static void CloseBrowser() {
		driver.quit();
		System.out.println("Browser close Successfully");

	}

}
