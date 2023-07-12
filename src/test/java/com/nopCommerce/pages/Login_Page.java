package com.nopCommerce.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.nopCommerce.common.utils.ReusableMethodTC;
import com.nopCommerce.common.utils.TestBase;
import com.nopCommerce.common.utils.ValueDTO;
import com.nopCommerce.common.utils.BrowserCallingTC;
import com.nopCommerce.log4jutils.LogFile;
import SamplePackage.*;

//import com.michaelpage.common.utils.BrowserCallingTC;
//import com.michaelpage.common.utils.LoginTC;
//import com.michaelpage.common.utils.ReusableMethodTC;
//import com.michaelpage.utils.LogFile;

public class Login_Page extends TestBase {
	
	String url = Dto.getURL();
	String userName = Dto.getUsername();
	String passWord = Dto.getPassword();
	String titlePage;
	
	// Login Page - User Name
	//@FindBy(how = How.XPATH, using = "//input[@id='Email']")
	//WebElement userNameTxb = driver.findElement(By.xpath("//input[@id='Email']")) ;
	
	By userNameTxb = By.xpath("//input[@id='Email']");
	By passWordTxb = By.xpath("//input[@id='Password']");
	By loginBtn = By.xpath("//button[@class='button-1 login-button']");
	By logoutBtn = By.xpath("//li[@class='nav-item']/a[contains(text(),'Logout')][@class='nav-link']");
	
	// Login Page - Password
	//@FindBy(how = How.XPATH, using = "//input[@id='Password']")
	//public WebElement passWordTxb = driver.findElement(By.xpath("//input[@id='Password']"));
	
	// Login Page - Login Button
	//@FindBy(how = How.XPATH, using = "//button[@class='button-1 login-button']")
	//public WebElement loginBtn = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
	
	// Home Page - Logout Button
	//@FindBy(how = How.XPATH, using = "//a[contains(text(),'Logout')]")
	//public WebElement logoutBtn = driver.findElement(By.xpath("//a[contains(text(),'Logout']"));
	
	public Login_Page() {
		PageFactory.initElements(driver, this);
	}

	public void launchApplication()   {
		
		///////////////////This Code is working and we are knowing browser from Config.Properties File
//		String brow = Example.property().toString();
//		System.out.println(brow);
//		if (brow.equalsIgnoreCase("Chrome")) {
//			System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\Drivers\\chromedriver.exe");
//			driver = new ChromeDriver();
//		} else {
//			System.out.println("Browser is not Chrome");
//		}
		
		/////////////Knowing the Browser Type from DataFiles and by using WebDriverMAnager
		BrowserCallingTC bc = new BrowserCallingTC();
		bc.browserSelection();
		
		System.out.println(url);
		driver.get(url);
		
		Reporter.log("Launched the Application");
		LogFile.APPLICATION_LOGS.info("Launched nopCommerce Application");
		System.out.println(userName);
		System.out.println(passWord);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	public void enterText(String webElementTitle) throws InterruptedException {
		switch (webElementTitle.toUpperCase()) {
		case "USERNAME": {
			System.out.println("I am in UserName");
			ReusableMethodTC.elementToBeVisible(driver.findElement(userNameTxb));
			ReusableMethodTC.highLighterMethod(driver, driver.findElement(userNameTxb));
			ReusableMethodTC.clear(driver.findElement(userNameTxb));
			ReusableMethodTC.sendKeys(driver.findElement(userNameTxb), userName);
			ReusableMethodTC.sendKeys(driver.findElement(userNameTxb), Keys.TAB);
			Reporter.log("Entered User Name");
			LogFile.APPLICATION_LOGS.info("Entered User Name");
			break;
		}
		case "PASSWORD": {
			
			System.out.println(passWord);
			ReusableMethodTC.elementToBeVisible(driver.findElement(passWordTxb));
			ReusableMethodTC.highLighterMethod(driver, driver.findElement(passWordTxb));
			ReusableMethodTC.sendKeys(driver.findElement(passWordTxb), passWord);
			Thread.sleep(2000);
			Reporter.log("Entered Password");
			LogFile.APPLICATION_LOGS.info("Entered Password");
			break;
		}
//		case "UNIQUE EMAILID": {
//			ReusableMethodTC.elementToBeVisible(userNameTxb);
//			ReusableMethodTC.highLighterMethod(driver, userNameTxb);
////			System.out.println("U ID:: " + MP_SIT_ApplywithyourCVPage.email);
////			ReusableMethodTC.sendKeys(userNameTxb, MP_SIT_ApplywithyourCVPage.email);
//			ReusableMethodTC.sendKeys(userNameTxb, Keys.TAB);
//			Reporter.log("Entered Email Address");
//			LogFile.APPLICATION_LOGS.info("Entered Email Address");
//			break;
//		}
		}
	}
//
	public void clickOnElement(String webElementTitle) throws Exception {

		switch (webElementTitle.toUpperCase()) {

		case "LOGIN": {
			try {
				System.out.println("I am in Login Button");
				ReusableMethodTC.elementToBeVisible(driver.findElement(loginBtn));
				ReusableMethodTC.highLighterMethod(driver, driver.findElement(loginBtn));
				Thread.sleep(2000);
				ReusableMethodTC.click(driver.findElement(loginBtn));
				LogFile.APPLICATION_LOGS.info("Clicked on 'Login' Button");
				Reporter.log("Clicked on 'Login' Button");

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			titlePage = driver.getTitle();
			System.out.println("Home Page Title::" + titlePage);
			break;
		}

		case "LOGOUT": {
			Thread.sleep(2000);
			System.out.println("I am in Logout Button");
			ReusableMethodTC.elementToBeVisible(driver.findElement(logoutBtn));
			ReusableMethodTC.highLighterMethod(driver, driver.findElement(logoutBtn));
			ReusableMethodTC.click(driver.findElement(logoutBtn));
			Reporter.log("Clicked on 'Logout' Button");
			LogFile.APPLICATION_LOGS.info("Clicked on 'Logout' Button");
			} 
			break;
		}
		}

	public void VerifyTitle(String arg) {
		
		System.out.println(arg);
		if (titlePage.contains(arg)) {
			System.out.println("Logged in Sucessfully");
			Reporter.log("Clicked on 'Login' Button");
			LogFile.APPLICATION_LOGS.info("Clicked on 'Login' Button");
		} else {
			System.out.println("Login Failed");
			Reporter.log("Clicked on 'Login' Button but the title is :  " + titlePage);
			LogFile.APPLICATION_LOGS.info("Clicked on 'Login' Button and is Unsuccessful");
		}
	}
	
	
//	public void createNewUserAccount() throws InterruptedException {
//		ReusableMethodTC.elementToBeVisible(createNewAccountLink);
//		ReusableMethodTC.highLighterMethod(driver, createNewAccountLink);
//		ReusableMethodTC.click(createNewAccountLink);
//		Thread.sleep(1000);
//
//		ReusableMethodTC.elementToBeVisible(firstNameText);
//		ReusableMethodTC.sendKeys(firstNameText, "Automation");
//		ReusableMethodTC.sendKeys(lastNameText, "MichaelPage");
//		ReusableMethodTC.elementToBeVisible(createEmailAddressText);
//		ReusableMethodTC.sendKeys(createEmailAddressText, userName);
//		ReusableMethodTC.sendKeys(createConfirmEmailAddressText, userName);
//		ReusableMethodTC.sendKeys(createPasswordText, passWord);
//		// scrollIntoElement(createConfirmPasswordText);
//		// ReusableMethodTC.sendKeys(createConfirmPasswordText, passWord);
//		try {
//			Thread.sleep(1200);
//			ReusableMethodTC.elementToBeVisible(signUpBtn);
//			scrollIntoElement(signUpBtn);
//			ReusableMethodTC.highLighterMethod(driver, signUpBtn);
//			// Assert.assertTrue(signUpBtn.getAttribute("value").contains("Create new
//			// account"));
//			System.out.println(createNewAccountTab.getAttribute("value").toString());
//			ReusableMethodTC.click(signUpBtn);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		Thread.sleep(1200);
//		System.out.println(RegistraionSucessMSg.getText());
//	}
//
//	public void logOut() throws InterruptedException {
//		try {
//			Thread.sleep(1000);
//			if (myAccountTab.isDisplayed() == true) {
//				System.out.println("myAccountTab isDisplayed::" + myAccountTab.isDisplayed());
//				ReusableMethodTC.elementToBeVisible(myAccountTab);
//				ReusableMethodTC.highLighterMethod(driver, myAccountTab);
//				clickUsingJavaScript(myAccountTab);
//				// ReusableMethodTC.click(myAccountTab);
//
//			} else {
//				System.out.println("Login isDisplayed::" + loginOrSignUpIcon.isDisplayed());
//				ReusableMethodTC.elementToBeVisible(loginOrSignUpIcon);
//				ReusableMethodTC.highLighterMethod(driver, loginOrSignUpIcon);
//				ReusableMethodTC.click(loginOrSignUpIcon);
//				ReusableMethodTC.elementToBeVisible(myAccountTab);
//				ReusableMethodTC.highLighterMethod(driver, myAccountTab);
//				ReusableMethodTC.click(myAccountTab);
//
//			}
//
//			ReusableMethodTC.elementToBeVisible(logoutBtn);
//			ReusableMethodTC.highLighterMethod(driver, logoutBtn);
//			ReusableMethodTC.click(logoutBtn);
//
//			System.out.println("Logged out Sucessfully ");
//			Reporter.log(" Logged out Sucessfully ");
//
//			if (driver.switchTo().alert() != null) {
//				System.out.println("Alert");
//				driver.switchTo().alert().accept();
//				System.out.println("Alert Accepted");
//			}
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
//
//	public void cookiesHandel() {
//		try {
//
//			if (cookiesBtn.isDisplayed() == true) {
//				System.out.println("Is cookies displayed ::" + cookiesBtn.isDisplayed());
//
//				ReusableMethodTC.elementToBeVisible(cookiesBtn);
//				ReusableMethodTC.highLighterMethod(driver, cookiesBtn);
//				ReusableMethodTC.click(cookiesBtn);
//				Thread.sleep(1000);
//			} else {
//				System.out.println("No cookies");
//			}
//
//			if (hideBtn.isDisplayed() == true) {
//				ReusableMethodTC.elementToBeVisible(hideBtn);
//				ReusableMethodTC.highLighterMethod(driver, hideBtn);
//				ReusableMethodTC.click(hideBtn);
//
//			}
//			System.out.println("Cookies Closed");
//			Thread.sleep(1000);
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//	}
}
