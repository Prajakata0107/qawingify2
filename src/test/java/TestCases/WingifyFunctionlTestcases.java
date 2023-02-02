package TestCases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.LoginPage;
import base.MySetup;
import base.SecondPage;

public class WingifyFunctionlTestcases extends MySetup {

	@Test(priority = -5)
	public void PositiveTestCase() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500000)", "");
		lp.setUsername("prajakta");
		System.out.println("UserName sent successfully");
		Thread.sleep(5000);
		lp.SetPassword("pass@1234");
		System.out.println("Password sent successfully");
		Thread.sleep(2000);
		lp.clickOnLoginButton();
		System.out.println("Click on login Sucessfully");

	}

	@Test(priority = -8)
	public void ValidAndInvalidPassANdUserName() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500000)", "");
		lp.setUsername("!@356&^@mmnm---===+)j");
		System.out.println("UserName sent successfully");
		Thread.sleep(3000);
		lp.SetPassword("?/");
		System.out.println("Password sent successfully");
		Thread.sleep(2000);
		lp.clickOnLoginButton();
	}

	@Test(priority = -9)
	public void ValidUseNameButInvalidPassword() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500000)", "");
		lp.setUsername("Prajakta");
		System.out.println("UserName sent successfully");
		Thread.sleep(3000);
		lp.SetPassword("?/-=");
		System.out.println(" Invalid Password sent successfully");
		Thread.sleep(2000);
		lp.clickOnLoginButton();
	}

	@Test(priority = 11)
	public void UserNamePasswordMustBePresent() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500000)", "");
		lp.setUsername("");
		System.out.println(" Empty UserName sent successfully");
		Thread.sleep(2000);
		System.out.println("Empty password sent successfully");
		lp.SetPassword("");
		Thread.sleep(2000);
		lp.clickOnLoginButton();
	}

	@Test(priority = 12)
	public void SameUserNameSamePassword() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500000)", "");
		lp.setUsername("Prajakta");
		System.out.println("UserName sent successfully");
		Thread.sleep(1000);
		lp.SetPassword("Prajakta");
		System.out.println("Password sent successfully");
		Thread.sleep(2000);
		lp.clickOnLoginButton();
	}

	@Test
	public void InValidUserNameValidPassword() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500000)", "");
		lp.setUsername("--+}");
		System.out.println(" invalid UserName sent successfully");
		Thread.sleep(1000);
		lp.SetPassword("Praj@1234");
		System.out.println("Valid password sent successfully");
		Thread.sleep(2000);
		lp.clickOnLoginButton();
	}

	@Test
	public void AfterSuccessFulLoginCheckAmountHeaderAndAssertThemSortedOrNot() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500000)", "");
		lp.setUsername("prajakta");
		System.out.println("UserName sent successfully");
		Thread.sleep(5000);
		lp.SetPassword("pass@1234");
		System.out.println("Password sent successfully");
		Thread.sleep(2000);
		lp.clickOnLoginButton();
		System.out.println("Click on login Sucessfully");
		SecondPage fp = new SecondPage(driver);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600000)", "");
		fp.clickOnAmountheader();
		Thread.sleep(5000);
		List<WebElement> amount = driver.findElements(By.xpath("//td[@class=\"text-right bolder nowrap\"]"));
		ArrayList originalList = new ArrayList();
		ArrayList tempList = new ArrayList();
		for (WebElement price : amount) {
			System.out.println(price.getText());
		}
        
		for (WebElement e : amount) {
			originalList.add(e.getText());
			tempList.add(e.getText());
		}
		System.out.println("this is tempList before Sorting" + tempList);
		Collections.sort(originalList);
		System.out.println("this is originalList after Sorting" + originalList);
		{
			List<ArrayList> list = Arrays.asList(tempList);
			List<ArrayList> expected = Arrays.asList(originalList);
			org.testng.Assert.assertEquals(list, expected);
		}

	}

}
