package Selenium.Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Selenium.PageObjects.Home_Page;
import Selenium.PageObjects.LogIn_Page;
import Selenium.Simple2.InitTest;

public class Login extends InitTest {

	protected static WebDriver driver;
	WebElement element;

	@Before
	public void init() {
		System.out.println("--------- wewnatrz init, wewnatrz Login");
	}

	@Ignore
	@Test
	public void valid_UserCredential() {
		driver = InitTest.getDriver();
		System.out.println("Starting test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.get("http://www.store.demoqa.com");
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();
		driver.findElement(By.id("log")).sendKeys("lasicmk2");
		driver.findElement(By.id("pwd")).sendKeys("qwe123");
		driver.findElement(By.id("login")).click();
		try {
			element = driver.findElement(By.xpath(".//*[@id='account_logout']/a"));
		} catch (Exception e) {
		}
		Assert.assertNotNull(element);
		driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();

		System.out.println("Ending test " + new Object() {
		}.getClass().getEnclosingMethod().getName());

	}
	@Ignore
	@Test
	public void inValid_UserCredential() {
		System.out.println("Starting test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver = InitTest.getDriver();
		driver.get("http://www.store.demoqa.com");
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();
		driver.findElement(By.id("log")).sendKeys("lasicmk2");
		driver.findElement(By.id("pwd")).sendKeys("qwe123111");
		driver.findElement(By.id("login")).click();
		try {
			element = driver.findElement(By.xpath(".//*[@id='account_logout']/a"));
		} catch (Exception e) {
		}
		Assert.assertNotNull(element);

		System.out.println("Ending test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
	}
	@Ignore
	@Test
	public void testForm1() {
		driver = InitTest.getDriver();
		// driver.get("http://toolsqa.com/automation-practice-form/");
		driver.get("http://toolsqa.wpengine.com/Automation-practice-form/");

		// Type Name in the FirstName text box
		driver.findElement(By.name("firstname")).sendKeys("Lakshay");

		// Type LastName in the LastName text box
		driver.findElement(By.name("lastname")).sendKeys("Sharma");

		// Click on the Submit button
		driver.findElement(By.id("submit")).click();

	}
	@Ignore
	@Test
	public void testForm2() {
		// Launch the Online Store WebSite
		driver = InitTest.getDriver();
		driver.get("http://toolsqa.wpengine.com/Automation-practice-form/");
		
		// Click on "Partial Link Text" link
		driver.findElement(By.partialLinkText("Partial")).click();
		System.out.println("Partial Link Test Pass");

		// Convert element in to a string
		String sClass = driver.findElements(By.tagName("button")).toString();
		System.out.println(sClass);

		// Click on "Link Text" link
		driver.findElement(By.linkText("Link Test")).click();
		System.out.println("Link Test Pass");
	}
	
	@Test
	public void atestPage1() {
		driver = InitTest.getDriver();
		driver.get("http://newtours.demoaut.com");
		driver.findElement(By.partialLinkText("REGISTER")).click();
		
		driver.findElement(By.partialLinkText("SIGN-ON")).click();
		driver.findElement(By.partialLinkText("Cruises")).click();
		driver.findElement(By.partialLinkText("Home")).click();
		
	}
	
	@Test
	public void loginTest(){
		driver = InitTest.getDriver();
		driver.get("http://www.store.demoqa.com");
		
		Home_Page.lnk_MyAccount(driver).click();
		LogIn_Page.txtbx_UserName(driver).sendKeys("lasicmk2");
		LogIn_Page.txtbx_Password(driver).sendKeys("qwe123");
		LogIn_Page.btn_LogIn(driver).click();
		Home_Page.lnk_LogOut(driver).click();
		
	}

}
