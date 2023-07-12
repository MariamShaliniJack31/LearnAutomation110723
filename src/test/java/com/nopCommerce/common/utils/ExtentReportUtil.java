package com.nopCommerce.common.utils;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtil {

	public static ExtentHtmlReporter htmlReporter = null;
	public static ExtentReports extent = null;
	public static ExtentTest test = null;
	static ValueDTO dto = new ValueDTO();
	public static int count = 0;

	public static ExtentReports setUp() {

		String reportLocation = System.getProperty("user.dir") + "/ExtentReport/Michaelpage_ExtentReport.html";

		htmlReporter = new ExtentHtmlReporter(reportLocation);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("Learn BDD Automation Report");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Automation Report");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Environment: ", dto.getSITURl());
		extent.setSystemInfo("Browser: ", dto.getWebDriverObj());
		extent.setSystemInfo("Language: ", dto.getLanguageSelection());
		System.out.println("Extent report location initialized : " + reportLocation);
		htmlReporter.start();
		System.out.println("System info set in Extent Report");

		return extent;

	}

	public static void testStepHandle(String teststatus, WebDriver driver, ExtentTest extenttest, Throwable throwable) {

		switch (teststatus) {

		case "FAIL":
			extenttest.fail(MarkupHelper.createLabel("Test Case Failed :", ExtentColor.RED));
			extenttest.error(throwable.fillInStackTrace());

			try {

				extenttest.addScreenCaptureFromPath(ReusableMethodTC.getScreenShot());

			} catch (Exception e) {
				e.printStackTrace();

			}

			break;

		case "PASS":
			extenttest.pass(MarkupHelper.createLabel("Test Case Passed :", ExtentColor.GREEN));
			break;

		case "SKIP":
			extenttest.pass(MarkupHelper.createLabel("Test Case Skipped :", ExtentColor.ORANGE));
			break;
		}
	}

}
