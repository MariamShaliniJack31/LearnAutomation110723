package com.nopCommerce.Listeners;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.nopCommerce.common.utils.ExtentReportUtil;
import com.nopCommerce.log4jutils.LogFile;

public class NGTestListener extends ExtentReportUtil implements ITestListener, IRetryAnalyzer {

	//ExtentReportListener extentReport = new ExtentReportListener();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		/*
		 * System.out.println("On Test Failure"); try {
		 * extentReport.getExtentreportScreenShot(); } catch (Throwable t) {
		 * t.printStackTrace();
		 * LogFile.APPLICATION_LOGS.error("Error in initialize() of Extent report"); }
		 */
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Started Execution..");
		LogFile.APPLICATION_LOGS.info("Started Execution..");
		ExtentReportUtil.setUp();

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Completed Execution..");
		LogFile.APPLICATION_LOGS.info("Completed Execution..");
		Reporter.log("Completed Execution..");
		extent.flush();

	}

	@Override
	public boolean retry(ITestResult result) {
		return false;
	}

}
