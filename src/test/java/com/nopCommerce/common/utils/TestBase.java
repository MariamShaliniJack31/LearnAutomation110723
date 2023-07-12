package com.nopCommerce.common.utils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.nopCommerce.log4jutils.LogFile;

public class TestBase {

	public static WebDriver driver = null;
	public static ValueDTO Dto = new ValueDTO();
	public static String path, output;
	public static JavascriptExecutor js;
	public static WebDriverWait wait;
	public static String fileLocation, FileName;
	static List<WebElement> cvpath;

	
	public static WebElement elementToBeVisible(WebElement webElement) {

		try {
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(webElement));
			wait.until(ExpectedConditions.elementToBeClickable(webElement));

		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Cannot find element: " + e.getMessage());
		}
		return webElement;
	}

	public static WebElement elementToBeInvisible(WebElement webElement) {
		try {

			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.invisibilityOf(webElement));

		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Cannot find element: " + e.getMessage());
		}
		return webElement;
	}

	public static WebElement getObject(WebElement webElement) {

		try {
			elementToBeVisible(webElement);
		} catch (Exception t) {
			webElement = null;
			//ErrorUtil.addVerificationFailure(t);
			LogFile.APPLICATION_LOGS.error("Cannot find object with key -- " + t.getMessage());
		}
		return webElement;
	}

	public static void scrollIntoView(WebElement webElement) {

		js = (JavascriptExecutor) driver;
		try {
			js.executeScript("window.scrollTo(0,300)", "webElement");
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Cannot find object with key -- " + e.getMessage());
		}
	}

	public static void scrollIntoElement(WebElement webElement) {

		js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].scrollIntoView(true);", webElement);
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Cannot find object with key -- " + e.getMessage());
		}
	}

	public static void clickUsingJavaScript(WebElement webElement) {

		js = (JavascriptExecutor) driver;
		try {

			js.executeScript("arguments[0].click();", webElement);
		} catch (Exception e) {
			LogFile.APPLICATION_LOGS.error("Cannot find object with key -- " + e.getMessage());
		}
	}
	
	public static void tearDown() {
		//driver.close();
		driver.quit();
		Reporter.log("Closed Browser");
		System.out.println("Closed Browser");
	}

//	public String getBrowserName() {
//		//return Dto.getWebDriverObj().toLowerCase();
//	}
//
//	public static void uploadFile(WebElement webElement, String FileName) throws Throwable {
//
//		fileLocation = MichaelpageConstants.FilePath + FileName;
//
//		if (Dto.getbrowserStatusvalueType().equalsIgnoreCase("Headless")) {
//
//			if ("chrome".equalsIgnoreCase(Dto.getWebDriverObj())) {
//				String FileLocation = System.getProperty("user.dir") + "/src/test/resources/TestDataFiles/" + FileName;
//				System.out.println(FileLocation);
//				driver.findElement(By.xpath("//*[contains(@name,'files[field_cv')]")).sendKeys(FileLocation);
//				Thread.sleep(3000);
//				System.out.println("Uploaded file in Chrome Headless Browser");
//
//			} else {
//				System.out.println("File: " + fileLocation);
//				driver.findElement(By.xpath("//*[contains(@name,'files[field_cv')]")).sendKeys(fileLocation);
//				Thread.sleep(3000);
//				System.out.println("Uploaded file in Firefox Headless Browser");
//			}
//
//		} else {
//			// System.out.println("File: "+ fileLocation);
//			StringSelection stringSelection = new StringSelection(fileLocation);
//			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
//			Robot robot = new Robot();
//
//			try {
//				robot.keyPress(KeyEvent.VK_CONTROL);
//				Thread.sleep(1000);
////				robot.keyPress(KeyEvent.VK_CONTROL);
////				Thread.sleep(500);
//				robot.keyPress(KeyEvent.VK_V);
//				Thread.sleep(1000);
//				robot.keyRelease(KeyEvent.VK_V);
//				Thread.sleep(1000);
//				robot.keyRelease(KeyEvent.VK_CONTROL);
//				Thread.sleep(2000);
//				robot.keyPress(KeyEvent.VK_ENTER);
//				Thread.sleep(2000);
//				robot.keyRelease(KeyEvent.VK_ENTER);
//				Thread.sleep(2000);
//				System.out.println("Uploaded file in  " + Dto.getWebDriverObj().toString() + " Browser");
//
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//				LogFile.APPLICATION_LOGS.error("File not found");
//				System.out.println("File not found");
//
//			}
//		}
//
//	}

	

//	public static void downloadFiles() throws Throwable {
//
//		String fileName = "";
//		String cvName = latestDownLoadedFileFromDownload(fileName, "pdf");
//		Robot robotObj = new Robot();
//
//		if ("Firefox".equalsIgnoreCase(Dto.getWebDriverObj())) {
//			Thread.sleep(2000);
//			robotObj.keyPress(KeyEvent.VK_ENTER);
//			Reporter.log("File is Downloaded Successfully from Firefox");
//
//		} else if (("ie").equalsIgnoreCase(Dto.getWebDriverObj())) {
//			Thread.sleep(2000);
//			robotObj.keyPress(KeyEvent.VK_ALT);
//			Thread.sleep(1000);
//			robotObj.keyPress(KeyEvent.VK_S);
//			robotObj.keyRelease(KeyEvent.VK_ALT);
//			robotObj.keyRelease(KeyEvent.VK_S);
//			Reporter.log("File is Downloaded Successfully from IE");
//
//		} else {
//			Thread.sleep(500);
//			Reporter.log("File is Downloaded Successfully from Chrome");
//		}
//
//		System.out.println("Downloaded CV Name::" + cvName);
//		Thread.sleep(2000);
//
//	}

//	public static String latestDownLoadedFileFromDownload(String fileName, String fileType) {
//		String returnFile = "";
//		try {
//			int counter = 0;
//			File uploadDirectory = new File(MichaelpageConstants.SRC_FOLDER);
//			File[] downloadedFiles = uploadDirectory.listFiles();
//			Arrays.sort(downloadedFiles, new Comparator<File>() {
//				@Override
//				public int compare(File firstFile, File secondFile) {
//					return Long.valueOf(secondFile.lastModified()).compareTo(firstFile.lastModified());
//				}
//			});
//			for (File file : downloadedFiles) {
//				if (file.isFile()) {
//					if (file.getName().startsWith(fileName) && file.getName().endsWith(fileType)) {
//						if (returnFile.equals("")) {
//							returnFile = file.getName();
//						}
//						if (counter >= 20 && file.exists() && file.isFile()) {
//							file.delete();
//						}
//						counter += 1;
//					}
//				}
//			}
//			if (returnFile.equals("")) {
//				returnFile = "No such file available in Download folder!!";
//			}
//		} catch (Exception e) {
//			returnFile = "No such file available in Download folder!!";
//			e.printStackTrace();
//		}
//		return returnFile;
//	}
//
//	public static void uploadFileWebForm(WebElement webElement, String FileName) throws Throwable {
//
//		fileLocation = MichaelpageConstants.FilePath + FileName;
//
//		if (Dto.getbrowserStatusvalueType().equalsIgnoreCase("Headless")) {
//
//			if ("chrome".equalsIgnoreCase(Dto.getWebDriverObj())) {
//				String FileLocation = System.getProperty("user.dir") + "/src/test/resources/TestDataFiles/" + FileName;
//				System.out.println(FileLocation);
//				driver.findElement(By.cssSelector("#edit-select-cv-upload-target")).sendKeys(FileLocation);
//				Thread.sleep(1000);
//				System.out.println("Uploaded file in Chrome Headless Browser");
//
//			} else {
//				System.out.println("File: " + fileLocation);
//				driver.findElement(By.cssSelector("#edit-select-cv-upload-target")).sendKeys(fileLocation);
//				Thread.sleep(1000);
//				System.out.println("Uploaded file in Firefox Headless Browser");
//			}
//
//		} else {
//			// System.out.println("File: "+ fileLocation);
//			StringSelection stringSelection = new StringSelection(fileLocation);
//			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
//			Robot robot = new Robot();
//
//			try {
//				robot.keyPress(KeyEvent.VK_CONTROL);
//				Thread.sleep(500);
//				robot.keyPress(KeyEvent.VK_V);
//				Thread.sleep(1000);
//				robot.keyRelease(KeyEvent.VK_V);
//				Thread.sleep(1000);
//				robot.keyRelease(KeyEvent.VK_CONTROL);
//				Thread.sleep(2000);
//				robot.keyPress(KeyEvent.VK_ENTER);
//				Thread.sleep(2000);
//				robot.keyRelease(KeyEvent.VK_ENTER);
//				Thread.sleep(2000);
//				System.out.println("Uploaded file in  " + Dto.getWebDriverObj().toString() + " Browser");
//
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//				LogFile.APPLICATION_LOGS.error("File not found");
//				System.out.println("File not found");
//
//			}
//		}
//	}
}
