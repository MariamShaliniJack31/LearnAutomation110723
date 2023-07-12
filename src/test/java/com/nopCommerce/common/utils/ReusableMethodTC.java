package com.nopCommerce.common.utils;

import java.awt.AWTException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.nopCommerce.log4jutils.LogFile;

public class ReusableMethodTC extends TestBase {

	static String mainWindow = null;
	static String mainWindowName = null;

	public static void click(WebElement webElement) {
		try {
			elementToBeVisible(webElement);
			webElement.click();

		} catch (Exception e) {

			for (int i = 0; i <= 10; ++i) {
				try {
					scrollIntoView(webElement);
					elementToBeVisible(webElement);
					webElement.click();
					break;
				} catch (Exception e1) {
					e1.printStackTrace();
					continue;
				}
			}

			LogFile.APPLICATION_LOGS.error("Unable to click: " + webElement.getAttribute("class").toString());
		}
	}

	public static void clickByJS(WebElement webElement) {
		try {
			elementToBeVisible(webElement);
			js.executeScript("arguments[0].click();", webElement);
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS
					.error("Cannot find object with key -- " + webElement.getAttribute("class").toString());
		}
	}

	public static void sendKeys(WebElement webElement, String text) {
		try {
			elementToBeVisible(webElement);
			webElement.clear();
			webElement.sendKeys(text);
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Unable to enter text in: " + webElement.getAttribute("class").toString());
		}
	}

	public static void selectByValue(WebElement webElement, String value) {
		try {
			elementToBeVisible(webElement);
			Select listBox = new Select(webElement);
			listBox.selectByValue(value);
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS
					.error("Unable to select the value : " + webElement.getAttribute("class").toString());
		}
	}

	public static void selectByVisibleText(WebElement webElement, String value) {
		try {
			elementToBeVisible(webElement);
			Select listBox = new Select(webElement);
			listBox.selectByVisibleText(value);
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS
					.error("Unable to select the value : " + webElement.getAttribute("class").toString());
		}
	}

	public static void mouseOver(WebElement webElement) {
		try {

			Actions act = new Actions(driver);
			elementToBeVisible(webElement);
			act.moveToElement(webElement).build().perform();
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Unable to move to element: " + webElement.getAttribute("class").toString());

		}
	}

	public static void dragAndDrop(WebElement source, WebElement target) {
		try {

			Actions act = new Actions(driver);
			act.dragAndDrop(source, target);
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Unable to drag and Drop");
		}
	}

	public static void selectByIndex(WebElement webElement, int index) {

		try {
			elementToBeVisible(webElement);
			Select listBox = new Select(webElement);
			listBox.selectByIndex(index);
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS
					.error("Unable to select the value : " + webElement.getAttribute("class").toString());
		}
	}

	public static void clear(WebElement webElement) {
		try {
			elementToBeVisible(webElement);
			webElement.clear();
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Unable to clear text : " + webElement.getAttribute("class").toString());
		}
	}

	public static boolean isElementPresent(WebElement webElement) {
		boolean status = false;
		try {
			elementToBeVisible(webElement);
			status = webElement.isDisplayed();
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Webelement is not present: " + webElement.getAttribute("class").toString());
		}

		return status;

	}

	public static boolean isEnabled(WebElement webElement) {
		boolean status = false;
		elementToBeVisible(webElement);
		try {
			status = webElement.isEnabled();
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Webelement is disabled: " + webElement.getAttribute("class").toString());
		}

		return status;
	}

	public static void verifyText(String expected, String actual) throws Exception {
		try {
			Assert.assertEquals(expected, actual);
		} catch (Exception t) {
			throw t;
		}
	}

	public static void verifyTextDirect(String text) throws Exception {
		try {
			Assert.assertTrue(driver.getPageSource().contains(text));
		} catch (Exception t) {
			throw t;
		}
	}

	public static String getScreenShot() {

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		File destFile = null;
		try {

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String filePath = System.getProperty("user.dir") + "/screenshots/" + "_"
					+ formater.format(calendar.getTime()) + ".png";
			destFile = new File(filePath);
			FileUtils.copyFile(scrFile, destFile);

		} catch (Exception t) {
			//ErrorUtil.addVerificationFailure(t);
			LogFile.APPLICATION_LOGS.error("Error in taking screenshot" + t.getMessage());
		}
		return destFile.getAbsolutePath().toString();

	}

	// Method is for HighLight the element before performing any Actions
	public static void highLighterMethod(WebDriver driver, WebElement elementToHighlight) {
		try {
			String originalStyle = elementToHighlight.getAttribute("style");

			JavascriptExecutor js = (JavascriptExecutor) driver;

			for (int i = 0; i < 2; i++) {
				js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						elementToHighlight);
				Thread.sleep(150);
				js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", elementToHighlight);
				Thread.sleep(150);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void navigateToOtherWindow() throws InterruptedException {

		mainWindow = driver.getWindowHandle();
		mainWindowName = driver.getTitle();
		System.out.println("Parent Window id :::" + mainWindow);

		Thread.sleep(2000);
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			if (!mainWindow.equals(childWindow)) {
				System.out.println("Child Window id :::" + childWindow);
				driver.switchTo().window(childWindow);
				System.out.println("Child window Title:::" + driver.switchTo().window(childWindow).getTitle());
				driver.manage().window().maximize();
				Thread.sleep(2000);
			}
		}
	}

	public static void navigateToMainWindow() throws InterruptedException, AWTException {
		System.out.println("Parent Window id :::" + mainWindow);

		for (String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);
			System.out.println("Title of parent window :" + driver.getTitle());
			if (!driver.getTitle().trim().equals(mainWindowName.trim())) {
				driver.close();
			}
		}

	}

	// Method is for sending KeyEvent
	public static void sendKeys(WebElement webElement, Keys tab) {
		try {
			elementToBeVisible(webElement);
			webElement.sendKeys(tab);
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Unable to enter text in: " + webElement.getAttribute("class").toString());
		}

	}

	public static void alertAccept_Dismiss(Integer value) throws InterruptedException, AWTException {
		Thread.sleep(5000);

		if (value == 0) {
			driver.switchTo().alert().accept();
			Reporter.log("Accepted alert window");
			LogFile.APPLICATION_LOGS.info("Accepted alert window");
		} else
			driver.switchTo().alert().dismiss();

		Reporter.log("Dismissed alert window");
		LogFile.APPLICATION_LOGS.info("Dismissed alert window");

	}

	public ArrayList<String> Error() {
		ArrayList<String> errors = new ArrayList<String>();
		try {
			List<WebElement> blankfielderror = driver.findElements(By.xpath("//strong[@class='error']"));
			if (blankfielderror.size() > 0) {
				for (int i = 1; i <= blankfielderror.size(); i++) {
					String ele = driver.findElement(By.xpath("(//strong[@class='error'])[" + i + "]")).getText();
					System.out.println("Verified : The Error  : " + i + " is" + ele);
					Reporter.log("Verified : The Error  : " + i + " is" + ele);
					LogFile.APPLICATION_LOGS.debug("The Error  : " + i + " is" + ele);
					errors.add(ele);
				}
			}
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Unable to Display Errors: ");
		}
		return errors;
	}

	public static void verifyTextPresent(String expected, String actual) throws Exception {
		try {
			Assert.assertTrue(actual.contains(expected));
		} catch (Exception t) {
			throw t;
		}
	}

	public static void readonlyInputBox(WebElement webElement) {
		try {
			elementToBeVisible(webElement);
			String readonly = webElement.getAttribute("readonly");
			Assert.assertNotNull(readonly);
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Unable to edit");
		}
	}

	public static void editableInputBox(WebElement webElement, String testData) {
		try {

			webElement.click();
			Thread.sleep(1000);
			webElement.clear();
			webElement.sendKeys(testData);
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Unable to edit");
		}
	}

	public static void navigateToFrame() throws InterruptedException, AWTException {

		Thread.sleep(4000);
		driver.switchTo().window(mainWindow);
		System.out.println("Navigated to main window");
		Thread.sleep(8000);

		System.out.println("New::" + driver.getCurrentUrl());
		System.out.println("New::" + driver.getTitle());

		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		int iSize = frames.size();
		System.out.println("Iframe size::" + iSize);

		for (int i = 0; i < iSize; i++) {
			String sValue = frames.get(i).getAttribute("src").toString();
			System.out.println("Iframe values:::" + sValue);
		}

	}

}
